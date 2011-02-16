<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J" />
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="Thu, 01 Dec 1994 16:00:00 GMT">
<title>KtaiQuiz 第${questionNumber}問回答分布</title>
<style type="text/css">
<!--
  	.legend { font-size: 150% }
    .graph {
        position: relative;
        width: 400px;
        border: 1px solid #B1D632;
        padding: 2px;
    }
    .graph .bar {
        display: block;
        position: relative;
        background: #B1D632;
        text-align: center;
        color: #333;
        height: 2em;
        line-height: 2em;
    }
    .graph .bar span { position: absolute; left: 1em; }
-->
</style>
</head>
<body>
<h2>KtaiQuiz 第${questionNumber}問回答分布</h2>
<table>
<c:forEach items="${conditionDto.questions[questionNumber - 1].choices}" var="choice" varStatus="status" >
	<tr>
		<td class="legend">${f:h(choice)}</td>
		<td>
			<div class="graph">
				<strong class="bar" style="width: ${percent[status.index]}%;">${result[status.index]}</strong>
			</div>
		</td>
	</tr>
</c:forEach>
</table>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.4/jquery.min.js"></script>
</body>
</html>