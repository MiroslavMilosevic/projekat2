import React, { useEffect, useState } from 'react';
import ReactDOM from 'react-dom';
import {v1 as uuid} from 'uuid'
import { BrowserRouter as Router, Switch, Route, Link, Redirect, useParams } from 'react-router-dom'
import {getInfo, getImena} from './services'
import {Navi, Home, Club, Login, Register} from './components'
import {ParagrafS2} from './style'




const App=()=>{

const [niz,setNiz]=useState([]);
const [nizUsera,setNizUsera]=useState([]);
useEffect(()=>{
getInfo().then(res=>{
console.log(res.data.nizLokala);
setNiz(res.data.nizLokala);
})
getImena().then(res=>{
setNizUsera(res.data.nizImena);
console.log(res.data.nizImena);
})
},[])
  return(
    <>
     <Router>
       <Navi></Navi>
        <Switch>
          <Route exact path="/home">
           <Home niz={niz} setNiz={setNiz}></Home>
          </Route>
          <Route exact path="/">
          <Home niz={niz} setNiz={setNiz}></Home>
          </Route>
          <Route exact path="/login">
           <Login nizUsera={nizUsera} setNizUsera={setNizUsera}>

           </Login>
          </Route>
          <Route exact path="/register">
          <Register nizUsera={nizUsera} setNizUsera={setNizUsera}></Register>
          </Route>
          <Route exact path="/one/:id">

          {localStorage.getItem('user')=== ''? <ParagrafS2>Niste Ulogovani</ParagrafS2> : <Club niz={niz} setNiz={setNiz}></Club>}
          </Route>
        </Switch>
      </Router>

    </>
  )
}
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

