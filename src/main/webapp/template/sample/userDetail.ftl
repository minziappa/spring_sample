<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<#include "../common/head.ftl">
	<body>
<#include "../common/navi.ftl">

    <div class="container">
    	<div class="jumbotron">
		<ul role="tablist" class="nav nav-tabs">
		<li><a href="/sample/">Welcome to Sample Project</a></li>
		<li><a href="/sample/admin/admin.do">Admin Page</a></li>
		<li class="active"><a href="/sample/user/userList.do">User Page</a></li>
		<li><a href="/sample/file/uploadFiles.do">Upload files</a></li>
		<li><a href="/sample/file/downloadFiles.do">Download files</a></li>
		<li><a href="/sample/vali.do">Validate</a></li>
		<li><a href="/sample/layout.do">layout</a></li>
		</ul>


		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3 class="panel-title">Select Data</h3>
			</div>
			<div class="panel-body">
          <b style="color:red" >

<#if errorMessage??>
	<#list errorMessage?keys as key>
	    ${errorMessage[key]} <br/>
	</#list>
</#if>
		  </b>

			<table class="table table-striped">
	            <tr>
	              <td>#</td>
	              <td>${model.userModel.userId?if_exists}</td>
	            </tr>
	            <tr>
	              <td>User Name</td>
	              <td>${model.userModel.userName?if_exists}</td>
	            </tr>
	            <tr>
	              <td>User Status</td>
	              <td>${model.userModel.userStatus?if_exists}</td>
	            </tr>
	            <tr>
	              <td>User Age</td>
	              <td>${model.userModel.userAge?if_exists}</td>
	            </tr>
	        </table>
		  
			</div>
		</div> <!-- /panel panel-primary -->


	</div>
	<!-- end #content -->

		</div> <!-- /jumbotron -->
<#include "../common/foot.ftl">
    </div> <!-- /container -->

	</body>
</html>
