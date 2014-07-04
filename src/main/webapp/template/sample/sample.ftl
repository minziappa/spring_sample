<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="content-language" content="ja" />
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<title>sample</title>

</head>
<body>
<h1>sample</h1>
<br/>

<#if model.sampleModel?has_content>

${model.sample.name?if_exists}

<#else>
 No data
</#if>

</body>
</html>