<template>
    <div>
            <!-- <v-dialog
              v-model="dialog"
              max-width="290">
              <v-card>
                <v-card-title class="font">บันทึกสำเร็จ</v-card-title>
                <v-card-actions>
                  <v-spacer></v-spacer>
                  <v-btn
                    color="green darken-1"
                    text
                    @click="dialog = false"
                  >
                    Agree
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-dialog> -->

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
                    <h1 class="font" @click="goShowPet()">ลงประวัติของน้อน <v-btn color="warning" fab dark><v-icon>mdi-account-circle</v-icon></v-btn></h1>
                   
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
                                                v-model="Pet.name"
                                                :rules="[(v) => !!v || 'กรุณากรอกชื่อ']"
                                                required
                                        ></v-text-field>    

                                        <v-row justify="center">
                                                <v-col cols="3">
                                                            <v-select
                                                                    class="font"
                                                                    label="เพศ"
                                                                    outlined
                                                                    v-model="Pet.gender"
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
                                                            v-model="Pet.age"
                                                            :rules="[(v) => !!v || 'กรุณาใส่อายุ']"
                                                            required
                                                    ></v-text-field>
                                                </v-col>
                                        </v-row>  

                                                          <v-row justify="center">
                                                                <v-col cols="20">
                                                                    <v-btn x-large @click="savePet" :class="{ warning: !valid, green: valid }">submit</v-btn>
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
  export default {
    name: "petForm",
    data() {
      return {
          Pet: {
            name : "",
            age : "",
            gender : ""
          },
          genders:[],
          dialog: false
        };
    },
    methods: {
      /* eslint-disable no-console */

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
        // function เมื่อกดปุ่ม submit
        savePet() {
          http
                  .post(
                          "/petPost",
                          this.Pet
                  )
                  .then(response => {
                    console.log(response);
                    if(response.data != null){
                          // const options1 = { title: "ประกาศ!", size: "sm" };
                          // this.$dialogs.alert("บันทึกข้อมูลสำเร็จ", options1);
                          this.$swal("บันทึกสำเร็จ","success!","success").then(function() {
                                          location.reload();
                                          window.location.href = '/showPet';
                                          });
                          // location.reload();          
                    }
                  })
                  .catch(e => {
                    console.log(e);
                  });
                  console.log(this.pet);
          // http
          //         .get("/pet")
          //         .then(response => {
          //           this.items = response.data;
          //           console.log(this.items);
          //         })
          //         .catch(e => {
          //           console.log(e);
          //         });
          // this.submitted = true;
        },
        goShowPet(){
          this.$router.push("/showPet");
        }
    },
        /* eslint-enable no-console */
        //update ui
        //update controller
      mounted() {
        this.getGender();
      }
};
</script>
<style>
  .font {
    font-family: 'Prompt', sans-serif;
    font-size: 30px ;
    color: black;
  }
  .back2 {
    background-image:  url(../assets/depositphotos_402265420-stock-illustration-orange-gradient-background-modern-clean.jpg);
    background-size: cover;

  }

</style>>
