<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>单图片上传</title>
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript">
		windows.onload=function(){
			alert("hello mvc")
			
		}
	</script>

</head>
<body>
	<fieldset>
		<legend>图片上传</legend>
		<h2>只能上传单张10M以下的 PNG、JPG、GIF 格式的图片</h2>
		<form action="${pageContext.request.contextPath}/photoUpload" method="post" enctype="multipart/form-data">
		    选择文件:<input type="file" name="file">   
			<input type="button" id="btnClick" value="上传">
		    <div id="preview"></div>
		</form>
	</fieldset>

<script>
    $("#btnClick").click(function () {
        var formData = new FormData();
        formData.append("username", $("#username").val());
        formData.append("file", $("#userface")[0].files[0]);
        $.ajax({
            url: '/fileupload',
            type: 'post',
            data: formData,
            processData: false,
            contentType: false,
            success: function (msg) {
                alert(msg);
            }
        });
    });
    function preview(file) {
        var prevDiv = document.getElementById('preview');
        if (file.files && file.files[0]) {
            var reader = new FileReader();
            reader.onload = function (evt) {
                prevDiv.innerHTML = '<img src="' + evt.target.result + '" />';
            }
            reader.readAsDataURL(file.files[0]);
        } else {
            prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';
        }
    }
</script>




</body>
</html>