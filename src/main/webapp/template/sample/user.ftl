<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<#include "../common/head.ftl">
	<body>
<#include "../common/navi.ftl">
<#include "../common/menu.ftl">

    <div class="container">

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">Select Data</h3>
					</div>
					<div class="panel-body">
						<form action="/sample/user/selectUser.do" method="POST">
		          <b style="color:red" >

<#if errorMessage??>
	<#list errorMessage?keys as key>
	    ${errorMessage[key]} <br/>
	</#list>
</#if>

		          </b>
							<table style="border-collapse: collapse;">
								<tr>
									<td style="padding: 3px;">User Name</td>
									<td style="padding: 3px;"><input type="text" name="userData" size="10" maxlength="14"></td>
									<td style="padding: 3px;">Example) 2014-07-01</td>
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
	<#if model.sampleList?has_content>
		<#list model.sampleList as sample>
            <tr>
              <td>${sample.userModel.userId?if_exists}</td>
              <td>${sample.userModel.userName?if_exists}</td>
              <td>${sample.userModel.userStatus?if_exists}</td>
              <td>${sample.userModel.userAge?if_exists}</td>
              <td><img alt="user image" src="${sample.userImage}" /></td>
            </tr>
    </#list>
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
