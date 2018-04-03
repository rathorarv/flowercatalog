const reload = function(){
  document.getElementById('imageToHide').style.visibility = 'visible';
}


const hide = function(){
  document.getElementById('imageToHide').style.visibility = 'hidden';
  setTimeout(reload,1000);
}

const hiddenPot = function(){
  const pot = document.getElementById('imageToHide');
  pot.onclick = hide;
}
window.onload = hiddenPot;
