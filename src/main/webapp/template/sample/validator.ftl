<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<#include "../common/head.ftl">
	<body>
<#include "../common/navi.ftl">

    <div class="container">
		<div class="jumbotron">
			<ul role="tablist" class="nav nav-tabs">
			<li><a href="/">Welcome to Sample Project</a></li>
			<li><a href="/admin/admin.do">Admin Page</a></li>
			<li><a href="/user/userList.do">User Page</a></li>
			<li><a href="/file/uploadFiles.do">Upload files</a></li>
			<li><a href="/file/downloadFiles.do">Download files</a></li>
			<li class="active"><a href="/vali.do">Validate</a></li>
			<li><a href="/layout.do">layout</a></li>
			</ul>

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Annotation Validate</h3>
				</div>
				<div class="panel-body">
					<form action="/validator.do" method="POST">
	          <b style="color:red" >

<#if errorMessage??>
	<#list errorMessage?keys as key>
	    ●${errorMessage[key]} <br/>
	</#list>
</#if>

	          </b>
						<table style="border-collapse: collapse;">
							<tr>
								<td style="padding: 3px;">A date</td>
								<td style="padding: 3px;"><input type="text" name="userData" size="10" maxlength="14"></td>
								<td style="padding: 3px;">Example) 2014-07-01</td>
							</tr>
							<tr>
								<td style="padding: 3px;">aaName</td>
								<td style="padding: 3px;"><input type="text" name="aaName.aa" size="10" maxlength="14"></td>
								<td style="padding: 3px;">Example) aaName.aa </td>
							</tr>
							<tr>
								<td style="padding: 3px;">aaName</td>
								<td style="padding: 3px;"><input type="text" name="aaName.aa" size="10" maxlength="14"></td>
								<td style="padding: 3px;">Example) aaName.aa </td>
							</tr>
							<tr>
								<td style="padding: 3px;">bbName</td>
								<td style="padding: 3px;"><input type="text" name="bbName.bb" size="10" maxlength="14"></td>
								<td style="padding: 3px;">Example) bbName.bb </td>
							</tr>
							<tr>
								<td style="padding: 3px;">bbName</td>
								<td style="padding: 3px;"><input type="text" name="bbName.bb" size="10" maxlength="14"></td>
								<td style="padding: 3px;">Example) bbName.bb </td>
							</tr>
							<tr>
								<td style="padding: 3px;">Phone Number</td>
								<td style="padding: 3px;"><input type="text" name="phoneNumber" size="20" maxlength="20"></td>
								<td style="padding: 3px;">Example) 81-080-1234-6789 </td>
							</tr>
							<tr>
								<td style="padding: 3px;"><input class="btn btn-sm btn-primary" type="submit" value="Search"/></td>
								<td style="padding: 3px;"></td>
								<td style="padding: 3px;"></td>
							</tr>
						</table>
					</form>
				</div>
			</div> <!-- /panel panel-primary -->

      </div>
	</div> <!-- /jumbotron -->
<#include "../common/foot.ftl">
    </div> <!-- /container -->

	</body>
</html>
