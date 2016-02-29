/**
 *
 */
jQuery(function($) {

	$("#searchButton").on(
			"click",
			function(event) {
				$("#myGraph").empty();
				var fromYear = $("#startYear").val()
				var fromMonth = $("#startMonth").val()
				var toYear = $("#endYear").val()
				var toMonth = $("#endMonth").val()

				var data = {
					year : fromYear,
					month : fromMonth,
					lastYear : toYear,
					lastMonth : toMonth
				};

				$.ajax({
					url : "kinnosawa/AdminCapacitySearchAction",
					type : "get",
					data : data,
					datatype : "json"
				}).done(
						function(data) {
							if (fromYear == "" && fromMonth == "00"
									&& toYear == "" && toMonth == "99") {
								$("#errorMessage").append(Globalize.localize('all', Globalize.culture()));
							} else if (fromYear == "" || fromMonth == "00"
									|| toYear == "" || toMonth == "99") {
								$("#errorMessage").append(Globalize.localize('Please', Globalize.culture()));
								return;
							}else{
								return;
							}
							//数字設定

							//幅と高さ設定
							var w = 500;
							var h = 300;
							var barPadding = 3;

							//ランダム色設定
							var color = d3.scale.category20();

							//svg要素
							var svg = d3.select("body")
										.append("svg")
										.attr("width", w)
										.attr("height", h);

							//各要素設定
							svg.selectAll("rect")
								.data(data)
								.enter()
								.append("rect")
								.attr("x",function(d,i){
									return i * (w/data.length);
								})
								.attr("y",function(d){
									return h - d * 10;
								})
								.attr("width",w / data.length - barPadding)
								.attr("height",function(d){
									return d * 10;
								})
								.attr("fill", function(d,i){return color(i); })//色をグラフに挿入

							//数字テキスト挿入
							svg.selectAll("text")
								.data(data)
								.enter()
								.append("text")
								.text(function(d){
									return d;
								})
								.attr("x",function(d,i){
									return i * (w/data.length) + 5;
								})
								.attr("y",function(d){
									return h - (d * 10) + 15;
								})
								.attr("fill","white");
						});
			});
});
