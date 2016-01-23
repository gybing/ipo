<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/mgr/public/includefiles/allincludefiles.jsp"%>
   
 
<html>
<head>
<title>付发行商货款</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css"> 
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
 
  <script type="text/javascript">
  $(document).ready(function() {
    $('#dg').datagrid({
      url: '<%=request.getContextPath()%>/SPOController/queryIncreasePublishGoods?t='+Math.random(), //从远程站点请求数据的 URL。
      method:"post",
      loadMsg: '加载中', //当从远程站点加载数据时，显示的提示消息。
      iconCls: 'icon-ok', //它将显示一个背景图片
      fitColumns: true, //设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
      nowrap: true, //设置为 true，则把数据显示在一行里。设置为 true 可提高加载性能。
      singleSelect: true, //设置为 true，则只允许选中一行。
      striped: true, //设置为 true，则把行条纹化。（即奇偶行使用不同背景色）
      pagination: true, //设置为 true，则在数据网格（datagrid）底部显示分页工具栏。
      pageNumber: 1, //当设置了 pagination 属性时，初始化页码。
      pageSize: 10, //当设置了 pagination 属性时，初始化页面尺寸。
      pageList: [5, 10, 15, 20], //当设置了 pagination 属性时，初始化页面尺寸的选择列表。
      toolbar: "#tb", //数据网格（datagrid）面板的头部工具栏。
      title: '', //列的标题文本。
      remoteSort: false, //定义是否从服务器排序数据。
      columns: [
        [{
          field: 'id',
          title: 'id',
          hidden:true
         },{
          field: 'payee',
          title: '发行会员编号',
          width : 200,
          align: 'center'
        }, {
          field: 'commodityId',
          title: '商品编码',
          width : 200,
          align: 'center'
        }, {
          field: 'payDate',
          title: '付款日期',
          width : 200,
          align: 'center' 
        }, {
            field: 'amount',
            title: '应付货款',
            width : 200,
            align: 'center' 
        },{
          field: 'oper',
          title: '付货款',
          width : 150,
          align: 'center',
          formatter: function(value, row, index) {
        	  if(row.payState=='1'){
        		  return "<a href=\"#\" onclick=\"pay("+row.id+")\">" + "付款" + "</a>";
        	  }else if(row.payState=='2'){
        		  return "已付";
        	  };
            }
        }]
      ]
    });
    var p = $('#dg').datagrid('getPager');
    $(p).pagination({
      beforePageText: '第',
      afterPageText: '页    共 {pages} 页',
      displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录'
    });
  });
  
  
  function pay(id){
	  var url_="<%=request.getContextPath()%>/SPOController/pay?t="+Math.random();
	  $.ajax({  
		    url: url_,  
		    data:{"id":id},  
		    type: 'POST',dataType: 'text',  
		    success : function(data, stats) {  
	             if(data=="success"){
	            	 alert('付款成功');
	            	 doSearch();
	             }else if(data=="error"){
	            	 alert('付款失败');
	             }
	        },
	  	    error: function (jqXHR, textStatus, errorThrown) {
	              alert('系统异常!');
	        }
		});  
  }
  
  
  function doSearch(){
    	$('#dg').datagrid('load',{
    		commodityId:$('#commodityId').val(),
    		payee:$('#payee').val()
    	});
   }
  
  </script>
</head>
<body>
<div id="main_body">
			<table class="table1_style" border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td>
						<br />
	<div class="div_list">
	<table id="dg" width="100%"></table>
		<div id="tb" style="padding:5px;height:auto">
		<div>
		<form name="frm"  >
			商品编码: <input id="commodityId"  class="easyui-textbox" style="width:80px">&nbsp;
			发行会员编号: <input id="payee"  class="easyui-textbox" style="width:80px">
			<input type="hidden">
			<a href="#" class="easyui-linkbutton" iconCls="icon-search" id="view" onclick="doSearch()">查询</a>					
		</form> 
		</div>
	</div>
	</div>
	</td>
	</tr>
    </table>
</div>
</body>

</html>
