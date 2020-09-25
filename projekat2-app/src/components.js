import {StyledNav, LinkS, DivS1, ParagrafS1, ParagrafS2, DivSImg} from './style'
import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link, Redirect, useParams } from 'react-router-dom'
import {v1 as uuid } from 'uuid'

export const Navi=()=>{
    return(
 <>
<StyledNav>
    <LinkS to='/home'>Home</LinkS> 
    <LinkS to='/login'>Login</LinkS> 
    <LinkS to='other'>Other</LinkS> 
</StyledNav>
    </>
    )
}

export const Home=({niz})=>{


    return(

        <>
        {niz.map(el=>{return <DivS1 key={uuid()}><ParagrafS1>{el.name}</ParagrafS1><ParagrafS1>{el.adress}</ParagrafS1>
        <ParagrafS1>{el.type}</ParagrafS1><ParagrafS1><Link to={`/one/${el.id}`}>Detalji</Link></ParagrafS1>
        
        </DivS1>})}
        </>
    )
}

export const Club=({niz})=>{
        const parametar=useParams().id;
        let club={name:'loading...', adress:'loading...'}
        for(let i=0;i<niz.length;i++){
              if(parametar===niz[i].id){
                  club=niz[i];
              }
                
        }
    return(
        <>
           <div>
           <ParagrafS2>{club.name}</ParagrafS2>   
           <ParagrafS2>Adress:{club.adress}</ParagrafS2>   
           <ParagrafS2>Type:{club.type}</ParagrafS2>   
           <ParagrafS2>Capacity:{club.capacity}</ParagrafS2> 
           <ParagrafS2>Type:{club.type}</ParagrafS2>   
           <ParagrafS2>Capacity:{club.capacity}</ParagrafS2> 
           <DivSImg src={club.img} alt={'nema slike'}></DivSImg>
             
           </div>               
        </>
    )
}