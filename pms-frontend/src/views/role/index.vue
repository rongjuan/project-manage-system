<template>
  <div class="app-container">
    <div class="filter-container" style="text-align: right">
      <el-button type="success" round icon="el-icon-circle-plus" @click="openForm">新建</el-button>
      <el-button type="danger" round icon="el-icon-delete-solid" @click="removeBatch">删除</el-button>
    </div>
    <br>
    <el-table
      ref="roleTable"
      v-loading="listLoading"
      :data="roles"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
      style="width: 100%;"
      @selection-change="handleSelectionChange"
    >
      <el-table-column align="center" type="selection" width="55" />
      <el-table-column align="left" label="名称" width="350" prop="name" />
      <el-table-column align="left" label="备注" prop="remark" />
      <el-table-column
        fixed="right"
        label="操作"
        width="300"
      >
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="openForm(scope.row)" />
          <el-button type="primary" icon="el-icon-user" circle @click="openUserSelector(scope.row.id)" />
          <el-button type="primary" icon="el-icon-setting" circle @click="openFunctionSelector(scope.row.id)" />
          <el-button type="danger" icon="el-icon-delete" circle @click="remove(scope.row.id)" />
        </template>
      </el-table-column>
    </el-table>
    <br>
    <!-- 分页区 -->
    <div>
      <el-pagination
        :page-sizes="roleQuery.page.pageSizes"
        :page-size="roleQuery.page.pageSize"
        :current-page="roleQuery.page.pageNum"
        :total="roleQuery.page.totalCount"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </div>
    <!-- 表单区 -->
    <el-dialog title="角色信息" :visible.sync="dialogFormVisible">
      <el-form ref="roleForm" :model="role" label-width="80px" :rules="rules">
        <el-form-item label="名称" prop="name">
          <el-input v-model="role.name" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="role.remark" type="textarea" maxlength="200" show-word-limit />
        </el-form-item>
        <el-form-item>
          <el-button type="primary" :loading="saveLoading" @click="save">保存</el-button>
          <el-button @click="dialogFormVisible = false">取消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 选择人员 -->
    <el-dialog title="授权人员" :visible.sync="dialogUserSelectorVisible" width="32%">
      <el-transfer
        v-model="userSelector"
        :titles="['待选', '已选']"
        filterable
        filter-placeholder="请输入姓名"
        :data="users"
        :props="prop"
      />
      <br>
      <div style="text-align: center">
        <el-button type="primary" @click="saveRoleUserRelation">保存</el-button>
        <el-button @click="dialogUserSelectorVisible = false">取消</el-button>
      </div>
    </el-dialog>
    <!-- 选择权限 -->
    <el-dialog title="授权功能" :visible.sync="dialogFunctionSelectorVisible" width="26%">
      <el-card class="box-card" shadow="never">
        <el-tree
          ref="menuTree"
          show-checkbox
          node-key="id"
          :data="menus"
          :props="treeProp"
          :check-strictly="true"
          default-expand-all
          :expand-on-click-node="false"
          :default-checked-keys="menuSelector"
        >
          <span slot-scope="{ node, data }" class="custom-tree-node">
            <span> <svg-icon :icon-class="data.icon" /> {{ node.label }}</span>
          </span>
        </el-tree>
      </el-card>
      <br>
      <div style="text-align: center">
        <el-button type="primary" size="small" @click="saveRoleMenuRelation">保存</el-button>
        <el-button size="small" @click="dialogFunctionSelectorVisible = false">取消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>

import { getRoleList, createRole, updateRole, deleteRole, deleteBatchRole, getRoleUser, saveRoleUser, getRoleMenu, saveRoleMenu } from '@/api/role'
import { getAllMenu } from '@/api/menu'
import { getAllUser } from '@/api/user'
import { parseObj } from '@/utils/index'

export default {
  data () {
    return {
      listLoading: true,
      dialogFormVisible: false,
      dialogUserSelectorVisible: false,
      dialogFunctionSelectorVisible: false,
      saveLoading: false,
      roles: [],
      roleQuery: {
        name: '',
        page: {
          pageSizes: [1, 10, 20, 50, 100],
          pageSize: 10,
          totalCount: 1,
          pageNum: 1
        }
      },
      form: {
        id: '',
        name: '',
        remark: '',
        users: [],
        menus: []
      },
      role: {},
      roleSelection: [],
      rules: {
        name: [
          { required: true, message: '请输入名称', trigger: 'blur' },
          { min: 2, max: 25, message: '长度在 2 到 25 个字符', trigger: 'blur' }
        ],
        remark: [
          { max: 200, message: '长度不能超过 200 个字符', trigger: 'blur' }
        ]
      },
      roleId: '',
      users: [],
      userSelector: [],
      prop: {
        key: 'id',
        value: 'id',
        label: 'name'
      },
      treeProp: {
        label: 'title',
        icon: 'icon',
        children: 'children'
      },
      menus: [],
      menuSelector: []
    }
  },
  created () {
    this.getRoleList()
  },
  methods: {
    getRoleList () {
      this.listLoading = true
      getRoleList(this.roleQuery).then(response => {
        const { data } = response
        this.roles = data.record
        this.roleQuery.page.pageNum = data.currentPage
        this.roleQuery.page.totalCount = data.totalCount
      }).finally(() => {
        this.listLoading = false
      })
    },
    handleSizeChange (pageSize) {
      this.roleQuery.page.pageSize = pageSize
      this.getRoleList()
    },
    handleCurrentChange (pageNum) {
      this.roleQuery.page.pageNum = pageNum
      this.getRoleList()
    },
    handleSelectionChange (val) {
      this.roleSelection = val
    },
    openForm (row) {
      this.dialogFormVisible = true
      if (this.$refs['roleForm'] !== undefined) {
        this.$refs['roleForm'].resetFields()
      }
      this.role = Object.assign({}, this.form)
      if (row) {
        parseObj(this.form, row, this.role)
      }
    },
    save () {
      this.$refs['roleForm'].validate((valid) => {
        if (!valid) return
        const role = Object.assign({}, this.role)
        if (!role.id) {
          this.createRole(role)
        } else {
          this.updateRole(role)
        }
      })
    },
    createRole (role) {
      this.saveLoading = true
      createRole(role).then(response => {
        this.dialogFormVisible = false
        this.getRoleList()
        this.$message({ type: 'success', message: response.msg })
      }).finally(() => {
        this.saveLoading = false
      })
    },
    updateRole (role) {
      this.saveLoading = true
      updateRole(role).then(response => {
        this.dialogFormVisible = false
        this.getRoleList()
        this.$message({ type: 'success', message: response.msg })
      }).finally(() => {
        this.saveLoading = false
      })
    },
    remove (id) {
      this.$confirm('是否确认要删除该角色?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteRole(id).then((response) => {
          this.getRoleList()
          this.$message({ type: 'success', message: response.msg })
        })
      })
    },
    removeBatch () {
      if (!this.roleSelection.length) {
        this.$message({ type: 'info', message: '请选择要删除的角色。' })
        return
      }
      this.$confirm('是否确认要删除这些角色?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        deleteBatchRole(this.roleSelection.map(role => role.id)).then(response => {
          this.getRoleList()
          this.$message({ type: 'success', message: response.msg })
        })
      })
    },
    openUserSelector (id) {
      this.dialogUserSelectorVisible = true
      this.roleId = id
      getAllUser().then(response => {
        this.users = response.data
        return getRoleUser(id)
      }).then(response => {
        this.userSelector = response.data
      })
    },
    saveRoleUserRelation () {
      this.saveLoading = true
      this.role = Object.assign({}, this.form)
      this.role.id = this.roleId
      this.role.users.length = 0
      this.userSelector.forEach(userId => {
        this.role.users.push({ 'id': userId })
      })
      const role = Object.assign({}, this.role)
      saveRoleUser(role).then(response => {
        this.dialogUserSelectorVisible = false
        this.$message({ type: 'success', message: response.msg })
      }).finally(() => {
        this.roleId = ''
        this.saveLoading = false
      })
    },
    openFunctionSelector (id) {
      this.dialogFunctionSelectorVisible = true
      this.roleId = id
      getAllMenu().then(response => {
        this.menus = response.data
        return getRoleMenu(id)
      }).then(response => {
        console.info(response)
        this.menuSelector = response.data
      })
    },
    saveRoleMenuRelation () {
      this.saveLoading = true
      this.role = Object.assign({}, this.form)
      this.role.id = this.roleId
      this.role.menus.length = 0
      this.role.menus = this.$refs.menuTree.getCheckedNodes().map(user => {
        return { 'id': user.id }
      })
      const role = Object.assign({}, this.role)
      saveRoleMenu(role).then(response => {
        this.dialogFunctionSelectorVisible = false
        this.$message({ type: 'success', message: response.msg })
      }).finally(() => {
        this.roleId = ''
        this.saveLoading = false
      })
    }
  }
}
</script>
