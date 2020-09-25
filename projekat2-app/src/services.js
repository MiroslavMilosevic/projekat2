import axios from 'axios'

export function getInfo(){

   return axios.get('http://localhost:8080/MiroslavServerZaJS/ServletAPI');
}