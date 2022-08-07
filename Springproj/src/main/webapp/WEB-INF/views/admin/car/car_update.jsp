<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- car_update.jsp -->
<%@ include file="../../top.jsp" %>

<!-- Product section-->
<section class="py-5">
    <div class="container px-4 px-lg-5 my-5">
        <form name="f" action="<c:url value="/admin/car/update"/>" method="post" onsubmit="return checkBoard()">
            <div class="row gx-4 gx-lg-5 align-items-center">
                <div class="col-md-6">
                    <img class="card-img-top mb-5 mb-md-0" src="https://picsum.photos/seed/${getCar.id}/600/700" alt="product_image" />
                </div>
                <div class="col-md-6">
                    <!-- 상품코드 -->
                    <div class="small mb-1">
                        <label>
                            <input type="text" name="code" value="${getCar.code}">
                        </label>
                    </div>
                    <!-- 상품이름 -->
                    <h1 class="display-5 fw-bolder">
                        <label>
                            <input type="text" name="name" value="${getCar.name}">
                        </label>
                    </h1>
                    <!-- 상품가격 -->
                    <div class="fs-5 mb-5">
                        <span>
                            <label>
                                <input type="text" name="price" value="${getCar.price}">
                            </label>
                        </span>
                    </div>
                    <!-- 상품설명 -->
                    <p class="lead">
                        <label>
                            <input type="text" name="description" value="${getCar.description}">
                        </label>
                    </p>
                    <!-- 옵션 -->
                    <div class="small mb-1">
                        <p>탑승인원:
                            <label><input type="text" name="passengers" value="${getCar.passengers}"></label> 명</p>
                        <p>트렁크 공간: <label><input type="text" name="luggages" value="${getCar.luggages}"></label></p>
                        <p>문: <label><input type="text" name="doors" value="${getCar.doors}"></label> 개</p>
                        <p>트랜스미션: <label><input type="text" name="transmission" value="${getCar.transmission}"></label></p>
                    </div>
                    <label><input type="text" name="id" value="${getCar.id}" hidden></label>
                    <!-- 버튼 -->
                    <div class="d-flex">
                        <button class="btn btn-outline-secondary flex-shrink-0" type="submit" style="margin-right: 5px" >수정</button>
<%--                        <button class="btn btn-outline-danger flex-shrink-0" type="button"--%>
<%--                                style="margin-right: 5px" onclick="location.href='/admin/car/delete?id=${getCar.id}'">삭제</button>--%>
                    </div>
                </div>
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
</script>

<%@ include file="../../bottom.jsp" %>
