<template>
  <div class="all">
    <el-table :data="pagination.records" border>
      <el-table-column fixed="left" prop="announcementname" label="通知标题" width="280"></el-table-column>
      <el-table-column prop="description" label="通知内容" width="600"></el-table-column>
      <el-table-column prop="time" label="发布时间" width="280"></el-table-column>
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="deleteById(scope.row.announcementid)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.page"
      :page-sizes="[6, 10]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  data() {
    return {
      pagination: {
        //分页后的通知信息
        page: 1, //当前页
        total: '', //记录条数
        size: 6, //每页条数
        records:[{
            announcementname:'开学通知',
            description:'具体开学时间，另行通知!!!!',
            time:'2021-01-01'
        }]
      }
    };
  },
  created() {
    this.getTongzhiInfo();
  },
  methods: {
    getTongzhiInfo() {
      //分页查询所有试卷信息
      this.$axios(`/health/findannounce/${this.pagination.page}/${this.pagination.size}`).then(res => {
        this.pagination.total = res.data.data.total
       this.pagination.records=res.data.data.list
        this.loading = false

      }).catch(error => {});
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getTongzhiInfo();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.page = val;
      this.getTongzhiInfo();
    },
    deleteById(announcementid) { //删除当前学生
      this.$confirm("确定删除吗？",{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'danger'
      }).then(()=> { //确认删除
        this.$axios({
          url: `/health/deleteannouce/${announcementid}`,
          method: 'delete',
        }).then(res => {
          this.getTongzhiInfo()
          this.$message({
                    showClose: true,
                    type: 'success',
                    message: '删除成功!!'
              })
        })
      }).catch(() => {

      })
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
