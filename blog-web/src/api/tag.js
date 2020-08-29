import request from './request'

export const getTags = ()=>
    request({
      url:'/tag/getAllTag',
      methods:'get'
    })
