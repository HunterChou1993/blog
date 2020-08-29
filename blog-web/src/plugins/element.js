import Vue from 'vue'
import {
  Button,
  Container,
  Main,
  Aside,
  Input,
  Icon,
  Loading,
  MessageBox,
  Message,
} from 'element-ui'

Vue.use(Button)
Vue.use(Container)
Vue.use(Main)
Vue.use(Aside)
Vue.use(Input)
Vue.use(Icon)

Vue.use(Loading.directive);

Vue.prototype.$loading = Loading.service;
Vue.prototype.$msgbox = MessageBox;
Vue.prototype.$alert = MessageBox.alert;
Vue.prototype.$confirm = MessageBox.confirm;
Vue.prototype.$prompt = MessageBox.prompt;
Vue.prototype.$notify = Notification;
Vue.prototype.$message = Message;
