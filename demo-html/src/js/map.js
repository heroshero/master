var jsonstr="[{'point': '湖北省','context': '2222'},{'point': '北京市','context': '故宫'}]";
		var jsonarray = eval('('+jsonstr+')');
		var sf;
$(function(){
	//一开始渲染原始数据
	$('#listTemplate').tmpl(jsonarray).appendTo('.listContent');
	map.centerAndZoom(new BMap.Point(108.946, 34.348), 6);  // 初始化地图,设置中心点坐标和地图级别
	map.enableScrollWheelZoom();  
	function showInfo(e){
		var pt = e.point;
		var flag = true;
		geoc.getLocation(pt, function(rs){
			var addComp = rs.addressComponents;
			//循环遍历json，判断是否在以浏览数据中
			sf = addComp.province;
			for(var i=0;i<jsonarray.length;i++){
				if(jsonarray[i].point == sf){
					flag = false;
					openInfo( pt.lng,pt.lat,jsonarray[i].context);
				}
			}
			if(flag){
					openInfo( pt.lng,pt.lat,'');
			}
		});

	}
	map.addEventListener("click", showInfo);
	var opts = {
				width : 400,     // 信息窗口宽度
				height: 200,     // 信息窗口高度
				enableMessage:true//设置允许信息窗发送短息
			   };
	var content = '<div><textarea class="text" id= "text" placeholder="可以做计划哦" ></textarea></div ><div class="center" ><input class="btn btn-info" type="button" value="保存" onclick="submit()"/></div>';
	function openInfo(lng,lat,text){
		var point = new BMap.Point(lng, lat);
		if(''!=text){
				 infoWindow = new BMap.InfoWindow(text,opts);  // 创建信息窗口对象 
		}else{
				 infoWindow = new BMap.InfoWindow(content,opts);  // 创建信息窗口对象 
		}
				infoWindow.addEventListener('open',function(type, target, point){ //窗口打开是，隐藏自带的关闭按钮
		    $('.BMap_pop>img').hide();
		})
		map.openInfoWindow(infoWindow,point); //开启信息窗口
	};
})
function submit(){
		var resJson ={'point':sf,"context":$('#text').val()};
		jsonarray.push(resJson);
		layer.msg('保存成功');
		$('.listContent').html($('#listTemplate').tmpl(jsonarray));
		//关闭弹框
		map.closeInfoWindow();
	}