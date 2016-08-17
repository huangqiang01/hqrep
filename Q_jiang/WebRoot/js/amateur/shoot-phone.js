//
//
$("img").on("click", function(e){
	var $this = $(this);
	$this.addClass("active");
	var setTime = setTimeout(function(){
		clearTimeout(setTime);
		setTime = null;
		$this.removeClass("active");
	}, 500);
	e.stopPropagation();
});
