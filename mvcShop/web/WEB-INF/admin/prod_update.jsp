<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- prod_update.jsp -->
<%@ include file="top.jsp" %>
<div align="center">
    <form name="f" action="prod_update_ok.mall" method="post" onsubmit="return checkInput()"
          enctype="multipart/form-data">
        <table style="width: 600px; border-top: blue 3px double; border-bottom: blue 3px double">
            <caption>상 품 수 정</caption>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">카테고리</th>
                <th align="left">
                    <label><input type="text" placeholder="${dto.pcategory_fk}"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품번호</th>
                <th align="left"><b>${dto.pnum}</b></th>
                <label>
                    <input type="text" name="num" value="${dto.pnum}" hidden>
                </label>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품명</th>
                <th align="left">
                    <label><input type="text" id="name" name="name" placeholder="상품명" value="${dto.pname}"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">제조회사</th>
                <th align="left">
                    <label><input type="text" name="company" placeholder="제조회사" value="${dto.pcompany}"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품이미지</th>
                <th align="left">
                    <img src="${upPath}${dto.pimage}" style="width: 100px; height: 100px" alt="image">
                    <input type="file" name="filename">
                    <input type="image" name="filename2" value="${dto.pimage}" hidden>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품수량</th>
                <th align="left">
                    <label><input type="text" name="qty" placeholder="상품수량" value="${dto.pqty}"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품가격</th>
                <th align="left">
                    <label><input type="text" name="price" placeholder="상품가격" value="${dto.price}"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품스펙</th>
                <th align="left">
                    <label for="specs"></label>
                    <select id="specs" name="specs" style="width: 150px;">
                        <c:forTokens items="none, HIT, NEW, BEST" delims="," var="pspec">
                            <c:if test="${dto.pspec == pspec}">
                                <option value="${pspec}" selected>${pspec}</option>
                            </c:if>
                            <c:if test="${dto.pspec != pspec}">
                                <option value="${pspec}">${pspec}</option>
                            </c:if>
                        </c:forTokens>
                    </select>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품소개</th>
                <th align="left">
                    <label><textarea style="width: 400px; resize: none" name="content" rows="5">${dto.pcontents}</textarea></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품포인트</th>
                <th align="left">
                    <label><input type="text" name="point" placeholder="상품포인트" value="${dto.point}"></label>
                </th>
            </tr>
            <tr>
                <td colspan="2" style="background-color: #eaefe8">
                    <input type="submit" value="상품수정">
                    <input type="button" value="취소" onClick="location.href='prod_list.mall';">
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    function checkInput(){
        if (f.name.value===""){
            alert("상품명을 입력하세요")
            f.name.focus()
            return false;
        }
        if (f.code.value===""){
            alert("상품코드를 입력하세요")
            f.code.focus()
            return false;
        }
        if (f.company.value===""){
            alert("제조회사를 입력하세요")
            f.company.focus()
            return false;
        }
        if (f.filename.value===""){
            alert("상품이미지를 입력하세요")
            f.img.focus()
            return false;
        }
        if (f.qty.value===""){
            alert("상품수량을 입력하세요")
            f.qty.focus()
            return false;
        }
        if (f.price.value===""){
            alert("상품가격을 입력하세요")
            f.price.focus()
            return false;
        }
        if (f.content.value===""){
            alert("상품소개를 입력하세요")
            f.content.focus()
            return false;
        }
        if (f.point.value===""){
            alert("상품포인트를 입력하세요")
            f.point.focus()
            return false;
        }
        return true;
    }
</script>
<%@ include file="bottom.jsp" %>
