<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<body>

			<div>
				<h2><a href="/sample/index/">Welcome to Spring Security Test</a></h2>
				<div>
				<br>
					<form action="/sample/j_spring_security_check" name="sform" id="sform" method="POST">
					<table>
						<tr>
							<td>user id</td><td><input type="text" name="j_username" value="" /></td><td>例)admin</td>
						</tr>
						<tr>
							<td>password</td><td><input type="password" name="j_password" value="" /></td><td>例)*******</td>
						</tr>
						<tr>
							<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
						</tr>
						<tr>
							<td><input name="submit" type="submit" value="Login" style="width:60pt;height:20pt;background-color:#566D7E;color:white;" /></td><td></td><td></td>
						</tr>
					</table>
					</form>
				</div>
			</div>
</body>
</html>