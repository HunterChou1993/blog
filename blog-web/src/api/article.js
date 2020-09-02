import request from './request'

/**
 * 获取热门文章接口
 * @returns {AxiosPromise}
 */
export const getHotArticle = ()=>
    request({
      url:'/article/hotArticle',
      methods:'get'
    })

/**
 * 获取两篇文章接口
 * @returns {AxiosPromise}
 */
export const getArticle = (page,size) =>
    request({
      url:'/article/getArticleInfo',
      methods: 'get',
      params:{
        page:page,
        size:size
      }
    })
