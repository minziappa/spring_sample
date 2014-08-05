<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<#include "../common/head.ftl">
	<body>
<#include "../common/navi.ftl">
<#include "../common/menu.ftl">

    <div class="container">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Insert Data</h3>
					</div>
					<div class="panel-body">
						<form action="/sample/admin/insertUser.do" enctype="multipart/form-data" method="POST">
              <b style="color:red" >

<#if errorMessage??>
	${errorMessage["userName"]?if_exists} <br/>
	${errorMessage["userPwd"]?if_exists} <br/>
	${errorMessage["userAge"]?if_exists} <br/>
</#if>
              </b>
							<table style="border-collapse: collapse;">
								<tr>
									<td style="padding: 3px;">User Name</td>
									<td style="padding: 3px;"><input type="text" name="userName" size="45"/></td>
									<td style="padding: 3px;">Example)tomcluse</td>
								</tr>
								<tr>
									<td style="padding: 3px;">User Password</td>
									<td style="padding: 3px;"><input type="password" name="userPwd" size="45"/></td>
									<td style="padding: 3px;">Example)abcd1234</td>
								</tr>
								<tr>
									<td style="padding: 3px;">User Authority</td>
									<td style="padding: 3px;">
										<select name="userStatus">
											<option value="0"> User </option>
											<option value="1"> Super Admin </option>
										</select>
									</td>
									<td style="padding: 3px;"> User </td>
								</tr>
								<tr>
									<td style="padding: 3px;">User Age</td>
									<td style="padding: 3px;"><input type="text" name="userAge" size="45"/></td>
									<td style="padding: 3px;">Example)19</td>
								</tr>
								<tr>
									<td style="padding: 3px;">Image File</td>
									<td style="padding: 3px;"><input type="file" name="userImg"/></td>
									<td style="padding: 3px;">Example)image.png</td>
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

<#include "../common/foot.ftl">
    </div> <!-- /container -->

	</body>

</html>
