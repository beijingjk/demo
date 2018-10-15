
    $(function(){
        queryTree();
    })
function queryTree(){
    $('#tree').tree({
        url:'../user/queryTree',
        parentField:"pid",
        formatter:function(node){
            return node.text;
        },
        onSelect:function(node){
            /*<![CDATA[*/if(node.url!=null && node.url!=''){
                if($("#tabs").tabs('exists',node.text)){
                    $("#tabs").tabs('select',node.text)
                }/*]]>*/else{
                    $("#tabs").tabs('add',{
                        title:node.text,
                        content:createFrame(node.url),
                        closable:true,
                        tools:[
                            {
                                iconCls:'icon-mini-refresh',
                                handler:function(){
                                    var selectTab = $('#tabs').tabs('getSelected');
                                    $('#tabs').tabs('update',{
                                        tab:selectTab,
                                        options:{
                                            content:createFrame(node.url)
                                        }
                                    });
                                }
                            }
                        ]
                    })
                }
            }
        }
    });
}

function createFrame(url) {
    return '<iframe border="0" scrolling="yes" frameborder="0"  src="'+ url + '" style="width:99.9%;height:99.5%;"></iframe>';
}

