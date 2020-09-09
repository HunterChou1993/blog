import axois from 'axios'

//配置参数
axois.defaults.baseURL = 'http://192.168.155.211:8090'//默认访问地址
axois.defaults.withCredentials = true //允许携带cookie



export default axois;
