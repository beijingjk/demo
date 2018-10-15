    $(function(){
        search();
    });
//保存
function saveUser(){
    $('#saveUser_formid').form('submit', {
        url:"../user/savePet",
        onSubmit: function(){
            return $("#saveUser_formid").form("validate");
        },
        success:function(data){
            $("#addUser_divid").form("clear")

            $("#addUser_divid").dialog("close")
            search();
        }
    });
}
/**
 * 新增打开弹框
 */
function openAddUser() {

    $("#saveUser_formid").form("clear");
    $("#addUser_divid").dialog({
        closed:false
    })
}
function search(){
    $('#pttypetable').datagrid({
        toolbar:"#toolbar",
        url:'../user/queryPetTypePage',
        //pagination:true,//如果为true,则在DataGrid控件底部显示
        //pageNumber:1,//在设置分页属性的时候初始化页码
        //pageSize:3,//在设置分页属性 的时候初始化页码大小
        //pageList:[3,5,8],//在设置分页属性的时候初始化页面大小选择列表
        //fit:true,
        checkOnSelect:false,
        selectOnCheck:false,
        singleSelect:true,
        columns:[[
            {field:'che',checkbox:'true'},
            {field:'ptid',title:'宠物编号',width:100},
            {field:'pttype',title:'宠物种类',width:100},
            {field:'ptname',title:'宠物名称',width:100},
            {field:'czuo',title:'操作',width:100,
                //添加表格里按钮
                formatter: function(value,row,index){
                    //alert(value);
                    //alert(row);

                    return '<input type="button" value="修改" onclick="editPet(\''+row.ptid+'\')"/><input type="button"  value="刪除" onclick="delPet(\''+row.ptid+'\')"/>';

                }
            },
        ]]
    });

}
//删除
function delPet(ptid){
    //alert(ptid)
    if(confirm("您确定删除编号为"+ptid)){
        $.ajax({
            url:"../user/delPet",
            type:"post",
            data:{ptid:ptid},
            success:function(data){
                search();

            }
        })
    }
}

//回显
function editPet(ptid){



    $('#editId').dialog({
        title: '修改',
        width: 400,
        height: 200,
        href: '../user/toedit?ptid='+ptid,
        modal: true ,
        buttons:[{
            text:'保存',
            handler:function(){
                $('#editUser_formid').form('submit', {
                    url:"../user/updatePet",
                    onSubmit: function(){
                        return $("#editUser_formid").form("validate");
                    },
                    success:function(data){
                        $("#editUser_formid").form("clear")

                        $("#editId").dialog("close")
                        search();
                    }
                });



            }

        }]
    });


}

