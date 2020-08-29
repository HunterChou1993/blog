<template>
  <div id="Container">
    <el-container>
      <el-main></el-main>
      <el-aside>
        <div class="search">
          <div class="search-main">
            <el-input v-model="searchInput" placeholder="请输入内容"></el-input>
            <i class="el-icon-search"></i>
          </div>
          <div class="search-articleList">
            <ul @mouseleave="handleLeave">
              <li @mouseenter="handleEnter" v-for="item in articleTags"><a href="">{{item}}</a></li>
            </ul>
            <div class="cover" :style="{top:coverTop + 'px'}"></div>
          </div>
        </div>
        <!-- 热门文章开始 -->
        <div class="hot">
          <h3>热门文章</h3>
        </div>
        <!--热门文章结束 -->
        <div class="recommend"></div>
        <div class="visitor"></div>
      </el-aside>
    </el-container>
  </div>
</template>

<script>
  import {getTags} from "../api/tag";

  export default {
    name: "Container",
    data(){
      return{
        /* input搜索框 v-model */
        searchInput:'',
        /* cover条的top数据 */
        coverTop:'',
        /* 分类 rticleList*/
        articleTags:[]
      }
    },
    methods:{
      handleEnter(e){
        this.coverTop = e.target.offsetTop;
      },
      handleLeave(){
        this.coverTop = 0;
      }
    },
    created(){
      //从后端获取相关标签
      getTags().then(res => {
        this.articleTags = res.data.data;
      })
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
      margin: 0 auto;
      padding: 0 50px;
      /* 右边栏样式 */
      >.el-aside {
        width: 300px;
        overflow: hidden;
        /* 搜索框样式 */
        >.search {
          width: 100%;
          background-color: #fff;
          padding-bottom: 20px;
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
        >.hot{
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
        }
      }
    }
  }
</style>
