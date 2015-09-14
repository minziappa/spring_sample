<#macro myLayout title="FreeMarker example">
<html>
<#include "header.ftl"/>
	<body>
		<#include "navi.ftl"/>
		<div class="container">
	    	<#nested/>
		</div>
		<#include "footer.ftl"/>
	</body>
</html>
</#macro>