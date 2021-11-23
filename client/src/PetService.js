import http from "../src/http-common";

class PetService{
    delete(id){
        return http.delete(`/pet/${id}`);
    }
    deleteAll() {
        return http.delete(`/pet`);
    }
    get(id) {
        return http.get(`/pet/${id}`);
    }
    update(id, data) {
        return http.put(`/pet/${id}`, data);
      }
}
export default new PetService();