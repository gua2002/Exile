<!--左边下拉导航栏-->
<template>
  <div id="left">
    <el-menu
      active-text-color="#dd5862"
      text-color="#000"
      :default-active="this.$route.path"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      :collapse="flag"
      background-color="#124280"
      menu-trigger="click"
      router
    >
      <el-submenu
        v-for="(item, index) in menu"
        :index="item.index"
        :key="index"
      >
        <template slot="title">
          <div class="left-width">
            <i class="iconfont" :class="item.icon"></i>
            <span slot="title" class="title">{{ item.title }}</span>
          </div>
        </template>
        <el-menu-item-group
          v-for="(list, index1) in item.content"
          :key="index1"
        >
          <el-menu-item
            @click="handleTitle(item.index)"
            :index="list.path"
            v-if="list.item1 != null"
            >{{ list.item1 }}</el-menu-item
          >
          <el-menu-item
            @click="handleTitle(item.index)"
            :index="list.path"
            v-if="list.item2 != null"
            >{{ list.item2 }}</el-menu-item
          >
          <el-menu-item
            @click="handleTitle(item.index)"
            :index="list.path"
            v-if="list.item3 != null"
            >{{ list.item3 }}</el-menu-item
          >
        </el-menu-item-group>
      </el-submenu>
    </el-menu>
  </div>
</template>

<script>
import store from "@/vuex/store";
import { mapState } from "vuex";
export default {
  name: "mainLeft",
  data() {
    return {};
  },
  computed: mapState(["flag", "menu"]),
  created() {

    this.addData();
    this.addData2();
  },
  methods: {
    handleOpen(key, keyPath) {
      // console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      // console.log(key, keyPath);
    },
    //点击标题传递参数给navigator组件
    handleTitle(index) {
      this.bus.$emit("sendIndex", index);
    },
    addData() {

      let role = this.$cookies.get("role");
      if (role == 1) {
        this.menu.push(
          {
            index: "1",
            title: "评测管理",
            icon: "icon-kechengbiao",
            content: [
              { item1: "评测查询", path: "/selectHealth" },
            ],
          },
          {
            index: "2",
            title: "健康预警",
            icon: "icon-tiku",
            content: [
              { item1: "预警管理", path: "/selectWarning" },
              { path: "/warning" },
            ],
          },
          {
            index: "3",
            title: "资讯管理",
            icon: "icon-tiku",
            content: [
              { item1: "资讯管理", path: "/selectArticle" },
              { item2: "添加资讯", path: "/addArticle" },
            ],
          },

        );
      }
    },
    addData2() {
      let role = this.$cookies.get("role");
      if (role == 0) {
        this.menu.push(
          {
            index: "1",
            title: "评测管理",
            icon: "icon-kechengbiao",
            content: [
              { item1: "评测管理", path: "/adminHealth" },
              { item2: "添加评测", path: "/addHealth" },
            ],
          },
          {
            index: "2",
            title: "预警管理",
            icon: "icon-performance",
            content: [
              { item1: "预警管理", path: "/selectWarning" },

              { item2: "预警因子", path: "/selectHealthToPart" },
            ],
          },
          {
            index: "3",
            title: "学生管理",
            icon: "icon-role",
            content: [
              { item1: "学生管理", path: "/studentManage" },
              { item2: "添加学生", path: "/addStudent" },
            ],
          },
          {
            index: "4",
            title: "教师管理",
            icon: "icon-Userselect",
            content: [
              { item1: "教师管理", path: "/teacherManage" },
              { item2: "添加教师", path: "/addTeacher" },
            ],
          },
          {
            index: "5",
            title: "通告管理",
            icon: "icon-module4mokuai",
            content: [
              { item1: "通告管理", path: "/tongaoManage" },
              { item2: "添加通知", path: "/addTongzhi" },
            ],
          },
          {
            index: "6",
            title: "资讯管理",
            icon: "icon-tiku",
            content: [
              { item1: "资讯管理", path: "/selectArticle" },
              { item2: "添加资讯", path: "/addArticle" },
            ],
          }
        );
      }
    },
  },
  store,
};
</script>

<style>
.el-menu-vertical-demo .el-submenu__title {
  overflow: hidden;
}
.left-width .iconfont {
  font-size: 18px;
  color: #fff;
}
.left-width {
  width: 213px;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  min-height: 900px;
}
#left {
  height: 900px;
  background-color: #5d9cec;
  z-index: 0;
}
#left .el-menu-vertical-demo .title {
  color: #fff;
  font-size: 16px;
  font-weight: bold;
  margin-left: 14px;
}
.el-submenu {
  border-bottom: 1px solid #eeeeee0f !important;
}
.el-submenu__title:hover {
  background-color: #fff;
}
.el-submenu__title i {
  color: #fbfbfc !important;
}
</style>
