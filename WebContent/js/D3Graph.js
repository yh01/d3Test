jQuery(function($) {
	var url = location.protocol;
	url += "/d3Test/salesList";
	var dataSet= [];
	getSalesGraph();

	function getSalesGraph() {
$.ajax({
	url : url,
	type : 'get',
	datatype : 'json'
		}).done(function(data) {
			for(i=0;i<data.length;i++){
				dataSet[i] = {name:data[i].itemName, val:data[i].salesAmount};
			}
			console.log(data);
			//svg領域の指定
			var size = $(window).width() * 0.4;
			var margin = {top: 20 , right: 0, left:  0, bottom: 20}
			var svgH = (25 * (data.length + 7)) - margin.top - margin.bottom;
			var svgW = size - margin.left - margin.right;
			var Margin = 0;
			var svg = d3.select("#D3Graph")
			            .append('svg')
				        .attr({
				    	       height: svgH,
				               width:  svgW
                     });

            //スケールの指定
			var xscale = d3.scale.linear()
				.domain([0,d3.max(dataSet,function(d){ return d.name})])
				.range([100, svgH]);
		    var yscale = d3.scale.linear()
				.domain([0,(d3.max(dataSet,function(d){ return d.val}) + Margin)])
				.range([0, svgW - (margin.left + Margin)]);

            //棒グラフの生成
			var barchart = svg.selectAll("rect")
			         .data(dataSet)
			         .enter()
			         .append("rect")
			         .attr({
							x: function(d,i){return i * 50 + Margin},//function(d,i){return i * 50 + Margin}
							y: function(d)  { return  svgH-((d.val * 5))},//function(d)  { return  svgH-((d.val * 5))}
							width:30,//30
							height :function(d){ return yscale(d.val)},//function(d){ return yscale(d.val)}
							fill: "blue"
			         });

			// 売り上げ記載
			svg.selectAll("text")
					.attr("class","xAxis")
					.data(dataSet)
					.enter()
					.append("text")
					.text(function(d){return d.val})
					.attr({
						x: function(d,i){return i * (svgH / dataSet.length)},//function(d,i){return i * (svgH / dataSet.length)}
						y: 50,//50
						fill:"black",
					});

			// 商品の名前の記載
			svg.selectAll("text2")
					.attr("class","yAxis")
					.data(dataSet)
					.enter()
					.append("text")
					.text(function(d){return d.name})
					.attr({
						x: Margin,//Margin
						y: function(d,i){return i * 50 + Margin + 25},//function(d,i){return i * 50 + Margin + 25}
						fill:"white",
					})
					.attr("transform", function(d,i){
						return "translate("+ 0 +"," + svgH + ")rotate(-90)";
					});
	});
  };
});