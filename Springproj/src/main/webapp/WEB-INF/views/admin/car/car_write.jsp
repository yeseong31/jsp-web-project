<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- car_write.jsp -->
<%@ include file="../../top.jsp" %>

<div class="container">
    <h1 class="display-6 text-center">차량 등록</h1>
    <form name="f" action="<c:url value="/admin/car/write"/>" method="post" onsubmit="return checkBoard()">
        <div class="row mt-4">
            <table class="table">
                <thead></thead>
                <tbody>
                <tr>
                    <th scope="col" class="text-center">이름</th>
                    <th>
                        <label>
                            <input type="text" name="name" placeholder="이름을 입력하세요">
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">코드</th>
                    <th>
                        <label>
                            <input type="text" name="code" placeholder="코드를 입력하세요">
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">가격</th>
                    <th>
                        <label>
                            <input type="text" name="price" placeholder="가격을 입력하세요">
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">설명</th>
                    <th>
                        <label>
                            <input type="text" name="description" placeholder="설명을 입력하세요">
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">탑승인원</th>
                    <th>
                        <label>
                            <input type="text" name="passengers" placeholder="탑승인원을 입력하세요">
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">트렁크공간</th>
                    <th>
                        <label>
                            <input type="text" name="luggages" placeholder="트렁크 공간을 입력하세요">
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">문 개수</th>
                    <th>
                        <label>
                            <input type="text" name="doors" placeholder="문 개수를 입력하세요">
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">트랜스미션</th>
                    <th>
                        <label>
                            <input type="text" name="transmission" placeholder="트랜스미션을 입력하세요">
                        </label>
                    </th>
                </tr>
                </tbody>
            </table>
        </div>
        <button type="submit" class="btn btn-outline-dark">등록</button>
    </form>
</div>

<!-- 유효성 검사 -->
<script type="text/javascript">
    function checkBoard(){
        if (f.name.value===""){
            alert("이름을 입력하세요")
            f.name.focus()
            return false;
        }
        if (f.code.value===""){
            alert("코드를 입력하세요")
            f.code.focus()
            return false;
        }
        if (f.description.value===""){
            alert("설명을 입력하세요")
            f.description.focus()
            return false;
        }
        if (f.price.value===""){
            alert("가격을 입력하세요")
            f.price.focus()
            return false;
        }
        if (f.passengers.value===""){
            alert("탐승인원을 입력하세요")
            f.passengers.focus()
            return false;
        }
        if (f.luggages.value===""){
            alert("트렁크 공간을 입력하세요")
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
</script>

<%@ include file="../../bottom.jsp" %>