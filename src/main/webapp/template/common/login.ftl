      <form class="form-signin" role="form" action="/sample/j_spring_security_check" name="sform" id="sform" method="POST">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input  type="text" name="j_username" class="form-control" placeholder="Email address" required autofocus>
        <input type="password" name="j_password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>