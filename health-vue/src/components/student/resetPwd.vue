<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
    <el-form-item label="新密码" prop="s_password">
      <el-input v-model="user.s_password" placeholder="请输入新密码" type="password" />
    </el-form-item>
    <el-form-item label="确认密码" prop="confirmPassword">
      <el-input v-model="user.confirmPassword" placeholder="请确认密码" type="password" />
    </el-form-item>
    <el-form-item>
      <el-button type="primary" size="mini" @click="submit">保存</el-button>
      <el-button type="danger" size="mini" @click="close">关闭</el-button>
    </el-form-item>
  </el-form>
</template>

<script>

export default {
  data() {
    const equalToPassword = (rule, value, callback) => {
      if (this.user.s_password !== value) {
        callback(new Error("两次输入的密码不一致"));
      } else {
        callback();
      }
    };
    return {
      test: "1test",
      user: {
        s_password: null,
        confirmPassword: null
      },
      // 表单校验
      rules: {
        s_password: [
          { required: true, message: "新密码不能为空", trigger: "blur" },
          { min: 6, max: 20, message: "长度在 6 到 20 个字符", trigger: "blur" }
        ],
        confirmPassword: [
          { required: true, message: "确认密码不能为空", trigger: "blur" },
          { required: true, validator: equalToPassword, trigger: "blur" }
        ]
      }
    };
  },
  methods: {
    submit() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          let s_id = this.$cookies.get("cid")
            this.$axios({ //修改密码
              url: '/health/studentPWD',
              method: 'put',
              data: {
                s_password: this.user.s_password,
                s_id:s_id
              }
            }).then(res => {
              if(res.data != null ) { //修改成功提示
                this.$message({
                  message: '修改成功!请重新登录!',
                  type: 'success'
                })
                this.$router.push({path:"/"}) //跳转到登录页面
                this.$cookies.remove("cname") //清除cookie
                this.$cookies.remove("cid")
                window.localStorage.removeItem("token")
                location.reload();
              }
              
            })
        }
      });
    },
    close() {
      this.$store.dispatch("tagsView/delView", this.$route);
      this.$router.push({ path: "/student" });
    }
  }
};
</script>
