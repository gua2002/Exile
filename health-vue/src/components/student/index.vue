<!--学生首页-->
<template>
  <div id="student">
    <el-row class="padding-50">
      <el-col :span="24">
        <ul class="list">
          <li class="logo"><i class="iconfont"></i></li>
          <li><a href="javascript:;" @click="health()">灯塔前沿哨</a></li>
          <li><router-link to="/myhealth">心海探测坊</router-link></li>
          <li><router-link to="/message">无忧漂流圈</router-link></li>
          <li class="right" @mouseenter="flag = !flag" @mouseleave="flag = !flag">
            <a href="javascript:;"><img :src="user.userimage" class="user-img" ref="img" /></a>
            <div class="msg" v-if="flag">
              <p @click="manage()">管理中心</p>
              <p class="exit" @click="exit()">退出</p>
            </div>
          </li>
        </ul>
      </el-col>
    </el-row>
    <!--路由区域-->
    <div class="main">
      <router-view></router-view>
    </div>
    <v-footer></v-footer>
  </div>
</template>

<script>
import myFooter from "@/components/student/myFooter"
import store from '@/vuex/store'
import {mapState} from 'vuex'
export default {
  store,
  components: {
    "v-footer": myFooter
  },
  data() {
    return {
      flag: false,
      user: {}
    }
  },
  created() {
    this.userInfo()
     window.addEventListener('popstate', this.popstate, false);
  },
  methods: {
    exit() {  //退出登录
      this.$router.push({path:"/"}) //跳转到登录页面
      this.$cookies.remove("cname") //清除cookie
      this.$cookies.remove("cid")
       window.localStorage.removeItem("token")
      location.reload();
    },
    manage() {  //跳转到修改密码页面
      this.$router.push({path: '/manager'})
    },
    userInfo() {
      let studentName = this.$cookies.get("cname")
      let studentId = this.$cookies.get("cid")
      let userimage=this.$cookies.get("userimage")
      console.log(`studentId${studentId}`)
      console.log(`studentName ${studentName}`)
      this.user.userName = studentName
      this.user.studentId = studentId
      this.user.userimage=userimage
    },
    health() { //跳转资讯页面
     let isPractice = false
      this.$store.commit("practice", isPractice)
      this.$router.push({path:'/student'})
    },
    popstate() {
		 location.reload();
	  }
  },
  computed:mapState(["isPractice"])
}
</script>

<style scoped>
.right .icon {
  margin-right: 6px;
}
#student .padding-50 {
  margin: 0 auto;
  padding: 0 50px;
  box-shadow: 0 0 10px 4px rgba(1,149,255,0.1);
  background-color: #fff;
}
.list a {
  text-decoration: none;
  color: #334046;
}
li {
  list-style: none;
  height: 60px;
  line-height: 60px;
}
#student .list{
  display: flex;
}
#student .list li {
  padding: 0 20px;
  cursor: pointer;
}
#student .list li:hover {
  background-color: #0195ff;
  transition: all 2s ease;
}
#student .list li:hover a {
  color: #fff;
}
#student .list .right {
  margin-left: auto;
  position: relative;
}
#student .list li.right :hover a {
  color: #000;
}
#student .list .logo {
  display: flex;
  font-weight: bold;
  color: #2f6c9f;
}
#student .list .logo i {
  font-size: 50px;
}
.right .msg {
  text-align: center;
  position: absolute;
  top: 60px;
  left: 0px;
  display: flex;
  flex-direction: column;
  border-radius: 2px;
  border-bottom: 3px solid #0195ff;
  background-color: #fff;
}
.right .msg p {
  height: 40px;
  line-height: 40px;
  width: 105px;
}
.right .msg p:hover {
  background-color: #0195ff;
}
.user-img {
  width: 55px;
  height: 55px;
  border-radius: 50%;
  margin-top: 5px;
  margin-left: 10px;
  cursor: pointer;
}
.iconfont{
  background: url("长-无帆心船.png");
  background-size: 120%;
  position: absolute;
  z-index: 50;
  margin-top: 6px;
  margin-left: -70px;
  width: 100px;
  height: 60px;
  float: left;

  background-repeat: no-repeat;
}
</style>
