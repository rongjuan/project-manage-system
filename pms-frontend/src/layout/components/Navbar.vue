<template>
  <div class="navbar">
    <hamburger :is-active="sidebar.opened" class="hamburger-container" @toggleClick="toggleSideBar" />

    <breadcrumb class="breadcrumb-container" />

    <div class="right-menu">
      <el-dropdown class="avatar-container" trigger="click">
        <div class="avatar-wrapper">
          <img :src="avatar+'?imageView2/1/w/80/h/80'" class="user-avatar">
          <i class="el-icon-caret-bottom" />
        </div>
        <el-dropdown-menu slot="dropdown" class="user-dropdown">
          <router-link to="/">
            <el-dropdown-item>
              <span style="display:block;" @click="openForm">修改密码</span>
            </el-dropdown-item>
          </router-link>
          <el-dropdown-item divided>
            <span style="display:block;" @click="logout">登出</span>
          </el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
    <!-- 表单区 -->
    <el-dialog title="修改密码" :visible.sync="dialogFormVisible">
      <el-form ref="userForm" :model="user" label-width="80px" :rules="rules">
        <el-form-item label="旧密码" prop="oldSecret">
          <el-input v-model="user.oldSecret" type="password" placeholder="旧密码" />
        </el-form-item>
        <el-form-item label="新密码" prop="newSecret">
          <el-input v-model="user.newSecret" type="password" placeholder="新密码" />
        </el-form-item>
        <el-form-item label="确认密码" prop="checkSecret">
          <el-input v-model="user.checkSecret" type="password" placeholder="确认密码" />
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
import { mapGetters } from 'vuex'
import Breadcrumb from '@/components/Breadcrumb'
import Hamburger from '@/components/Hamburger'
import { updateUserSecret } from '@/api/user'

export default {
  components: {
    Breadcrumb,
    Hamburger
  },
  data () {
    const checkPwd = (rule, value, callback) => {
      if (value !== this.user.newSecret) {
        callback(new Error('两次输入的新密码不一致'))
      } else {
        callback()
      }
    }
    return {
      saveLoading: false,
      dialogFormVisible: false,
      user: {
        oldSecret: '',
        newSecret: '',
        checkSecret: ''
      },
      rules: {
        oldSecret: [
          { required: true, message: '请再次输入新密码', trigger: 'blur' },
          { min: 6, max: 36, message: '长度在 6 到 36 个字符', trigger: 'blur' }
        ],
        newSecret: [
          { required: true, message: '请再次输入新密码', trigger: 'blur' },
          { min: 6, max: 36, message: '长度在 6 到 36 个字符', trigger: 'blur' }
        ],
        checkSecret: [
          { required: true, message: '请再次输入新密码', trigger: 'blur' },
          { min: 6, max: 36, message: '长度在 6 到 36 个字符', trigger: 'blur' },
          { validator: checkPwd, trigger: 'blur' }
        ]
      }
    }
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'avatar'
    ])
  },
  methods: {
    toggleSideBar () {
      this.$store.dispatch('app/toggleSideBar')
    },
    async logout () {
      await this.$store.dispatch('user/logout')
      this.$router.push(`/login?redirect=${this.$route.fullPath}`)
    },
    openForm () {
      this.dialogFormVisible = true
      if (this.$refs['userForm'] !== undefined) {
        this.$refs['userForm'].resetFields()
      }
    },
    save () {
      this.$refs['userForm'].validate((valid) => {
        if (!valid) return
        const data = Object.assign({}, this.user)
        this.saveLoading = true
        updateUserSecret(data).then(response => {
          this.dialogFormVisible = false
          this.$message({ type: 'success', message: response.msg })
          this.$alert('修改密码成功，请重新登录。', '提示', {
            confirmButtonText: '确定',
            callback: action => {
              this.logout()
            }
          })
        }).finally(() => {
          this.saveLoading = false
        })
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0,21,41,.08);

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background .3s;
    -webkit-tap-highlight-color:transparent;

    &:hover {
      background: rgba(0, 0, 0, .025)
    }
  }

  .breadcrumb-container {
    float: left;
  }

  .right-menu {
    float: right;
    height: 100%;
    line-height: 50px;

    &:focus {
      outline: none;
    }

    .right-menu-item {
      display: inline-block;
      padding: 0 8px;
      height: 100%;
      font-size: 18px;
      color: #5a5e66;
      vertical-align: text-bottom;

      &.hover-effect {
        cursor: pointer;
        transition: background .3s;

        &:hover {
          background: rgba(0, 0, 0, .025)
        }
      }
    }

    .avatar-container {
      margin-right: 30px;

      .avatar-wrapper {
        margin-top: 5px;
        position: relative;

        .user-avatar {
          cursor: pointer;
          width: 40px;
          height: 40px;
          border-radius: 10px;
        }

        .el-icon-caret-bottom {
          cursor: pointer;
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
        }
      }
    }
  }
}
</style>
