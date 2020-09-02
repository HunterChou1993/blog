<template>
  <div id="Container">
    <el-container>
      <el-main></el-main>
      <el-aside>
        <div :class="['search',{'fixed':ifSearchFixed}]">
          <div class="search-main">
            <el-input v-model="searchInput" placeholder="请输入内容"></el-input>
            <i class="el-icon-search"></i>
          </div>
          <div class="search-articleList">
            <ul @mouseleave="handleLeave">
              <li @mouseenter="handleEnter(index)" v-for="(item,index ) in articleTags"><router-link :to="'/blog/'+index">{{item}}</router-link></li>
            </ul>
            <div class="cover" :style="{top:coverTop*40 + 'px'}"></div>
          </div>
        </div>
        <!-- 热门文章开始 -->
        <div class="hot">
          <h3>热门文章</h3>
          <ul>
            <li v-for="(item,index) in articleHot">
              <i>{{index + 1}}</i>
              <a :href="item.articleId">{{item.title}}</a>
            </li>
          </ul>
        </div>
        <!--热门文章结束 -->
        <div class="recommend">
          <h3>顶置推荐</h3>
          <ul>
            <li v-if="!!getArticleRecommend.title">
              <i>{{ 1}}</i>
              <a :href="getArticleRecommend.articleId">{{getArticleRecommend.title}}</a>
            </li>
          </ul>
        </div>
        <div class="visitor">
          <h3>最近访客</h3>
          <ul>
            <li v-for="item in visitor" :style="{backgroundImage:`url(${item.image})`}">
              <p>{{item.name}}</p>
            </li>
          </ul>
        </div>
      </el-aside>
    </el-container>
  </div>
</template>

<script>
  import {getTags} from "../api/tag";
  import { getHotArticle} from "../api/article";
  import { getUserInfo } from "../api/userInfo";

  export default {
    name: "Container",
    data(){
      return{
        /* input搜索框 v-model */
        searchInput:'',
        /* cover条的top数据 */
        coverTop:this.$route.params.id*1,
        /* 分类 rticleList*/
        articleTags:[],
        /* 热门文章 */
        articleHot:[],
        /* 最近访客数据 */
        visitor:[],
        /* 控制search的class名字 */
        ifSearchFixed:false
      }
    },
    methods:{
      handleEnter(index){
        this.coverTop = index;
      },
      handleLeave(){
        this.coverTop = this.$route.params.id * 1;
      },
      handleWindowScroll(){
        this.ifSearchFixed = document.documentElement.scrollTop >= 900;
      }
    },
    computed:{
      getArticleRecommend(){
        return  this.articleHot[0] || [];
      }
    },
    created(){
      //从后端获取相关标签
      getTags().then(res => {
        this.articleTags = res.data.data;
      })

      //获取热门文章
      getHotArticle().then(res => {
        this.articleHot = res.data.data;
      })
      //获取最近访问的信息
      getUserInfo().then(res => {
        this.visitor = res.data.data;
      })
    },
    mounted(){
      /* 监听滚动 */
      window.addEventListener("scroll",this.handleWindowScroll)
    },
    /* 离开之后就清除滚动事件 */
    destroyed(){
      window.removeEventListener("scroll",this.handleWindowScroll)
    }
  }
</script>

<style scoped lang="less">
  #Container {
    padding-top: 20px;
    width: 100%;
    user-select: none;
    >.el-container {
      box-sizing: border-box;
      width: 100%;
      max-width: 1360px;
      margin: 70px auto 0;
      /* 右边栏样式 */
      >.el-aside {
        width: 300px;
        overflow: hidden;
        /* 搜索框样式 */
        >.search {
          width: 100%;
          background-color: #fff;
          padding-bottom: 20px;
          &.fixed {
            position: fixed;
            width: 300px;
            z-index: 3;
            animation: searchMove .5s 1 ease-in-out;
            animation-fill-mode: forwards;
          }
          /* 添加动画 */
          @keyframes searchMove{
            0%{
              top:-500px;
            }
            40% {
              top:81px
            }
            65%{
              top:60px
            }
            100%{
              top:81px;
            }
          }
          /* 搜索框主要内容样式 */
          .search-main {
            box-sizing: border-box;
            width: 100%;
            height: 80px;
            padding: 20px;
            background-color: grey;
            position: relative;
            .el-input {
              overflow: hidden;
              height: 40px;
              border-radius: 20px;
              /deep/ input {
                border-color: grey;
                outline: none;
                &:focus{
                  border-color: grey;
                  outline: none;
                }
              }
            }
            i {
              position: absolute;
              right: 40px;
              top: 29px;
              width: 22px;
              height: 33px;
              font-size: 18px;
              line-height: 22px;
              text-align: right;
              font-weight: bold;
              color: rgb(120,123,119);
              cursor: pointer;
            }
          }
          /* 文章列表主要样式 */
          .search-articleList {
            position: relative;
            width: 100%;
            margin-top: 20px;
            ul {

              width: 100%;

              li {
                box-sizing: border-box;
                position: relative;
                z-index: 1;
                width: 100%;
                height: 40px;
                line-height: 40px;
                padding: 0 30px;
                a{
                  color:#797977;
                  display: block;
                  width: 100%;
                  height: 100%;
                  border-bottom: 1px dotted #eee;
                }
              }
            }
            .cover {
              box-sizing: border-box;
              position: absolute;
              left: 0;
              top: 0;
              width: 100%;
              height: 40px;
              border-right: 5px solid #000;
              border-color: rgba(0,0,0,.5);
              transition: top .3s;
            }
          }
        }
        /*热门样式*/
        >.hot,.recommend{
          box-sizing: border-box;
          width: 100%;
          background-color: #fff;
          padding: 20px;
          margin-top: 20px;
          h3{
            padding: 0 5px 10px;
            line-height: 30px;
            font-weight: 400;
            border-bottom: 1px solid #e8e9e7;
            color:#383937;
            position: relative;
            font-size: 18px;
          }
          ul {
            margin-top: 15px;
            li{
              overflow: hidden;
              height: 30px;
              line-height: 30px;
              margin: 7px 0;
              a{
                color:#787977;
                font-size: 14px;
              }
              i{
                display: inline-block;
                width: 22px;
                height: 22px;
                background-color: #edefee;
                text-shadow: 0 1px 0 rgba(255,255,255,.5);
                color: #000;
                font-style: normal;
                font-size: 12px;
                border-radius: 100%;
                text-align: center;
                line-height: 22px;
                margin-right: 14px;
              }
              &:nth-child(1) i{
                background-color: #e24d46;
                color: #fff;
              }
              &:nth-child(2) i{
                background-color: #2ea7e0;
                color: #fff;
              }
              &:nth-child(3) i{
                background-color: #6bc30d;
                color: #fff;
              }
            }
          }
        }
        >.visitor {
          box-sizing: border-box;
          width: 100%;
          background-color: #fff;
          padding: 20px;
          margin-top: 20px;
          h3{
            padding: 0 5px 10px;
            line-height: 30px;
            font-weight: 400;
            border-bottom: 1px solid #e8e9e7;
            color:#383937;
            position: relative;
            font-size: 18px;
          }
          ul {
            margin-top: 15px;
            li {
              position: relative;
              float: left;
              width: 23%;
              height: 60px;
              background-position: center top;
              background-size: cover;
              background-repeat: no-repeat;
              margin: 1%;

              p {
                overflow: hidden;
                position: absolute;
                bottom: 0;
                left: 0;
                width: 100%;
                line-height: 20px;
                height: 20px;
                text-align: center;
                color: #fff;
                font-size: 12px;
                background-color: rgba(0,0,0,.3);
              }
            }
            /*清除浮动*/
            &::after{
              display: block;
              content: '';
              width: 0;
              height: 0;
              clear: both;
            }
          }
        }
      }
    }
  }
</style>
