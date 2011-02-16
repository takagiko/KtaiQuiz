<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GMT">
<title>KtaiQuiz 結果発表</title>
<style type="text/css">
<!--
td { font-size: 200% }
th { font-size: 200% }
-->
</style>
</head>
<body>
<h2>KtaiQuiz 結果発表</h2>
<p>
<table border="1">
	<tr bgcolor="lightgray">
		<th>順位</th>
		<th>名前</th>
		<th>得点</th>
		<th>平均時間</th>
	</tr>
<c:forEach items="${result}" var="user" varStatus="status" >
	<tr>
		<td>${status.count}</td>
		<td class="cls${fn:length(result) - status.index}" style="background-color: black; ">${user.name}</td>
		<td class="cls${fn:length(result) - status.index}" style="background-color: black;">${user.score}</td>
		<td class="cls${fn:length(result) - status.index}" style="background-color: black;">${user.avgTime / 1000}秒</td>
		<td><button onclick="javascript:$('.cls${fn:length(result) - status.index}').css('background', 'white')">オープン</button></td>
	</tr>
</c:forEach>
</table>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
</body>
</html>