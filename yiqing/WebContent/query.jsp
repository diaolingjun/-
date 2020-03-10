<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <!--         这个用来选择日期 -->
    <div align="center">
    <form action="QueryServlet" target="show" method="post">
          按日期查询<input type="datetime" name="Date">
          <input type="submit" value="查询">
    </form>
    </div>
</body>
</html>