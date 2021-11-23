<template>
<div>
     <v-container style="height: 500%; margin-right:15%" >
          <v-card class="bg" style="width:1000%; margin:auto; background-color:#FFFFFF">
            <v-layout text-center wrap>
              <v-flex mb-4>
                <br />
                <h1 class="display-1 font-weight-bold mb-3">รายชื่อน้อน</h1>
              </v-flex>
            </v-layout>
            <v-row justify="center">
              <v-col cols="100">
                    <v-data-table
                      :headers="headers"
                      :items="showPet"
                      disable-pagination
                      :hide-default-footer="true"
                    >
                      <template v-slot:[`item.actions`]="{ item }">
                           <!-- <v-icon small @click="deletePet(item.id)">mdi-delete</v-icon> -->
                            <v-btn
                                  color="warning"
                                  small
                                  dark
                                >
                                  <v-icon @click="editPet(item.id)">mdi-pencil</v-icon>
                                </v-btn>
                                &nbsp;
                                <v-btn
                                  color="error"
                                  small
                                  dark
                                >
                                  <v-icon @click="deletePet(item.id)">mdi-delete</v-icon>
                                </v-btn>
                      </template>
                    </v-data-table>
              </v-col>
            </v-row>
          </v-card>
        </v-container>
    

</div>

 
      
</template>

<script>
import http from "../http-common";
import PetService from "../PetService";

export default {
  
  name: "PetList",
  data() {
    return {
      showPet: [],
      headers: [
        { text: "idน้อน", value: "id" },
        { text: "ชื่อผู้น้อน", value: "name" },
        { text: "เพศ", value: "gender.name"},
        { text: "อายุ", value: "age"},
        { text: "Actions", value: "actions", sortable: false }
      ]
          
    };
    
  },
  methods: {
      /* eslint-disable no-console */

      getList(){
        http
                .get("/pet")
                .then(response => {
                  this.showPet = response.data;
                  console.log(response.data);
                })
                .catch(e => {
                  console.log(e);
                });
      },

      deletePet(id){
            PetService.delete(id)
              .then((response) => {
                console.log(response.data);
                location.reload(); 
              })
              .catch((e) => {
                console.log(e);
              });    
      },

      editPet(id){
        document.location.href = 'http://localhost:8080/editPet/'+id;
      }
     

    /* eslint-disable no-console */
  },

  mounted() {
      this.getList()
  },
  
};

</script>
<style>
.font {
  font-family: 'Prompt', sans-serif;
  font-size: 30px ;
  color: black;
}
  .bg {
    background-image:  url(../assets/depositphotos_402265420-stock-illustration-orange-gradient-background-modern-clean.jpg) ;
    background-size: 1500px 200px;
  }

</style>>