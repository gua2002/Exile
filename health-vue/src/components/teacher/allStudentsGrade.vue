// 所有学生
<template>
  <div class="all">
    <el-table :data="pagination.records" border>
      <el-table-column fixed="left" prop="e_title" label="评测名称" width="230"></el-table-column>
      <el-table-column prop="s_name" label="姓名" width="100"></el-table-column>
      <el-table-column prop="s_college" label="学院" width="200"></el-table-column>
      <el-table-column prop="e_starte" label="开始时间" width="200"></el-table-column>
      <el-table-column prop="e_ends" label="结束时间" width="200"></el-table-column>
      <el-table-column prop="e_descripte" label="介绍" width="320"></el-table-column>
      <el-table-column fixed="right" label="查看预警" width="150">
        <template slot-scope="scope">
          <el-button @click="checkGrade(scope.row.e_id,scope.row.s_id)" type="primary" size="small">预警信息</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[6, 10]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page"
    ></el-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pagination: {
        //分页后的考试信息
        current: 1, //当前页
        total: null, //记录条数
        size: 6 //每页条数
      }
    };
  },
  created() {
    this.getAnswerInfo();
  },
  methods: {
    getAnswerInfo() {
      //分页查询所有试卷信息
      this.$axios(`/health/students/${this.pagination.current}/${this.pagination.size}`).then(res => {
        this.pagination.total = res.data.data.total
       this.pagination.records=res.data.data.list
        this.loading = false
      }).catch(error => {});
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getAnswerInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getAnswerInfo();
    },
    checkGrade(e_id,s_id) {
      this.$router.push({ path: "/warning", query: { e_id: e_id,s_id: s_id } });
    }
  }
};
</script>
<style lang="scss" scoped>
.all {
  padding: 0px 40px;
  .page {
    margin-top: 20px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .edit {
    margin-left: 20px;
  }
  .el-table tr {
    background-color: #dd5862 !important;
  }
}
.el-table .warning-row {
  background: #000 !important;
}

.el-table .success-row {
  background: #dd5862;
}
</style>
