<#import "../layout/desgin1/layout.ftl" as layout>
<@layout.myLayout>
			<br/>
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">CSV File</h3>
				</div>
				<div class="panel-body">
					<form action="/file/handleUploadFiles" enctype="multipart/form-data" method="POST">
          <b style="color:red" >${errorMessage?if_exists}</b>
						<table style="border-collapse: collapse;">
							<tr>
								<td style="padding: 3px;">File Name</td>
								<td style="padding: 3px;"><input type="text" name="csvName" size="30"/></td>
								<td style="padding: 3px;">test</td>
							</tr>
							<tr>
								<td style="padding: 3px;">Image File</td>
								<td style="padding: 3px;"><input type="file" name="csvFile"/></td>
								<td style="padding: 3px;">You can upload the /spring_sample/document/uploadFileForTest.csv</td>
							</tr>
							<tr>
								<td style="padding: 3px;">Option</td>
								<td style="padding: 3px;">
									<input type="radio" name="option" value="0" checked="checked"/>Asynchronous
									<input type="radio" name="option" value="1"/>Synchronous
								</td>
								<td style="padding: 3px;"></td>
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
</@layout.myLayout>