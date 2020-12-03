// 회원정보 Member 객체들을 저장하는 배열
var members = []; // object -> 문자열  JSON

// 생성자 함수 Member

function Member(id, pw, name) {
    this.userid = id;
    this.userpw = pw;
    this.username = name;
}

Member.prototype.makeHtml = function (index) {

    console.log(this.userid + ' : ' + this.userpw + ' : ' + this.username);

    var memberHtml = '';
    memberHtml += '<tr>';
    memberHtml += ' <td>' + index + '</td>';
    memberHtml += ' <td>' + this.userid + '</td>';
    memberHtml += ' <td>' + this.userpw + '</td>';
    memberHtml += ' <td>' + this.username + '</td>';
    memberHtml += ' <td><div class="btn-group" role="group" aria-label="Basic example"><button type="button" onclick="editMember(' + index + ')" class="btn btn-info">수정</button><button type="button" onclick="delmember(' + index + ')" class="btn btn-info">삭제</button></div></td>';
    memberHtml += '</tr>';

    return memberHtml;

}



$(document).ready(function(){

    // localStorage 저장하는 key -> members
    // localStorage.getItem('members') 저장 값이 없으면 null 반환
    if (localStorage.getItem('members') == null) {
        // 초기배열 저장 : 배열을 문자열로 변경해서 저장
        localStorage.setItem('members', JSON.stringify(members));
        
    } else {
        
        members = JSON.parse(localStorage.getItem('members'));
        
        console.log(members);
        
        setlist();

    }



});
/*function load(){    
   alert('외부 스크립트 파일에서 로드'); 
}*/



function regmember() {

    // 사용자가 입력한 데이터를 확인
    // 유효성 검사
    // 사용자 정보를 저장하는 객체를 생성

    // 아이디
    var userid = $('#userid');
    // 비밀번호
    var pw = $('#pw');
    // 비밀번호 확인
    var repw = $('#repw');
    // 이름
    var username = $('#username');

    var check = false; // 문제 없다

     
    // 공백문자를 검사 : trim()을 이용해서 공백 제거 후 문자열 비교
    if ($.trim(userid.val()).length < 1) {
 
        $('#userid_msg').show();
        check = true;
    }
   
    if ($.trim(pw.val()).length < 1) {
        $('#pw_msg').show();
        check = true;
    }
    if ($.trim(repw.val()).length < 1 || pw.val() != repw.val()) {
        $('#repw_msg').show();
        check = true;
    }
    if ($.trim(username.val()).length < 1) {
        $('#username_msg').show();
        check = true;
    }


    /*userid.onfocus = function(){
        $('#userid_msg').style.display='none';
    }*/

    
    userid.focus(function(){
        $('#userid_msg').hide();
        userid.val('');
    });
   
    pw.focus(function(){
        $('#pw_msg').hide();
        pw.val('');
    });

    repw.focus(function(){
        $('#repw_msg').hide();
        repw.val('');
    });

    username.focus(function(){
        $('#username_msg').hide();
        username.val('');
    });

    console.log(check);

    
    if (check) {
        return false;
    }


    /*var member = {
        memberid: userid.val(),
        pw: pw.val(),
        membername: username.val()
    };*/

    var member = new Member(userid.val(), pw.val(), username.val());

    //console.log('member', member);
    member.makeHtml()

    // 배열에 회원 정보를 저장
    members.push(member);

    console.log('members', members);

    $('#regform').each(function() {
        this.reset();  
    });

    alert('등록되었습니다.');

    // localStorage 저장
    localStorage.setItem('members', JSON.stringify(members));

    // 리스트 갱신
    setlist();



    return false;
}


// 리스테이블의 정렬
function setlist() {

    // table tbody 캐스팅
    var listrow = $('#listrow');

    var tbody = '<tr class="thead-dark">';
    tbody += '<th>순번(index)</th>';
    tbody += '<th>아이디</th>';
    tbody += '<th>비밀번호</th>';
    tbody += '<th>이름</th>';
    tbody += '<th>관리</th>';
    tbody += '</tr>';

    for (var i = 0; i < members.length; i++) {
        //tbody += members[i].makeHtml(i);
        
        tbody += '<tr>';
        tbody += ' <td>' + i + '</td>';
        tbody += ' <td>' + members[i].userid + '</td>';
        tbody += ' <td>' + members[i].userpw + '</td>';
        tbody += ' <td>' + members[i].username + '</td>';
        tbody += ' <td><div class="btn-group" role="group" aria-label="Basic example"><button type="button" onclick="editMember(' + i + ')" class="btn btn-info">수정</button><button type="button" onclick="delmember(' + i + ')" class="btn btn-info">삭제</button></div></td>';
        tbody += '</tr>';
        
    }

    listrow.html(tbody);
}


// 배열의 데이터를 삭제
function delmember(index) {

    var delChk = confirm('삭제하시겠습니까?');

    if (delChk) {

        // 삭제 -> 배열에서 요소를 삭제
        members.splice(index, 1);

        // localStorage 저장
        localStorage.setItem('members', JSON.stringify(members));


        alert('삭제되었습니다.');



        // 배열의 변경된 내용으로 리스트 출력
        setlist();

    }

}

function editMember(index) {
    
    console.log(members[index]);

    // 수정 화면 캐스팅
    var editDiv = $('div.edit_div');
    editDiv.show();

    // form 안에 있는 input 캐스팅
    // id    
    var eid = $('#editid');
    // name
    var ename = $('#editname');
    // pw
    var epw = $('#editpw');
    // repw
    var erepw = $('#editrepw');
    // index
    var idx = $('#index');

    idx.val(index);
    eid.val(members[index].userid);
    ename.val(members[index].username);
    epw.val(members[index].userpw);
    erepw.val(members[index].userpw);

}

function editMemberData() {
    // 캐스팅
    // index
    var eidx = $('#index').val();
    // id
    // var eid = $('#editid');
    // pw
    var epw = $('#editpw');
    // repw
    var erepw = $('#editrepw');
    // name
    var ename = $('#editname');


    // editpw > msg
    var pw_msg = $('#editpw_msg');
    var repw_msg = $('#editrepw_msg');
    var ename_msg = $('#editname_msg');


    var check = false; // 문제 없다

    // 공백문자를 검사 : trim()을 이용해서 공백 제거 후 문자열 비교
    if ($.trim(epw.val()).length < 1) {
        pw_msg.show();
        check = true;
    }
    if ($.trim(erepw.val()).length < 1 || epw.val() != erepw.val()) {
        repw_msg.show();
        check = true;
    }
    if ($.trim(ename.val()).length < 1) {
        ename_msg.show();
        check = true;
    }


    epw.focus(function(){
        pw_msg.hide();
        epw.val('');
    });

    erepw.focus(function(){
        repw_msg.hide();
        erepw.val('');
    });

    ename.focus(function(){
        ename_msg.hide();
        ename.val('');
    });

    console.log(check);

    if (check) {
        return false;
    }
    

    // members[index] -> pw, name 수정
    members[eidx].username = $.trim(ename.val());
    members[eidx].userpw = epw.val();

    // localStorage 저장
    localStorage.setItem('members', JSON.stringify(members));

    alert('수정되었습니다.');

    // 회원 리스트 갱신
    setlist();

    $('#editform').each(function() {
        this.reset();  
    });    
    $('div.edit_div').hide();


    return false;

}


function editMemberClose() {
    // 수정 화면 캐스팅
    var editDiv = $('div.edit_div');
    editDiv.hide();
}