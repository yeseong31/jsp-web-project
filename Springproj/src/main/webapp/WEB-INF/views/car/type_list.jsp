<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- type_list.jsp -->
<%@ include file="../top.jsp" %>

<!-- Header-->
<%@ include file="../header.jsp" %>
<!-- Section-->
<section class="py-5">
    <h5 class="display-6 fw-bolder text-center">차량 종류</h5>
    <div class="container px-4 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <!-- Car List -->
            <c:if test="${empty getCarTypeList}">
                <h2>현재 등록된 차량이 없습니다.</h2>
            </c:if>
            <c:forEach var="dto" items="${getCarTypeList}">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" src="https://picsum.photos/seed/${dto.id}/450/300" alt="..." />
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">${dto.name}</h5>
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center">
                                <a class="btn btn-outline-dark mt-auto btn-sm" href="<c:url value="/car/type_detail?id=${dto.id}"/>">옵션 보기</a>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
</footer>


<%@ include file="../bottom.jsp" %>