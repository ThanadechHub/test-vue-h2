<template>
    <div>

        <v-card
            class="mx-auto"
            max-width="1200"
            outlined
            raised
            shaped
        >
            <v-container class="back2">
                <v-layout text-center wrap>
                <v-flex mb-4>
                    <br />
                    <h1 class="font">แก้ไขประวัติของน้อน <v-btn color="warning" fab dark><v-icon>mdi-pencil</v-icon></v-btn></h1>
                </v-flex>
                </v-layout>   
                <v-row justify="center">
                  <v-col cols="10">
                    <v-form v-model="valid" ref="form">
                         <v-row justify="center">
                           <v-col cols="8">
                                                     <v-text-field
                                                class="font"
                                                outlined
                                                label="ชื่อ"
                                                v-model="currentPet.name"
                                                :rules="[(v) => !!v || 'กรุณากรอกชื่อ']"
                                                required
                        ></v-text-field> 

                                                                <v-row justify="center">
                                                <v-col cols="3">
                                                            <v-select
                                                                    class="font"
                                                                    label="เพศ"
                                                                    outlined
                                                                    v-model="currentPet.gender"
                                                                    :items="genders"
                                                                    item-text="name"
                                                                    item-value="id"
                                                                    :rules="[(v) => !!v || 'เลือกเพศกำเนิดของน้อน']"
                                                                    required
                                                            ></v-select>
                                                </v-col>
                                                <v-col cols="6">
                                                    <v-text-field
                                                            class="font"
                                                            outlined
                                                            label="อายุ"
                                                            v-model="currentPet.age"
                                                            :rules="[(v) => !!v || 'กรุณาใส่อายุ']"
                                                            required
                                                    ></v-text-field>
                                                </v-col>
                                        </v-row>  

                                                          <v-row justify="center">
                                                                <v-col cols="20">
                                                                          <v-btn
                                                                            x-large
                                                                            color="success"
                                                                            @click="updatePet"
                                                                            >
                                                                              Update
                                                                              <v-icon
                                                                                right
                                                                                dar
                                                                              >
                                                                                mdi-cloud-upload
                                                                              </v-icon>
                                                                            </v-btn>
                                                                </v-col>
                                                          </v-row>   
                           </v-col>
                         </v-row>
                    </v-form>
                  </v-col>
                </v-row> 
            </v-container>
        </v-card>
    </div>
</template>

<script>
import http from "../http-common";
import PetService from "../PetService";
  export default {
    name: 'editPet',
    data() {
      return {
        currentPet: {
          gender:""
        },
        message: '',
        genders:[]
      }
    },
   methods: {
     /* eslint-disable no-console */
     getPet(id){
          PetService.get(id)
            .then(response => {
              this.currentPet = response.data;
              console.log(response.data);
            })
            .catch(err => {
              console.log(err);
            });
     },
     getGender() {
          http
                  .get("/gender")
                  .then(response => {
                    this.genders = response.data;
                    console.log(response.data);
                  })
                  .catch(e => {
                    console.log(e);
                  });
      },
      updatePet() {
              PetService.update(this.currentPet.id, this.currentPet)
                .then(response => {
                  console.log(response.data);
                  this.message = 'The pet was updated successfully!';
                })
        .catch(e => {
          console.log(e);
        });
      },
   },
  mounted() {
    this.message = '';
    this.getGender();
    this.getPet(this.$route.params.id);
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