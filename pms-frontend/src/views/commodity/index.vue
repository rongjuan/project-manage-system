<template>
  <div class="app-container">
    <el-button type="primary" round icon="el-icon-plus" @click="create">创建商品</el-button>
    <br><br>
    <el-table
      v-loading="listLoading"
      :data="commodities"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="序号" width="50">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="费用类型" width="255">
        <template slot-scope="scope">
          {{ scope.row.feeName }}
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
        <el-form ref="commodityForm" :model="commodity" :rules="formRules" label-width="80px" label-position="left">
          <el-form-item label="费用类型" prop="feeId">
            <el-select v-model="commodity.feeId" name="feeId" placeholder="请选择">
              <el-option
                v-for="item in fees"
                :key="item.id"
                :label="item.name"
                :value="item.id" />
            </el-select>
          </el-form-item>
          <el-form-item label="名称" prop="name">
            <el-input v-model="commodity.name" name="name" placeholder="商品名称" />
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="commodity.remark" type="textarea" />
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
import { findByPage, create, update, findById, deleteById } from '@/api/commodity'
import { findAll } from '@/api/fee'

export default {
  name: 'Commodity',
  data() {
    const validateName = (rule, value, callback) => {
      if (value === null || value === '') {
        callback(new Error('商品名称不能为空'))
      } else {
        callback()
      }
    }
    return {
      commodities: null,
      listLoading: false,
      pageSizes: [1, 10, 20, 50, 100],
      pageSize: 10,
      currentPage: 1,
      totalCount: 1,
      dialogFormVisible: false,
      commodity: {
        'id': '',
        'feeId': '',
        'feeName': '',
        'name': '',
        'remark': ''
      },
      formRules: {
        feeId: [{ required: true, trigger: 'change', message: '请选择费用类型' }],
        name: [{ required: true, trigger: 'blur', validator: validateName }]
      },
      dialogConfirmVisible: false,
      fees: []
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
    findFees() {
      findAll().then(response => {
        this.fees = response.data
      })
    },
    list(currentPage, pageSize) {
      this.listLoading = true
      findByPage(currentPage, pageSize).then(response => {
        const result = response.data
        this.commodities = result.record
        this.totalCount = result.totalCount
        this.currentPage = result.currentPage
        this.listLoading = false
      })
    },
    create() {
      this.commodity.id = ''
      this.commodity.feeId = ''
      this.commodity.name = ''
      this.commodity.remark = ''
      this.findFees()
      this.dialogFormVisible = true
    },
    update(commodity) {
      this.commodity.id = commodity.id
      this.find(this.commodity.id)
      this.findFees()
      this.dialogFormVisible = true
    },
    find(id) {
      findById(id).then(response => {
        const result = response.data
        this.commodity.id = result.id
        this.commodity.feeId = result.feeId
        this.commodity.name = result.name
        this.commodity.remark = result.remark
      })
    },
    remove(commodity) {
      this.$confirm('此操作将永久删除该商品, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteById(commodity.id).then(response => {
          this.$message({ message: response.msg, type: 'success' })
          this.list(this.currentPage, this.pageSize)
        })
      })
    },
    save() {
      this.$refs.commodityForm.validate(valid => {
        if (valid) {
          // 判断是创建还是修改
          if (this.commodity.id === '') {
            // 创建
            create(this.commodity).then(response => {
              this.$message({ message: response.msg, type: 'success' })
              this.dialogFormVisible = false
              this.list(1, this.pageSize)
            })
          } else {
            // 修改
            update(this.commodity).then(response => {
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
