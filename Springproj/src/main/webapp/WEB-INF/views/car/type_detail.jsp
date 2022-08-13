<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- type_detail.jsp -->
<%@ include file="../top.jsp" %>

<!-- Product section-->
<section class="py-5" style="background-color: #f8f9fa">
    <div class="container px-4 px-lg-5 my-5">
        <div class="row gx-4 gx-lg-5 align-items-center">
            <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="https://picsum.photos/seed/${getCarType.id}/600/700" alt="product_image" /></div>
            <div class="col-md-6">
                <!-- 상품코드 -->
                <div class="small mb-1">차량 종류: ${getCarType.code}</div>
                <!-- 상품이름 -->
                <h1 class="display-5 fw-bolder">${getCarType.name}</h1>
                <!-- 상품설명 -->
                <p class="lead">${getCarType.description}</p>
                <!-- 버튼 -->
                <div class="d-flex">
                    <button class="btn btn-outline-dark flex-shrink-0" type="button"
                            style="margin-right: 5px" onclick="location.href='/car/type_list'">목록으로 돌아가기</button>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Related items section -->
<section class="py-5 bg-light">
    <div class="container px-4 px-lg-5 mt-5">
        <h2 class="fw-bolder mb-4">차량</h2>
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">

            <!-- Car List -->
            <c:if test="${empty getCarList}">
                <h2>현재 등록된 차량이 없습니다.</h2>
            </c:if>
            <c:forEach var="dto" items="${getCarList}">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" src="https://picsum.photos/seed/${dto.id}/450/300" alt="..." />
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${dto.name}</h5>
                                <!-- Product price-->
                                    ${dto.price}원
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center">
                                <a class="btn btn-outline-dark mt-auto btn-sm"
                                   href="<c:url value="/car/detail?id=${dto.id}"/>">옵션 보기</a>
                                <a class="btn btn-outline-primary mt-auto btn-sm"
                                   href="<c:url value="/car/reserve?id=${dto.id}"/>">예약하기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

            <!-- Sample Card -->
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Sale badge-->
                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                    <!-- Product image-->
                    <img class="card-img-top" src="https://picsum.photos/seed/123/450/300" alt="..." />
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">Sale Item</h5>
                            <!-- Product price-->
                            <span class="text-muted text-decoration-line-through">$50.00</span>
                            $25.00
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
</footer>

<%@ include file="../bottom.jsp" %>
