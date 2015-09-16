<#import "../layout/desgin1/layout.ftl" as layout>
<@layout.myLayout>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">CSV File</h3>
					</div>
					<div class="panel-body">
		      	<form action="/file/downloadCsvFile" method="POST">

							<a href="${filePath?if_exists}">${filePath?if_exists}</a>

							<table style="border-collapse: collapse;">
								<tr>
									<td style="padding: 3px;">File Name</td>
									<td style="padding: 3px;"><input type="text" name="fileName" size="45"></td>
									<td style="padding: 3px;">Example) tomcluse</td>
								</tr>
								<tr>
									<td style="padding: 3px;">Option</td>
									<td style="padding: 3px;">
										<input type="radio" name="option" value="0" checked="checked"/>Download directly
										<input type="radio" name="option" value="1"/>Download from link
									</td>
									<td style="padding: 3px;"></td>
								</tr>
								<tr>
									<td style="padding: 3px;"><input class="btn btn-success" type="submit" value="DownLoad"/></td>
									<td style="padding: 3px;"></td>
									<td style="padding: 3px;"></td>
								</tr>
							</table>
						</form>
					</div>
				</div> <!-- /panel panel-primary -->

				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title">PDF File</h3>
					</div>
					<div class="panel-body">
		      	<form action="/file/downloadPdfFile" method="POST">

							<a href="${filePath?if_exists}">${filePath?if_exists}</a>

							<table style="border-collapse: collapse;">
								<tr>
									<td style="padding: 3px;">File Name</td>
									<td style="padding: 3px;"><input type="text" name="fileName" size="45"></td>
									<td style="padding: 3px;">Example) tomcluse</td>
								</tr>
								<tr>
									<td style="padding: 3px;">Option</td>
									<td style="padding: 3px;">
										<input type="radio" name="option" value="0" checked="checked"/>Download directly
										<input type="radio" name="option" value="1"/>Download from link
									</td>
									<td style="padding: 3px;"></td>
								</tr>
								<tr>
									<td style="padding: 3px;"><input class="btn btn-success" type="submit" value="DownLoad"/></td>
									<td style="padding: 3px;"></td>
									<td style="padding: 3px;"></td>
								</tr>
							</table>
						</form>
					</div>
				</div> <!-- /panel panel-primary -->
</@layout.myLayout>