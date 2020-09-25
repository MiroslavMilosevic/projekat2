import {StyledNav, LinkS, DivS1, ParagrafS1, ParagrafS2, DivSImg, ButtonKom, InputKom, ParagrafS3,
    LoginStyledInput1,LoginStyledInput2, LoginStyledButton, GoToRegisterButton, LoginStyledDiv


} from './style'
import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link, Redirect, useParams, useHistory } from 'react-router-dom'
import {v1 as uuid } from 'uuid'
import {postProvera} from './functions';
import {getInfo, postComent, postLike} from './services';


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

export const Club=({niz, setNiz})=>{
         const [komentar,setKomentar] = useState('');
         const [poruka,setPoruka] = useState('');
        const parametar=useParams().id;
        let club={name:'loading...', adress:'loading...' ,nizKomentara:[]}
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
           <ParagrafS2>Rating:{club.rating}</ParagrafS2>
           <DivSImg src={club.img} alt={'nema slike'}></DivSImg>
           <ButtonKom onClick={()=>{console.log('das');
           postLike('true',club.id).then(
            getInfo().then(res=>{
                setNiz(res.data.nizLokala)
            })
           )
        
        
        }}>Like</ButtonKom>
           <InputKom placeholder='komentarisite' onChange={(e)=>{setKomentar(e.target.value)}}></InputKom>
           <ButtonKom onClick={()=>{
               let covek=localStorage.getItem('user');
                  if(postProvera(komentar)&&covek!==localStorage.getItem(`comment${covek}${club.id}`)){
                    localStorage.setItem(`comment${covek}${club.id}`, covek);
                      postComent(komentar, club.id).then(
                      getInfo().then(res=>{
                          setNiz(res.data.nizLokala)
                      })

                      );
                  }else{setPoruka('komentar nije ispravan ili ste vec komentarisali')}               


           }}>Komentarisi</ButtonKom>
            <ParagrafS3>{poruka}</ParagrafS3> 
           {club.nizKomentara.map(el=>{return <ParagrafS2 key={uuid()}>{el}</ParagrafS2>})}
              
             
           </div>               
        </>
    )
}

export const Login=({niz, setNiz})=>{

      const history=useHistory();
    return(
        <>
          <LoginStyledDiv>
              <LoginStyledInput1 type='text' placeholder='username'></LoginStyledInput1>
              <LoginStyledInput2 type='password' placeholder='username'></LoginStyledInput2>
              <br/>
              <LoginStyledButton>Uloguj se</LoginStyledButton>
              <LoginStyledButton>Registruj se</LoginStyledButton>
              </LoginStyledDiv>         
        
        </>
    )
}