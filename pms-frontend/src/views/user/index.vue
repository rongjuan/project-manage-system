<template>
  <div class="app-container">
    <!-- 查询区 -->
    <div class="filter-container">
      <el-input v-model="userQuery.account" placeholder="账号" style="width: 200px;" class="filter-item" />
      <el-input v-model="userQuery.name" placeholder="名称" style="width: 150px;" class="filter-item" />
      <el-input v-model="userQuery.phone" placeholder="电话" style="width: 200px;" class="filter-item" />
      <el-input v-model="userQuery.email" placeholder="邮箱" style="width: 255px;" class="filter-item" />
      <el-button class="filter-item" type="primary" icon="el-icon-search" style="margin-left: 10px;" @click="query">查询</el-button>
      <el-button class="filter-item" type="primary" icon="el-icon-refresh">重置</el-button>
    </div>
    <br>
    <!-- 列表区 -->
    <div class="filter-container" style="text-align: right">
      <el-button type="success" round icon="el-icon-circle-plus" @click="openForm()">新建</el-button>
      <el-button type="danger" round icon="el-icon-delete-solid" @click="removeBatch()">删除</el-button>
    </div>
    <br>
    <el-table
      ref="userTable"
      v-loading="listLoading"
      :data="users"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      style="width: 100%;"
      @selection-change="handleSelectionChange"
    >
      <el-table-column align="center" type="selection" width="55" />
      <el-table-column align="left" label="账号" width="200" prop="account" />
      <el-table-column align="left" label="名称" width="150" prop="name" />
      <el-table-column align="left" label="电话" width="180" prop="phone" />
      <el-table-column align="left" label="邮箱" width="200" prop="email" />
      <el-table-column align="center" label="头像" width="95" prop="photo">
        <template slot-scope="scope">
          <el-image :src="scope.row.photo" style="width: 40px; height: 40px" />
        </template>
      </el-table-column>
      <el-table-column align="left" label="备注" prop="remark" />
      <el-table-column
        fixed="right"
        label="操作"
        width="150"
      >
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="openForm(scope.row)" />
          <el-button type="danger" icon="el-icon-delete" circle @click="remove(scope.row.id)" />
        </template>
      </el-table-column>
    </el-table>
    <br>
    <!-- 分页区 -->
    <div>
      <el-pagination
        :page-sizes="userQuery.page.pageSizes"
        :page-size="userQuery.page.pageSize"
        :current-page="userQuery.page.pageNum"
        :total="userQuery.page.totalCount"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </div>
    <!-- 表单区 -->
    <el-dialog title="用户信息" :visible.sync="dialogFormVisible">
      <el-form ref="userForm" :model="user" label-width="80px" :rules="rules">
        <el-form-item label="账号" prop="account">
          <el-input v-model="user.account" :disabled="accountDisabled" />
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="user.name" />
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="user.phone" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="user.email" />
        </el-form-item>
        <el-form-item label="头像" prop="photo">
          <el-input v-model="user.photo" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="user.remark" type="textarea" maxlength="200" show-word-limit />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" :loading="saveLoading" @click="save">保存</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>

import { getUserList, createUser, updateUser, deleteUser, deleteBatchUser, existUser } from '@/api/user'

export default {
  data () {
    const accountIsExist = (rule, value, callback) => {
      if (!this.user.id) {
        existUser(value).then(response => {
          if (response.data) {
            callback(new Error('账号已存在。'))
          } else {
            callback()
          }
        })
      } else {
        callback()
      }
    }
    return {
      listLoading: true,
      dialogFormVisible: false,
      saveLoading: false,
      accountDisabled: true,
      users: [],
      userQuery: {
        account: '',
        name: '',
        phone: '',
        email: '',
        page: {
          pageSizes: [1, 10, 20, 50, 100],
          pageSize: 10,
          totalCount: 1,
          pageNum: 1
        }
      },
      form: {
        id: '',
        account: '',
        name: '',
        phone: '',
        email: '',
        photo: '',
        remark: ''
      },
      user: {},
      userSelection: [],
      rules: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          { min: 3, max: 45, message: '长度在 3 到 45 个字符', trigger: 'blur' },
          { validator: accountIsExist, trigger: 'blur' }
        ],
        name: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 2, max: 25, message: '长度在 2 到 25 个字符', trigger: 'blur' }
        ],
        phone: [
          { required: true, message: '请输入 11 位电话', len: 11, trigger: 'blur' }
        ],
        email: [
          { required: true, message: '请输入邮箱', type: 'email', trigger: 'blur' }
        ],
        photo: [
          { required: true, message: '请输入头像', trigger: 'blur' },
          { max: 200, message: '长度不能超过 200 个字符', trigger: 'blur' }
        ],
        remark: [
          { max: 200, message: '长度不能超过 200 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  created () {
    this.getUserList()
  },
  methods: {
    getUserList () {
      this.listLoading = true
      getUserList(this.userQuery).then(response => {
        const { data } = response
        this.users = data.record
        this.userQuery.page.pageNum = data.currentPage
        this.userQuery.page.totalCount = data.totalCount
      }).finally(() => {
        this.listLoading = false
      })
    },
    query () {
      this.userQuery.page.pageNum = 1
      this.getUserList()
    },
    handleSizeChange (pageSize) {
      this.userQuery.page.pageSize = pageSize
      this.getUserList()
    },
    handleCurrentChange (pageNum) {
      this.userQuery.page.pageNum = pageNum
      this.getUserList()
    },
    handleSelectionChange (val) {
      this.userSelection = val
    },
    openForm (row) {
      this.dialogFormVisible = true
      if (this.$refs['userForm'] !== undefined) {
        this.$refs['userForm'].resetFields()
      }
      this.user = Object.assign({}, this.form)
      if (!row) {
        this.accountDisabled = false
      } else {
        this.accountDisabled = true
        for (const props in this.form) {
          this.user[props] = row[props]
        }
      }
    },
    save () {
      this.$refs['userForm'].validate((valid) => {
        if (!valid) return
        const user = Object.assign({}, this.user)
        if (!user.id) {
          this.createUser(user)
        } else {
          this.updateUser(user)
        }
      })
    },
    createUser (user) {
      this.saveLoading = true
      createUser(user).then((response) => {
        this.dialogFormVisible = false
        this.getUserList()
        this.$message({ type: 'success', message: response.msg })
      }).finally(() => {
        this.saveLoading = false
      })
    },
    updateUser (user) {
      this.saveLoading = true
      updateUser(user).then((response) => {
        this.dialogFormVisible = false
        this.getUserList()
        this.$message({ type: 'success', message: response.msg })
      }).finally(() => {
        this.saveLoading = false
      })
    },
    remove (id) {
      this.$confirm('是否确认要删除该用户?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteUser(id).then((response) => {
          this.getUserList()
          this.$message({ type: 'success', message: response.msg })
        })
      })
    },
    removeBatch () {
      if (!this.userSelection.length) {
        this.$message({ type: 'info', message: '请选择要删除的用户。' })
        return
      }
      this.$confirm('是否确认要删除这些用户?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteBatchUser(this.userSelection.map(user => user.id)).then(response => {
          this.getUserList()
          this.$message({ type: 'success', message: response.msg })
        })
      })
    }
  }
}
</script>
