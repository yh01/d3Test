/**
 *
 */
jQuery(function($) {
	var url = location.protocol;
	url += "/d3Test/D3GraphList";
	var dataSet= [];
	var w = 500;
	var h = 240;
	var padding= 20;
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


            //スケールの指定
			var xScale = d3.scale.linear()
			.domain([0,d3.max(dataSet,function(d){
				return d.val
			})])
			.range([padding, w - padding])
			.nice();

            //棒グラフの生成
			svg.selectAll("rect")
			.d3.select("#graphLine")
            .data(dataSet)
            .enter()
            .append("rect")
            .on("mouseover", function(d) {
                d3.select(this).attr("fill", "orange");
            })
            .on("mouseout", function(d) {
                d3.select(this).attr("fill", "blue");
            })
            .on("click", function(d) {
                var rs = d3.select(this).attr("r");
                alert(rs);
            })
            .attr({
                x: padding,
                y: function(d, i) { return 50 + (i * 25); },
                r : function(d) { return d; },
                width : function(d) { return xScale(d) - padding; },
                height: 20,
                fill: "blue"
            });


			// 売り上げ記載


			// 商品の名前の記載

		});
	};
});
/*
var list = [10, 30, 5, 60, 40, 78, 56, 30, 24, 80];
var svgWidth = 640; // SVG領域の横幅
var svgHeight = 480;    // SVG領域の縦幅
// SVG全体の設定
var svg = d3.select("#graphLine").append("svg")
    .attr("width", svgWidth).attr("height", svgHeight)
// 横棒グラフを描く部分
svg.selectAll("rect")   // SVGでの四角形を示す要素を指定
    .data(list) // データを設定
    .enter()
    .append("rect") // SVGでの四角形を示す要素を生成
    .attr("x", 0)   // 横棒グラフなのでX座標は0。これはSVG上での座標
    .attr("y", function(d,i){   // Y座標を配列の順序に応じて計算
        return i * 18;
    })
    .attr("width", function(d){ // 横幅を配列の内容に応じて計算
        return (d*2) +"px";
    })
    .attr("height", "16")   // 棒グラフの高さを指定
    .attr("style", "fill:rgb(255,160,160)") // 棒グラフの色を薄赤色に設定
// 横棒グラフに値を表示する部分
svg.selectAll("text")
    .data(list) // データを設定
    .enter()
    .append("text") // SVGでの文字を示す要素を生成
    .text(function(d){  // 配列内のデータを表示する
        return d;
    })
    .attr("x", 2)   // 文字のX座標を指定
    .attr("y", function(d,i){   // 文字のY座標を指定
        return i * 18 + 14;
    })
    .attr("font-size", "10pt")  // 文字のサイズを指定
    */

