<!-- 添加学生 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="姓名">
        <el-input v-model="form.s_name"></el-input>
      </el-form-item>
      <el-form-item label="性别">
        <el-input v-model="form.s_sex"></el-input>
      </el-form-item>
      <el-form-item label="学院">
        <el-input v-model="form.s_college"></el-input>
      </el-form-item>
      <el-form-item label="所属专业">
        <el-input v-model="form.s_major"></el-input>
      </el-form-item>
      <el-form-item label="班级">
        <el-input v-model="form.s_class"></el-input>
      </el-form-item>
      <el-form-item label="电话号码">
        <el-input v-model="form.s_phone"></el-input>
      </el-form-item>
      <el-upload
          action="http://localhost:8088/health/upload"
          list-type="picture-card"
          :on-preview="handlePictureCardPreview"
          :on-remove="handleRemove"
          :on-success="uploadOk"
           style="padding-left:80px;padding-bottom:40px;">
          <i class="el-icon-plus"></i>
          <el-dialog :visible.sync="dialogVisible" size="tiny">
            <img width="100%" :src="dialogImageUrl" alt />
          </el-dialog>
        </el-upload>
      
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
      dialogImageUrl: "",
      dialogVisible: false,
      dialogFormVisible: false,
      form: {
        //表单数据初始化
        s_name: null,
        s_sex: null,
        s_college: null,
        s_major: null,
        s_class: null,
        s_phone: null,
        s_image: null,
      },
    };
  },
  methods: {
    uploadOk(response, file, fileList) {
      this.form.s_image = response.data;
    },
    handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handlePictureCardPreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    onSubmit() {
      //数据提交
      this.$axios({
        url: "/health/addstudent",
        method: "post",
        data: {
          ...this.form,
        },
      }).then((res) => {
        if (res.data.code == 200) {
          this.$message({
            message: "数据添加成功",
            type: "success",
          });
          this.$router.push({ path: "/studentManage" });
        }
      });
    },
    cancel() {
      //取消按钮
      this.form = {};
    },
    
  },
};
</script>
<style lang="scss" scoped>
.add {
  padding: 0px 40px;
  width: 400px;
}
</style>

