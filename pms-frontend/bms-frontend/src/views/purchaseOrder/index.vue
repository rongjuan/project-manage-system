<template>
  <div class="app-container">
    <el-button type="primary" round icon="el-icon-plus" @click="create">创建采购订单</el-button>
    <br><br>
    <el-table
      v-loading="listLoading"
      :data="purchaseOrders"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="序号" width="50">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="采购日期">
        <template slot-scope="scope">
          {{ scope.row.purchaseDate }}
        </template>
      </el-table-column>
      <el-table-column label="供应商">
        <template slot-scope="scope">
          {{ scope.row.supplierName }}
        </template>
      </el-table-column>
      <el-table-column label="商品">
        <template slot-scope="scope">
          {{ scope.row.commodityName }}
        </template>
      </el-table-column>
      <el-table-column label="归属项目">
        <template slot-scope="scope">
          {{ scope.row.projectName }}
        </template>
      </el-table-column>
      <el-table-column label="商品规格">
        <template slot-scope="scope">
          {{ scope.row.specification }}
        </template>
      </el-table-column>
      <el-table-column label="单位">
        <template slot-scope="scope">
          {{ scope.row.unit }}
        </template>
      </el-table-column>
      <el-table-column label="数量">
        <template slot-scope="scope">
          {{ scope.row.quantity }}
        </template>
      </el-table-column>
      <el-table-column label="单价">
        <template slot-scope="scope">
          {{ scope.row.price }}
        </template>
      </el-table-column>
      <el-table-column label="合计">
        <template slot-scope="scope">
          {{ scope.row.amount }}
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
      <el-dialog :visible.sync="dialogFormVisible" title="采购订单">
        <el-form ref="purchaseOrderForm" :model="purchaseOrder" :rules="formRules" label-width="80px" label-position="left">
          <el-form-item label="采购日期" prop="purchaseDate">
            <el-date-picker v-model="purchaseOrder.purchaseDate" type="date" placeholder="选择日期" value-format="yyyy-MM-dd HH:mm:ss"/>
          </el-form-item>
          <el-form-item label="项目" prop="projectId">
            <el-select v-model="purchaseOrder.projectId" name="projectId" placeholder="请选择">
              <el-option
                v-for="item in projects"
                :key="item.id"
                :label="item.name"
                :value="item.id" />
            </el-select>
          </el-form-item>
          <el-form-item label="商品" prop="commodityId">
            <el-select v-model="purchaseOrder.commodityId" name="commodityId" placeholder="请选择">
              <el-option
                v-for="item in commodities"
                :key="item.id"
                :label="item.name"
                :value="item.id" />
            </el-select>
          </el-form-item>
          <el-form-item label="供应商" prop="supplierId">
            <el-select v-model="purchaseOrder.supplierId" name="supplierId" placeholder="请选择">
              <el-option
                v-for="item in suppliers"
                :key="item.id"
                :label="item.name"
                :value="item.id" />
            </el-select>
          </el-form-item>
          <el-form-item label="商品规格" prop="specification">
            <el-input v-model="purchaseOrder.specification" name="specification" placeholder="商品规格" />
          </el-form-item>
          <el-form-item label="单位名称" prop="unit">
            <el-input v-model="purchaseOrder.unit" name="unit" placeholder="单位名称" />
          </el-form-item>
          <el-form-item label="单价" prop="price">
            <el-input-number :precision="2" v-model="purchaseOrder.price" name="price" @change="updateAmount" />
          </el-form-item>
          <el-form-item label="商品数量" prop="quantity">
            <el-input-number v-model="purchaseOrder.quantity" name="quantity" @change="updateAmount" />
          </el-form-item>
          <el-form-item label="合计" prop="amount">
            <el-input-number :precision="2" v-model="purchaseOrder.amount" name="amount" disabled />
          </el-form-item>
          <el-form-item label="备注">
            <el-input v-model="purchaseOrder.remark" type="textarea" />
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
import { findByPage, create, update, findById, deleteById } from '@/api/purchaseOrder'
import { findAllSuppliers } from '@/api/supplier'
import { findAllCommodities } from '@/api/commodity'
import { findAllProjects } from '@/api/project'

export default {
  name: 'PurchaseOrder',
  data() {
    return {
      purchaseOrders: null,
      listLoading: false,
      pageSizes: [1, 10, 20, 50, 100],
      pageSize: 10,
      currentPage: 1,
      totalCount: 1,
      dialogFormVisible: false,
      purchaseOrder: {
        'id': '',
        'purchaseDate': '',
        'supplierId': '',
        'supplierName': '',
        'commodityId': '',
        'commodityName': '',
        'projectId': '',
        'projectName': '',
        'specification': '',
        'unit': '',
        'quantity': 1,
        'price': 0.00,
        'amount': 0.00,
        'remark': ''
      },
      formRules: {
        purchaseDate: [{ required: true, message: '请选择采购日期', trigger: 'change' }],
        supplierId: [{ required: true, message: '请选择供应商', trigger: 'change' }],
        commodityId: [{ required: true, message: '请选择商品', trigger: 'change' }],
        projectId: [{ required: true, message: '请选择项目', trigger: 'change' }],
        specification: [{ required: true, message: '请填写规格', trigger: 'blur' }],
        unit: [{ required: true, message: '请填写单位名称', trigger: 'blur' }],
        quantity: [{ type: 'number', required: true, message: '请填写数量', trigger: 'blur' }],
        price: [{ type: 'number', required: true, message: '请填写单价', trigger: 'blur' }]
      },
      dialogConfirmVisible: false,
      suppliers: [],
      commodities: [],
      projects: []
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
    updateAmount() {
      this.purchaseOrder.amount = this.purchaseOrder.quantity * this.purchaseOrder.price
    },
    findSuppliers() {
      findAllSuppliers().then(response => {
        this.suppliers = response.data
      })
    },
    findCommodities() {
      findAllCommodities().then(response => {
        this.commodities = response.data
      })
    },
    findProjects() {
      findAllProjects().then(response => {
        this.projects = response.data
      })
    },
    list(currentPage, pageSize) {
      this.listLoading = true
      findByPage(currentPage, pageSize).then(response => {
        const result = response.data
        this.purchaseOrders = result.record
        this.totalCount = result.totalCount
        this.currentPage = result.currentPage
        this.listLoading = false
      })
    },
    create() {
      this.purchaseOrder.id = ''
      this.purchaseOrder.purchaseDate = ''
      this.purchaseOrder.supplierId = ''
      this.purchaseOrder.commodityId = ''
      this.purchaseOrder.projectId = ''
      this.purchaseOrder.specification = ''
      this.purchaseOrder.unit = ''
      this.purchaseOrder.quantity = 1
      this.purchaseOrder.price = 0.00
      this.purchaseOrder.amount = 0.00
      this.purchaseOrder.remark = ''
      this.findSuppliers()
      this.findCommodities()
      this.findProjects()
      this.dialogFormVisible = true
    },
    update(purchaseOrder) {
      this.purchaseOrder.id = purchaseOrder.id
      this.find(this.purchaseOrder.id)
      this.findSuppliers()
      this.findCommodities()
      this.findProjects()
      this.dialogFormVisible = true
    },
    find(id) {
      findById(id).then(response => {
        const result = response.data
        this.purchaseOrder.id = result.id
        this.purchaseOrder.purchaseDate = result.purchaseDate
        this.purchaseOrder.supplierId = result.supplierId
        this.purchaseOrder.commodityId = result.commodityId
        this.purchaseOrder.projectId = result.projectId
        this.purchaseOrder.specification = result.specification
        this.purchaseOrder.unit = result.unit
        this.purchaseOrder.quantity = result.quantity
        this.purchaseOrder.price = result.price
        this.purchaseOrder.amount = result.amount
        this.purchaseOrder.remark = result.remark
      })
    },
    remove(purchaseOrder) {
      this.$confirm('此操作将永久删除该采购订单, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteById(purchaseOrder.id).then(response => {
          this.$message({ message: response.msg, type: 'success' })
          this.list(this.currentPage, this.pageSize)
        })
      })
    },
    save() {
      this.$refs.purchaseOrderForm.validate(valid => {
        if (valid) {
          // 判断是创建还是修改
          if (this.purchaseOrder.id === '') {
            // 创建
            create(this.purchaseOrder).then(response => {
              this.$message({ message: response.msg, type: 'success' })
              this.dialogFormVisible = false
              this.list(1, this.pageSize)
            })
          } else {
            // 修改
            update(this.purchaseOrder).then(response => {
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
