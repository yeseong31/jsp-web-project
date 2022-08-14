<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- insert.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">사용자 등록 페이지</h5>
        <form name="f" action="<c:url value="/common/sign_up"/>" method="post" onsubmit="return checkBoard()">
            <div class="row mt-4">
                <table class="table">
                    <thead></thead>
                    <tbody>
                    <tr>
                        <th scope="col" class="text-center" style="width: 150px">아이디</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="userid" placeholder="아이디를 입력하세요"
                                       style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">이름</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="username" placeholder="이름 입력하세요"
                                       style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">이메일</th>
                        <th>
                            <label style="width: 100%">
                                <input type="email" name="email" placeholder="이메일을 입력하세요"
                                       style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">전화번호</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="phone" placeholder="전화번호를 입력하세요"
                                       style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">비밀번호</th>
                        <th>
                            <label style="width: 100%">
                                <input type="password" name="password" placeholder="비밀번호를 입력하세요"
                                       style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">비밀번호 확인</th>
                        <th>
                            <label style="width: 100%">
                                <input type="password" name="password2" placeholder="비밀번호를 한 번 더 입력하세요"
                                       style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">관리자 유무</th>
                        <th>
                            <label style="width: 100%">
                                <input id="is_admin" name="is_admin" value="1" hidden>
                                <input type="checkbox" id="checkbox" name="checkbox" checked>
                            </label>
                        </th>
                    </tr>
                    </tbody>
                </table>
            </div>
            <button type="submit" class="btn btn-outline-dark">등록</button>
        </form>
    </div>
</section>

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

    let is_admin = document.getElementById("is_admin");
    let checkbox = document.getElementById("checkbox");
    checkbox.onclick = function () {
        if (checkbox.checked) {
            is_admin.value = 1
        } else {
            is_admin.value = 0
        }
    }
</script>

<%@ include file="../../bottom.jsp" %>