<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- update.jsp -->
<%@ include file="../top.jsp" %>

<div class="container">
  <h1 class="display-6 text-center">차종 수정</h1>
  <form name="f" action="cartype_update.do" method="post" onsubmit="return checkBoard()">
    <div class="row mt-4">
      <table class="table">
        <thead></thead>
        <tbody>
        <tr>
          <th scope="col" class="text-center">이름</th>
          <th>
            <label>
              <input type="text" name="name" value="${getCartype.name}" disabled>
            </label>
          </th>
        </tr>
        <tr>
          <th scope="col" class="text-center">코드</th>
          <th>
            <label>
              <input type="text" name="code" value="${getCartype.code}" disabled>
            </label>
          </th>
        </tr>
        <tr>
          <th scope="col" class="text-center">설명</th>
          <th>
            <label>
              <input type="text" name="description" value="${getCartype.description}">
            </label>
          </th>
        </tr>
        </tbody>
      </table>
    </div>
    <label>
      <input type="text" name="id" value="${getCartype.id}" hidden>
    </label>
    <button type="submit" class="btn btn-outline-dark">수정</button>
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
</script>

<%@ include file="../bottom.jsp" %>