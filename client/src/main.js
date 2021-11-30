import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify';
import router from './router';
import 'material-design-icons-iconfont/dist/material-design-icons.css' 
import 'v-slim-dialog/dist/v-slim-dialog.css'
// import SlimDialog from 'v-slim-dialog'
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

// Vue.use(SlimDialog)
Vue.use(VueSweetalert2);


Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  iconfont: 'md',
  render: h => h(App)
}).$mount('#app')
