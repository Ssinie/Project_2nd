/* product jsp script */

var num = ${num};
var id = ${id};

var wishCheck = ${wishCheck};

var wish = document.getElementById("wish");
wish.onclick = function() { changeHeart(); }

/* 관심상품 버튼 눌렀을 때 */
function changeHeart() {
	$.ajax({
		type: "POST",
		url: "wishlistPro.ns",
		dataType: "json",
		data: "num"+num+"&id"+id,
		error: function(){
			Rnd.alert("통신 에러","error","확인",function(){});
            },
            success : function(jdata) {
                if(jdata.resultCode == -1){
                    Rnd.alert("좋아요 오류","error","확인",function(){});
                }
                else{
                    if(jdata.likecheck == 1){
                        $("#btn_like").attr("src","/home/img/ico_like_after.png");
                        $("#likecnt").empty();
                        $("#likecnt").append(jdata.likecnt);
                    }
                    else if (jdata.likecheck == 0){
                        $("#btn_like").attr("src","/home/img/ico_like_before.png");
                        $("#likecnt").empty();
                        $("#likecnt").append(jdata.likecnt);
                        
                    }
                }
            }
        });
 }
