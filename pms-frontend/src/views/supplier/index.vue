<template>
  <div class="app-container">
    <el-button type="primary" round icon="el-icon-plus" @click="create">创建供应商</el-button>
    <br><br>
    <el-table
      v-loading="listLoading"
      :data="suppliers"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="ID" width="50">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="名称" width="120">
        <template slot-scope="scope">
          {{ scope.row.name }}
        </template>
      </el-table-column>
      <el-table-column label="开户行" width="150">
        <template slot-scope="scope">
          {{ scope.row.bankName }}
        </template>
      </el-table-column>
      <el-table-column label="卡号" width="120">
        <template slot-scope="scope">
          {{ scope.row.bankAccount }}
        </template>
      </el-table-column>
      <el-table-column label="联系人" width="100">
        <template slot-scope="scope">
          {{ scope.row.contact }}
        </template>
      </el-table-column>
      <el-table-column label="联系电话" width="120">
        <template slot-scope="scope">
          {{ scope.row.contactPhone }}
        </template>
      </el-table-column>
      <el-table-column label="地址" width="255">
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
      <el-dialog :visible.sync="dialogFormVisible" title="供应商">
        <el-form ref="supplierForm" :model="supplier" :rules="formRules" label-width="80px" label-position="left">
          <el-form-item label="名称" prop="name">
            <el-input v-model="supplier.name" name="name" />
          </el-form-item>
          <el-form-item label="开户行" prop="bankName">
            <el-input v-model="supplier.bankName" name="bankName" />
          </el-form-item>
          <el-form-item label="卡号" prop="bankAccount">
            <el-input v-model="supplier.bankAccount" name="bankAccount" />
          </el-form-item>
          <el-form-item label="联系人" prop="contact">
            <el-input v-model="supplier.contact" name="contact" />
          </el-form-item>
          <el-form-item label="联系电话" prop="contactPhone">
            <el-input v-model="supplier.contactPhone" name="contactPhone" />
          </el-form-item>
          <el-form-item label="地址" prop="address">
            <el-input v-model="supplier.address" name="address" />
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="supplier.remark" type="textarea" />
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
import { findByPage, create, update, findById, deleteById } from '@/api/supplier'

export default {
  name: 'Supplier',
  data() {
    const validateName = (rule, value, callback) => {
      if (value === null || value === '') {
        callback(new Error('请输入正确的供应商名称'))
      } else {
        callback()
      }
    }
    const validateBankName = (rule, value, callback) => {
      if (value === null || value === '') {
        callback(new Error('请输入正确的供应商名称'))
      } else {
        callback()
      }
    }
    const validateBankAccount = (rule, value, callback) => {
      if (value === null || value === '') {
        callback(new Error('请输入正确的供应商名称'))
      } else {
        callback()
      }
    }
    return {
      suppliers: null,
      listLoading: false,
      pageSizes: [1, 10, 20, 50, 100],
      pageSize: 10,
      currentPage: 1,
      totalCount: 1,
      dialogFormVisible: false,
      supplier: {
        'id': '',
        'name': '',
        'bankName': '',
        'bankAccount': '',
        'contact': '',
        'contactPhone': '',
        'address': '',
        'remark': ''
      },
      formRules: {
        name: [{ required: true, trigger: 'blur', validator: validateName }],
        bankName: [{ required: true, trigger: 'blur', validator: validateBankName }],
        bankAccount: [{ required: true, trigger: 'blur', validator: validateBankAccount }]
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
        this.suppliers = result.record
        this.totalCount = result.totalCount
        this.currentPage = result.currentPage
        this.listLoading = false
      })
    },
    create() {
      this.supplier.id = ''
      this.supplier.name = ''
      this.supplier.bankName = ''
      this.supplier.bankAccount = ''
      this.supplier.contact = ''
      this.supplier.contactPhone = ''
      this.supplier.address = ''
      this.supplier.remark = ''
      this.dialogFormVisible = true
    },
    update(supplier) {
      this.supplier.id = supplier.id
      this.find(this.supplier.id)
      this.dialogFormVisible = true
    },
    find(id) {
      findById(id).then(response => {
        const result = response.data
        this.supplier.id = result.id
        this.supplier.name = result.name
        this.supplier.bankName = result.bankName
        this.supplier.bankAccount = result.bankAccount
        this.supplier.contact = result.contact
        this.supplier.contactPhone = result.contactPhone
        this.supplier.address = result.address
        this.supplier.remark = result.remark
      })
    },
    remove(supplier) {
      this.$confirm('此操作将永久删除该供应商, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteById(supplier.id).then(response => {
          this.$message({ message: response.msg, type: 'success' })
          this.list(this.currentPage, this.pageSize)
        })
      })
    },
    save() {
      this.$refs.supplierForm.validate(valid => {
        if (valid) {
          // 判断是创建还是修改
          if (this.supplier.id === '') {
            // 创建
            create(this.supplier).then(response => {
              this.$message({ message: response.msg, type: 'success' })
              this.dialogFormVisible = false
              this.list(1, this.pageSize)
            })
          } else {
            // 修改
            update(this.supplier).then(response => {
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
