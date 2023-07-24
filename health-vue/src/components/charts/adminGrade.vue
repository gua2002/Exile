// 成绩统计页面
<template>
  <div id="grade">
    <div ref="box" class="box"></div>
    <div class="notFound" v-if="isNull">
      <i class="iconfont icon-LC_icon_tips_fill"></i><span>该考生未参加评测</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "grade",
  data() {
    return {
      isNull: false, //原始数据
      tableDataX: [], //x轴数据 保存次数
      tableDataY: [
        "优秀","良好","一般","危险","严重"
      ], //y轴数据 保存分数
      tableDataZ:[]
    }
  },
  mounted() {
    this.score();
  },
  methods: {
    score() {
      let s_id = this.$route.query.s_id
      let e_id = this.$route.query.e_id
      this.$axios(`/health/warningscore/${s_id}/${e_id}`).then(res => { //根据学生Id查询成绩
        console.log(res)
        if(res.data.code == 200) {
          let rootData = res.data.data
          rootData.forEach((element) => {
            this.tableDataX.push(element.c_name)
            this.tableDataZ.push(element.w_name)
          });
          let boxDom = this.$refs["box"];
          let scoreCharts = this.$echarts.init(boxDom);
          let option = {
            xAxis: {
              type: "category",
              data: this.tableDataX
            },
            yAxis: {
              type: "category",
              data: this.tableDataY
            },
            series: [
              {
                data: this.tableDataZ,
                type: "line",
                itemStyle: { normal: { label: { show: true } } }
              }
            ]
          };
          scoreCharts.setOption(option);
          scoreCharts.on("mouseover", params => {
            console.log(params.value);
          });
        }else {
          this.isNull = true
        }
      })
    }
  }
};
</script>

<style lang="scss" scoped>
#grade {
  position: relative;
  .box{
    width: 1200px;
    height: 400px;
  }
  .notFound {
    position: absolute;
    top: 0px;
    left: 0px;
  }
}
</style>
