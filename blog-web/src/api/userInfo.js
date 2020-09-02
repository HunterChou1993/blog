import request from './request'

export const getUserInfo = () =>
    request({
      url:'/user/getUserInfo',
      methods:'get'
    })
