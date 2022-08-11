<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- sign_up.jsp -->
<%@ include file="../top.jsp" %>
<div style="font-size: 14px; text-align: center; width: 100%; min-height: 80vh; display: flex; flex-direction: row;
            align-items: center;justify-content: center;background-color: #fafafa;">
    <form name="f" action="<c:url value="/common/sign_up"/>" method="post" onsubmit="return checkBoard()">
        <div>
            <div style="align-items: center; background-color: #fff; border: 1px solid #dbdbdb; border-radius: 1px;
                        margin: 0 0 10px;padding: 10px 0;width: 350px;height: 580px;">
                <div style="display: flex; align-items: center; justify-content: center;">
                    <img src="https://user-images.githubusercontent.com/66625672/183276264-2d5aa8de-6e43-4c73-97b2-fc16f2d3fe20.png"
                         style="width: 100%; margin: 50px 0" alt="logo1">
                </div>
                <div style="margin-bottom:.5rem">
                    <label for="userid" class="floating-label"></label>
                    <input style="width: 258px; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px;padding: 9px 0 7px 8px;background-color: #FAFAFA;"
                           type="text" id="userid" name="userid" placeholder="아이디">
                </div>
                <div style="margin-bottom:.5rem">
                    <label for="username" class="floating-label"></label>
                    <input style="width: 258px; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px;padding: 9px 0 7px 8px;background-color: #FAFAFA;"
                           type="text" id="username" name="username" placeholder="이름">
                </div>
                <div style="margin-bottom:.5rem">
                    <label for="email" class="floating-label"></label>
                    <input style="width: 258px; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px;padding: 9px 0 7px 8px;background-color: #FAFAFA;"
                           type="email" id="email" name="email" placeholder="이메일">
                </div>
                <div style="margin-bottom:.5rem">
                    <label for="phone" class="floating-label"></label>
                    <input style="width: 258px; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px;padding: 9px 0 7px 8px;background-color: #FAFAFA;"
                           type="text" id="phone" name="phone" placeholder="전화번호">
                </div>
                <div style="margin-bottom:.5rem">
                    <label for="password" class="floating-label"></label>
                    <input style="width: 258px; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px;padding: 9px 0 7px 8px;background-color: #FAFAFA;"
                           type="password" id="password" name="password" placeholder="비밀번호">
                </div>
                <div style="margin-bottom:.5rem">
                    <label for="password2" class="floating-label"></label>
                    <input style="width: 258px; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px;padding: 9px 0 7px 8px;background-color: #FAFAFA;"
                           type="password" id="password2" name="password2" placeholder="비밀번호 확인">
                </div>
                <div>
                    <button id="button-join" type="submit" class="btn btn-primary signup-button" style="width: 258px; margin-left: 2px"> 회원가입 </button>
                </div>
            </div>
            <div style="background-color: white;height: 70px;border: 1px solid rgba(0, 0, 0, 0.18);">
                <div style="margin-top: 25px">
                    계정이 없으신가요? <a href="<c:url value="/common/sign_in"/>">로그인</a>
                </div>
            </div>
        </div>
    </form>
</div>

<!-- 유효성 검사 -->
<script type="text/javascript">
    function checkBoard(){
        if (f.userid.value===""){
            alert("아이디를 입력하세요")
            f.userid.focus()
            return false;
        }
        if (f.username.value===""){
            alert("이름을 입력하세요")
            f.username.focus()
            return false;
        }
        if (f.email.value===""){
            alert("이메일을 입력하세요")
            f.email.focus()
            return false;
        }
        if (f.phone.value===""){
            alert("전화번호를 입력하세요")
            f.phone.focus()
            return false;
        }
        if (f.password.value===""){
            alert("비밀번호를 입력하세요")
            f.password.focus()
            return false;
        }
        if (f.password2.value===""){
            alert("비밀번호 확인을 입력하세요")
            f.password2.focus()
            return false;
        }
        if (f.password.value !== f.password2.value){
            alert("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.")
            f.password.value = ""
            f.password2.value = ""
            f.password.focus()
            return false;
        }
        return true;
    }
</script>
<%@ include file="../bottom.jsp" %>