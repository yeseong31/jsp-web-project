<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../top.jsp" %>
<!-- rent.jsp -->

<!-- Header-->
<%@ include file="../header.jsp" %>
<!-- 차량 예약 -->
<section class="py-5">
    <div class="container" style="background-color: #f9fafb; border: 3px solid #212529; border-radius: 30px; padding: 50px 50px">
        <h5 class="display-6 fw-bolder text-center">차량 예약</h5>
        <!-- 예약일 지정 -->
        <form name="f" method="post" action="<c:url value="/car/rent"/>" onsubmit="return checkBoard()">
            <br><p style="font-size: 20px"><b>언제 필요하세요?</b></p>
            <table class="table">
                <tbody>
                <tr>
                    <th scope="col" class="text-center" style="width: 20%">대여일</th>
                    <th>
                        <label style="width: 100%">
                            <input type="date" id="acceptance_date" name="acceptance_date" max="2040-12-31" value=""
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA">
                        </label>
                    </th>
                    <th scope="col" class="text-center" style="width: 20%">반납일</th>
                    <th>
                        <label style="width: 100%">
                            <input type="date" id="return_date" name="return_date" max="2040-12-31" value=""
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA" onclick="setReturnDate()">
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
                        <label style="width: 100%">
                        <input type="text" id="test" name="test" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA" disabled
                                <c:if test="${empty getCar}">
                                    value="" placeholder="'차량 둘러보기'로 차량을 먼저 선택해 주세요!"></label>
                                    <label><input name="car_num_id" value="" hidden></label>
                                </c:if>
                                <c:if test="${not empty getCar}">
                                    value="${getCar.name} - ${getCarNum.num}"></label>
                                    <label><input name="car_num_id" value="${getCarNum.id}" hidden></label>
                                </c:if>
                    </th>
                </tr>
                </tbody>
            </table>
            <!-- 예약 확인 -->
            <div class="text-center">
                <a class="btn btn-outline-secondary mt-auto btn-lg" href="<c:url value="/"/>">차량 둘러보기</a>
                <a class="btn btn-outline-dark mt-auto btn-lg" href="<c:url value="/car/rent/check"/>">내 예약 확인</a>
                <button class="btn btn-outline-danger mt-auto btn-lg" type="submit">예약 진행</button>
            </div>
        </form>
    </div>
</section>
<!-- Footer-->
<%@ include file="../footer.jsp" %>

<script type="text/javascript">
    function checkBoard(){
        if (f.acceptance_date.value===""){
            alert("대여일을 선택하세요")
            f.acceptance_date.focus()
            return false;
        }
        if (f.return_date.value===""){
            alert("반납일을 선택하세요")
            f.return_date.focus()
            return false;
        }
        if (f.car_num_id.value===""){
            alert("대여할 차량을 선택하세요")
            f.car_num_id.focus()
            return false;
        }
        return true;
    }
    (function() {
        let target_date = new Date().toISOString().substring(0, 10);
        document.getElementById("acceptance_date").value = target_date;
        document.getElementById("acceptance_date").min = target_date;
        document.getElementById("return_date").value = target_date;
        document.getElementById("return_date").min = target_date;
    })();
    function setReturnDate() {
        document.getElementById("return_date").min = document.getElementById("acceptance_date").value;
    }
</script>

<%@ include file="../bottom.jsp" %>