<template>
    <div class="articleInfo">
        <section v-for="item in articleList" :key="item.articleId">
            <h5>
                <span>【{{item.type}}】</span>
                <a href="">{{item.title}}</a>
            </h5>
            <div class="time">
                <p class="date">{{item.createDate | date}}</p>
                <p class="month">{{item.createDate | month}}<span>月</span></p>
                <p class="year">{{item.createDate | year}}</p>
            </div>
            <div class="content">
                <a href="" :style="{backgroundImage:`url(${item.image})`}">
                    <i></i>
                </a>
                {{item.content}}
            </div>
            <div class="read-more">
                <a href="">继续阅读</a>

            </div>
        </section>
    </div>
</template>

<script>
  import { getArticle } from "../api/article";

  export default {
    name: "Article",
    data(){
      return{
        articleList:[],
      }
    },
    methods:{
    //  发送请求方法
      getArticleInfo(page,size,id){
         getArticle(page,size,id).then(res => {
            this.articleList = res.data.data.records
         })
      }
    },
    filters:{
        date(value) {
          //匹配日期
            return value.match(/^(\d{4})-(\d{1,2})-(\d{1,2})/)[3]
        },
        month(value) {
          return value.match(/^(\d{4})-(\d{1,2})-(\d{1,2})/)[2]
        },
        year(value) {
          return value.match(/^(\d{4})-(\d{1,2})-(\d{1,2})/)[1]
        }
    },
    computed:{
        id(){
          return this.$route.params.id
        }
    },
    //监听id变化渲染相关的文章
    watch:{
        id(){
          this.getArticleInfo(0,5,this.id)
        }
    },
    mounted(){
      this.getArticleInfo(0,5,this.id)
    }
  }
</script>

<style scoped lang="less">
    .articleInfo{
        >section {
            overflow: hidden;
            position: relative;
            box-sizing: border-box;
            width: 100%;
            padding: 20px 30px 25px;
            margin-bottom: 20px;
            background-color: #fff;
            h5{
                line-height: 30px;
                padding: 5px 130px 5px 0;
                border-bottom: 1px solid #e8e9e7;
                font-size: 18px;
                font-weight: 400;
                span{
                    font-size: 16px;
                    font-weight: 400;
                    display: inline-block;
                    vertical-align: bottom;
                    color: #2ea7e0;
                }
                a {
                    color: #787977;
                    font-size: 14px;
                    text-decoration: none;
                    &:hover {
                        color:#6bc30d;
                        text-decoration: underline;
                    }
                }
            }
            .time {
                width: 80px;
                font-family: "Source Code Pro";
                position: absolute;
                right: 10px;
                top: 10px;
                background-color: #fff;
                padding: 0 20px 5px 20px;
                line-height: 32px;
                .date {
                    display: block;
                    text-align: center;
                    font-weight: 700;
                    font-size: 40px;
                    color: #6bc30d;
                    position: relative;
                    topx: 2px;
                }
                .month {
                    display: inline-block;
                    color:#989997;
                    font-size: 19px;
                    span {
                        font-size: 14px;
                    }

                 }
                .year {
                    display: inline-block;
                    color:#989997;
                    margin-left: 10px;
                    font-size: 18px;
                }
            }
            .content {
                margin-top: 20px;
                line-height: 28px;
                position: relative;
                min-height: 200px;
                a{
                    position: relative;
                    display: block;
                    width: 300px;
                    height: 180px;
                    border: 1px solid #e8e9e7;
                    overflow: hidden;
                    float: left;
                    margin-right: 20px;
                    background-position: center top;
                    background-size: cover;
                    i {
                        position: absolute;
                        top:0;
                        left: 0;
                        display: block;
                        width: 0;
                        height: 100%;
                        transform: translateX(-40px) skew(-15deg);
                        box-shadow: 0 0 30px 20px rgba(255,255,255,.3);
                    }
                    &:hover i{
                        transition: transform 0.3s;
                        transform: translateX(350px) skew(-15deg);
                    }
                }
            }
            .read-more {
                a{
                    font-weight: bold;
                    color:#383937;
                    text-decoration: none;
                    border: none;
                    line-height: 40px;
                }
            }
        }
    }
</style>
