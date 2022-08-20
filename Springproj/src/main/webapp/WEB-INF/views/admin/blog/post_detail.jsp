<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- post_detail.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">게시물 상세 페이지</h5>
        <div class="row mt-4">
            <table class="table">
                <thead></thead>
                <tbody>
                <tr>
                    <th scope="col" class="text-center" style="width: 150px">번호</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="id" value="${post.id}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                  border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center" style="width: 150px">제목</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="title" value="${post.title}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                  border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center" style="width: 150px">요약문</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="hook_text" value="${post.hook_text}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                  border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center">내용</th>
                    <th>
                        <label style="width: 100%">
                            <textarea id="newTweetContent" name="content"
                                      style="width: 100%; font-size: 15px;
                                          border: 1px solid #dbdbdb; border-radius: 6px; padding: 9px 8px 7px 8px;
                                          background-color: #FAFAFA; resize: none" rows="10"
                                      onkeydown="resize(this)" onkeyup="resize(this)" readonly>${post.content}</textarea>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center" style="width: 150px">작성일</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="create_at" value="${ post.create_at.year }/${ post.create_at.monthValue }/${ post.create_at.dayOfMonth }"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                  border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center" style="width: 150px">수정일</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="update_at"
                                    <c:if test="${not empty post.update_at}">
                                        value="${ post.update_at.year }/${ post.update_at.monthValue }/${ post.update_at.dayOfMonth }"
                                    </c:if>
                                    <c:if test="${empty post.update_at}">
                                           value=""
                                    </c:if>
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                  border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>
                <tr>
                    <th scope="col" class="text-center" style="width: 150px">작성자</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="author" value="${post.author}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                  border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>                <tr>
                    <th scope="col" class="text-center" style="width: 150px">카테고리</th>
                    <th>
                        <label style="width: 100%">
                            <input type="text" name="category" value="${category.name}"
                                   style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                  border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                        </label>
                    </th>
                </tr>

                </tbody>
            </table>
        </div>
        <button type="button" class="btn btn-outline-dark"
                onclick="location.href='/admin/blog/post_list'">목록</button>
        <button type="button" class="btn btn-outline-secondary"
                onclick="location.href='/admin/blog/post_update?id=${post.id}'">수정</button>
        <button type="button" name="delete_btn" class="btn btn-outline-danger"
                onclick="location.href='/admin/blog/post_delete?id=${post.id}'">삭제</button>
    </div>
</section>

<script type="text/javascript">
    function resize(obj) {
        obj.style.height = '1px';
        obj.style.height = (12 + obj.scrollHeight) + 'px';
    }
</script>

<%@ include file="../../bottom.jsp" %>