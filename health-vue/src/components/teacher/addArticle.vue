<!-- 添加教师 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="80px">
         <el-form-item label="文章标题">
            <el-input v-model="form.et_name" style="width: 400px;"></el-input>
          </el-form-item>
          <el-form-item label="文章介绍">
            <el-input v-model="form.et_description" style="width: 400px;"></el-input>
          </el-form-item>
          <el-form-item label="添加时间">
            <el-date-picker type="date" placeholder="添加时间" v-model="form.et_ctime" style="width: 400px;"></el-date-picker>
          </el-form-item>
          <el-form-item label="文章作者">
            <el-input v-model="form.et_author" style="width: 400px;"></el-input>
          </el-form-item>
          <el-form-item label="文章来源">
            <el-input v-model="form.et_root" style="width: 400px;"></el-input>
          </el-form-item>
          <el-form-item label="文章内容">
           <mavon-editor v-model="form.et_content" ref="md"  @change="change" style="min-height: 400px"/>
          </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit()">立即创建</el-button>
        <el-button type="text" @click="cancel()">取消</el-button>
      </el-form-item>
    </el-form>
  </section>
</template>

<script>
// 导入组件 及 组件样式
import { mavonEditor } from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
export default {
   // 注册
    components: {
        mavonEditor,
    },
  data() {
    return {
      form: { //表单数据初始化
        et_name: null,
        et_description: null,
        et_ctime: null,
        et_author: null,
        et_root:null,
        et_content:null
      },
      html:'',    // 及时转的html
    };
  },
  methods: {
    onSubmit() { //数据提交
      this.$axios({
        url: '/health/addarticle',
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
          this.$router.push({path: '/selectArticle'})
        }
      })
    },
    cancel() { //取消按钮
      this.form = {}
    },
    // 所有操作都会被解析重新渲染
    change(value, render){
      // render 为 markdown 解析后的结果[html]
      this.html = render;
    },
    
  }
};
</script>
<style lang="scss" scoped>
.add {
  padding: 0px 40px;
  width: 750px;
}
</style>

