<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<style type="text/css">
	{box-sizing: border-box;}

/* Button used to open the contact form - fixed at the bottom of the page */
.open-button {
  background-color: #555;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  opacity: 0.8;
  position: fixed;
  bottom: 23px;
  right: 28px;
  width: 280px;
}

/* The popup form - hidden by default */
.form-popup {
  display: none;
  position: fixed;
  bottom: 0;
  right: 15px;
  border: 3px solid #f1f1f1;
  z-index: 9;
}

/* Add styles to the form container */
.form-container {
  max-width: 300px;
  padding: 10px;
  background-color: white;
}

/* Full-width input fields */
.form-container input[type=text], .form-container input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

/* When the inputs get focus, do something */
.form-container input[type=text]:focus, .form-container input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Set a style for the submit/login button */
.form-container .btn {
  background-color: #4CAF50;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  margin-bottom:10px;
  opacity: 0.8;
}

/* Add a red background color to the cancel button */
.form-container .cancel {
  background-color: red;
}

/* Add some hover effects to buttons */
.form-container .btn:hover, .open-button:hover {
  opacity: 1;
}
	
</style>

<!-- popup form -->
<script type="text/javascript">
	function openForm() {
	  document.getElementById("myForm").style.display = "block";
	}
	
	function closeForm() {
	  document.getElementById("myForm").style.display = "none";
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<table border="0">
		<tr>
			<th>쪽지번호</th>
			<th>수신자</th>
			<th>발신자</th>
			<th>쪽지날짜</th>
			<th>내용</th>
			<th>쪽지코드</th>
		</tr>
	<c:choose>
		<c:when test="${empty list}">
			<tr><td colspan="6">---작성된 글이 없습니다.---</td></tr>
		</c:when>
		<c:otherwise>
			<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.n_seq}</td>
				<td>${dto.n_receiver}</td>
				<td>${dto.n_sender}</td>
				<td>${dto.n_time}</td>
				<td><a href="getMessage.do?n_seq=${dto.n_seq}">${dto.n_content}</a></td>
				<td>${dto.ns_state_code}</td>
				<td> <a href="deleteMessage.do?n_seq=${dto.n_seq}&n_receiver=test">삭제</a></td>		
			</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>

</table>

</body>
</html>