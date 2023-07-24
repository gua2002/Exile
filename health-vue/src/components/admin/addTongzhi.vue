<!-- 添加教师 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="通告标题">
            <el-input v-model="form.announcementname"></el-input>
          </el-form-item>
          <el-form-item label="通告内容">
            <el-input v-model="form.description"></el-input>
          </el-form-item>
          <el-form-item label="发布时间">
            <el-date-picker type="date" placeholder="发布时间" v-model="form.time" style="width: 100%;"></el-date-picker>
         </el-form-item>
    <el-form-item>
        <el-button type="primary" @click="onSubmit()">立即创建</el-button>
        <el-button type="text" @click="cancel()">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>

<script>
export default {
  data() {
    return {
      form: { //表单数据初始化
        announcementname: null,
        description: null,
        time:null,
      }
    };
  },
  methods: {
    onSubmit() { //数据提交
      this.$axios({
        url: '/health/addannounce',
        method: 'post',
        data: {
          ...this.form
        }
      }).then(res => {
        if(res.data.code == 200) {
          this.$message({
            message: '数据添加成功',
            type: 'success'
          })
          this.$router.push({path: '/tongaoManage'})
        }
      })
    },
    cancel() { //取消按钮
      this.form = {}
    },
    
  }
};
</script>
<style lang="scss" scoped>
.add {
  padding: 0px 40px;
  width: 400px;
}
</style>

