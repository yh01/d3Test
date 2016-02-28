//数字設定
var test1 =$("#test1").text();
var test2 =$("#test2").text();
var test3 =$("#test3").text();
var dataset = [{
	key : "test1",
	y :test1,
	color : "#1E90FF"
	},{
	key : "test2",
	y :test2,
	color : "#bbeeff"
	},{
	key : "test3",
	y :test3,
	color : "#33CC33"
	}
];
//幅と高さ設定
var width = 800;
var height = 800;


nv.addGraph(function() {
	  var chart2 = nv.models.pie().x(function(d) {
		  return d.key;
	  }).y(function(d) {
		  return d.y;
	  }).donut(true)
	  	.donutRatio(0.35)
	  	.width(width)
	  	.height(height)
	  	.labelType(function(d,i,values){
		  return values.key + ':' + values.value;
	  });



    d3.select("body").selectAll("#chart2")
        .datum([dataset])
        .transition()
        .duration(1200)
        .attr('width', width)
        .attr('height', height)
        .call(chart2);

  return chart2;
});
