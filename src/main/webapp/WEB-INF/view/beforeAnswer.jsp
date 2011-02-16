<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GMT">
<c:choose>
	<c:when test="${fn:length(conditionDto.questions) < questionNumber}"><title>おつかれさまでした</title></c:when>
	<c:otherwise><title>問題${f:h(questionNumber)}</title></c:otherwise>
</c:choose>
</head>
<body>

<c:choose>
	<c:when test="${fn:length(conditionDto.questions) < questionNumber}">
		<p style="color:red;">問題は全て終了しました。</p>
		<p>スクリーンでの結果発表をお待ちください。ありがとうございました。</p>
	</c:when>
	<c:otherwise>
		<html:errors/>
		<p>回答受付を開始したら、下のボタンから回答ページへ移動してください。</p>
		<s:form method="get" action="/show/${f:h(userid)}/${f:h(password)}/${f:h(questionNumber)}">
			<s:submit property="submit">第${f:h(questionNumber)}問へ</s:submit>
		</s:form>
	</c:otherwise>
</c:choose>

</body>
</html>