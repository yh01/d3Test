jQuery(function($) {

	Globalize.culture(navigator.languages[0]);
	Globalize.addCultureInfo( "ja", {
		messages: {
			"0hit":"0件HITしました。",
			"all"  :"全件表示します！",
			"matterHit":"件HITしました。",
			"sales":"の販売数は:",
			"number":"個です",
			"Please":"全ての項目を入力してください。"
		}
	});
	Globalize.addCultureInfo( "en", {
		messages: {
			"0hit":"0 was hit.",
			"all"  :"All cases to display!",
			"matterHit":"It was matter hit.",
			"sales":" The number of sales:",
			"number":" is Number",
			"Please":"Please enter all of the items."
		}
	});


	$("#searchButton").on(
			"click",
			function(event) {
				$("#errorMessage").empty();
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
							}else if(data){
								$("#errorMessage").append(
										data.length + Globalize.localize('matterHit', Globalize.culture()));
							}else{
								$("#errorMessage").append(Globalize.localize('0hit', Globalize.culture()));
								return;
							}

							var size = $(window).width() * 0.65;
							var margin = {
								top : 20,
								right : 0,
								left : 200,
								bottom : 20
							};
							var svgHeight = (35 * (data.length));
							var Margin = 20;
							var svgWidth = size - margin.left - Margin;
							var translateHeight = svgHeight + 10;
							var svg = d3.select("#myGraph").append("svg").attr(
									{
										width : svgWidth,
										height : svgHeight + margin.top
												+ margin.bottom
									});

							var scale = d3.scale.linear().domain(
									[ 0, d3.max(data, function(d) {
										return d.total
									}) ]).range(
									[ 0, svgWidth - (margin.left + Margin) ])
									.nice();
							var xAxisCall = d3.svg.axis().scale(scale).orient(
									"bottom")
							var xAxis = svg.append("g").attr("class", "axis")
									.attr(
											"transform",
											"translate(" + margin.left + ","
													+ translateHeight + ")")
									.call(xAxisCall);

							var scaleName = d3.scale.linear().domain(
									[ 0, d3.max(data, function(d) {
										return d.goodsName
									}) ]).range([ 0, svgHeight ]);

							svg.selectAll("text1").data(data).enter().append(
									"text").attr({
								x : 0,
								y : function(d, i) {
									return i * 35 + 15;
								},
								fill : "black"
							}).text(function(d) {
								return d.goodsName;
							});

							var barchart = svg.selectAll("rect").data(data)
									.enter().append("rect").on(
											"mouseover",
											function(d) {
												d3.select(this).attr("fill",
														"orange");
											}).on("mouseout", function(d) {
										d3.select(this).attr("fill", "blue");
									}).on(
											"click",
											function(d) {
												alert(d.goodsName + Globalize.localize('sales', Globalize.culture())
														+ d.total + Globalize.localize('number', Globalize.culture()));
											}).transition().delay(
											function(d, i) {
												return i * 150;
											}).duration(1000).ease("bounce")
									.each("start", function() {
										d3.select(this).attr({
											x : margin.left,
											y : 0,
											width : 0,
											height : 20,
											fill : "red"
										})
									}).attr({
										x : margin.left,
										y : function(d, i) {
											return i * 35
										},
										width : function(d) {
											return scale(d.total)
										},
										height : 20,
										fill : "blue"
									});
						})
			});
});
