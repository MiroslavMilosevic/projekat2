import React, { useEffect, useState } from 'react';
import ReactDOM from 'react-dom';
import {v1 as uuid} from 'uuid'
import { BrowserRouter as Router, Switch, Route, Link, Redirect, useParams } from 'react-router-dom'
import {getInfo} from './services'
import {Navi, Home, Club} from './components'




const App=()=>{

const [niz,setNiz]=useState([]);
useEffect(()=>{
getInfo().then(res=>{
console.log(res.data.nizLokala);
setNiz(res.data.nizLokala);

})
},[])
  return(
    <>
     <Router>
       <Navi></Navi>
        <Switch>
          <Route exact path="/home">
           <Home niz={niz}></Home>
          </Route>
          <Route exact path="/">
          
          </Route>
          <Route exact path="/login">
          
          </Route>
          <Route exact path="/register">
          
          </Route>
          <Route exact path="/one/:id">
          <Club niz={niz}></Club>
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

