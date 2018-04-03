const showData = function(person){
  const comment = document.createElement('p');
  comment.innerHTML += '----------------------------------------------------<br>';
  comment.className += 'dateTable';
  comment.innerHTML += person.name + '<br><br>';
  comment.innerHTML += person.comment;
  return comment;
};

const getInfo = function(){
  const name = document.getElementById('name').value;
  const comment = document.getElementById('comment').value;
  sendAjax("POST","/commentHandler",callBack,`name=${name}&comment=${comment}`);
}

const callBack = function(){
    const returnData = this.responseText;
    const comment = JSON.parse(returnData);
    const feedback = document.getElementById('feedbacks');
    feedback.prepend(showData(comment));
}