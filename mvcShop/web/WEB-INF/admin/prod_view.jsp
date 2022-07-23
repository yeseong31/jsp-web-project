<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- prod_view.jsp -->
<%@ include file="top.jsp" %>
<div align="center">
    <table style="width: 600px; border-top: blue 3px double; border-bottom: blue 3px double">
        <caption>상 품 상 세 보 기</caption>
        <tr>
            <th style="width: 100px; background-color: #ffcc00">카테고리</th>
            <td style="width: 200px;text-align: left; padding-left: 8px">${dto.pcategory_fk}</td>
            <th style="width: 100px; background-color: #ffcc00">상품번호</th>
            <td style="width: 200px;text-align: left; padding-left: 8px">${dto.pnum}</td>
        </tr>
        <tr>
            <th style="width: 100px; background-color: #ffcc00">상품명</th>
            <td style="width: 200px;text-align: left; padding-left: 8px">${dto.pname}</td>
            <th style="width: 100px; background-color: #ffcc00">제조회사</th>
            <td style="width: 200px;text-align: left; padding-left: 8px">${dto.pcompany}</td>
        </tr>
        <tr>
            <th style="width: 100px; background-color: #ffcc00">상품이미지</th>
            <th style="width: 100px; height: 100px">
                <img src="${upPath}${dto.pimage}" style="width: 100px; height: 100px" alt="image">
            </th>
        </tr>
        <tr>
            <th style="width: 100px; background-color: #ffcc00">상품수량</th>
            <td style="width: 200px;text-align: left; padding-left: 8px">${dto.pqty}</td>
            <th style="width: 100px; background-color: #ffcc00">상품가격</th>
            <td style="width: 200px;text-align: left; padding-left: 8px">${dto.price}</td>
        </tr>
        <tr>
            <th style="width: 100px; background-color: #ffcc00">상품스펙</th>
            <td style="width: 200px;text-align: left; padding-left: 8px">${dto.pspec}</td>
            <th style="width: 100px; background-color: #ffcc00">상품포인트</th>
            <td style="width: 200px;text-align: left; padding-left: 8px">${dto.point}</td>
        </tr>
        <tr>
            <th style="width: 100px; background-color: #ffcc00">상품소개</th>
            <td colspan="3" style="width: 500px; text-align: left; padding: 8px">
                <label>
                    <textarea style="width: 400px; resize: none" name="content" disabled>${dto.pcontents}</textarea>
                </label>
            </td>
        </tr>
        <tr>
            <td colspan="4" style="text-align: center; background-color: #eaefe8">
                <input type="button" value="돌아가기" onClick="location.href='prod_list.mall';">
            </td>
        </tr>
    </table>
</div>
<%@ include file="bottom.jsp" %>
