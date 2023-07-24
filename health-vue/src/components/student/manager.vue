<template >
  <div class="app-container">
    <el-row :gutter="20">
      <el-col :span="6" :xs="24">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <span>个人信息</span>
          </div>
          <div>
            <div class="text-center">
             <img :src="userimage" class="user-img" ref="img" />
            </div>
          </div>
        </el-card>
      </el-col>
      <el-col :span="18" :xs="24">
        <el-card>
          <div slot="header" class="clearfix">
            <span>基本资料</span>
          </div>
          <el-tabs v-model="activeTab">
            <el-tab-pane label="基本资料" name="userinfo">
              <userInfo :user="user" />
            </el-tab-pane>
            <el-tab-pane label="修改密码" name="resetPwd">
              <resetPwd :user="user" />
            </el-tab-pane>
          </el-tabs>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
import userInfo from "./userInfo";
import resetPwd from "./resetPwd";
export default {
  components: { userInfo, resetPwd },
  data() {
    return {
      userimage:null,
      user: {},
      activeTab: "userinfo"
    };
  },
  created() {
    this.getUser();
  },
  methods: {
    getUser() {
       let userimage=this.$cookies.get("userimage")
       let s_id=this.$cookies.get("cid")
       this.userimage=userimage
         //分页查询所有试卷信息
      this.$axios(`/health/findstudentid/${s_id}`).then(res => {
           this.user=res.data.data
           console.log(res.data.data)
      }).catch(error => {});
    }
  }
};
</script>
<style lang="scss" scoped>
.app-container{
  padding:20px 220px;
}
.user-img {
  width: 190px;
  height: 190px;
  border-radius: 50%;
  margin-top: 5px;
  margin-left: 20px;
  margin-bottom: 50px;
  cursor: pointer;
}
</style>
