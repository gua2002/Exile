// 点击试卷后的缩略信息
<template>
  <div id="msg">
    <div class="title">
    </div>
    <div class="wrapper">
      <ul class="top">
        <li class="example"><i class="iconfont icon-pen-"></i>{{pagination.e_title}}</li>
      </ul>
      <ul class="bottom">
        <i class="el-icon-loading"></i><span>{{pagination.e_starte}} ——  <i class="el-icon-loading"></i>{{pagination.e_ends}}</span>
       <li class="right"><el-button @click="toAnswer(pagination.e_id)">开始评测</el-button></li> 
      </ul>
      <ul class="info">
        <li @click="dialogVisible = true"><a href="javascript:;"><i class="iconfont icon-info"></i>温馨提示</a></li>
      </ul>
      <ul class="info">
        <pre>{{pagination.e_toke}}</pre>
      </ul>
    </div>
    <!--考生须知对话框-->
    <el-dialog
      title="温馨提示"
      :visible.sync="dialogVisible"
      width="30%" >
      <span style="color: #88949b;">{{pagination.e_descripte}}</span>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">知道了</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogVisible: true, //对话框属性
      pagination: { //考试信息
       
      },
    }
  },
  
  mounted() {
    this.init()
    this.loading = true
    this.insertesc()
  },
  methods: {
     init() {
          let e_id = this.$route.query.e_id //获取路由传递过来的试卷编号
          this.$axios(`/health/findevalutinfo/${e_id}`).then(res => {  //通过e_id请求试卷详细信息
          this.pagination=res.data.data
       })
    },
    insertesc(){
       this.$axios({
            url: '/health/insertesc',
            method: 'put',
            data: {
              s_id: this.$cookies.get("cid"), //获取学生id
              e_id: this.$route.query.e_id,  //获取路由传递过来的e_id
            }
          }).then((r) => {   
               console.log(r);
        }) 
    },
    toAnswer(e_id) {
       this.$axios({
            url: '/health/insertqec',
            method: 'post',
            data: {
              s_id: this.$cookies.get("cid"), //获取学生id
              e_id: this.$route.query.e_id,  //获取路由传递过来的e_id
            }
          }).then((r) => {  
               console.log(r);
               this.$router.push({path:"/answer",query:{e_id: e_id}})
        }) 
    }
  }
}
</script>

<style lang="scss" scoped>
.bottom {
  .right{
    .el-button{
      color: #409EFF;
      border-color: #c6e2ff;
      background-color: #ecf5ff;
    }
  }
}
.bottom i{
  color: #0195ff;
}
.right {
  margin-left: auto;
}
.inner .contenti .question {
  margin-left: 40px;
  color: #9a9a9a;
  font-size: 14px;
}
.content .inner .titlei {
  margin-left: 20px;
  font-size: 16px;
  color: #88949b;
  font-weight: bold;
}
.content .title .time {
  font-size: 16px;
  margin-left: 420px;
  color: #999;
}
.content .stitle {
  background-color: #0195ff;
}
.content .title span {
  margin-right: 10px;
}
#msg .content .title {
  font-size: 20px;
  margin: 0px;
  display: flex;
  align-items: center;
}
.content {
  margin-top: 20px;
  background-color: #fff;
}
.content .header {
  padding: 10px 30px;
}
.wrapper .info {
  margin: 20px 0px 0px 20px;
  border-top: 1px solid #eee;
  padding: 20px 0px 10px 0px;
}
.wrapper .info a {
  color: #88949b;
  font-size: 14px;
}
.wrapper .info a:hover {
  color: #0195ff;
}
.wrapper .bottom .btn {
  cursor: pointer;
  padding: 5px 10px;
  border: 1px solid #88949b;
  border-radius: 4px;
} 
.wrapper .bottom {
  display: flex;
  margin-left: 20px;
  color: #999;
  font-size: 14px;
  align-items: center;
}
.wrapper .bottom li {
  margin-right: 14px;
}
#msg {
  background-color: #eee;
  width: 980px;
  margin: 0 auto;
}
#msg .title {
  margin: 20px;
}
#msg .wrapper {
  background-color: #fff;
  padding: 10px;
}
.wrapper .top {
  display: flex;
  margin: 20px;
  align-items: center;
}
.wrapper .top .right {
  margin-left: auto;
}
.wrapper .top .example {
  color: #333;
  font-size: 22px;
  font-weight: 700;
}
.wrapper .top li i {
  margin-left: 20px;
  color: #88949b;
}
.wrapper .right .count {
  margin-right: 60px;
  color: #fff;
  padding: 4px 10px;
  background-color: #88949b;
  border-top-left-radius: 4px;
  border-bottom-left-radius: 4px;
  border: 1px solid #88949b;
}
.wrapper .right .score {
  position: absolute;
  left: 53px;
  top: -5px;
  padding: 1px 12px;
  font-size: 20px;
  color: #88949b;
  border: 1px dashed #88949b;
  border-left: none;
  border-top-right-radius: 4px;
  border-bottom-right-radius: 4px;
  font-weight: bold;
}
.wrapper .right div {
  position: relative;
}
pre {
  white-space: pre-wrap;
  word-wrap: break-word;
  font-size: 18px;
  color: #88949b;
}
</style>
