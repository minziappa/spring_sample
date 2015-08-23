<#macro myLayout title="FreeMarker example">
<html>
<#include "header.ftl"/>
	<body style="width:100%;height:100%">
		<#include "navi.ftl"/>
		<div class="row row-offcanvas row-offcanvas-right">
    		<#include "sideMenu.ftl"/>
	    	<#nested/>
		</div>
		<#include "footer.ftl"/>
	</body>
</html>
</#macro>