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
    <!-- 特效 -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/index/css/normalize.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/index/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/index/css/demo.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/index/css/component.css" />
</head>
<body>
    <input type="hidden" id="allpath" value="${pageContext.request.contextPath}"/>
    <%--<div class="mask"></div>
    <div class="main">
        <h1><span style="font-size: 84px;">B</span><span style="font-size:30px;">log</span></h1>
        <p id="time"></p>
        <div class="enter">
            Please&nbsp;&nbsp;Click&nbsp;&nbsp;Enter
        </div>
    </div>--%>

    <div class="container demo-1">
        <div class="content">
            <div id="large-header" class="large-header">

                <div style="position:absolute;left: 540px; top:300px;"  class="time" id="time" data-hours="" data-minutes="">
                    <div class="digit">
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                    </div>
                    <div class="digit">
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                    </div>
                    <div class="digit">
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                    </div>
                    <div class="digit">
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                    </div>
                    <div class="digit">
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                    </div>
                    <div class="digit">
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                        <div class="line"></div>
                    </div>
                </div>
                <canvas  id="demo-canvas"></canvas>
            </div>
        </div>
    </div>
    <script src="${pageContext.request.contextPath}/resources/index/js/TweenLite.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/index/js/EasePack.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/index/js/rAF.js"></script>
    <script src="${pageContext.request.contextPath}/resources/index/js/demo-1.js"></script>

    <script src='${pageContext.request.contextPath}/resources/index/js/Rx.min.js'></script>
    <script src='${pageContext.request.contextPath}/resources/index/js/rxcss.min.js'></script>
    <script src="${pageContext.request.contextPath}/resources/index/js/index.js"></script>
    <!-- layui.js -->
    <script src="${pageContext.request.contextPath}/resources/lay/plugin/layui/layui.js"></script>
    <!-- layui规范化用法 -->
    <script type="text/javascript">
        layui.config({
            base: '${pageContext.request.contextPath}/resources/lay/js/'
        }).use('index');
    </script>
</body>
</html>