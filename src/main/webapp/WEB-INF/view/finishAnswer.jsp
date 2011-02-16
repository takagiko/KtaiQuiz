<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GMT">
<title>問題${f:h(questionNumber)}回答完了</title>
</head>
<body>
<p>問題${f:h(questionNumber)}の回答を受け付けました。</p>

<c:choose>
	<c:when test="${fn:length(conditionDto.questions) == questionNumber}">
		<p>問題はこれで全て終了です。スクリーンでの結果発表をお待ちください。ありがとうございました。</p>
	</c:when>
	<c:otherwise>
		<s:form method="get" action="/show/${f:h(userid)}/${f:h(password)}/${f:h(questionNumber + 1)}">
			<s:submit property="submit">第${f:h(questionNumber + 1)}問へ</s:submit>
		</s:form>
	</c:otherwise>
</c:choose>

</body>
</html>