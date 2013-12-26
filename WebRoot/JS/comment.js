function commentSubmit(){
	var text=document.form_comment.commentContent.value;
	if(text==null || text ==''){
		alert('您还没有发表任何评论！');
		return false;
	}else{
		return true;
	}
}