import Vue from 'vue'
import VueRouter from 'vue-router'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import BootstrapVue from 'bootstrap-vue'

import About from '@/views/About'
import Index from '@/views/Index'
import Navbar from '@/components/Navbar'


Vue.use(BootstrapVue)
Vue.use(VueRouter)

const router =  new VueRouter({
    routes: [
        {
            path: "/",
            redirect: {
                name: "index"
            }
        },
        {
            path:"/index",
            name: 'index',
            component: Index
        },
        {
            path:"/about",
            component: About
        },
        {
            path:"/test",
            component: {template: "<div>test</div>"}
        }
    ]
});



const app = new Vue({
    router, el: '#app'
})
