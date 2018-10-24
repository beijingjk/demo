<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


	文件域
		 <input type="file" id="imgFileBTN" >
	图片回显的img标签
		<div id="showImgDiv" style="width: 150px;height: 200px;border-style:solid;border-width:1px; border-color:black;">
			 <img src="" id="showImg" style="width: 150px;height: 200px;">
		</div>
	显示进度条的div
		<div id="showBars" ></div>
<!-- ****************************************************************************************-->

	//文件域的id
    $("#imgFileBTN").uploadify({
    //前台请求后台的url 不可忽略的参数
    'uploader' :"<%=request.getContextPath()%>/user/upImg.do",
    //插件自带 不可忽略的参数
    'swf' : '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
  //撤销按钮的图片路径
    'cancelImg' : '<%=request.getContextPath() %>/js/uploadify/uploadify-cancel.png',
  //如果为true 为自动上传 在文件后 为false 那么它就要我们自己手动点上传按钮
    'auto' : true,
    //可以同时选择多个文件 默认为true 不可忽略
    'multi' : false,
    //给上传按钮设置文字
    'buttonText' : '上传头像',
    //上传后队列是否消失
    'removeCompleted' : true,
    'removeTimeout' : 1,
  //上传文件的个数
    'uploadLimit' : 2,
    'fileTypeExts' : '*.jpg;*.jpge;*.gif;*.png',
    'fileSizeLimit' : '2MB',
  //给div的进度条加背景 不可忽略
    'queueID' : 'showBars',
 // controller层方法中接收文件的参数名
    'fileObjName' : 'artImg',
//      上传成功后的回调函数
    'onUploadSuccess' : function(file, data, response) {
		alert(data);
		$("#showImg").prop("src","<%=request.getContextPath()%>/"+data);
		$("#addphoto").val(data);
	}
<!-- ****************************************************************************************-->

@RequestMapping("upImg")
	@ResponseBody
	    public String upImg(MultipartFile artImg,HttpServletRequest req) throws Exception{
	        //获取原文件名称
	        String fileName = artImg.getOriginalFilename();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	        String folderPath = req.getSession().getServletContext().getRealPath("/")+
	                "upload/";
	        File file = new File(folderPath);
//	        该目录是否已经存在
	        if(!file.exists()){
	         //   创建文件夹
	            file.mkdir();
	        }
	        String onlyFileName = sdf.format(new Date())+fileName.substring(fileName.lastIndexOf('.'));
	        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
	        fos.write(artImg.getBytes());
	        fos.flush();
	        fos.close();
	        return  "upload/"+onlyFileName;
	    }

</body>
</html>