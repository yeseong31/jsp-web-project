<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- prod_view.jsp -->
<%@ include file="top.jsp" %>
<%@ include file="left.jsp" %>
<div style="float: right; width: 700px;">
    <div style="height: 90%; margin: 20px 0; border-top: darkblue 3px double; border-bottom: darkblue 2px double">
        <div style="background-color: lightcyan">
            <h3 style="margin: 0; color: green">[${dto.pname}] 상품 정보</h3>
        </div>
        <div style="height: 45%; padding: 20px">
            <div style="margin-top: 20px; float: left; width: 40%">
                <img src="${upPath}${dto.pimage}" alt="image">
            </div>
            <div style="float: right; width: 60%">
                <table style="margin-top: 20px; width: 70%">
                    <tr>
                        <td style="width: 100px">상품번호</td>
                        <td>${dto.pnum}</td>
                    </tr>
                    <tr>
                        <td style="width: 100px">상품이름</td>
                        <td>${dto.pname}</td>
                    </tr>
                    <tr>
                        <td style="width: 100px">상품가격</td>
                        <td>${dto.price}</td>
                    </tr>
                    <tr>
                        <td style="width: 100px">상품포인트</td>
                        <td>${dto.point} point</td>
                    </tr>
                    <tr>
                        <td style="width: 100px">상품개수</td>
                        <td>${dto.pqty} 개</td>
                    </tr>
                    <tr>
                        <td style="width: 50%">
                            <input type="button" value="장바구니 담기">
                        </td>
                        <td style="width: 50%">
                            <input type="button" value="즉시 구매하기">
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div style="padding: 30px 20px 0 40px; height: auto; text-align: left; border-top: darkblue 3px dashed">
            <div>
                <b>상품 상세 설명</b>
            </div>
            <div>
                ${dto.pcontents}
            </div>
        </div>
    </div>
</div>
<%@ include file="bottom.jsp" %>