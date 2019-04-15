<template>
  <div class="app-container">
    <el-button type="primary" round icon="el-icon-plus" @click="create">创建项目</el-button>
    <br><br>
    <el-table
      v-loading="listLoading"
      :data="projects"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="序号" width="50">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="名称" width="150">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="项目经理" width="120">
        <template slot-scope="scope">
          {{ scope.row.userName }}
        </template>
      </el-table-column>
      <el-table-column label="工程地址" width="255">
        <template slot-scope="scope">
          {{ scope.row.address }}
        </template>
      </el-table-column>
      <el-table-column label="备注">
        <template slot-scope="scope">
          {{ scope.row.remark }}
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="200">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" size="mini" circle @click="update(scope.row)"/>
          <el-button type="danger" icon="el-icon-delete" size="mini" circle @click="remove(scope.row)" />
        </template>
      </el-table-column>
    </el-table>
    <br>
    <div>
      <el-pagination
        :current-page="currentPage"
        :page-sizes="pageSizes"
        :page-size="10"
        :total="totalCount"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange" />
    </div>
    <div>
      <el-dialog :visible.sync="dialogFormVisible" title="项目">
        <el-form ref="projectForm" :model="project" :rules="formRules" label-width="80px" label-position="left">
          <el-form-item label="项目经理" prop="userId">
            <el-select v-model="project.userId" name="userId" placeholder="请选择">
              <el-option
                v-for="item in users"
                :key="item.id"
                :label="item.name"
                :value="item.id" />
            </el-select>
          </el-form-item>
          <el-form-item label="名称" prop="name">
            <el-input v-model="project.name" name="name" placeholder="项目名称" />
          </el-form-item>
          <el-form-item label="工程地址" prop="address">
            <el-input v-model="project.address" name="address" placeholder="地址" />
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="project.remark" type="textarea" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取 消</el-button>
          <el-button type="primary" @click="save">确 定</el-button>
        </div>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import { findByPage, create, update, findById, deleteById } from '@/api/project'
import { findAll } from '@/api/user'

export default {
  name: 'Project',
  data() {
    const validateName = (rule, value, callback) => {
      if (value === null || value === '') {
        callback(new Error('项目名称不能为空'))
      } else {
        callback()
      }
    }
    return {
      projects: null,
      listLoading: false,
      pageSizes: [1, 10, 20, 50, 100],
      pageSize: 10,
      currentPage: 1,
      totalCount: 1,
      dialogFormVisible: false,
      project: {
        'id': '',
        'userId': '',
        'name': '',
        'address': '',
        'remark': ''
      },
      formRules: {
        userId: [{ required: true, trigger: 'change', message: '请选择采购日期' }],
        name: [{ required: true, trigger: 'blur', validator: validateName }]
      },
      dialogConfirmVisible: false,
      users: []
    }
  },
  created() {
    this.init()
  },
  methods: {
    init() {
      this.list(1, this.pageSize)
    },
    handleSizeChange(pageSize) {
      this.pageSize = pageSize
      this.list(this.currentPage, this.pageSize)
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage
      this.list(this.currentPage, this.pageSize)
    },
    findUsers() {
      findAll().then(response => {
        this.users = response.data
      })
    },
    list(currentPage, pageSize) {
      this.listLoading = true
      findByPage(currentPage, pageSize).then(response => {
        const result = response.data
        this.projects = result.record
        this.totalCount = result.totalCount
        this.currentPage = result.currentPage
        this.listLoading = false
      })
    },
    create() {
      this.project.id = ''
      this.project.userId = ''
      this.project.name = ''
      this.project.address = ''
      this.project.remark = ''
      this.findUsers()
      this.dialogFormVisible = true
    },
    update(project) {
      this.project.id = project.id
      this.find(this.project.id)
      this.findUsers()
      this.dialogFormVisible = true
    },
    find(id) {
      findById(id).then(response => {
        const result = response.data
        this.project.id = result.id
        this.project.userId = result.userId
        this.project.name = result.name
        this.project.address = result.address
        this.project.remark = result.remark
      })
    },
    remove(project) {
      this.$confirm('此操作将永久删除该项目, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteById(project.id).then(response => {
          this.$message({ message: response.msg, type: 'success' })
          this.list(this.currentPage, this.pageSize)
        })
      })
    },
    save() {
      this.$refs.projectForm.validate(valid => {
        if (valid) {
          // 判断是创建还是修改
          if (this.project.id === '') {
            // 创建
            create(this.project).then(response => {
              this.$message({ message: response.msg, type: 'success' })
              this.dialogFormVisible = false
              this.list(1, this.pageSize)
            })
          } else {
            // 修改
            update(this.project).then(response => {
              this.$message({ message: response.msg, type: 'success' })
              this.dialogFormVisible = false
              this.list(this.currentPage, this.pageSize)
            })
          }
        }
      })
    }
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
</style>
