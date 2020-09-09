<template>
  <div id="MyNav">
    <div class="nav-main">
      <div class="nav-main-logo">Hunter</div>
      <!--登录部分开始-->
      <div class="nav-main-login">
        <el-button type="primary">登录</el-button>
        <el-button type="success">注册</el-button>
      </div>
      <!-- 登录部分结束 -->
      <!-- 导航连接 开始 -->
      <div class="nav-main-nav">
        <ul :class="'list'+ action">
          <!--router-link 是vue-router做跳转的标签-->
          <li><router-link to="/">首页</router-link></li>
          <li><router-link to="/blog">博客</router-link></li>
          <li><router-link to="/message">留言</router-link></li>
          <li><router-link to="/daily">日记</router-link></li>
          <li><router-link to="/links">友链</router-link></li>
          <li><router-link to="/about">关于</router-link></li>
        </ul>
      </div>
      <!-- 导航链接 结束 -->
    </div>
  </div>
</template>

<script>
  export default {
    name: "MyNav",
    data(){
      return{
        //保存路由顺序，避免每次获取
        routerList:["Home","Blog","Message","Daily","links","about"]
      }
    },
    computed:{
      action(){
        //利用router的名字来获取上面List的下标
        let index = this.routerList.indexOf(this.$route.name)
        return index + 1;
      }
    }
  }
</script>

<style scoped lang="less">
  #MyNav {
    width: 100%;
    height: 60px;
    background-color: #fff;
    border: 1px solid #e8e9e7;
    position: fixed;
    z-index: 1;
    /* 导航主体样式 */
    >.nav-main {
      box-sizing: border-box;
      width: 100%;
      max-width: 1360px;
      height: 60px;
      margin: 0 auto;
      padding: 0 50px;
      /* 左边Logo样式 */
      .nav-main-logo {
        float: left;//浮动属性
        height: 60px;
        line-height: 60px;//行高为了垂直居中
        text-align: center;
        color: #777;
        font-size: 40px;
        font-family: BarbaraHand;
      }
      /* 右边登录样式 */
      .nav-main-login {
        float: right;
        height: 60px;
        line-height: 60px;
        /* 修改el-buttony样式 */
        .el-button {
          padding: 9px 13px;
        }
      }
      /*中间导航样式*/
      .nav-main-nav {
        float: right;
        width: 576px;
        height: 60px;
        margin-right: 9%;
        ul {
          width: 100%;
          height: 100%;
          display: flex;
          li {
            flex: 1;
            a {
              position: relative;
              display: block;
              width: 100%;
              height: 100%;
              text-align: center;
              line-height: 58px;
              font-weight: 400;
              font-size: 15px;
              color: #212220;
              transition: color .5s;
              &::after{
                position: absolute;
                bottom: 0;
                right: 0;
                left: 0;
                margin: 0 auto;
                content: "";
                width: 0;
                height: 2px;
                background-color: #6bc30d;
                transition: width .5s;
              }
              &:hover {
                color:#6bc30d;
                &::after{
                  width: 100%;
                }
              }
            }
          }
          &.list1 li:nth-child(1),
          &.list2 li:nth-child(2),
          &.list3 li:nth-child(3),
          &.list4 li:nth-child(4),
          &.list5 li:nth-child(5),
          &.list6 li:nth-child(6){
            a {
              color: #6bc30d;
            }
          }
        }
      }
    }
  }

  /*@media all and (min-width: 1366px) {*/
  /*padding: 0 50px;*/
  /*}*/
</style>
