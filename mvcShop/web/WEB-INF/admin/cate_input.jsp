<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!-- cate_input.jsp -->
<%@ include file="top.jsp" %>
<div align="center">
    <div>
        <h3>카테고리 등록</h3>
        <form name="f" action="cate_input_ok.mall" method="post" onsubmit="return checkInput()">
            <table style="border: black 1px solid; width: 300px">
                <tr>
                    <th style="background-color: yellow; border: #a9a9a9 1px solid">카테고리 코드</th>
                    <td>
                        <label>
                            <input type="text" id="code" name="code" placeholder="카테고리 코드">
                        </label>
                    </td>
                </tr>
                <tr>
                    <th style="background-color: yellow; border: #a9a9a9 1px solid">카테고리 이름</th>
                    <td>
                        <label>
                            <input type="text" id="cname" name="cname" placeholder="카테고리 이름">
                        </label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center" style="background-color: #ffcc00">
                        <input type="submit" value="등록">
                        <input type="reset" value="취소">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<script type="text/javascript">
    function checkInput(){
        if (f.code.value===""){
            alert("카테고리 코드를 입력하세요")
            f.code.focus()
            return false;
        }
        if (f.cname.value===""){
            alert("카테고리 이름을 입력하세요")
            f.cname.focus()
            return false;
        }
        return true;
    }
</script>
<%@ include file="bottom.jsp" %>
