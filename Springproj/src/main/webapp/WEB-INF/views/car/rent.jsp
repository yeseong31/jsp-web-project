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
                        <label for="car_id">
                        </label><select id="car_id" name="car_id"
                                        style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                                border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                        <c:if test="${empty getCar}">
                            <option value="" selected>---</option>
                        </c:if>
                        <c:if test="${not empty getCarList}">
                            <c:forEach var="dto" items="${getCarList}">
                                <c:if test="${getCar.id eq dto.id}">
                                    <option value="${dto.id}" selected>${dto.name} (${dto.code})</option>
                                </c:if>
                                <c:if test="${getCar.id ne dto.id}">
                                    <option value="${dto.id}">${dto.name} (${dto.code})</option>
                                </c:if>
                            </c:forEach>
                        </c:if>
                    </select>
                    </th>
                </tr>
                </tbody>
            </table>
            <!-- 예약 확인 -->
            <div class="text-center">
                <a class="btn btn-outline-secondary mt-auto btn-lg" href="<c:url value="/"/>">둘러보기</a>
                <a class="btn btn-outline-dark mt-auto btn-lg" href="#">예약 확인</a>
                <button class="btn btn-outline-danger mt-auto btn-lg" type="submit">빠른 예약</button>
            </div>
        </form>
    </div>
</section>
<!-- Footer-->
<footer class="py-5 bg-dark">
    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2022</p></div>
</footer>

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
        if (f.car_id.value===""){
            alert("대여할 차량을 선택하세요")
            f.car_id.focus()
            return false;
        }
        return true;
    }

    const acceptance_date = document.getElementById("acceptance_date");
    const return_date = document.getElementById("return_date");
    acceptance_date.min = new Date().toISOString().substring(0, 10);
    return_date.min = new Date().toISOString().substring(0, 10);

    function setReturnDate() {
        return_date.min = acceptance_date.value;
    }
</script>

<%@ include file="../bottom.jsp" %>