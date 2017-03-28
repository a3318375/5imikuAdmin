<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>不落阁后台管理系统</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/lay/images/Logo_40.png" type="image/x-icon">
    <!-- layui.css -->
    <link href="${pageContext.request.contextPath}/resources/lay/plugin/layui/css/layui.css" rel="stylesheet" />
    <!-- 本页样式 -->
    <link href="${pageContext.request.contextPath}/resources/lay/css/index.css" rel="stylesheet" />
</head>
<body>
    <div class="mask"></div>
    <div class="main">
        <h1><span style="font-size: 84px;">B</span><span style="font-size:30px;">log</span></h1>
        <p id="time"></p>
        <div class="enter">
            Please&nbsp;&nbsp;Click&nbsp;&nbsp;Enter
        </div>
    </div>
    <!-- layui.js -->
    <script src="${pageContext.request.contextPath}/resources/lay/plugin/layui/layui.js"></script>
    <!-- layui规范化用法 -->
    <script type="text/javascript">
        layui.config({
            base: '${pageContext.request.contextPath}/resources/lay/js/'
        }).use('index');
    </script>
    <script src="//captcha.luosimao.com/static/dist/api.js"></script>
</body>
</html>