<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="js/arrayOperate.js"></script>  
		<title>查找</title>
	</head>
	<body>
		<h1>请输入teamview的区域</h1>
 		<form method="POST">
    		省: <select id="province" name = "province"></select> 
    		市: <select id="city" name = "city"></select>
    		具体场站: <select id="station" name = "station"></select><br/>
    		<input type="button" value="search" onclick="search()" />
    	</form>
		<script type="text/javascript">
		var cities = new Array();
		var json;
		$.ajax({
                type:"POST",//为post请求
                url:"getRegion",//这是我在后台接受数据的文件名
                async:false,//设置成true，这标志着在请求开始后，其他代码依然能够执行。如果把这个选项设置成false，这意味着所有的请求都不再是异步的了，这也会导致浏览器被锁死
                dataType:"json",
                error:function(request){//请求失败之后的操作
                    return;
                },
                success:function(data){//请求成功之后的操作
                    alert(data);
                	json = data;
                	var tmp = new Array();
                    for(var i = 0; i < data.length; i++) {
                    	tmp[i] = data[i].province;
                    }
                    var province = unique1(tmp);
                    for(i = 0 ; i < province.length; i++) {
                    	cities[province[i]] = new Array();
                    }
                    for(var i = 0; i < data.length; i++) {
                    	if(cities[data[i].province].indexOf(data[i].city) == -1)
                    		cities[data[i].province].push(data[i].city);
                    }
                }
        });
        //添加具体厂站
        function loadStations() {
        	var city=$("#city");
			var pro=$("#province");
			var station=$("#station");
			var proValue=pro.val();
			var cityValue=city.val();
			var stations = new Array();
			station.find("option").remove();
			for(var i = 0; i < json.length; i++) {
                if(json[i].province == proValue && json[i].city == cityValue) {
					stations.push(json[i].station);
                }  	
            }
            for(var i = 0; i<stations.length; i++) {
            	var op = new Option(stations[i],stations[i]);
            	station.append(op);
            }   
        }
       	//添加区   
        function loadCity(){
			var city=$("#city");
			var pro=$("#province");
			var index=pro.val();
			city.find("option").remove();
			for(var i in cities[index]){
				var op=new Option(cities[index][i],cities[index][i]);
				city.append(op);
			}
			loadStations();
			city.bind("change",function() {
				loadStations();
			})
		}
		//添加市
		window.onload=function(){
			var pro=$("#province");
			for(var p in cities){
				var op=new Option(p,p);
				pro.append(op);
			}
			loadCity();
			pro.bind("change",function(){
				loadCity();
			})
		}
		
		function search() {
			var pro = $("#province").val();
			var city = $("#city").val();
			var station = $("#station").val();
			for(var i = 0; i < json.length; i++) {
				if(json[i].province == pro && json[i].city == city && json[i].station == station)
					alert("账号是："+json[i].teamView+"\n密码是："+json[i].password);
			}
		}
		</script>

    </body>
</html>