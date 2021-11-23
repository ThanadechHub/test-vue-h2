import Vue from 'vue'
import Router from 'vue-router'
import PetHome from '../components/PetHome.vue'
import PostPet from '../components/PostPet.vue'
import showPet from '../components/showPet.vue'
import editPet from '../components/EditPet.vue'

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: PetHome
        },{
            path: '/petForm',
            component: PostPet
        },{
            path:  '/showPet',
            component: showPet
        },{
            path: '/editPet/:id',
            component: editPet
        }
    ]
});