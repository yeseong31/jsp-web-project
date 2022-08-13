<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../top.jsp" %>
<!-- reserve.jsp -->

<!-- Header-->
<header class="bg-dark py-5">
    <div class="container px-4 px-lg-5 my-5">
        <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">렌트카 서비스</h1>
            <p class="lead fw-normal text-white-50 mb-0">Spring Maven을 이용한 웹 서비스</p>
        </div>
    </div>
</header>
<!-- 차량 예약 -->
<section class="py-5">
    <div class="container" style="background-color: #f9fafb; border: 3px solid #212529; border-radius: 30px; padding: 50px 50px">
        <h5 class="display-6 fw-bolder text-center">차량 예약</h5>
        <!-- 예약일 지정 -->
        <br><p style="font-size: 20px"><b>언제 필요하세요?</b></p>
        <table class="table">
            <tbody>
            <tr>
                <th scope="col" class="text-center" style="width: 20%">대여일</th>
                <th>
                    <label style="width: 100%">
                        <input type="date" id="acceptance_date" name="acceptance_date"
                               min="2022-01-01" max="2040-12-31"
                               style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA">
                    </label>
                </th>
                <th scope="col" class="text-center" style="width: 20%">반납일</th>
                <th>
                    <label style="width: 100%">
                        <input type="date" id="return_date" name="return_date"
                               min="2022-01-01" max="2040-12-31"
                               style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA">
                    </label>
                </th>
            </tr>
            </tbody>
        </table>
        <!-- 차량 선택 -->
        <br><p style="font-size: 20px"><b>어떤 차량을 원하세요?</b></p>
        <table class="table">
            <tbody>
            <tr>
                <th scope="col" class="text-center" style="width: 20%">차량</th>
                <th>
                    <label for="name">
                    </label><select id="name" name="name"
                                    style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                            border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                    <c:forEach var="dto" items="${getCarList}">
                        <c:if test="${getCar.id eq dto.id}">
                            <option value="${dto.id}" selected>${dto.name} (${dto.code})</option>
                        </c:if>
                        <c:if test="${getCar.id ne dto.id}">
                            <option value="${dto.id}">${dto.name} (${dto.code})</option>
                        </c:if>
                    </c:forEach>
                </select>
                </th>
            </tr>
            </tbody>
        </table>
        <!-- 예약 확인 -->
        <div class="text-center">
            <a class="btn btn-outline-secondary mt-auto btn-lg" href="<c:url value="/"/>">둘러보기</a>
            <a class="btn btn-outline-dark mt-auto btn-lg" href="#">예약 확인</a>
            <a class="btn btn-outline-danger mt-auto btn-lg" href="#">빠른 예약</a>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
</footer>

<%@ include file="../bottom.jsp" %>