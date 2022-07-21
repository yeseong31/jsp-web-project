<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- prod_input.jsp -->
<%@ include file="top.jsp" %>
<div align="center">
    <form name="f" action="prod_input_ok.mall" method="post" onsubmit="return checkInput()">
        <table style="width: 600px; border-top: blue 3px double; border-bottom: blue 3px double">
            <caption>상 품 등 록 카 테 고 리</caption>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">카테고리</th>
                <th align="left">
                    <label for="categories"></label>
                    <select id="categories" style="width: 150px;">
                        <option value="CPU">CPU (1001)</option>
                        <option value="Moniter">Moniter (1002)</option>
                        <option value="GPU">GPU (1003)</option>
                    </select>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품명</th>
                <th align="left">
                    <label><input id="name" name="name" placeholder="상품명"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품코드</th>
                <th align="left">
                    <label><input name="code" name="code" placeholder="상품코드"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">제조회사</th>
                <th align="left">
                    <label><input name="company" placeholder="제조회사"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품이미지</th>
                <th align="left">
                    <input type="file" name="img">
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품수량</th>
                <th align="left">
                    <label><input name="quantity" placeholder="상품수량"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품가격</th>
                <th align="left">
                    <label><input name="price" placeholder="상품가격"></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품스펙</th>
                <th align="left">
                    <label for="specs"></label>
                    <select id="specs" style="width: 150px;">
                        <option value="NORMAL">::NORMAL::</option>
                    </select>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품소개</th>
                <th align="left">
                    <label><textarea style="width: 400px; resize: none" name="content" rows="5" ></textarea></label>
                </th>
            </tr>
            <tr>
                <th style="background-color: #ffcc00; width: 100px">상품포인트</th>
                <th align="left">
                    <label><input name="point" placeholder="상품포인트"></label>
                </th>
            </tr>
            <tr>
                <td colspan="2" style="background-color: #eaefe8">
                    <input type="submit" value="상품등록">
                    <input type="reset" value="취소">
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
        if (f.img.value===""){
            alert("상품이미지를 입력하세요")
            f.img.focus()
            return false;
        }
        if (f.quantity.value===""){
            alert("상품수량을 입력하세요")
            f.quantity.focus()
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
