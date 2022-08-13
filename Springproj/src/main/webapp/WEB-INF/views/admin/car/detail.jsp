<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- detail.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">차량 상세 페이지</h5>
        <div class="row mt-4">
            <table class="table">
                <thead></thead>
                <tbody>
                <tr>
                    <th scope="col" class="text-center" style="width: 150px">이름</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="name" value="${getCar.name}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">코드</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="code" value="${getCar.code}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">가격</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="price" value="${getCar.price}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
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
                                      onkeydown="resize(this)" onkeyup="resize(this)" readonly>${getCar.description}</textarea>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">탑승인원</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="passenger" value="${getCar.passenger}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">트렁크 공간</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="luggage" value="${getCar.luggage}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">문</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="door" value="${getCar.door}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">트랜스미션</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="transmission" value="${getCar.transmission}" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">차량 종류</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="car_type" value=" ${getCarType.name} (${getCarType.code})" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">차량 이미지</th>
                    <td><input type="file" name="filename"
                               style="width: 100%; height: 48px; font-size: 15px; border: 1px solid #dbdbdb;
                               border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" multiple readonly></td>
                </tr>
                </tbody>
            </table>
        </div>
        <!-- 버튼 -->
        <div class="d-flex">
            <button type="button" class="btn btn-outline-dark flex-shrink-0"
                    style="margin-right: 5px" onclick="location.href='/admin/car/list'">목록</button>
            <button class="btn btn-outline-secondary flex-shrink-0" type="button"
                    style="margin-right: 5px" onclick="location.href='/admin/car/update?id=${getCar.id}'">수정</button>
            <button class="btn btn-outline-danger flex-shrink-0" type="button"
                    style="margin-right: 5px" onclick="location.href='/admin/car/delete?id=${getCar.id}'">삭제</button>
        </div>
    </div>
</section>

<script type="text/javascript">
    function resize(obj) {
        obj.style.height = '1px';
        obj.style.height = (12 + obj.scrollHeight) + 'px';
    }
</script>

<%@ include file="../../bottom.jsp" %>
