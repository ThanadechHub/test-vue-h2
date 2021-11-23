import axios from "axios";

export default axios.create({
    baseURL: "http://localhost:9000/",
    headers: {
        'Access-Control-Allow-Headers': 'Content-Type, Authorization',
        'Access-Control-Allow-Origin': '*',
        'Access-Control-Expose-Headers': '*',
        'Access-Control-Allow-Methods': '*',
        "Content-type": "application/json",
        
    }
});