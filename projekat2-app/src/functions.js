export function postProvera(comment){
if(comment.trim().length>0&&comment.trim().length<=40){

    return true;
    
}else {
    return false;
}

}