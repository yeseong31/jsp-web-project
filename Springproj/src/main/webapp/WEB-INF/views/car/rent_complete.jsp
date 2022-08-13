<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../top.jsp" %>
<!-- rent_complete.jsp -->

<!-- Header-->
<%@ include file="../header.jsp" %>
<!-- 차량 예약 -->
<section class="py-5">
    <div class="container" style="background-color: #f9fafb; border: 3px solid #212529; border-radius: 30px; padding: 50px 50px">
        <h5 class="display-6 fw-bolder text-center">차량 예약 확인</h5><br>
        <table class="table">
            <tbody>
            <tr>
                <th scope="col" class="text-center" style="width: 20%">아이디</th>
                <th colspan="3">
                    <label style="width: 100%">
                        <input type="text" value="${member}" readonly
                               style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA">
                    </label>
                </th>
            </tr>
            <tr>
                <th scope="col" class="text-center" style="width: 20%">예약번호</th>
                <th colspan="3">
                    <label style="width: 100%">
                        <input type="text" value="${rent.id}" readonly
                               style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA">
                    </label>
                </th>
            </tr>
            <tr>
                <th scope="col" class="text-center" style="width: 20%">차량</th>
                <th colspan="3">
                    <label style="width: 100%">
                        <input type="text" value="${car.name}" readonly
                               style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA">
                    </label>
                </th>
            </tr>
            <tr>
                <th scope="col" class="text-center" style="width: 20%">대여일</th>
                <th>
                    <label style="width: 100%">
                        <input type="date" value="${rent.return_date}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                            border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA" readonly>
                    </label>
                </th>
                <th scope="col" class="text-center" style="width: 20%">반납일</th>
                <th>
                    <label style="width: 100%">
                        <input type="date" value="${rent.return_date}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                            border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA" readonly>
                    </label>
                </th>
            </tr>
            </tbody>
        </table>
        <!-- 예약 확인 -->
        <div class="text-center">
            <a class="btn btn-outline-dark mt-auto btn-lg" href="#">출력</a>
            <a class="btn btn-outline-dark mt-auto btn-lg" href="#">반납 완료 신청</a>
        </div>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
</footer>

<%@ include file="../bottom.jsp" %>