<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- comment_update.jsp -->
<%@ include file="../top.jsp" %>
<!-- Main Contents -->
<div class="container my-3">
    <div class="row">
        <div class="col-md-8 col-lg-9" id="main-area">
            <h1>답글 수정</h1>
            <!-- Comments section-->
            <div id="comment-area">
                <section class="mb-5">
                    <div class="card bg-light">
                        <div class="card-body">
                            <!-- Comment form-->
                            <form method="post" class="mb-4" name="f" action="<c:url value="/blog/comment_update"/>" onsubmit="return checkBoard()">
                                <div class="form-group">
                                    <label for="content"></label>
                                    <textarea name="content" id="content" class="form-control"
                                              <c:if test="${empty userid}">disabled</c:if>
                                              placeholder="답글을 남겨 주세요!" style="resize: none"
                                              onkeydown="resize(this)" onkeyup="resize(this)">${comment.content}</textarea>
                                </div><br>
                                <label><input name="id" value="${comment.id}" hidden></label>
                                <label><input name="post" value="${comment.post}" hidden></label>
                                <label><input name="author" value="${userid}" hidden></label>
                                <input type="submit" value="답글 수정" class="register btn btn-outline-dark">
                                <a href="<c:url value="/blog"/>" class="btn btn-outline-secondary">목록</a>
                            </form>
                        </div>
                    </div>
                </section>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function checkBoard() {
        if (f.content.disabled===true) {
            alert('로그인 후 이용해 주세요.');
            location.href='/common/sign_in';
            return false;
        }
        else if (f.content.value===""){
            alert("답글 내용을 입력해 주세요.")
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
<%@ include file="../bottom.jsp" %>