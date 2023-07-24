<template>
  <div class="wjxq"> 
      <ul class="question_ul">
        <li class="question_li" v-for="(item,index) in list" :key='index'>
          <div class="test_content_nr_tt">
						<i>{{index+1}}</i><font>{{item.q_name}}</font><b class="el-icon-loading"></b>
					</div>
          <div class="test_content_nr_main">
          <div class="option">
            <label>
              <input type="radio" :name="item.q_name" :id="item.q_id" value='1'  @change="get_radio_value"><span>没有</span>
              <div></div>
            </label>
          </div>
          <div class="option">
            <label>
              <input type="radio" :name="item.q_name" :id="item.q_id" value='2'  @change="get_radio_value"><span>轻度</span>
              <div></div>
            </label>
          </div>
          <div class="option">
            <label>
              <input type="radio" :name="item.q_name" :id="item.q_id" value='3'  @change="get_radio_value"><span>有时</span>
              <div></div>
            </label>
          </div>
          <div class="option">
            <label>
              <input type="radio" :name="item.q_name" :id="item.q_id" value='4'  @change="get_radio_value"><span>经常</span>
              <div></div>
            </label>
          </div>
          <div class="option">
            <label>
              <input type="radio" :name="item.q_name" :id="item.q_id" value='5'  @change="get_radio_value"><span>总是</span>
              <div></div>
            </label>
          </div>
          </div>
        </li>
      </ul>
      <button class="submit" @click="submit" type="submit">提交</button>
  </div>
</template>

<script>
var myMap = new Map();
import store from '@/vuex/store'
import {mapState} from 'vuex'
export default {
  store,
  data() {
    return {
      userInfo: { //用户信息
          name: null,
          id: null
      },
      s_id:null,
      e_id:null,
      list: {}, //单选详情页数组
      riskId: [],//选项id
      optionScoreStr: [],//选项分值
    }
  },
  created() { 
     this.getCookies()
    this.getMessage(); 
  },
 
  methods: {
     getMessage() {
        let e_id = this.$route.query.e_id //获取路由传递过来的试卷编号
        this.$axios(`/health/findanswers/${e_id}`).then(res => {
          this.list = res.data.data;
          console.log(res.data.data);
        });
    },
    getCookies() {  //获取cookie
      this.userInfo.name = this.$cookies.get("cname")
      this.userInfo.id = this.$cookies.get("cid")
    },
     submit() {
        for (var [key, value] of myMap.entries()) {
          console.log({key: key, value: value});
          this.riskId.push(key)
          this.optionScoreStr.push(value)
        }
        if (this.riskId.length < this.list.length) {
          this.$message.error('题目还未答完,请重新作答!!!')
           location.reload();
          return false
        }else{
            console.log(this.riskId);
            console.log(this.optionScoreStr);
            this.$axios({
               url: '/health/inseranswers',
               method: 'post',
               data: {
                  s_id: this.$cookies.get("cid"), //获取学生id
                  e_id: this.$route.query.e_id,  //获取路由传递过来的e_id
                  q_id: this.riskId,
                  q_grade: this.optionScoreStr,
               }
            }).then((r) => {
              console.log(r);
             if (r.status == 200) {
                this.$message.success('提交成功')
                this.$router.push({path: '/myhealth'})
             }
           })
        }
        
     },
    get_radio_value(e){
        myMap.set(e.target.id, e.target.value);
        console.log(e.target.id+":============"+e.target.value)
    }
 }
}
</script>

<style lang='css' scoped>
.wjxq {
  width: 70%;
  height: 100%;
  background-color:#ffffff;
  margin: 0 auto;
}
.question_ul {
  margin-top: 20px;
  width: 100%;
  padding: 10px 10px;
}
.question_ul p{
  font-size: 30px;
}
.question_li {
  margin-bottom: 20px;
}
.question_li .title {
  font-size: 15px;
  font-weight: 400;
  color: rgba(51, 51, 51, 1);
  line-height: 15px;
}
.question_li_wrap {
  position: relative;
  display: flex;
  align-items: center;
  width: 4.34rem;
  height: 0.55rem;
  border-radius: 0.05rem;
  margin-top: 10px;
  margin-bottom: 0.1rem;
  padding-left: 0.1rem;
}
.question_li span {
  margin-left: 0.18rem;
}
.wjxq .submit {
  cursor: pointer;
  display: inline-block;
  text-align: center;
  background-color: rgb(39, 118, 223);
  width: 240px;
  margin: 20px 40%;
  border-radius: 4px;
  height: 30px;
  line-height: 30px;
  color: #fff;
  margin-top: 22px;
}
.test_content_nr{width:100%; border-top:3px solid #efefef;}
.test_content_nr>ul>li{width:100%;  border-bottom:5px solid #efefef; padding-top:10px;}
.test_content_nr_tt{width:85%; height:auto; line-height:32px; margin:0 auto; border-bottom:1px solid #e4e4e4;}
.test_content_nr_tt i{width:25px; height:25px; line-height:25px; text-align:center; display:block; float:left; background:#5d9cec; border-radius:50%; margin-left:-50px; color:#fff; margin-top:8px; font-size:16px;}
.test_content_nr_tt span{padding:0 8px;}
.test_content_nr_tt font{font-size:18px}
.test_content_nr_tt b{display:block; float:right; margin-right:-50px; color:#f48c27; font-size:20px;}

.test_content_nr_main{width:85%; margin:0 auto; padding:10px 0;height:auto;}

.option{line-height:32px; display:block; background:#fff;color:#666;}
.option:hover{background:#e4e4e4;}
.option input{width:15px; height:15px; display:block; float:left; margin:10px 10px 0 0;}
.option label{height:auto;display:block;}
.option span{font-size: 15px;}
</style>