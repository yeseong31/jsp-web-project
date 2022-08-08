<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- car_update.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">차량 수정 페이지</h5>
        <form name="f" action="<c:url value="/admin/car/update"/>" method="post" onsubmit="return checkBoard()">
            <div class="row mt-4">
                <table class="table">
                    <thead></thead>
                    <tbody>
                    <tr>
                        <th scope="col" class="text-center" style="width: 150px">이름</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="name" value="${getCar.name}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">코드</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="code" value="${getCar.code}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">가격</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="price" value="${getCar.price}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">설명</th>
                        <th>
                            <label style="width: 100%">
                                <textarea id="newTweetContent" name="description" placeholder="설명을 입력해 주세요"
                                          style="width: 100%; font-size: 15px;
                                          border: 1px solid #dbdbdb; border-radius: 6px; padding: 9px 8px 7px 8px;
                                          background-color: #FAFAFA; resize: none" rows="10"
                                          onkeydown="resize(this)" onkeyup="resize(this)">${getCar.description}</textarea>
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">탑승인원</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="passengers" value="${getCar.passengers}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">트렁크 공간</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="luggages" value="${getCar.luggages}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">문</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="doors" value="${getCar.doors}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">트랜스미션</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="transmission" value="${getCar.transmission}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                            </label>
                        </th>
                    </tr>
                    </tbody>
                </table>
            </div>
            <label>
                <input type="text" name="id" value="${getCar.id}" hidden>
            </label>
            <!-- 버튼 -->
            <div class="d-flex">
                <button class="btn btn-outline-secondary flex-shrink-0" type="submit" style="margin-right: 5px" >수정</button>
                <%--                        <button class="btn btn-outline-danger flex-shrink-0" type="button"--%>
                <%--                                style="margin-right: 5px" onclick="location.href='/admin/car/delete?id=${getCar.id}'">삭제</button>--%>
            </div>
        </form>
    </div>
</section>

<!-- 유효성 검사 -->
<script type="text/javascript">
    function checkBoard(){
        if (f.code.value===""){
            alert("코드를 입력하세요")
            f.code.focus()
            return false;
        }
        if (f.name.value===""){
            alert("이름을 입력하세요")
            f.name.focus()
            return false;
        }
        if (f.price.value===""){
            alert("가격을 입력하세요")
            f.price.focus()
            return false;
        }
        if (f.description.value===""){
            alert("설명을 입력하세요")
            f.description.focus()
            return false;
        }
        if (f.passengers.value===""){
            alert("탑승인원을 입력하세요")
            f.passengers.focus()
            return false;
        }
        if (f.luggages.value===""){
            alert("트렁크공간을 입력하세요")
            f.luggages.focus()
            return false;
        }
        if (f.doors.value===""){
            alert("문 개수를 입력하세요")
            f.doors.focus()
            return false;
        }
        if (f.transmission.value===""){
            alert("트랜스미션을 입력하세요")
            f.transmission.focus()
            return false;
        }
        return true;
    }

    function resize(obj) {
        obj.style.height = '1px';
        obj.style.height = (12 + obj.scrollHeight) + 'px';
    }
</script>

<%@ include file="../../bottom.jsp" %>