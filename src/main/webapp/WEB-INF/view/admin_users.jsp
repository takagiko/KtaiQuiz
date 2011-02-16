<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GMT">
<title>KtaiQuiz ログインユーザ一覧</title>
</head>
<body>
<h2>KtaiQuiz ログインユーザ一覧</h2>
<p>
<table border="1">
	<tr bgcolor="lightgray">
		<th>連番</th>
		<th>ユーザID</th>
		<th>名前</th>
	</tr>
<c:forEach items="${idList}" var="id" varStatus="status" >
	<tr>
		<td>No.${status.count}</td>
		<td>${id}</td>
		<td>${nameList[status.index]}</td>
	</tr>
</c:forEach>
</table>
</html>