    <!-- Main jumbotron for a primary marketing message or call to action -->
	<ul role="tablist" class="nav nav-tabs">
		<li <#if model??><#if model.navi??><#if model.navi == "inputUser">class="active"</#if></#if></#if>><a href="/admin/inputUser">Input user</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "userList">class="active"</#if></#if></#if>><a href="/admin/userList">User data</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "userDetail">class="active"</#if></#if></#if>><a href="#">User Detail</a></li>
	</ul>