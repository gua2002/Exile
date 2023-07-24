import Vue from 'vue'
import Router from 'vue-router'
Vue.use(Router)

const routes= [
    {
      path: '/',
      name: 'login', //登录界面
      component: () => import('@/components/common/login')
    },
    {
      path: '/index', //主页
      component: () => import('@/components/admin/index'),
      children: [
        {
          path: '/', //首页默认路由
          component: () => import('@/components/teacher/hello')
        },
        {
          path:'/warning', //预警信息
          component: () => import('@/components/charts/grade')
        },
        {
          path: '/selectHealthToPart', //预警因子
          component: () => import('@/components/admin/selectHealthToPart')
        },
        {
          path: '/scorePart',
          component: () => import('@/components/charts/scorePart')
        },
        {
          path: '/selectWarning', //所有学生预警信息统计
          component: () => import('@/components/teacher/allStudentsGrade')
        },
        {
          path: '/adminHealth', //查询所有评测信息
          component: () => import('@/components/admin/selectEvating')
        },
        {
          path: '/addHealth', //添加评测信息
          component: () => import('@/components/admin/addEvating')
        },
        {
          path: '/selectHealth', //查询所有评测
          component: () => import('@/components/teacher/selectExam')
        },
        {
          path: '/studentManage', //学生管理界面
          component: () => import('@/components/admin/studentManage')
        },
        {
          path: '/addStudent', //添加学生
          component: () => import('@/components/admin/addStudent')
        },
        {
          path: '/teacherManage',//教师管理页面
          component: () => import('@/components/admin/tacherManage')
        },
        {
          path: '/addTeacher',//添加教师
          component: () => import ('@/components/admin/addTeacher')
        },
        {
          path: '/tongaoManage',//通告管理页面
          component: () => import ('@/components/admin/tongaoManage')
        },
        {
          path: '/addTongzhi',//添加通告
          component: () => import ('@/components/admin/addTongzhi')
        },
        {
          path: '/selectArticle',//资讯管理页面
          component: () => import ('@/components/teacher/articleManage')
        },
        {
          path: '/addArticle',//资讯通告
          component: () => import ('@/components/teacher/addArticle')
        },

      ]
    },
    {
      path: '/student',
      component: () => import('@/components/student/index'),
      children: [
        {path:"/",component: ()=> import('@/components/student/studentindex')},
        {path:"/myhealth",component: ()=> import('@/components/student/myHealth')},
        {path:"/articleinfo",component: ()=> import('@/components/student/articleinof')},
        {path: '/manager', component: () => import('@/components/student/manager')},
        {path: '/examMsg', component: () => import('@/components/student/examMsg')},
        {path: '/message', component: () => import('@/components/student/message')},
        {path: '/answer',component: () => import('@/components/student/answer')}
      ]
    },
    
  ]
  const router = new Router({

    routes
    
  });
// 添加路由守卫
router.beforeEach((to,from,next)=>{
  if(to.path=='/'){
    next();
  }else{
   let token =  localStorage.getItem("token");
   if(token==null || token==''){
    next("/");
   }else{
     next();
   }
  }

})
export default router
