<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GMT">
<title>KtaiQuiz コントロールパネル</title>
</head>
<body>
<h2>KtaiQuiz コントロールパネル</h2>
<p>
	現在  
<c:choose>
	<c:when test="${conditionDto.questionNumber > fn:length(conditionDto.questions)}">受付終了状態です。</c:when>
	<c:when test="${conditionDto.isAnswerAccepting and true}">${conditionDto.questionNumber}問目受付中です。</c:when>
	<c:otherwise>${conditionDto.questionNumber}問目受付前です。</c:otherwise>
</c:choose>
</p>
<p>ログインユーザ：${fn:length(conditionDto.userMap)}人 <s:link page="/adminShowUsers/${f:h(password)}" target="_blank">別ウインドウで一覧</s:link></p>
<p><s:link page="/admin/${f:h(password)}">リロード</s:link></p>

<c:forEach items="${conditionDto.questions}" var="question" varStatus="status" >
	<div>
		第${status.count}問：
		<s:link page="/adminSetWaiting/${f:h(password)}/${status.count}">受付前にする</s:link>
		<s:link page="/adminSetAccepting/${f:h(password)}/${status.count}">受付中にする</s:link>
		◆
		回答済み${fn:length(conditionDto.questions[status.index].answers)}人
		<s:link page="/adminShowGraph/${f:h(password)}/${status.count}" target="_blank">別ウインドウでグラフ表示</s:link>
	</div>
</c:forEach>
<p>
	<s:link page="/adminSetWaiting/${f:h(password)}/${fn:length(conditionDto.questions) + 1}">受付終了状態にする</s:link>
</p>
<p>
	<s:link page="/adminShowResult/${f:h(password)}" target="_blank">別ウインドウで結果発表</s:link>
</p>
<br>
<br>
<br>
<p>	★要注意★ <s:link page="/adminResetAll/${f:h(password)}" >全リセット</s:link> ★要注意★</p>
</body>
</html>