//查询所有评测
<template>
  <div class="exam">
    <el-table :data="pagination.records" border>
      <el-table-column fixed="left" prop="e_title" label="测评名称" width="240"></el-table-column>
      <el-table-column prop="e_descripte" label="介绍" width="400"></el-table-column>
      <el-table-column prop="e_starte" label="开始时间" width="220"></el-table-column>
      <el-table-column prop="e_ends" label="结束时间" width="220"></el-table-column>
      <el-table-column prop="e_time" label="时间限制(分钟)" width="150"></el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[4, 8, 10, 20]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total" class="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      form: {}, //保存点击以后当前试卷的信息
      pagination: { //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 4 //每页条数
      },
      dialogVisible: false
    }
  },
  created() {
    this.getExamInfo()
  },
  methods: {
    getExamInfo() { //分页查询所有信息
      this.$axios(`/health/findevaiting/${this.pagination.current}/${this.pagination.size}`).then(res => {
        this.pagination.total = res.data.data.total
       this.pagination.records=res.data.data.list
        this.loading = false
      }).catch(error => {
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val
      this.getExamInfo()
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val
      this.getExamInfo()
    },
  },
};
</script>
<style lang="scss" scoped>
.exam {
  padding: 0px 40px;
  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .edit{
    margin-left: 20px;
  }
}
</style>
