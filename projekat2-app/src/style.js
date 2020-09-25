import styled from 'styled-components'
import { BrowserRouter as Router, Switch, Route, Link, Redirect, useParams } from 'react-router-dom'


export const StyledNav=styled.nav`
background-color:red;

`
export const LinkS=styled(Link)`
background-color:lightblue;
font-size:25px;
margin-left:20%;

`

export const ParagrafS1=styled.p`
background-color:cyan;
font-size:17px;
pading:0;
margin:0;
`
export const DivS1=styled.div`
background-color:lightgreen;
font-size:17px;
width:100%;
margin-bottom:5px;
`
export const ParagrafS2=styled.p`
background-color:coral;
font-size:20px;
pading:0;
margin:1px;
text-align:center;
`
export const DivSImg=styled.img`
width:50%;
margin-left:25%;
`