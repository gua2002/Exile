// 主页面
<template>
  <div id="myExam">
    <div class="title"></div>
    <div class="wrapper">
       <ul class="paper" v-loading="loading">
        <li class="item" v-for="(item,index) in pagination" :key="index">
          <p class="tt">{{item.et_name}}</p>
          <p class="name">{{item.et_description}}</p>
          <div class="info">
            <i class="el-icon-loading"></i><span>{{item.et_ctime.substr(0,10)}}</span>
            <i class="el-icon-edit"></i><span >{{item.et_author}}</span>
            <i class="el-icon-paperclip"></i><span>{{item.et_root}}</span>
          </div>
          <div class="content">
            <pre >{{item.et_content}}</pre>
          </div> 
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pagination: [{
           et_name:' ',
           et_description:' ',
           et_ctime:' ',
           et_author:' ',
           et_root:' ',
           et_content:' '
      }]
    };
  },
  created() {
    this.getarticleInfo()
    this.loading = true
  },
  methods: {
    //获取当前所有信息
    getarticleInfo() {
      let et_id = this.$route.query.et_id
      this.$axios(`/health/findarticleinfo/${et_id}`).then(res => {
        this.pagination=res.data.data
        this.loading = false
        console.log(this.pagination)
      }).catch(error => {
        console.log(error)
      })
    }
  }
}
</script>

<style lang="scss" scoped>
.pagination {
  padding: 20px 0px 30px 0px;
.el-pagination {
    display: flex;
    justify-content: center;
}
}
.paper .item a {
  color: #000;
}
.wrapper .top .order {
  cursor: pointer;
}
.wrapper .top .order:hover {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.wrapper .top .order:visited {
  color: #0195ff;
  border-bottom: 2px solid #0195ff;
}
.item .info i {
  margin-right: 5px;
  color: #0195ff;
}
.item .info span {
  margin-right: 14px;
}
.paper .item {
  width: 980px;
  border-radius: 4px;
  padding: 10px 20px;
  border: 1px solid #eee;
  box-shadow: 0 0 4px 2px rgba(217,222,234,0.3);
  transition: all 0.6s ease;
}
.paper .item .info {
  font-size: 14px;
  color: #88949b;
}
.paper .item .name {
  font-size: 14px;
  color: #88949b;
  
}
.paper .item .tt{
   font-size: 30px;
   font-weight: bold;
   text-align: center;
}
.paper * {
  margin: 20px 0;
}
.wrapper .paper {
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
}
.top .el-icon-search {
  position: absolute;
  right: 10px;
  top: 10px;
}
.top .icon {
  position: relative;
}
.wrapper .top {
  border-bottom: 1px solid #eee;
  margin-bottom: 20px;
}
#myExam .search-li {
  margin-left: auto;
}
.top .search-li {
  margin-left: auto;
}
.top li {
  display: flex;
  align-items: center;
}
.top .search {
  margin-left: auto;
  padding: 10px;
  border-radius: 4px;
  border: 1px solid #eee;
  box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
  transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
}
.top .search:hover {
  color: #0195ff;
  border-color: #0195ff;
}
.wrapper .top {
  display: flex;
}
.wrapper .top li {
  margin: 20px;
}
#myExam {
  width: 1200px;
  margin: 0 auto;
}
#myExam .title {
  margin: 20px;
}
#myExam .wrapper {
  background-color: #fff;
   margin: 20px;
}
.content{
  width: 970px;
}
pre {
  white-space: pre-wrap;
  word-wrap: break-word;
  font-size: 15px;
  color: #88949b;
}
</style>
