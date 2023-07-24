<template>
  <section class="index">
    <div class="chuan_tou">
      <i class="iconfont"></i>
    </div>
    <div class="hello">
      <span>很高兴遇见你,{{user.userName}}老师。</span>
    </div>

    <div class="msg">
      <br>
      <p class="title" >教务公告：</p>
      <ul>
        <li v-for="site in sites" @click="openMsg(site.announcementid)">{{site.announcementname}}<i class="el-icon-loading"></i>------<i class="el-icon-loading"></i>{{site.time}}</li>
      </ul>
    </div>
  </section>
</template>

<script>
export default {
  data() {
    return {
      user: { //用户信息
        userName: null,
        userId: null
      },
      sites:[{
          announcementid:null,
          announcementname:null,
          description:null,
          time:null,
      }]
    }
  },
  created() {
    this.getUserInfo(),
    this.getAnnounce()
  },
  methods: {
    getUserInfo() { //获取用户信息
      let userName = this.$cookies.get("cname")
      let userId = this.$cookies.get("cid")
      this.user.userName = userName
      this.user.userId = userId
    },
    getAnnounce(){
         this.$axios(`/health/checkAllAnnouncement`).then(res => {
        this.sites = res.data.data;
      }).catch(error => {});
    },
    openMsg(announcementid) {
      for(var msg in this.sites){
        if(announcementid==this.sites[msg].announcementid){
          this.$alert(this.sites[msg].description,{
        confirmButtonText: '确定'
      })
        }
      }
    }
  }
}
</script>


<style lang="scss" scoped>
.index {
  margin-left: 70px;
  .hello {
    font-size: 20px;
    color: #726f70;
  }

  .msg {
    .title {
      font-size: 16px;
      color: #000;
      margin-top: 20px;
      margin-left: 10px;
    }
    ul {
      display: flex;
      flex-direction: column;
      width: 600px;
      overflow: hidden;
    }
    li {
      margin-top: 10px;
      font-size: 14px;
      color: lightcoral;
      cursor: pointer;
      display: inline-block;
    }
  }
}
.iconfont{
  background: url("船头.png");
  background-size: 100%;
  position: absolute;
  z-index: 50;
  margin-top: -8px;
  margin-left: -50px;
  width: 50px;
  height: 50px;
  float: left;
  background-repeat: no-repeat;
}
</style>

