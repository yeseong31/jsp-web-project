<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- type_update.jsp -->
<%@ include file="../../top.jsp" %>

<div class="container">
  <h1 class="display-6 text-center">차종 수정</h1>
  <form name="f" action="<c:url value="/admin/car/type_update"/>" method="post" onsubmit="return checkBoard()">
    <div class="row mt-4">
      <table class="table">
        <thead></thead>
        <tbody>
        <tr>
          <th scope="col" class="text-center" style="width: 150px">이름</th>
          <th>
            <label style="width: 100%">
              <input type="text" name="name" value="${getCartype.name}"
                  style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
            </label>
          </th>
        </tr>
        <tr>
          <th scope="col" class="text-center">코드</th>
          <th>
            <label style="width: 100%">
              <input type="text" name="code" value="${getCartype.code}"
                     style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                    border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
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
                        onkeydown="resize(this)" onkeyup="resize(this)">${getCartype.description}</textarea>
            </label>
          </th>
        </tr>
        </tbody>
      </table>
    </div>
    <label>
      <input type="text" name="id" value="${getCartype.id}" hidden>
    </label>
    <button type="submit" class="btn btn-outline-secondary">수정</button>
<%--    <button type="button" name="delete_btn" class="btn btn-outline-danger"--%>
<%--            onclick="location.href='/admin/car/type_delete?id=${getCartype.id}'">삭제</button>--%>
  </form>
</div>

<!-- 유효성 검사 -->
<script type="text/javascript">
  function checkBoard(){
    if (f.description.value===""){
      alert("설명을 입력하세요")
      f.description.focus()
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