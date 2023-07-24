<template>
  <el-form ref="form" :model="user" :rules="rules" label-width="80px">
         <el-form-item label="姓名" prop="s_name">
            <el-input v-model="user.s_name"  :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="学院" prop="s_college">
            <el-input v-model="user.s_college"  :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="专业" prop="s_major">
            <el-input v-model="user.s_major"  :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="班级" prop="s_class">
            <el-input v-model="user.s_class"  :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="电话" prop="s_phone">
            <el-input v-model="user.s_phone" maxlength="11"></el-input>
          </el-form-item>
         <el-form-item label="性别" prop="s_sex">
            <el-input v-model="user.s_sex" :disabled="true"></el-input>
        </el-form-item>
     <el-form-item>
      <el-button type="primary" size="medium" @click="submit">保存</el-button>
       <el-button type="danger" size="mini" @click="close">关闭</el-button>
    </el-form-item>
  </el-form>
</template>

<script>

export default {
  props: {
    user: {
      type: Object
    }
  },
  data() {
    return {
     rules: {
        s_phone: [
          { required: true, message: "手机号码不能为空", trigger: "blur" },
          {
            pattern: /^1[3|4|5|6|7|8|9][0-9]\d{8}$/,
            message: "请输入正确的手机号码",
            trigger: "blur"
          }
        ]
      }
   }
  },
  
  methods: {
    submit() {
      this.$axios({
        url: '/health/updatastudent',
        method: 'put',
        data: {
          ...this.user
        }
      }).then(res => {
        console.log(res)
        if(res.data.code ==200) {
          this.$message({
            message: '更新成功',
            type: 'success'
          })
        }
        this.$router.push({ path: "/student" });
      })
    },
     close() {
      this.$store.dispatch("tagsView/delView", this.$route);
      this.$router.push({ path: "/student" });
    }
  }
};
</script>
