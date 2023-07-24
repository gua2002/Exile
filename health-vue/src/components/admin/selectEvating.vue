//查询所有评测
<template>
  <div class="exam">
    <el-table :data="pagination.records" border>
      <el-table-column fixed="left" prop="e_title" label="测评名称" width="240"></el-table-column>
      <el-table-column prop="e_descripte" label="介绍" width="380"></el-table-column>
      <el-table-column prop="e_starte" label="开始时间" width="200"></el-table-column>
      <el-table-column prop="e_ends" label="结束时间" width="200"></el-table-column>
      <el-table-column prop="e_time" label="时间限制(分钟)" width="150"></el-table-column>
      <el-table-column fixed="right" label="操作" width="150">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row.e_id)" type="primary" size="small">编辑</el-button>
          <el-button @click="deleteRecord(scope.row.e_id)" type="danger" size="small">删除</el-button>
        </template>
      </el-table-column>
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
    <!-- 编辑对话框-->
    <el-dialog
      title="编辑信息"
      :visible.sync="dialogVisible"
      width="30%"
      :before-close="handleClose">
      <section class="update">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="评测名称">
            <el-input v-model="form.e_title"></el-input>
          </el-form-item>
          <el-form-item label="介绍">
            <el-input v-model="form.e_descripte"></el-input>
          </el-form-item>
          <el-form-item label="开始时间">
              <el-date-picker type="date" placeholder="开始时间" v-model="form.e_starte" style="width: 100%;"></el-date-picker>
          </el-form-item>
          <el-form-item label="结束时间">
               <el-date-picker type="date" placeholder="结束时间" v-model="form.e_ends" style="width: 100%;"></el-date-picker>
          </el-form-item>
          <el-form-item label="时间(分钟)">
            <el-input v-model="form.e_time"></el-input>
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
    this.getExamInfo2()
  },
  methods: {
    edit(e_id) { //编辑试卷
      this.dialogVisible = true
     console.log(e_id)
        for(var evaluating in this.pagination.records){
          console.log(evaluating)
          console.log(this.pagination.records[evaluating])
          if(e_id == this.pagination.records[evaluating].e_id){
            this.form = this.pagination.records[evaluating]
          }
        }
    },
    handleClose(done) { //关闭提醒
      this.$confirm('确认关闭？')
        .then(_ => {
          done();
        }).catch(_ => {});
    },
    submit() { //提交修改后的试卷信息
      this.dialogVisible = false
      this.$axios({
        url: '/health/updataevating',
        method: 'put',
        data: {
          ...this.form
        }
      }).then(res => {
        if(res.data.code == 200) {
          this.$message({ //成功修改提示
            message: '更新成功',
            type: 'success'
          })
        }
        this.getExamInfo2()
        location.reload();
      })
    },
    deleteRecord(e_id) {
      this.$confirm("确定删除吗?","温馨提示",{
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'danger'
      }).then(()=> { //确认删除
        this.$axios({
          url: `/health/delevating/${e_id}`,
          method: 'delete',
        }).then(res => {
          this.getExamInfo2()
        })
      }).catch(() => {

      })
    },
    getExamInfo2() { //分页查询所有试卷信息
      this.$axios(`/health/findallevaiting/${this.pagination.current}/${this.pagination.size}`).then(res => {
        this.pagination.total = res.data.data.total
        this.pagination.records=res.data.data.list
        this.loading = false
      }).catch(error => {
      })
    },
    //改变当前记录条数
    handleSizeChange(val) {
      this.pagination.size = val
      this.getExamInfo2()
    },
    //改变当前页码，重新发送请求
    handleCurrentChange(val) {
      this.pagination.current = val
      this.getExamInfo2()
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
