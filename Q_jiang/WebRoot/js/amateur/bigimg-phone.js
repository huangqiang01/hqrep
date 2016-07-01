$(".img img").on("click", function(){
	$(".content-big").show();
});

$(".img-reset").on("click", function(){
	$(".big-super-img").css("width", "100%");
	$(".content-big").hide();
});



var currentScale, currentWidth;
var initWidth = 100;

touch.on('#target', 'pinchend', function(ev){
	currentScale = ev.scale - 1;
	currentWidth = initWidth + initWidth * currentScale;
	currentWidth = currentWidth < 100 ? 100 : currentWidth;
	currentWidth = currentWidth > 400 ? 400 : currentWidth;
	initWidth = currentWidth;
	$(".big-super-img").css("width", currentWidth + "%");
});
