import axios from 'axios'

export function getInfo(){

   return axios.get('http://localhost:8080/MiroslavServerZaJS/ServletAPI');
   
}

export function postComent(comment, id){

   return axios.get('http://localhost:8080/MiroslavServerZaJS/PostIProveraServlet?comment='+comment+'&id='+id);
   
}

export function postLike(like, id){

   return axios.get('http://localhost:8080/MiroslavServerZaJS/ServletLike?like=true&id='+id);
   
}