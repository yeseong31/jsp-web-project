<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- comment_update.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">답변 수정 페이지</h5>
        <form name="f" action="<c:url value="/admin/blog/comment_update"/>" method="post" onsubmit="return checkBoard()">
            <div class="row mt-4">
                <table class="table">
                    <thead></thead>
                    <tbody>
                    <tr>
                        <th scope="col" class="text-center" style="width: 150px">번호</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="id" value="${comment.id}"
                                       style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                      border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center" style="width: 150px">질문</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="post" value="${comment.post}"
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
                                          onkeydown="resize(this)" onkeyup="resize(this)">${comment.content}</textarea>
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center" style="width: 150px">작성자</th>
                        <th>
                            <label style="width: 100%">
                                <input type="text" name="author" value="${comment.author}"
                                       style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                      border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;" readonly>
                            </label>
                        </th>
                    </tr>
                    </tbody>
                </table>
            </div>
            <button type="submit" class="btn btn-outline-secondary">수정</button>
            <button type="button" name="delete_btn" class="btn btn-outline-danger"
                    onclick="location.href='/admin/blog/comment_delete?id=${comment.id}'">삭제</button>
        </form>
    </div>
</section>

<script type="text/javascript">
    function checkBoard(){
        if (f.content.value===""){
            alert("내용을 입력하세요")
            f.content.focus()
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