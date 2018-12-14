<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<th>보낸사람</th>
			<th>시간</th>
			<th>내용</th>
		</tr>
		<tr>
			<td>${dto.n_sender}</td>
			<td>${dto.n_time}</td>
			<td>${dto.n_content}</td>
		</tr>
	</table>
	<a href="getMessageList.do?n_receiver=test">뒤로</a>
</body>
</html>