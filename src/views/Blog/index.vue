<template>
    <div class="blog">
        <!--使用组件-->
        <MyNav></MyNav>
        <Container></Container>
    </div>
</template>

<script>
  // 引入组件
  import MyNav from '../../components/MyNav'
  import Container from '../../components/Container'
    export default {
        name: "Blog",
      //注册组件
      components:{
        MyNav,
        Container
      }
    }
</script>

<style scoped>

</style>
