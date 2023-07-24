<!-- 添加学生 -->
<template>
  <section class="add">
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="评测名称">
        <el-input v-model="form.e_title" style="width: 400px;"></el-input>
      </el-form-item>
      <el-form-item label="简单介绍">
        <el-input v-model="form.e_descripte" style="width: 400px;"></el-input>
      </el-form-item>
      <el-form-item label="开始时间">
        <el-date-picker type="date" placeholder="开始时间" v-model="form.e_starte" style="width: 400px;"></el-date-picker>
      </el-form-item>
      <el-form-item label="结束时间">
        <el-date-picker type="date" placeholder="结束时间" v-model="form.e_ends" style="width: 400px;"></el-date-picker>
      </el-form-item>
      <el-form-item label="时间(分钟)">
        <el-input v-model="form.e_time" style="width: 400px;"></el-input>
      </el-form-item>
      <el-form-item label="扩展知识">
         <mavon-editor v-model="form.e_toke" ref="md" @change="change" style="min-height: 400px"/>
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
        e_title: null,
        e_descripte: null,
        e_starte: null,
        e_ends: null,
        e_time: null,
        e_toke: null
      },
       html:'',    // 及时转的html
    };
  },
  methods: {
    onSubmit() { //数据提交
      this.$axios({
        url: '/health/addevating',
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
          this.$router.push({path: '/adminHealth'})
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

