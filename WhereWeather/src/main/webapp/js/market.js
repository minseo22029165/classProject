
		

	
		// 댓글 목록 
		function fnComList(){
			$('#comList *').remove();
			$('#reply_content').val('');
			
			var saleNo = $('#saleNo').val();

			$.ajax({
				url : myHostUrl + '/market/reply/' + saleNo,
				type : 'GET',
				success : function(data){

					for(var i = 0 ; i < data.length; i++) {
						var html = '';
						html += '<div id="rely_div_' + data[i].replyNo + '" class="card mb-3" style="max-width: 100%;">';
						html += '  <div class="row g-0">';
						html += '    <div class="col-1">이미지</div>';

						// 댓글 보기 
						html += '    <div id="reply_view_div_' + data[i].replyNo + '" class="col-10">';
						html += '      <div class="card-body">';
						html += '        <h5 class="card-title">' + data[i].replyNic + '</h5>';
						html += '        <h5 id="reply_view_cnt_' + data[i].replyNo + '" class="card-title">' + data[i].replyCnt + '</h5>';
						html += '        <p class="card-text">' + data[i].replyDate + '</p>';
						html += '      </div>';
						html += '    </div>';
						
						// 댓글 수정폼
						html += '    <div id="reply_upd_div_' + data[i].replyNo + '" class="col-10" style="display:none">';
						html += '      	<div class="card-body text-right">';
						html += '			<textarea id="reply_content_' + data[i].replyNo + '" class="form-control" aria-label="With textarea">' + data[i].replyCnt + '</textarea>';
						html += ' 			<div class="btn-group" role="group" aria-label="Basic example"><button type="button" onclick="fnReplyUpd(' + data[i].replyNo + ')" class="btn btn-info">수정</button><button type="button" onclick="fnReplyView(' + data[i].replyNo + ');" class="btn btn-info">취소</button></div>';
					    						
						html += '      	</div>';
						html += '    </div>';						
						
						html += '    <div class="col-1 dropleft">';
						// 내 댓글인 경우에만 수정, 삭제 허용
						if(memIdx == data[i].replyIdx){
							html += '    	<a class="btn btn-white" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="cursor:pointer;">';
							html += '    		<img src="/image/icon/usefulbutton.png" style="width:15px;">';
							html += '		</a>';
							html += '    	<div class="dropdown-menu" aria-labelledby="dropdown01">';
							html += '    		<a class="dropdown-item" href="javascript:fnReplyDel(' + data[i].replyNo + ');">삭제</a>';
							html += '    	    <a class="dropdown-item" href="javascript:fnReplyUpdForm(' + data[i].replyNo + ');">수정</a>';
							html += '    	</div>';
						}
						html += '    </div>';
						html += '  </div>';
						html += '</div>';

						$('#comList').append(html);
					} 	
					
				},
				error : function(e){
				
					console.log("에러발생 : " + e);
					alert("에러발생 : " + e);
				}
			});
		}
		
		
		// 댓글 등록
		//$('#reply_button').click(function(){	
		function fnReplyBtnClick(){
			
			// 로그인 체크 
			fnLoginChk();
			
			if($.trim($('#reply_content').val()).length < 1) { 
				alert('댓글을 입력해주세요.'); 
				$('#reply_content').focus();
				return false;
			}
			
			var data = {
				saleNo : $('#saleNo').val(),
				replyCnt : $('#reply_content').val()
			};

			$.ajax({
				url : myHostUrl + '/market/reply/reg',
				type : 'POST',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=UTF-8',
				//dataType : 'json',
				async : false, 
				success : function(msg){

					if(msg == 'Y'){
						// 댓글 목록 호출
						fnComList();
					}else {
						alert('오류가 발생했습니다. 다시 시도해주세요.' + msg);
						return false;
					}
				}, 
				error : function(err){
					alert(err);
					return;
				} 				
			});

		//});
		}
		
		// 로그인 체크 
		function fnLoginChk(){
			if(memIdx == null){
				alert('로그인 후 이용해주세요.');
				return false;
			}
		}		
		
		function fnReplyUpdClose() {
		    // 수정 화면 캐스팅
		    var editDiv = $('div.edit_div');
		    editDiv.hide();
		}		
		
		// 댓글 상세보기로 되돌리기
		function fnReplyView(replyNo) {
			// 댓글 수정폼 숨기기 
			$('#reply_view_div_' + replyNo).show();
			$('#reply_upd_div_' + replyNo).hide();			
		}
		
		// 댓글 수정폼
		function fnReplyUpdForm(replyNo) {

			// 댓글 수정폼 보이게
			$('#reply_view_div_' + replyNo).hide();
			$('#reply_upd_div_' + replyNo).show();
			
// 			var html = '';
// 			html += '<div class="edit_div">';
// 			html += '	<div class="edit_for_header">';
// 			html += '    <h2>댓글 수정</h2>';
// 			html += '    <a href="javascript:fnReplyUpdClose();">닫기</a>';
// 			html += '	</div>';
// 			html += '	<hr>';
// 			html += '	<form id="editform" onsubmit="return fnReplyUpd();">';
// 			html += '    	<table>';
// 			html += '       	<tr>';
// 			html += '         	  	<td>';
// 			html += '           		<input type="text" name="edit_replyCmt" id="edit_replyCmt" class="form-control">';
// 			html += '           		<textarea id="edit_replyCmt" class="form-control" aria-label="With textarea"></textarea>';
// 			html += '             	</td>';
// 			html += '         	</tr>';
// 			html += '         	<tr>';
// 			html += '              <td>';
// 			html += '                  <input type="submit" value="댓글 수정" class="btn btn-warning">';
// 			html += '              </td>';
// 			html += '           </tr>';
// 			html += '        </table>';
// 			html += '    </form>';
// 			html += '</div>';
		}
		
		// 댓글 수정 처리
		function fnReplyUpd(replyNo) {
		
			// 로그인 체크 
			fnLoginChk();
			
			var replyCnt = $('#reply_content_' + replyNo);
			
			if($.trim(replyCnt.val()).length < 1) { 
				alert('댓글을 입력해주세요.'); 
				replyCnt.focus();
				return false;
			}
			
			var data = {
				replyNo : replyNo,
				replyCnt : replyCnt.val()
			};

			$.ajax({
				url : myHostUrl + '/market/reply/upd',
				type : 'POST',
				data : JSON.stringify(data),
				contentType : 'application/json; charset=UTF-8',
				//dataType : 'json',
				async : false, 
				success : function(msg){

					if(msg == 'Y'){
						$('#reply_view_cnt_' + replyNo).text(replyCnt.val());
						
						// 댓글 상세보기로 되돌리기
						fnReplyView(replyNo);
					}else {
						alert('댓글 수정에 실패했습니다.' + msg);
						return false;
					}
				}, 
				error : function(err){
					alert(err);
					return;
				} 				
			});

		}
		
		// 댓글 삭제 처리
		function fnReplyDel(replyNo) {
		
			// 로그인 체크 
			fnLoginChk();

			$.ajax({
				url : myHostUrl + '/market/reply/del/' + replyNo,
				type : 'GET',
				contentType : 'application/json; charset=UTF-8',
				//dataType : 'json',
				async : false, 
				success : function(msg){

					if(msg == 'Y'){
						$('#rely_div_' + replyNo).hide();

					}else {
						alert('댓글 삭제에 실패했습니다.' + msg);
						return false;
					}
				}, 
				error : function(err){
					alert(err);
					return;
				} 				
			});

		}
		
   		