<!-- 用户登录界面 -->
<template>
  <div id="login">
    <div class="top">
          <i class="iconfont"></i><span class="title" style="margin-left: 5%">欢迎登陆无帆心船</span>
    </div>
    <div class="bg"></div>
    <el-row class="main-container">
      <el-col :lg="8" :xs="16" :md="10" :span="10">

        <div class="bottom">
          <div class="container">
            <p class="title" style="color: #999999;">账号登录</p>
            <el-form :label-position="labelPosition" label-width="80px" :model="formLabelAlign">
              <el-form-item label="账号">
                <el-input v-model.number="formLabelAlign.uid" placeholder="请输入学号"style=""></el-input>
              </el-form-item>
              <el-form-item label="密码">
                <el-input v-model="formLabelAlign.password" placeholder="请输入密码" type='password'></el-input>
              </el-form-item>
              <div class="submit">
                <el-button type="primary" class="row-login" @click="login()">登&nbsp;&nbsp;&nbsp;&nbsp;录</el-button>
              </div>
            </el-form>
          </div>
        </div>
      </el-col>
    </el-row>

  </div>
</template>

<script>
import store from '@/vuex/store'
import {mapState} from 'vuex'
export default {
  store,
  name: "login",
  data() {
    return {
      role: 2,
      labelPosition: 'left',
      formLabelAlign: {
        uid: '',
        password: ''
      }
    }
  },
  methods: {
    //用户登录请求后台处理
    login() {
      console.log("登录操作执行-------");
      this.$axios({
        url: `/health/login`,
        method: 'post',
        data: {
          ...this.formLabelAlign
        }
      }).then(res=>{
        let resData = res.data.data
        if(resData != null) {
          switch(resData.role) {
            case 0:  //管理员
              localStorage.setItem('token',res.data.data.token);  //后端发的令牌
              this.$cookies.set("cname", resData.username)
              this.$cookies.set("cid", resData.userid)
              this.$cookies.set("userimage", resData.userimage)
              this.$cookies.set("role", 0)
              this.$router.push({path: '/index'}) //跳转到首页
               this.$router.push({path: '/index'}) //跳转到首页
               this.$message({
                    showClose: true,
                    type: 'success',
                    message: '登陆成功!!'
              })

              break
            case 1: //教师
            localStorage.setItem('token',res.data.data.token);  //后端发的令牌
              this.$cookies.set("cname", resData.username)
              this.$cookies.set("cid", resData.userid)
              this.$cookies.set("userimage", resData.userimage)
              this.$cookies.set("role", 1)
              this.$router.push({path: '/index'}) //跳转到教师用户
               this.$router.push({path: '/index'}) //跳转到首页
                this.$message({
                    showClose: true,
                    type: 'success',
                    message: '登陆成功!!'
              })

              break
            case 2: //学生
            localStorage.setItem('token',res.data.data.token);  //后端发的令牌
              this.$cookies.set("token", resData.token)
              this.$cookies.set("cname", resData.username)
              this.$cookies.set("cid", resData.userid)
              this.$cookies.set("userimage", resData.userimage)
               this.$cookies.set("role", 2)
              this.$router.push({path: '/student'})
               this.$message({
                    showClose: true,
                    type: 'success',
                    message: '登陆成功!!'
              })

              break
          }
        }
        if(resData == null) { //错误提示
          this.$message({
            showClose: true,
            type: 'error',
            message: '用户名或者密码错误'
          })
        }
      })
    },
  },
  computed: mapState(["userInfo"]),
  mounted() {

  }
}
</script>

<style lang="scss" scoped>
/*.container {
  margin-bottom: 32px;
}*/
a:link {
  color:#ff962a;
  text-decoration:none;
}
#login {
  font-size: 14px;
  color: #000;
}
#login .bg {
  position: absolute;
  width: 100%;
  height: 100%;
  background: url('../../assets/img/banner.png') no-repeat center;
  background-size: 100%;
}
#login .main-container {
  display: flex;
  margin-top: 100px;
  justify-content: center;
}

/*首页字体*/
#login  .top {
  margin-top: 1px;
  font-size: 30px;
  color: #ecf5ff;
  display: flex;
   overflow-y: auto;
  justify-content: left;
}
/*#login .top .icon-kaoshi {
  font-size: 80px;
  position: absolute;
  z-index: 10;
}*/
#login .top .title {
  margin-top: 20px;
  position: absolute;
  z-index: 2;
}
#login .bottom {
  display:flex;
  justify-content: center;
  background-color:#ffffff;
  border-radius: 5px;
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  position: relative;
  margin-top: 15%;
  width: 100%;
  height: 80%;
}
#login .bottom .title {
  text-align: center;
  font-size: 35px;
}
.bottom .container .title {
  margin: 50px;
}
.bottom .submit .row-login {
  width: 100%;
  background-color: #04468b;
  border-color: #04468b;
  margin: 20px 10px;
  padding: 15px 20px;
  font-size: 20px;
}
.bottom .submit {
  display: flex;
  justify-content: center;
}
.footer {
  margin-top: 100px;
  text-align: center;
}
.footer .msg1 {
  font-size: 18px;
  color: #fff;
  margin-bottom: 15px;
}
.footer .msg2 {
  margin-top: 70px;
  color:#9c9191;
	width:100%;
	font-size: 15px;
	font-family:"Microsoft YaHei";
	overflow: hidden;
}
.bottom .options {
  margin-bottom: 40px;
  color: #ff962a;
  display: flex;
  justify-content: space-between;
}
.bottom .options > a {
  color: #ff962a;
}
.bottom .options .register span:nth-child(1) {
  color: #8C8C8C;
}
.iconfont{
  background: url("xiaohui.png");
  background-size: 100%;
  position: absolute;
  z-index: 50;
  margin-top: 10px;
  margin-left: 5px;
  width: 70px;
  height: 70px;
  float: left;
  background-repeat: no-repeat;
}
</style>
