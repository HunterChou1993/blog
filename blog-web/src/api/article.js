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
