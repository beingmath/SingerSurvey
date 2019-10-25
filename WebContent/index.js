$(function() {
	var url = location.search;
	var str = url.substr(1);
	var $name = $(".value").val();
	var strs = str.split("=");
	var id = strs[1];
	getCommentList(id);
	$.ajax({
		url : "query",
		data : {
			id : id,
		},
		success : function(song) {
			var $songInfo = $("<img class=\"song_image\" src=\"image/"
					+ song.mid + ".jpg\" \>\n"
					+ "    <div class=\"song_infos\">\n" + "  <h1>" + song.name
					+ "</h1>\n" + "      <h3>专辑:" + song.album + "</h3>");
			var $songtro = $(".songIntro");
			$songInfo.appendTo($songtro);
		}
	});

	$("body").delegate(".inputarea", "propertychange input", function() {
		if ($(this).val().length > 0) {
			$(".btn").prop("disabled", false);
		} else {
			$(".btn").prop("disabled", true);
		}
	})
	$(".btn").click(function() {
		var $area = $(".inputarea").val();
		var $comment = createComment($area, $name, createTime(), 0, 0, 0, 0);
		$(".comment__list").append($comment);
		$(".inputarea").val("");
		$(".btn").prop("disabled", true);
		$.ajax({
			url : "insertComment",
			data : {
				comment : $area,
				id : id
			},
			success : function(value) {
				$comment.get(0).id = value;
			},
		});
	});
	// 点赞
	$("body").delegate(
			".acc",
			"click",
			function() {
				var nid = $(this).parents(".one_comment").get(0).id;
				$(this).toggleClass("toggle");
				// 点赞
				if ($(this).attr("class").indexOf("toggle") != -1) {
					$(this).find(".accnumber").text(
							parseInt($(this).find(".accnumber").text()) + 1);
					$.ajax({
						url : "acc",
						data : {
							nid : nid,
							name : $name
						},
					});
					// 取消赞
				} else {
					$(this).find(".accnumber").text(
							parseInt($(this).find(".accnumber").text()) - 1);
					$.ajax({
						url : "toggleacc",
						data : {
							nid : nid,
							name : $name
						},
					});
				}
			});
	// 点踩
	$("body").delegate(
			".step",
			"click",
			function() {
				var nid = $(this).parents(".one_comment").get(0).id;
				$(this).toggleClass("cai");
				if ($(this).attr("class").indexOf("cai") != -1) {
					$(this).find(".stepnumber").text(
							parseInt($(this).find(".stepnumber").text()) + 1);
					$.ajax({
						url : "step",
						data : {
							nid : nid,
							name : $name
						},
					});
				} else {
					$(this).find(".stepnumber").text(
							parseInt($(this).find(".stepnumber").text()) - 1);
					$.ajax({
						url : "togglestep",
						data : {
							nid : nid,
							name : $name
						},
					});
				}
			});
	function getCommentList(id) {
		$.ajax({
			url : "selectComment",
			async: false,
			data : {
				id : id
			},
			success : function(data) {
				for (var i = 0; i < data.length; i++) {
					var $ifacc;
					var $ifstep;
					$.ajax({
						url : "selectIfAccstep",
						async: false,
						data : {
							commentid : data[i].id,
							username : $name
						},
						success : function(aCCstep) {
							 $ifacc = aCCstep.acc;
							$ifstep = aCCstep.step;
						}
					});
					var $comment = createComment(data[i].comment,
							data[i].username, data[i].time, $ifacc,
							$ifstep, data[i].acc, data[i].step);
						$comment.get(0).id = data[i].id;
						$(".comment__list").append($comment);
				}
			}
		});
	}
	function createComment($areaq, $name, $time, $ifacc, $ifstep, $acc, $step) {
		var $comment = $("<li class=\"one_comment\">\n"
				+ "	<p class=\"person_name\">\n"
				+ "		<i class=\"person_image\"></i>"
				+ $name
				+ "\n"
				+ "	</p>\n"
				+ "		<p class=\"person_comment\">"
				+ $areaq
				+ "\n"
				+ "	</p>\n"
				+ "	<p class=\"person_down\">\n"
				+ "	<span class=\"infoTime\">"
				+ $time
				+ "</span>\n"
				+ "	<span class=\"infoHandle\">\n"
				+ "	<a class=\""
				+ (($ifacc == 1) ? "acc toggle" : "acc")
				+ "\" href=\"javascript:;\"><span class=\"accnumber\">"
				+ $acc
				+ "</span></a>\n"
				+ "	<a class=\""
				+ (($ifstep == 1) ? "step cai" : "step")
				+ "\" href=\"javascript:;\"><span class=\"stepnumber\">"
				+ $step + "</span></a>\n" + "	</span>\n" + "	</p>\n" + "	</li>");
		return $comment;
	}
	createTime();
	function createTime() {
		// 2018-4-12 17:09
		var date = new Date();
		var arr = [ date.getFullYear()
				+ "-"
				+ (date.getMonth() + 1)
				+ "-"
				+ date.getDate()
				+ " "
				+ ((date.getHours() < 10) ? ("0" + date.getHours()) : date
						.getHours())
				+ ":"
				+ ((date.getMinutes() < 10) ? ("0" + date.getMinutes()) : date
						.getMinutes())
				+ ":"
				+ ((date.getSeconds()) < 10 ? ("0" + date.getSeconds()) : date
						.getSeconds()) ];
		// 把数组变成字符串
		return arr.join("");
	}

});