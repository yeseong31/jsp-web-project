<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- list.jsp -->
<%@ include file="../top.jsp" %>

<!-- Header-->
<%@ include file="../header.jsp" %>
<!-- Section-->
<section class="py-5">
    <div class="container">
        <!-- 차량 목록 -->
        <div class="container px-4 px-lg-5 mt-5">
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
                                       href="<c:url value="/car/rent?id=${dto.id}"/>">예약하기</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <!-- ※※※ Sample Card ※※※ -->
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Sale badge-->
                        <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                        <!-- Product image-->
                        <img class="card-img-top" src="https://picsum.photos/450/300" alt="..." />
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">※ Sample Card ※</h5>
                                <!-- Product reviews-->
                                <div class="d-flex justify-content-center small text-warning mb-2">
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                </div>
                                <!-- Product price-->
                                <span class="text-muted text-decoration-line-through">$20.00</span>
                                $18.00
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center">
                                <a class="btn btn-outline-dark mt-auto btn-sm" href="#">옵션 보기</a>
                                <a class="btn btn-outline-primary mt-auto btn-sm" href="#">예약하기</a>
                            </div>
                        </div>
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