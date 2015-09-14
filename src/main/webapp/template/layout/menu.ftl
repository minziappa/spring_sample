    <!-- Main jumbotron for a primary marketing message or call to action -->
	<ul role="tablist" class="nav nav-tabs">
		<li <#if model??><#if model.navi??><#if model.navi == "index">class="active"</#if></#if></#if>><a href="/index/">Welcome to Sample Project</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "admin">class="active"</#if></#if></#if>><a href="/admin/admin">Admin Page</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "user">class="active"</#if></#if></#if>><a href="/user/userList">User Page</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "file">class="active"</#if></#if></#if>><a href="/file/uploadFiles">Upload files</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "file">class="active"</#if></#if></#if>><a href="/file/downloadFiles">Download files</a></li>
		<li <#if model??><#if model.navi??><#if model.navi == "validate">class="active"</#if></#if></#if>><a href="/validator/validator">Validate</a></li>
	</ul>