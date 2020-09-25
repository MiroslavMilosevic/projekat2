import {StyledNav, LinkS, DivS1, ParagrafS1, ParagrafS2, DivSImg, ButtonKom, InputKom, ParagrafS3,
    LoginStyledInput1,LoginStyledInput2, LoginStyledButton, GoToRegisterButton, LoginStyledDiv


} from './style'
import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link, Redirect, useParams, useHistory } from 'react-router-dom'
import {v1 as uuid } from 'uuid'
import {postProvera} from './functions';
import {getImena, getInfo, postComent, postLike, registerUser} from './services';


export const Navi=()=>{
    const history=useHistory();
    return(
 <>
<StyledNav>
    <LinkS to='/home'>Home</LinkS> 

    {localStorage.getItem('user')===''? <LinkS to='/login'>Login</LinkS>: <LinkS onClick={
        ()=>{localStorage.setItem('user', ''); history.push('/home');window.location.reload(); }} to='/home'>Log out</LinkS>} 
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
            let covek=localStorage.getItem('user');
            if(covek!==localStorage.getItem(`like${covek}${club.id}`)){
                localStorage.setItem(`like${covek}${club.id}`, covek);
           postLike(club.id).then(
            getInfo().then(res=>{
                setNiz(res.data.nizLokala)
            })
           )
            }else {
                console.log('vec lajkovano');
            }
        
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

export const Login=({nizUsera, setNizUsera})=>{
      const [username,setUsername] = useState('');
      const [password,setPassword] = useState('');
      const history=useHistory();
    return(
        <>
          <LoginStyledDiv>
              <LoginStyledInput1 onChange={(e)=> setUsername(e.target.value)} type='text' placeholder='username'></LoginStyledInput1>
              <LoginStyledInput2 onChange={(e)=> setPassword(e.target.value)} type='password' placeholder='password'></LoginStyledInput2>
              <br/>
              <LoginStyledButton onClick={()=>{
                  console.log('blabla');
                  for(let i=0;i<nizUsera.length;i++){
                    console.log(nizUsera[i].username);
                    console.log(username);
                    console.log(nizUsera[i].password);
                    console.log(password);
                      if(nizUsera[i].username===username&&nizUsera[i].password===password){
                          console.log('desilo se');
                             localStorage.setItem('user', username);
                             history.push('/home')
                             window.location.reload();
                                    
                      }
                  }
              }}>Uloguj se</LoginStyledButton>
              <LoginStyledButton onClick={()=>{history.push('/register')}}>Registruj se</LoginStyledButton>
              </LoginStyledDiv>         
        
        </>
    )
}

export const Register=({nizUsera, setNizUsera})=>{
    const [username,setUsername] = useState('');
    const [password,setPassword] = useState('');
    const history=useHistory();
  return(
      <>
        <LoginStyledDiv>
            <LoginStyledInput1 onChange={(e)=> setUsername(e.target.value)} type='text' placeholder='username'></LoginStyledInput1>
            <LoginStyledInput2 onChange={(e)=> setPassword(e.target.value)} type='password' placeholder='username'></LoginStyledInput2>
            <br/>
            <LoginStyledButton onClick={()=>{
                let br=0;
                for(let i=0;i<nizUsera.length;i++){
                    if(nizUsera[i].username===username){
               
                    br++;
                              console.log('korisnik vec postoji');      
                    }
                }
                if(br===0){
                    registerUser(username.trim(), password.trim()).then(res=>{
                              getImena().then(res=>{
                                setNizUsera(res.data.nizImena);
                                localStorage.setItem('user', username);
                                history.push('/home')
                                window.location.reload();
                    console.log('upesno registrovan korisnik');
                            
                             })
    
                        })           
                }
            }}>Registruj se</LoginStyledButton>
           
            </LoginStyledDiv>         
      
      </>
  )
}