<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GMT">
<title>ようこそ</title>
</head>
<body>
<p>KtaiQuiz へようこそ！</p>
<p>あなたの名前をおしえてください。（ニックネームOK、絵文字NG）</p>
<html:errors/>
<s:form method="get" action="/register/${f:h(userid)}/${f:h(password)}">
	<html:text property="name"/>
	<s:submit property="submit">登録</s:submit>
</s:form>
</body>
</html>