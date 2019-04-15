<template>
  <div class="app-container">
    <el-button type="primary" round icon="el-icon-plus" @click="create">创建商品</el-button>
    <br><br>
    <el-table
      v-loading="listLoading"
      :data="fees"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="序号" width="50">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="名称" width="255">
        <template slot-scope="scope">
          {{ scope.row.name }}
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
      <el-dialog :visible.sync="dialogFormVisible" title="商品">
        <el-form ref="feeForm" :model="fee" :rules="formRules" label-width="80px" label-position="left">
          <el-form-item label="类型名称" prop="name">
            <el-input v-model="fee.name" name="name" placeholder="商品名称" />
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="fee.remark" type="textarea" />
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
import { findByPage, create, update, findById, deleteById } from '@/api/fee'

export default {
  name: 'Fee',
  data() {
    const validateName = (rule, value, callback) => {
      if (value === null || value === '') {
        callback(new Error('商品名称不能为空'))
      } else {
        callback()
      }
    }
    return {
      fees: null,
      listLoading: false,
      pageSizes: [1, 10, 20, 50, 100],
      pageSize: 10,
      currentPage: 1,
      totalCount: 1,
      dialogFormVisible: false,
      fee: {
        'id': '',
        'name': '',
        'remark': ''
      },
      formRules: {
        name: [{ required: true, trigger: 'blur', validator: validateName }]
      },
      dialogConfirmVisible: false
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
    list(currentPage, pageSize) {
      this.listLoading = true
      findByPage(currentPage, pageSize).then(response => {
        const result = response.data
        this.fees = result.record
        this.totalCount = result.totalCount
        this.currentPage = result.currentPage
        this.listLoading = false
      })
    },
    create() {
      this.fee.id = ''
      this.fee.name = ''
      this.fee.remark = ''
      this.dialogFormVisible = true
    },
    update(fee) {
      this.fee.id = fee.id
      this.find(this.fee.id)
      this.dialogFormVisible = true
    },
    find(id) {
      findById(id).then(response => {
        const result = response.data
        this.fee.id = result.id
        this.fee.name = result.name
        this.fee.remark = result.remark
      })
    },
    remove(fee) {
      this.$confirm('此操作将永久删除该商品, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteById(fee.id).then(response => {
          this.$message({ message: response.msg, type: 'success' })
          this.list(this.currentPage, this.pageSize)
        })
      })
    },
    save() {
      this.$refs.feeForm.validate(valid => {
        if (valid) {
          // 判断是创建还是修改
          if (this.fee.id === '') {
            // 创建
            create(this.fee).then(response => {
              this.$message({ message: response.msg, type: 'success' })
              this.dialogFormVisible = false
              this.list(1, this.pageSize)
            })
          } else {
            // 修改
            update(this.fee).then(response => {
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
