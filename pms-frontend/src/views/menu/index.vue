<template>
  <div class="app-container">
    <el-row :gutter="12">
      <el-col :span="8">
        <el-card shadow="never">
          <div slot="header">
            <el-button type="success" icon="el-icon-plus" circle size="small" @click="createBrotherNode" />
            <el-button type="success" icon="el-icon-arrow-right" circle size="small" @click="createChildNode" />
            <el-button type="danger" icon="el-icon-delete" circle size="small" @click="removeNode" />
          </div>
          <el-tree
            ref="menuTree"
            :data="menus"
            :props="props"
            default-expand-all
            :highlight-current="true"
            :expand-on-click-node="false"
            @node-click="handleNodeClick"
          >
            <span slot-scope="{ node, data }" class="custom-tree-node">
              <span> <svg-icon :icon-class="data.icon" /> {{ node.label }}</span>
            </span>
          </el-tree>
        </el-card>
      </el-col>
      <el-col :span="16">
        <el-card shadow="never">
          <div slot="header" style="height: 32px">
            <span style="line-height: 32px">菜单管理 {{ title }}</span>
          </div>
          <el-form ref="menuForm" :model="menu" label-width="80px" :rules="rules">
            <el-form-item label="名称" prop="title">
              <el-input v-model="menu.title" />
            </el-form-item>
            <el-form-item label="图标" prop="icon">
              <el-input v-model="menu.icon" style="width: 90%" />
              <svg-icon :icon-class="menu.icon" style="margin-left: 10px" />
            </el-form-item>
            <el-form-item label="路径" prop="path">
              <el-input v-model="menu.path" />
            </el-form-item>
            <el-form-item label="排序" prop="sort">
              <el-input-number v-model="menu.sort" :min="1" :max="99" />
            </el-form-item>
            <el-form-item label="备注" prop="remark">
              <el-input v-model="menu.remark" type="textarea" maxlength="200" show-word-limit />
            </el-form-item>
            <el-form-item>
              <el-button type="primary" :loading="saveLoading" @click="save">保存</el-button>
            </el-form-item>
          </el-form>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>

import { getAllMenu, createMenu, updateMenu, removeMenu } from '@/api/menu'
import { parseObj } from '@/utils/index'

export default {
  data () {
    return {
      title: '',
      saveLoading: false,
      props: {
        label: 'title',
        icon: 'icon',
        children: 'children'
      },
      menus: [],
      menu: {},
      form: {
        id: '',
        pid: '',
        title: '',
        icon: 'config',
        path: '',
        sort: '',
        remark: ''
      },
      rules: {
        title: [
          { required: true, message: '请输入名称', trigger: 'blur' },
          { min: 3, max: 50, message: '长度在 3 到 50 个字符', trigger: 'blur' }
        ],
        icon: [
          { required: true, message: '请输入图标', trigger: 'blur' },
          { max: 200, message: '长度不能超过 200 个字符', trigger: 'blur' }
        ],
        path: [
          { required: true, message: '请输入路径', trigger: 'blur' },
          { max: 200, message: '长度不能超过 200 个字符', trigger: 'blur' }
        ],
        sort: [
          { type: 'number', required: true, message: '请输入排序编号', trigger: 'blur' }
        ],
        remark: [
          { max: 200, message: '长度不能超过 200 个字符', trigger: 'blur' }
        ]
      }
    }
  },
  created () {
    this.menu = Object.assign({}, this.form)
    this.initTree()
  },
  methods: {
    initTree () {
      getAllMenu().then(response => {
        this.menus = response.data
      })
    },
    handleNodeClick (data) {
      this.resetFields()
      parseObj(this.form, data, this.menu)
    },
    createBrotherNode () {
      if (this.validateCurrentNode()) {
        this.menu = Object.assign({}, this.form)
        this.menu.pid = this.$refs['menuTree'].getCurrentNode().pid
        this.title = ' -> 添加 【' + this.$refs['menuTree'].getCurrentNode().title + '】 的同级部门'
      }
    },
    createChildNode () {
      if (this.validateCurrentNode()) {
        this.menu = Object.assign({}, this.form)
        this.menu.pid = this.$refs['menuTree'].getCurrentNode().id
        this.title = ' -> 添加 【' + this.$refs['menuTree'].getCurrentNode().title + '】 的子部门'
      }
    },
    removeNode () {
      if (this.validateCurrentNode()) {
        this.$confirm('是否确认要删除该菜单?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          removeMenu(this.$refs['menuTree'].getCurrentNode().id).then(response => {
            this.initTree()
            this.$message({ type: 'success', message: response.msg })
          })
        })
      }
    },
    save () {
      if (this.validateCurrentNode()) {
        this.$refs['menuForm'].validate((valid) => {
          if (!valid) return
          const menu = Object.assign({}, this.menu)
          if (!menu.id) {
            this.createMenu(menu)
          } else {
            this.updateMenu(menu)
          }
        })
      }
    },
    createMenu (menu) {
      this.saveLoading = true
      createMenu(menu).then(response => {
        this.$message({ type: 'success', message: response.msg })
        this.menu = Object.assign({}, this.form)
        this.initTree()
      }).finally(() => {
        this.saveLoading = false
        this.resetFields()
      })
    },
    updateMenu (menu) {
      this.saveLoading = true
      updateMenu(menu).then(response => {
        this.$message({ type: 'success', message: response.msg })
        this.menu = Object.assign({}, this.form)
        this.initTree()
      }).finally(() => {
        this.saveLoading = false
        this.resetFields()
      })
    },
    validateCurrentNode () {
      const currentNode = this.$refs['menuTree'].getCurrentNode()
      if (!currentNode) {
        this.$message({ type: 'info', message: '请选择一个节点' })
        return false
      }
      return true
    },
    resetFields () {
      if (this.$refs['menuForm'] !== undefined) {
        this.$refs['menuForm'].resetFields()
      }
      this.title = ''
    }
  }
}
</script>

<style scoped>
  .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-right: 8px;
  }
</style>
