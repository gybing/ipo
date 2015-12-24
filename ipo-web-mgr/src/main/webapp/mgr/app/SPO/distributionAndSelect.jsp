<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>分配增发商品及查询</title>

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/default/easyui.css"> 
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/jquery-easyui/themes/icon.css">
<script src="<%=request.getContextPath()%>/static/jquery/jquery-1.8.0.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/jquery.easyui.min.js"  type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/static/jquery-easyui/locale/easyui-lang-zh_CN.js" type="text/javascript"></script>
<link rel="stylesheet" href="../../skinstyle/default/css/common.css" type="text/css" />
<style type="text/css">
	.content span{display:block}
</style>
<script type="text/javascript">
$(document).ready(function(){
	var editRow = undefined;
	 $('#tt').datagrid({  
        title:'分配增发商品及查询',  
        iconCls:'icon-ok', 
        method:"get",
        height:400,
        pageSize:5,  
        pageList:[5,10,15],  
        nowrap:true,
        singleSelect:true,
        striped:true,  
     
        url:"<%=request.getContextPath()%>", //搜索前,触发此action请求所有用户信息  
       queryParams:{
   
       },
        loadMsg:'数据加载中......',  
        fitColumns:true,//允许表格自动缩放,以适应父容器  
        columns : [ [ {  
        	 fiele:'checked',
	     	 checkbox:true  
        },{
       	 field : 'id',  
            width : 200,  
            align: "center",
            title : '承销商代码'
        },{
       	 field : 'test2',  
            width : 200,  
            align: "center",
            title : '承销商名称',
        },{  
            field : 'test3',  
            width : 200,  
            align: "center",
            title : '承销商分配比例（%）',
            editor: { type: 'text', options: { required: true } }
        },{  
            field : 'test4',  
            width : 200, 
            align: "center",
            title : '承销商返佣比例（%）',
            editor: { type: 'text', options: { required: true } }
        }]],
        toolbar:[{text: '修改', iconCls: 'icon-edit', handler: function () {
            var row = $("#tt").datagrid('getSelected');
            if (row !=null) {
                if (editRow != undefined) {
                    $("#tt").datagrid('endEdit', editRow);
                }
                if (editRow == undefined) {
                    var index = $("#tt").datagrid('getRowIndex', row);
                    $("#tt").datagrid('beginEdit', index);
                    editRow = index;
                    $("#tt").datagrid('unselectAll');
                }
            } else {
                
            }
        }},
        '-',
        { text: '保存', iconCls: 'icon-save', handler: function () {
            //保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
            $("#tt").datagrid("endEdit", editRow);
        }},
        '-',
        { text: '取消编辑', iconCls: 'icon-redo', handler: function () {
            //取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
            editRow = undefined;
            $("#tt").datagrid("rejectChanges");
            $("#tt").datagrid("unselectAll");
        }
        }],
        onAfterEdit: function (rowIndex, rowData, changes) {
        	alert(rowData.test3);
        	 console.info(rowData);
             editRow = undefined;
        },
        onDblClickRow:function (rowIndex, rowData) {
            if (editRow != undefined) {
                $("#tt").datagrid('endEdit', editRow);
            }

            if (editRow == undefined) {
                $("#tt").datagrid('beginEdit', rowIndex);
                editRow = rowIndex;
            }
        },
        onClickRow:function(rowIndex,rowData){
            if (editRow != undefined) {
                $("#tt").datagrid('endEdit', editRow);
            }
        },
        pagination : true,
        rownumbers : false,
        selectOnCheck: false,
        checkOnSelect: false
       
	 
});
	 $('#tt').datagrid('insertRow',{
		    index: 1,  
		    row: {
		        id: '新名称',
		        test2: 30,
		        test3: 'qq',
		        test4: '新消息'
		    }
		});
	 $('#tt').datagrid('insertRow',{
		    index: 2,  
		    row: {
		        id: '新名称',
		        test2: 30,
		        test3: 'qq',
		        test4: '新消息'
		    }
		});
});
function test2(inputValue,row){
	row: {
        test4: inputValue
    }
}

function test(id){
	
	alert(id);
}

</script>
</head>
<body>
	<div class="warning">
		<div class="content" style="height:100%">
			<span>温馨提示 :</span>
			<span>分配增发商品及查询</span>
		</div>
	</div>

	<form>
		<div>
		<table id="tt" width="95%" height="100" align="center">
			
		</table>
		</div>
	</form>
</body>
</html>