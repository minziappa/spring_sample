<#macro myLayout title="FreeMarker example">
<html>
<#include "header.ftl"/>
	<body>
		<div id="wrapper">
		<#include "navi.ftl"/>
		<div id="page-wrapper" style="min-height: 390px;">
	    	<#nested/>
		</div>
		<#include "footer.ftl"/>
		</div><!-- /.wrapper -->
		<#include "bottom.ftl"/>
	</body>
</html>
</#macro>