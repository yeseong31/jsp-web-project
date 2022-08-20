<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- post_update.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">게시물 수정 페이지</h5>
        <form name="f" action="<c:url value="/admin/blog/post_update"/>" method="post" onsubmit="return checkBoard()">
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
                                          border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                                </label>
                            </th>
                        </tr>
                        <tr>
                            <th scope="col" class="text-center" style="width: 150px">요약문</th>
                            <th>
                                <label style="width: 100%">
                                    <input type="text" name="hook_text" value="${post.hook_text}"
                                           style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                          border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
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
                                              onkeydown="resize(this)" onkeyup="resize(this)">${post.content}</textarea>
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
                                <label for="category">
                                </label><select id="category" name="category" style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                                border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                                <c:forEach var="cate" items="${categories}">
                                    <option value="${cate.id}"
                                        <c:if test="${cate.id eq post.category}">selected</c:if>
                                    >${cate.name}</option>
                                </c:forEach>
                            </select>
                            </th>
                        </tr>
                    </tbody>
                </table>
            </div>
            <button type="submit" class="btn btn-outline-secondary">수정</button>
            <button type="button" name="delete_btn" class="btn btn-outline-danger"
                    onclick="location.href='/admin/blog/post_delete?id=${post.id}'">삭제</button>
        </form>
    </div>
</section>

<script type="text/javascript">
    function checkBoard(){
        if (f.title.value===""){
            alert("제목을 입력하세요")
            f.title.focus()
            return false;
        }
        if (f.hook_text.value===""){
            alert("요약문을 입력하세요")
            f.hook_text.focus()
            return false;
        }
        if (f.content.value===""){
            alert("내용을 입력하세요")
            f.content.focus()
            return false;
        }
        if (f.category.value===""){
            alert("카테고리를 입력하세요")
            f.category.focus()
            return false;
        }
        return true;
    }

    function resize(obj) {
        obj.style.height = '1px';
        obj.style.height = (12 + obj.scrollHeight) + 'px';
    }
</script>

<%@ include file="../../bottom.jsp" %>