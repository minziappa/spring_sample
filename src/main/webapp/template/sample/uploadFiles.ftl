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
			<li><a href="/sample/user/userList.do">User Page</a></li>
			<li class="active"><a href="/sample/file/uploadFiles.do">Upload files</a></li>
			<li><a href="/sample/file/downloadFiles.do">Download files</a></li>
			<li><a href="/sample/vali.do">Validate</a></li>
			<li><a href="/sample/layout.do">layout</a></li>
			</ul>

			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">CSV File</h3>
				</div>
				<div class="panel-body">
					<form action="/sample/file/handleUploadFiles.do" enctype="multipart/form-data" method="POST">
          <b style="color:red" >${errorMessage?if_exists}</b>
						<table style="border-collapse: collapse;">
							<tr>
								<td style="padding: 3px;">File Name</td>
								<td style="padding: 3px;"><input type="text" name="csvName" size="45"/></td>
								<td style="padding: 3px;">Example)tomcluse</td>
							</tr>
							<tr>
								<td style="padding: 3px;">Image File</td>
								<td style="padding: 3px;"><input type="file" name="csvFile"/></td>
								<td style="padding: 3px;">Example)file.csv</td>
							</tr>
							<tr>
								<td style="padding: 3px;">Option</td>
								<td style="padding: 3px;">
									<input type="radio" name="option" value="0" checked="checked"/>Asynchronous
									<input type="radio" name="option" value="1"/>Synchronous
								</td>
								<td style="padding: 3px;">Example)tomcluse</td>
							</tr>
							<tr>
								<td style="padding: 3px;"><input class="btn btn-sm btn-primary" type="submit" value="Register" /></td>
								<td style="padding: 3px;"></td>
								<td style="padding: 3px;"></td>
							</tr>
						</table>
					</form>
				</div>
			</div> <!-- /panel panel-primary -->
		</div> <!-- /jumbotron -->
<#include "../common/foot.ftl">
    </div> <!-- /container -->

	</body>

</html>
