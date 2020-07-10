//初始化echarts，指定图表呈现在ID为'china_chart'的容器中
var china_chart = echarts.init(document.getElementById('china_chart'));
//设置图例中的颜色
var COLORS = ["#ffffff", "#fdf368", "#fdad4b", "#fb5173", "#bb3937", "#772526", "#480f10"];
china_chart.setOption({				//建议将该部分直接放入到 get中，否则可能出现数据加载不出来的问题
	title:[{				//效果图左边文字
		text: "Novel\n",
		left: "4%",
		y: "10%",
		textStyle: {
			fontSize: 70
		}
	}, {
		text: "Coronavirus\n",
		left: "4%",
		y: "22%",
		textStyle: {
			fontSize: 70
		},
	},{
		text: "2019",
		left: "4%",
		y: "34%",
		textStyle: {
			fontSize: 70
		},
	},{
		text:"————",
		left: "4%",
		y: "42%",
		textStyle: {
			color: '#99cc33',
			fontSize: 70
		},
	},{
		text: "DATA SOURCES:",
		left: "4%",
		y: "51%",
		textStyle: {
			fontSize: 36
		},
	},
		{
			text: "DXY·DX DOCTOR",
			left: "4%",
			y: "58%",
			textStyle: {
				fontSize: 24
			},
		}, {
			text: "CCTV NEWS",
			left: "4%",
			y: "64%",
			textStyle: {
				fontSize: 24
			},
		}, {
			text: "CHINA DAILY\n",
			left: "4%",
			y: "70%",
			textStyle: {
				fontSize: 24
			},
		},
		{
			text: "National Health Commission of the PRC",
			left: "4%",
			y: "76%",
			textStyle: {
				fontSize: 24
			},
		},
	],
	tooltip: {
		formatter:function(params){//提示框浮层内容格式器，支持字符串模板和回调函数两种形式。
			return params.seriesName+'<br />'+params.name+'：'+params.value
		}//数据格式化
	},
	visualMap: {//visualMap 是视觉映射组件，用于进行『视觉编码』，也就是将数据映射到视觉元素（视觉通道）。
		type: 'piecewise',//分段型视觉映射组件
		pieces: [{//自定义『分段式视觉映射组件』的每一段的范围，以及每一段的文字，以及每一段的特别的样式。
			value: 0, color: COLORS[0]	//设置数值为0时展现的颜色
		}, {
			min: 1, max: 9, color: COLORS[1]	//设置数值[1,9]时的颜色
		}, {
			min: 10, max: 99, color: COLORS[2]
		}, {
			min: 100, max: 499, color: COLORS[3]
		}, {
			min: 500, max: 999, color: COLORS[4]
		}, {
			min: 1000, max: 10000, color: COLORS[5]
		}, {
			min: 10000, color: COLORS[6]
		}],
		inRange: {
			color:COLORS //取值范围的颜色
		},

		show:false//设置图注是否显示
	},
	geo: {				//地理坐标系组件用于地图的绘制
		map: 'china',	//设置地图为中国
		roam: false,	//不开启缩放和平移
		zoom:1.23,		//视角缩放比例
		label: {		//地图上现实的文字标签
			normal: {
				show: false,	//设置为不显示
				fontSize:'10',
				color: 'rgba(0,0,0,0.7)'
			}
		},
		itemStyle: {
			normal: {	// 普通状态下的样式
				borderColor: '#333333',
				shadowColor: 'rgba(0, 0, 0, 0.5)',
				shadowBlur: 5
			},
			emphasis:{
				areaColor: '#F3B329',//鼠标选择区域颜色
				shadowOffsetX: 0,
				shadowOffsetY: 0,
				shadowBlur: 20,
				borderWidth: 0,
				shadowColor: 'rgba(0, 0, 0, 0.5)',
			}
		},
		label:{
			emphasis: {
				show: false
			}
		},
		left:"auto",              //组件离容器左侧的距离,百分比字符串或整型数字
		top:65,                   //组件离容器上侧的距离，百分比字符串或整型数字
		right:"6%",               //组件离容器右侧的距离,百分比字符串或整型数字
		bottom:95,
	},
	series : [//系列列表。（图表）
		{
			name: '现存确诊人数',
			type: 'map',//图表类型
			geoIndex: 0,
			data:d//图表的数据
		}
	]
})
