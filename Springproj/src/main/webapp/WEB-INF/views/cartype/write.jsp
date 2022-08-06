<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- write.jsp -->
<%@ include file="../top.jsp" %>

<div class="container">
    <h1 class="display-6 text-center">차종 등록</h1>
    <form name="f" action="cartype_write.do" method="post" onsubmit="return checkBoard()">
        <div class="row mt-4">
            <table class="table">
                <thead></thead>
                <tbody>
                    <tr>
                        <th scope="col" class="text-center">이름</th>
                        <th>
                            <label>
                                <input type="text" name="name" placeholder="이름을 입력하세요">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">코드</th>
                        <th>
                            <label>
                                <input type="text" name="code" placeholder="코드를 입력하세요">
                            </label>
                        </th>
                    </tr>
                    <tr>
                        <th scope="col" class="text-center">설명</th>
                        <th>
                            <label>
                                <input type="text" name="description" placeholder="설명을 입력하세요">
                            </label>
                        </th>
                    </tr>
                </tbody>
            </table>
        </div>
        <button type="submit" class="btn btn-outline-dark">등록</button>
    </form>
</div>

<!-- 유효성 검사 -->
<script type="text/javascript">
    function checkBoard(){
        if (f.name.value===""){
            alert("이름을 입력하세요")
            f.name.focus()
            return false;
        }
        if (f.code.value===""){
            alert("설명을 입력하세요")
            f.code.focus()
            return false;
        }
        if (f.description.value===""){
            alert("설명을 입력하세요")
            f.description.focus()
            return false;
        }
        return true;
    }
</script>

<%@ include file="../bottom.jsp" %>