<#import "layout/adminLayout.ftl" as layout>
<@layout.myLayout>
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
</@layout.myLayout>