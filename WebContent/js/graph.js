/**
 *
 */
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

nv.addGraph(function() {
	  var chart1 = nv.models.bulletChart();

	  d3.select("body").selectAll("#chart1")
	      .datum(DataSet())
	      .transition().duration(1000)
	      .call(chart1);

	  return chart1;
	});


	function DataSet() {
	  return {
	  	"title":"総在庫数",		//Label the bullet chart
	  	"ranges":[0,test2,test3],	 //Minimum, mean and maximum values.
	  	"measures":[test3],		 //Value representing current measurement (the thick blue line in the example)
	  	"markers":[test1,test2,test3]			 //Place a marker on the chart (the white triangle marker)
	  };
	}