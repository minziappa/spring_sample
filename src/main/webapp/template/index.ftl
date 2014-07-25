<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<#include "common/head.ftl">
	<body>
<#include "common/navi.ftl">
<#include "common/menu.ftl">

    <div class="container">
      <!-- Example row of columns -->
			<div>
<#if admin?exists >
				<h2><a href="/sample/index/">Welcome to Sample Project</a></h2>
<#else>
      <!-- Example row of columns -->
<#include "common/login.ftl">
</#if>

			</div>
<#include "common/foot.ftl">
    </div> <!-- /container -->

	</body>
</html>
