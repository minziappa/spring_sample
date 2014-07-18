<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<#include "../common/head.ftl">
	<body>
<#include "../common/navi.ftl">
<#include "../common/menu.ftl">

    <div class="container">
      <!-- Example row of columns -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Select Data</h3>
					</div>
					<div class="panel-body">
						<form action="/sample/user/selectUser.do" method="POST">
		          <b style="color:red" >${errorMessage?if_exists}</b>
							<table style="border-collapse: collapse;">
								<tr>
									<td style="padding: 3px;">User Name</td>
									<td style="padding: 3px;"><input type="text" name="userName" size="45"></td>
									<td style="padding: 3px;">Example)tomcluse</td>
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
				<table class="table table-striped">
          <thead>
            <tr>
              <th>#</th>
              <th>User Name</th>
              <th>User Status</th>
              <th>User Age</th>
            </tr>
          </thead>
          <tbody>

<#if model??>
	<#if model.sample?has_content>
            <tr>
              <td>${model.sample.userModel.userId?if_exists}</td>
              <td>${model.sample.userModel.userName?if_exists}</td>
              <td>${model.sample.userModel.userStatus?if_exists}</td>
              <td>${model.sample.userModel.userAge?if_exists}</td>
              <td><img alt="user image" src="${model.sample.userImage}" /></td>
            </tr>
	<#else>
	 No data
	</#if>
<#else>
 No data
</#if>
          </tbody>
        </table>

      </div>
<#include "../common/foot.ftl">
    </div> <!-- /container -->

	</body>
</html>
