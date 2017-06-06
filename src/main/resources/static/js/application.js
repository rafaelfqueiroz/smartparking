$(document).ready(function() {
	parking_lot_form();
});

function parking_lot_form() {
	add_parking_log();
	remove_parking_lot();
}

function add_parking_log() {
	$(".first-parking-box").click(function () {
		
		$.get("/parking/new", function(data) {
			
			$(".flex-parking").append("<div class=\"parking-box\">"+ 
					"<div><i class=\"fa fa-minus pull-right\"></i></div>" +
					"<span>#" + data.number + "</span>" +
				 "</div>");
			var i = $(".flex-parking").children().last().children().first().children().first();
			i.bind("click", function () {
				$(this).parent().parent().remove();
			});
			
		});
		
		
	});
}

function remove_parking_lot(id_lot, box) {
	$(".parking-box i").click(function() {
		$.delete("/app/parkinglot/", {id:""}, function(data) {
			$(this).parent().parent().remove();
		})
	});
}

function get_parking_color(div, state) {
	if (state == 0) {
		$(div).css("background-color", "#cbffc2");
	}
	if (state == 1) {
		$(div).css("background-color", "#d1edff");
	}
	if (state == 2) {
		$(div).css("background-color", "#ff9e9e");
	}
}