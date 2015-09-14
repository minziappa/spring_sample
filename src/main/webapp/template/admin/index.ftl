<#import "layout/indexLayout.ftl" as layout>
<@layout.myLayout>

<script>
function changeColor(x) {
	if(x.className == "box1") {
	    x.style.backgroundColor = "#ffb0b0";
	} else if(x.className == "box2") {
	    x.style.backgroundColor = "#bccdff";
	} else if(x.className == "box3") {
	    x.style.backgroundColor = "#c8ffdb";
	} else if(x.className == "box4") {
	    x.style.backgroundColor = "#cece14";
	}
}

function normalColor(x) {
    x.style.backgroundColor = "#ffffff";
}
</script>

<div class="row">
	<div class="col-md-6">
	  	<div class="box1" onmouseover="changeColor(this)" onmouseout="normalColor(this)">
	  		This a option1
	  	</div>
	</div>
	<div class="col-md-6">
	  	<div class="box2" onmouseover="changeColor(this)" onmouseout="normalColor(this)">
			This a option2
	  	</div> 
	</div>
	<div class="col-md-6">
	  	<div class="box3" onmouseover="changeColor(this)" onmouseout="normalColor(this)">
	  		This a option3
	  	</div>
	</div>
	<div class="col-md-6">
	  	<div class="box4" onmouseover="changeColor(this)" onmouseout="normalColor(this)">
			This a option4
	  	</div> 
	</div>
</div>

</@layout.myLayout>