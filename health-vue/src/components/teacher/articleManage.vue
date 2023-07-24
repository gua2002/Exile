
<template>
  <div class="all">
    <el-table :data="pagination.records" border>  
      <el-table-column fixed="left" prop="et_name" label="文章标题" width="240"></el-table-column>
      <el-table-column prop="et_description" label="文章介绍" width="200"></el-table-column>
      <el-table-column prop="et_ctime" label="添加时间" width="200"></el-table-column>
      <el-table-column prop="et_author" label="文章作者" width="200"></el-table-column>
      <el-table-column prop="et_root" label="文章来源" width="200"></el-table-column>
      <el-table-column fixed="right" label="操作" width="200">
        <template slot-scope="scope">
          <el-button @click="checkGrade(scope.row.et_id)" type="primary" size="small">编辑</el-button>
          <el-button @click="deleteById(scope.row.et_id)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pagination.current"
      :page-sizes="[1,6, 10]"
      :page-size="pagination.size"
      layout="total, sizes, prev, pager, next, jumper"
      :total="pagination.total"
      class="page">
    </el-pagination>
    <!-- 编辑对话框-->
    <el-dialog
      title="编辑信息"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <section class="update">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="文章标题">
            <el-input v-model="form.et_name"></el-input>
          </el-form-item>
          <el-form-item label="文章介绍">
            <el-input v-model="form.et_description"></el-input>
          </el-form-item>
          <el-form-item label="添加时间">
            <el-date-picker type="date" placeholder="时间" v-model="form.et_ctime" style="width: 100%;"></el-date-picker>
          </el-form-item>
          <el-form-item label="文章作者">
            <el-input v-model="form.et_author"></el-input>
          </el-form-item>
          <el-form-item label="文章来源">
            <el-input v-model="form.et_root"></el-input>
          </el-form-item>
        </el-form>
      </section>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit()">确 定</el-button>
      </span>
    </el-dialog>
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
        size: 6, //每页条数
        records:[{

        }]
      },
      dialogVisible: false, //对话框
      form: {}, //保存点击以后当前试卷的信息
    };
  },
  created() {
    this.getTeacherInfo2();
  },
  methods: {
    getTeacherInfo2() {
      //分页查询所有信息
      this.$axios(`/health/findartice/${this.pagination.current}/${this.pagination.size}`).then(res => {
         this.pagination.records=res.data.data.list
         this.pagination.total = res.data.data.total
         this.loading = false
      }).catch(error => {});
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val;
      this.getTeacherInfo2();
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val;
      this.getTeacherInfo2();
    },
    checkGrade(et_id) { //修改教师信息
      this.dialogVisible = true
      console.log(et_id)
        for(var teacher in this.pagination.records){
          console.log(teacher)
          console.log(this.pagination.records[teacher])
          if(et_id == this.pagination.records[teacher].et_id){
            this.form = this.pagination.records[teacher]
          }
        }
    },
    deleteById(et_id) { //删除当前教师
      console.log(et_id)
      this.$confirm("确定删除吗?","温馨提示",{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'danger'
      }).then(()=> { //确认删除
        this.$axios({
          url: `/health/delarticle/${et_id}`,
          method: 'delete',
        }).then(res => {
          this.getTeacherInfo2()
          this.$message({
                    showClose: true,
                    type: 'success',
                    message: '删除成功!!'
              })
        })
      }).catch(() => {

      })
    },
    submit() { //提交更改
      this.dialogVisible = false
      this.$axios({
        url: '/health/updataarticle',
        method: 'put',
        data: {
          ...this.form
        }
      }).then(res => {
        console.log(res)
        if(res.data.code ==200) {
          this.$message({
            message: '更新成功',
            type: 'success'
          })
        }
        this.getTeacherInfo2()
      })
    },
    handleClose(done) { //关闭提醒
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        }).catch(_ => {});
    },
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
