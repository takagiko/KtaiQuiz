<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GMT">
<title>問題${f:h(questionNumber)}</title>
</head>
<body>
<p>問題${f:h(questionNumber)}</p>

${conditionDto.questions[questionNumber - 1].question}
<html:errors/>
<s:form method="get" action="/answer/${f:h(userid)}/${f:h(password)}/${f:h(questionNumber)}">
	<c:forEach items="${conditionDto.questions[questionNumber - 1].choices}" var="choice" varStatus="status" >
		<p>
			<c:choose>
				<c:when test="${fn:length(conditionDto.questions[questionNumber - 1].rightAnswer) == 1}">
					<input type="radio" name="answer" value="${status.count}" >${f:h(choice)}
				</c:when>
				<c:otherwise>
					<input type="checkbox" name="answer" value="${status.count}" >${f:h(choice)}
				</c:otherwise>
			</c:choose>
		</p>
	</c:forEach>
	<s:submit property="submit">回答</s:submit>
</s:form>

</body>
</html>