<template>
<div>
<v-card
    class="mx-auto"
    max-width="1200"
    outlined
    raised
    shaped
  >
  <v-container class="bg">
    <v-row class="text-center">
      <v-col cols="12">
        <v-img
          :src="require('../assets/Dog Cat Pet Circle Round Cartoon Logo Vector Icon.jpg')"
          class="my-3"
          contain
          height="200"
        />
      </v-col>

      <v-col class="mb-4">
        <h1 class="display-2 font-weight-bold mb-3">
          Welcome to My Pets
        </h1> 
      </v-col>

  
      <v-col cols="12">
            <div class="my-2">
              <v-btn
              @click="goPostPet"
                x-large
                color="warning"
                dark
              >
                ลงทะเบียนน้อน
              </v-btn>
            </div>
      </v-col>

    </v-row>
  </v-container>
</v-card>
</div>
</template>

<script>

  export default {
    name: 'PetHome',

    methods: {
      goPostPet:function(){
        this.$router.push('/petForm')
        window.location.reload()
      }
    },
  }
</script>

<style>
.bg{
   
 background-image:  url(../assets/depositphotos_402265420-stock-illustration-orange-gradient-background-modern-clean.jpg);
  background-size: cover;
  background-blend-mode: multiply;

}
</style>