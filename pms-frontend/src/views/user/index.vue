<template>
  <div>
    <!-- 查询区 -->
    <el-form :inline="true" :model="queryForm">
      <el-form-item label="账号:">
        <el-input v-model.trim="queryForm.account" class="query-form-input" placeholder="请输入账号" />
      </el-form-item>
      <el-form-item label="名称:">
        <el-input v-model.trim="queryForm.name" class="query-form-input" placeholder="请输入名称" />
      </el-form-item>
      <el-form-item label="电话:">
        <el-input v-model.trim="queryForm.phone" class="query-form-input" placeholder="请输入电话" />
      </el-form-item>
      <el-form-item label="邮箱:">
        <el-input v-model.trim="queryForm.email" class="query-form-input" placeholder="请输入邮箱" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="queryClick()">查询</el-button>
        <el-button @click="resetClick()">重置</el-button>
      </el-form-item>
    </el-form>

    <!-- 列表区 -->
    <div style="text-align: right;margin-bottom: 20px;">
      <el-button type="success" @click="editClick()">添加</el-button>
      <el-button type="danger" :disabled="!userSelection.length" @click="deleteBatchClick()">批量删除</el-button>
    </div>

    <el-table
      v-loading="loading"
      :data="dataTable"
      border
      highlight-current-row
      tooltip-effect="dark"
      @selection-change="selectChange"
    >
      <el-table-column
        align="center"
        type="selection"
        width="55"
      />
      <el-table-column
        align="center"
        label="账号"
        show-overflow-tooltip
        prop="account"
      />
      <el-table-column
        align="center"
        label="名称"
        show-overflow-tooltip
        prop="name"
      />
      <el-table-column
        align="center"
        label="电话"
        show-overflow-tooltip
        prop="phone"
      />
      <el-table-column
        align="center"
        label="邮箱"
        show-overflow-tooltip
        prop="email"
      />
      <el-table-column
        align="center"
        label="头像"
        width="100"
        prop="photo"
      >
        <template slot-scope="scope">
          <el-image :src="scope.row.photo" style="width: 40px;" />
        </template>
      </el-table-column>
      <el-table-column
        align="center"
        label="备注"
        show-overflow-tooltip
        prop="remark"
      />
      <el-table-column
        align="center"
        label="操作"
        width="150"
      >
        <template slot-scope="scope">
          <el-button type="text" @click="editClick(scope.row)">修改</el-button>
          <el-button type="text" @click="deleteClick(scope.row.id)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- 分页区 -->
    <div style="margin: 20px 0;">
      <el-pagination
        :page-sizes="[1, 10, 20, 50, 100]"
        :page-size="page.pageSize"
        :current-page="page.pageNum"
        :total="totalCount"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="sizeChange"
        @current-change="currentPageChange"
      />
    </div>
    <!-- 表单区 -->
    <el-dialog :title="title" :visible.sync="dialogFormVisible">
      <el-form ref="userForm" :model="userForm" label-width="80px" :rules="rules">
        <el-form-item label="账号" prop="account">
          <el-input v-model="userForm.account" :disabled="!!userForm.id" />
        </el-form-item>
        <el-form-item label="名称" prop="name">
          <el-input v-model="userForm.name" />
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="userForm.phone" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="userForm.email" />
        </el-form-item>
        <el-form-item label="头像" prop="photo">
          <el-input v-model="userForm.photo" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="userForm.remark" type="textarea" maxlength="200" show-word-limit />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" :loading="buttonLoading" @click="submitClick">保存</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>

import { getUserPageList, addUser, updateUser, deleteUser, deleteBatchUser, existUser } from '@/api/user'

export default {
  data () {
    const accountIsExist = (rule, value, callback) => {
      if (!this.userForm.id) {
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
      loading: true,
      dialogFormVisible: false,
      buttonLoading: false,
      dataTable: [],
      queryForm: {
        account: '',
        name: '',
        phone: '',
        email: ''
      },
      page: {
        pageSize: 10,
        pageNum: 1
      },
      totalCount: 1,
      form: {
        id: '',
        account: '',
        name: '',
        phone: '',
        email: '',
        photo: '',
        remark: ''
      },
      title: '',
      userForm: {},
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
    this.queryClick()
  },
  methods: {
    queryClick () {
      this.page.pageNum = 1
      this.getUserList()
    },
    resetClick () {
      this.queryForm = {
        account: '',
        name: '',
        phone: '',
        email: ''
      }
    },
    editClick (row) {
      this.dialogFormVisible = true
      if (this.$refs['userForm'] !== undefined) {
        this.$refs['userForm'].resetFields()
      }
      this.userForm = Object.assign({}, this.form)
      if (!row) {
        this.title = '添加用户信息'
      } else {
        this.title = '修改用户信息'
        for (const props in this.form) {
          this.userForm[props] = row[props]
        }
      }
    },

    getUserList () {
      this.loading = true
      const params = Object.assign({}, this.queryForm, { page: this.page })
      getUserPageList(params).then(response => {
        const { data } = response
        this.dataTable = data.record
        this.totalCount = data.totalCount === 0 ? 1 : data.totalCount
      }).finally(() => {
        this.loading = false
      })
    },
    sizeChange (pageSize) {
      this.page.pageSize = pageSize
      this.getUserList()
    },
    currentPageChange (pageNum) {
      this.page.pageNum = pageNum
      this.getUserList()
    },
    selectChange (val) {
      this.userSelection = val
    },
    submitClick () {
      this.$refs['userForm'].validate((valid) => {
        if (!valid) return
        const params = Object.assign({}, this.userForm)
        this.buttonLoading = true
        if (!params.id) {
          addUser(params).then((response) => {
            this.dialogFormVisible = false
            this.$message.success(response.msg)
            this.getUserList()
          }).finally(() => {
            this.buttonLoading = false
          })
        } else {
          updateUser(params).then((response) => {
            this.dialogFormVisible = false
            this.$message.success(response.msg)
            this.getUserList()
          }).finally(() => {
            this.buttonLoading = false
          })
        }
      })
    },
    deleteClick (id) {
      this.$confirm('是否确认要删除该用户?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteUser(id).then((response) => {
          this.$message.success(response.msg)
          this.getUserList()
        })
      })
    },
    deleteBatchClick () {
      this.$confirm('是否确认要删除这些用户?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteBatchUser(this.userSelection.map(user => user.id)).then(response => {
          this.$message.success(response.msg)
          this.getUserList()
        })
      })
    }
  }
}
</script>
<style lang="scss" scoped>
.query-form-input {
  width: 150px;
}
</style>
