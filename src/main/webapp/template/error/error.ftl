<#include "../common/document_type.ftl">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<unfoldMeta />
<meta http-equiv="Cache-Control" content="no-cache" />
<title>エラー</title>
<#include "../common/css.ftl">

</head>

<body class="body">
<div id="designHook0">
	<div id="h1">
		<h1><span class="h1">ｴﾗｰ</span></h1>
	</div><!-- //h1 -->

	<div id="designHook1">

		<span class="errors">${errorMessage?if_exists}</span>

	</div><!--/designhook1-->
</div>
</body>
</html>