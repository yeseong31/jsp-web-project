<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- type_detail.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">차량 종류 상세 페이지</h5>
        <div class="row mt-4">
            <table class="table">
                <thead></thead>
                <tbody>
                <tr>
                    <th scope="col" class="text-center" style="width: 150px">이름</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="name" value="${getCarType.name}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                  border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">코드</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="code" value="${getCarType.code}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                  border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">설명</th>
                    <th>
                        <label style="width: 100%">
                            <textarea id="newTweetContent" name="description"
                                      style="width: 100%; font-size: 15px;
                                          border: 1px solid #dbdbdb; border-radius: 6px; padding: 9px 8px 7px 8px;
                                          background-color: #FAFAFA; resize: none" rows="10"
                                      onkeydown="resize(this)" onkeyup="resize(this)" readonly>${getCarType.description}</textarea>
                        </label>
                    </th>
                </tr>
                </tbody>
            </table>
        </div>
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='/admin/car/type_list'">목록</button>
        <button type="button" class="btn btn-outline-secondary"
                onclick="location.href='/admin/car/type_update?id=${getCarType.id}'">수정</button>
        <button type="button" name="delete_btn" class="btn btn-outline-danger"
                onclick="location.href='/admin/car/type_delete?id=${getCarType.id}'">삭제</button>
    </div>
</section>

<script type="text/javascript">
    function resize(obj) {
        obj.style.height = '1px';
        obj.style.height = (12 + obj.scrollHeight) + 'px';
    }
</script>

<%@ include file="../../bottom.jsp" %>