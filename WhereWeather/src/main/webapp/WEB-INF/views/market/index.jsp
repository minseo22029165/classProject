<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
	session.setAttribute("memidx", "1");
	session.setAttribute("memnic", "메이웨더");
	session.setAttribute("memloc", "0.00,0.00");	
	
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	
	<title>+WEATHER WEAR+</title>
	
	<link rel="styleSheet" href="<c:url value="/css/default.css"/>">
	<link rel="styleSheet" href="<c:url value="/css/market.css?2021020811"/>">
	
	<%@ include file="/WEB-INF/views/include/basicset.jsp"%>
   
    <!-- bootstrap START -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
   	<!-- <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script> -->
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script> 
    <!-- bootstrap END -->
 	
</head>

<body bgcolor="#f5f5f5">

	<%@ include file="/WEB-INF/views/include/header.jsp"%>

	<!-- 컨텐츠 영역 -->
	<div class="content" id="content" name="content">
		<form id="form">
			<input type="hidden" name="saleNo" id="saleNo" value="">
		</form>	
		<div id="market" name="market"></div>
	</div>
	
	<%@ include file="/WEB-INF/views/include/footer.jsp" %>

	<script type="text/javascript">
		var myHostUrl = 'http://localhost:8080';
		var memIdx = '<%=(String)session.getAttribute("memidx")%>';
		var memNic = '<%=(String)session.getAttribute("memnic")%>';
		var memLoc = '<%=(String)session.getAttribute("memloc")%>';
		
		//임의의 file object영역
        var files = {};
        var previewIndex = 0;		
	    
		$(document).ready(function(){
			// 판매 목록 호출 
			fnSaleList();
		});



		
		// 구매 등록폼
		function fnSaleWriteForm(){
			// 페이지 테그 삭제
			$('#market *').remove();
		    
			// 구매 등록폼
			
			var html = '';
			// 검색
			html += '<div class="write_form" >';
			html += '	<div>마켓 글쓰기</div>';
			html += '	<div class="write_form_btn" >';
			html += ' 	 	<button type="button" class="btn btn-outline-primary" onclick="fnSaleReg();">등록</button>';
			html += '	</div>';
			html += '</div>';
		
			// 첨부 버튼 
            html += '<div id="attach">';
            html += '	<div class="img_upload_div">';
            html += '		<label for="uploadInput">';
            html += '    		<img class="img_upload" src="/image/icon/carmera.png">';
            html += '     	</label>';
            html += '     	<input id="uploadInput" style="display: none" type="file" name="filedata" multiple onchange="addPreview($(this));"/>';
            html += '	</div>';
            // 미리보기 영역
            html += '	<div id="preview" class="img_preview"></div>';
            html += '</div>';            
            
            // multipart 업로드시 영역 
            html += '<form id="saleRegForm" />';
			html += '<table class="table">';
    		html += '	<tr>';
			html += '      	<td>';

 			html += '      		<input id="saleTitle" name="saleTitle" class="form-control" type="text" placeholder="제목">';
 			html += '      		<input id="saleAmount" name="saleAmount" class="form-control" type="number" placeholder="가격">';
			
 			html += '			<br><br>';
 			html += '      		<div class="form-check form-check-inline">';
 			html += '        		<input class="form-check-input" type="radio" name="inlineRadioOptions" id="payDiv" name="payDiv" value="D" checked>';
 			html += '        		<label class="form-check-label" for="inlineRadio1">직접결제</label>';
 			html += '      		</div>';
 			html += '      		<div class="form-check form-check-inline">';
 			html += '        		<input class="form-check-input" type="radio" name="inlineRadioOptions" id="payDiv" name="payDiv" value="K">';
 			html += '        		<label class="form-check-label" for="inlineRadio2">카카오페이</label>';
 			html += '      		</div>';
 			html += '        	<div class="form-group">';
 			html += '          		<label for="exampleFormControlTextarea1"></label>';
 			html += '          		<textarea id="saleCmt" name="saleCmt" class="form-control" id="exampleFormControlTextarea1" rows="5"></textarea>';
 			html += '        	</div>';
			
			html += '		</td>';
			html += '    </tr>';

			html += '</table>';	
	
			$('#market').append(html);	
		}
		
	
		// 상품 등록
		function fnSaleReg(){
			var saleTitle = $('#saleTitle');
			var saleAmount = $('#saleAmount');
			var saleCmt = $('#saleCmt');

			// 로그인 체크 
			fnLoginChk();
		
			if($.trim($('#saleTitle').val()).length < 1) { 
				alert('제목을 입력해주세요.'); 
				$('#saleTitle').focus();
				return false;
			}			

			if($.trim($('#saleAmount').val()).length < 1) { 
				alert('가격을 입력해주세요.'); 
				$('#saleAmount').focus();
				return false;
			}	
			
			if($.trim($('#saleCmt').val()).length < 1) { 
				alert('내용을 입력해주세요.'); 
				$('#saleCmt').focus();
				return false;
			}		
			
			var form = $('#saleRegForm')[0];
	        var formData = new FormData(form);
	        
	        
	        formData.append('saleTitle', $('#saleTitle').val());
	        formData.append('saleAmount', $('#saleAmount').val());
	        formData.append('saleCmt', $('#saleCmt').val());
	        formData.append('payDiv', $('#payDiv').val());
	        
	        /* 	
			var data = {
					saleTitle : $('#saleTitle').val(),
					saleAmount : $('#saleAmount').val(),
					saleCmt : $('#saleCmt').val(),
					payDiv : $('#payDiv').val(),
					saleAmount : $('#saleAmount').val()
				};	
			 
			formData.append('data', data);
			*/
			
	        for (var index = 0; index < Object.keys(files).length; index++) {
	            //formData 공간에 files라는 이름으로 파일을 추가한다.
	            //동일명으로 계속 추가할 수 있다.
	            formData.append('files', files[index]);
	        }
	        
	        //ajax 통신으로 multipart form을 전송한다.
	        $.ajax({
	            type : 'POST',
	            enctype : 'multipart/form-data',
	            processData : false,
	            contentType : false,
	            cache : false,
	            timeout : 600000,
	            url : myHostUrl + '/market/sale/reg',
	            //dataType : 'JSON',
	            data : formData,
	            success : function(result) {
					if(result > 0){
						// 상세보기 페이지 이동 
						fnViewInfo(result);
					}else {
		                //-1 = 잘못된 확장자 업로드, -2 = 용량초과, 그외 = 성공(1)
		                if (result === -1) {
		                    alert('jpg, gif, png, bmp 확장자만 업로드 가능합니다.');
		                   
		                } else if (result === -2) {
		                    alert('파일이 10MB를 초과하였습니다.');
		                  
		                } else {
		                    alert('에러');
		                    
		                }
					}	
	            }
	            //전송실패에대한 핸들링은 고려하지 않음
	        });

		}
        
		
        // image preview 기능 구현
        // input = file object[]
        function addPreview(input) {
            if (input[0].files) {
                //파일 선택이 여러개였을 시의 대응
                for (var fileIndex = 0; fileIndex < input[0].files.length; fileIndex++) {
                    var file = input[0].files[fileIndex];
 
                    if (validation(file.name))
                        continue;
 
                    var reader = new FileReader();
                    reader.onload = function(img) {
                        //div id="preview" 내에 동적코드추가.
                        //이 부분을 수정해서 이미지 링크 외 파일명, 사이즈 등의 부가설명을 할 수 있을 것이다.
                        var imgNum = previewIndex++;
                        
                        var html = '';
                        html += '<div class="preview-box" value="' + imgNum  +'">';
                        html += '	<a class="img_delete" href="#" value="' + imgNum + '" onclick="deletePreview(this)"><img class="x-btn" src="/image/icon/x.png"></a>';
                        html += '	<img class="thumbnail rounded" src="' + img.target.result + '">';                         
                        html += '</div>';
                        
                        $("#preview").append(html);
                        files[imgNum] = file;
                    };
                    reader.readAsDataURL(file);
                }
            } else
                alert('invalid file input'); // 첨부클릭 후 취소시의 대응책은 세우지 않았다.
        }	
        //preview 영역에서 삭제 버튼 클릭시 해당 미리보기이미지 영역 삭제
        function deletePreview(obj) {
            var imgNum = obj.attributes['value'].value;
            delete files[imgNum];
            $("#preview .preview-box[value=" + imgNum + "]").remove();
            resizeHeight();
        }
 
        //client-side validation
        //always server-side validation required
        function validation(fileName) {
            fileName = fileName + "";
            var fileNameExtensionIndex = fileName.lastIndexOf('.') + 1;
            var fileNameExtension = fileName.toLowerCase().substring(
                    fileNameExtensionIndex, fileName.length);
            if (!((fileNameExtension === 'jpg')
                    || (fileNameExtension === 'gif') || (fileNameExtension === 'png'))) {
                alert('jpg, gif, png 확장자만 업로드 가능합니다.');
                return true;
            } else {
                return false;
            }
        }
        
		// 판매 목록
		function fnSaleList(){
			$.ajax({
				url : myHostUrl + '/market/sale',
				type : 'GET',
				success : function(data){

					// 글쓰기
					var html = '';
					html += '<a href="javascript:fnSaleWriteForm()"><div id="write_btn"></div></a>';
					
					// 검색
					html += '<div class="search_div" >;'
					html += '	<div class="search_input" >';
					html += '		<div class="input-group">';
					html += '  			<input type="text" class="form-control" placeholder="" aria-label="" aria-describedby="button-addon2">';
					html += '			<div class="input-group-append">';
					html += '  				<button class="btn btn-outline-primary" type="button" id="button-addon2">Search</button>';

					html += '			</div>';
					html += '		</div>';
					html += '	</div>';
					html += '</div>';
					
					$('#market').append(html);
					
					// 리스트
					for(var i = 0 ; i < data.saleList.length; i++) {
						mainFileName = data.saleList[i].fileName;
	
						if(mainFileName == '' || mainFileName == null){
							mainFileName = '/image/icon/default.png';
						}
						html = '<a href="javascript:fnViewInfo(' + data.saleList[i].saleNo + ')">';
						html += '<div class="card mb-3" style="max-width: 100%;">';
						html += '  <div class="row g-0">';
						html += '    <div class="col-3" >';
						html += '      <img src="' + mainFileName + '" width="100px">';
						html += '    </div>';
						html += '    <div class="col-9">';
						html += '      <div class="card-body">';
						html += '        <h5 class="card-title">' + data.saleList[i].saleTitle + '</h5>';
						html += '        <p class="card-text">' + data.saleList[i].saleAmount + '</p>';
						html += '        <p class="card-text">' + data.saleList[i].saleDate + '<small class="text-muted"> <img src="/image/icon/comment.png" width="15px"> ' + data.saleList[i].comCnt + ' <img src="/image/icon/heart.png" width="15px"> ' + data.saleList[i].goodCnt + '</small></p>';
						html += '      </div>';
						html += '    </div>';
						html += '  </div>';
						html += '</div>';
				    	html += '</a>';
						
				    	$('#market').append(html);
					} 	
					
					
					
				},
				error : function(e){
					console.log("에러발생 : " + e);
				}
			});
		}		
		
		// 구매목록 상세보기 
		function fnViewInfo(saleNo){
			// 페이지 테그 삭제
			$('#market *').remove();
			$('#saleNo').val(saleNo);
			
			var addClass = "active";

			$.ajax({
				url : myHostUrl + '/market/sale/view/' + saleNo,
				type : 'GET',
				success : function(data){
					var html = '';
					
					// 이미지 목록
					if(data.imageList.length > 0){
						html = '<div id="carouselExampleDark" class="carousel carousel-dark slide" data-bs-ride="carousel">';
						html += '  <ol class="carousel-indicators">';
				
						for(var i = 0 ; i < data.imageList.length ; i++) {
							addClass = '';
							if(i == 0){
								addClass = 'active';								
							}
							html += '    <li data-bs-target="#carouselExampleDark" data-bs-slide-to="' + (i + 1) + '" class="' + addClass + '"></li>';
						}
						 
						html += '  </ol>';
						html += '  <div class="carousel-inner">';
						for(var i = 0 ; i < data.imageList.length; i++) {
							addClass = '';
							
							if(i == 0){
								addClass = 'active';								
							}							
							
							html += '    <div class="carousel-item ' + addClass + '">';
							html += '      <img src="' + data.imageList[i].fileNameAll +'" class="d-block image_list" alt="...">';
							html += '      <div class="carousel-caption d-none d-md-block">';
							html += '        <h5></h5>';
							html += '        <p></p>';
							html += '      </div>';
							html += '    </div>';
						}
						html += '  </div>';
					   	html += '  <a class="carousel-control-prev" href="#carouselExampleDark" role="button" data-bs-slide="prev">';
						html += '    <span class="carousel-control-prev-icon" aria-hidden="true"></span>';
						html += '    <span class="visually-hidden">Previous</span>';
					  	html += '  </a>';
						html += '  <a class="carousel-control-next" href="#carouselExampleDark" role="button" data-bs-slide="next">';
					 	html += '    <span class="carousel-control-next-icon" aria-hidden="true"></span>';
						html += '    <span class="visually-hidden">Next</span>';
						html += '  </a>';
						html += '</div>';
					}
					
					// 상세보기
					html += '<table class="table">';
					html += '  <thead>';
					html += '    <tr>';
					html += '      	<th scope="col">' + data.saleMember.saleNic + '</th>';
					html += '    </tr>';
					html += '  </thead>';
					html += '  <tbody>';
					html += '    <tr>';
					html += '      	<td>';
					html += data.saleMember.saleTitle + '<br>';
					html += data.saleMember.saleDate + '<br><br>';
					html += data.saleMember.saleCmt + '<br><br>';
					html += '댓글 ' + data.saleMember.comCnt + '개 ＊ 조아요 ' + data.saleMember.goodCnt + ' ＊ 조회 ' + data.saleMember.readCnt + '<br>';
					html += '		</td>';
					html += '    </tr>';
					html += '  </tbody>';
					html += '</table>';
					
					html += '<!-- 댓글 등록 폼 -->';
					html += '<div class="col-12">';					
					html += '	<div class="input-group mb-3">';
					html += '		<textarea id="reply_content" class="form-control" aria-label="With textarea"></textarea>';
					html += '  		<button class="btn btn-outline-secondary" type="button" id="reply_button" onclick="fnReplyBtnClick();">Button</button>';
					html += '	</div>';

					html += '	<!-- 댓글 목록 -->';
					html += '	<div id="comList" name="comList"></div>';
					html += '</div>';									
					$('#market').append(html);

					// 댓글 목록 호출
					fnComList();
						
				},
				error : function(e){
					console.log("에러발생 : " + e);
				}
				
				
			});			
		}       

	</script>    
	<script src="<c:url value="/js/market.js?20210208"/>"></script>
</body>

</html>