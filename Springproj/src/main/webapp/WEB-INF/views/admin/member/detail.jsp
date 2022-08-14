<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- detail.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">사용자 상세 페이지</h5>
        <div class="row mt-4">
            <table class="table">
                <thead></thead>
                <tbody>
                <tr>
                    <th scope="col" class="text-center" style="width: 150px">아이디</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="userid" value="${dto.userid}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">이름</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="username" value="${dto.username}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">이메일</th>
                    <th>
                        <label style="width: 100%">
                            <input type="email" name="email" value="${dto.email}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">전화번호</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="phone" value="${dto.phone}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">비밀번호</th>
                    <th>
                        <label style="width: 100%">
                            <input type="password" name="password"  value="${dto.password}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly disabled>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">관리자 유무</th>
                    <th>
                        <label style="width: 100%">
                            <input id="is_admin" name="is_admin" value="1" hidden>
                            <input type="checkbox" id="checkbox" name="checkbox" checked disabled>
                        </label>
                    </th>
                </tr>
                </tbody>
            </table>
        </div>
        <!-- 버튼 -->
        <div class="d-flex">
            <button type="button" class="btn btn-outline-dark flex-shrink-0"
                    style="margin-right: 5px" onclick="location.href='/admin/member/list'">목록</button>
            <button class="btn btn-outline-danger flex-shrink-0" type="button"
                    style="margin-right: 5px" onclick="location.href='/admin/member/delete?userid=${dto.userid}'">삭제</button>
        </div>
    </div>
</section>

<%@ include file="../../bottom.jsp" %>