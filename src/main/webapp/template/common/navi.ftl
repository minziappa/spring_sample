    <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="/sample/">Sample name</a>
      </div>
<#if user??>
  	<#include "naviLogin.ftl">
<#else>
  	<#include "naviLogout.ftl">
</#if>
    </div>
  </nav><!--/navigation -->