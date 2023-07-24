<!--页脚部分-->
<template>
  <footer id="footer">
    <ul>
      <p> 推荐1920*1080分辨率 ，Google Chrome,IE 6.0以上版本 </p>
    </ul>
  </footer>
</template>

<script>
export default {
  name: "myFooter"
}
</script>

<style scoped>
#footer p {
  color: #919698;
  font-size: 14px;
}
#footer {
  background-color: #eee;
}
#footer ul {
  margin-top: 40px;
  border-top: 1px solid #d5d5d5;
  display: flex;
  justify-content: center;
  height: 80px;
  line-height: 80px;
}
</style>
