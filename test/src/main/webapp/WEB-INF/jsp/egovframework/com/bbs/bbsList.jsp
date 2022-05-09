<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>mariaDB 연동확인</h1>
<table style="border: 1px solid;">
        <tr>
            <th>아이디</th>
            <th>비번</th>
            <th>주소</th>
            <th>가입일</th>
        </tr>

   
        <c:forEach items="${list}" var="result">
            <tr>
                <th>${result.id}</th>
                <th>${result.pw}</th>
                <th>${result.zipcode}</th>
                <th>${result.regdate}</th>

            </tr>
        </c:forEach>

</table>

</body>
</html>