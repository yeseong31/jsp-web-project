<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- type_write.jsp -->
<%@ include file="../../top.jsp" %>

<section class="py-5">
    <div class="container">
        <h5 class="display-6 fw-bolder text-center">차량 종류 등록 페이지</h5>
        <form name="f" action="<c:url value="/admin/car/type_write"/>" method="post" onsubmit="return checkBoard()">
            <div class="row mt-4">
                <table class="table">
                    <thead></thead>
                    <tbody>
                        <tr>
                            <th scope="col" class="text-center" style="width: 150px">이름</th>
                            <th>
                                <label style="width: 100%">
                                    <input type="text" name="name" placeholder="이름을 입력하세요"
                                           style="width: 100%; height: 36px; font-size: 15px; border: 1px solid #dbdbdb;
                                        border-radius: 6px; padding: 9px 0 7px 8px; background-color: #FAFAFA;">
                                </label>
                            </th>
                        </tr>
                        <tr>
                            <th scope="col" class="text-center">코드</th>
                            <th>
                                <label style="width: 100%">
                                    <input type="text" name="code" placeholder="코드를 입력하세요"
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
                                                background-color: #FAFAFA; resize: none"
                                            onkeydown="resize(this)" onkeyup="resize(this)"></textarea>
                                </label>
                            </th>
                        </tr>
                    </tbody>
                </table>
            </div>
            <button type="submit" class="btn btn-outline-dark">등록</button>
        </form>
    </div>
</section>

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

    function resize(obj) {
        obj.style.height = '1px';
        obj.style.height = (12 + obj.scrollHeight) + 'px';
    }
</script>

<%@ include file="../../bottom.jsp" %>