<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>数据列表页面</title>
    <!-- layui.css -->
    <link href="${pageContext.request.contextPath}/resources/lay/plugin/layui/css/layui.css" rel="stylesheet" />
</head>
<body>
<input type="hidden" id="allpath" value="${pageContext.request.contextPath}"/>
    <fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field" style="display:none;">
        <legend style="text-align:center;">文章列表</legend>
        <div class="layui-field-box">
            <div id="dataContent" class="">
                <form class="layui-form form-main" id="myfrom" action="${pageContext.request.contextPath}/blog/saveBlog">
                    <div class="layui-form-item">
                        <label class="layui-form-label">标题</label>
                        <div class="layui-input-block">
                            <input type="text" name="blogName" required="" lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">摘要</label>
                        <div class="layui-input-block">
                            <input type="text" name="blogAbstract" lay-verify="required" placeholder="请输入摘要" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">分类</label>
                        <div class="layui-input-block">
                            <select name="blogType" lay-verify="required">
                                <c:forEach items="${tlist}" var = "type">
                                    <option value="${type.typeId}" ${type.typeId eq blogVo.blogType ? 'selected=\"selected\"' : ''}>${type.typeName}</option>
                                </c:forEach>
                            </select><div class="layui-unselect layui-form-select"><div class="layui-select-title">
                            <input type="text" placeholder="请选择" value="" readonly="" class="layui-input layui-unselect"><i class="layui-edge"></i></div><dl class="layui-anim layui-anim-upbit"><dd lay-value="LY02212035178403" class="">ASP.NET MVC</dd><dd lay-value="LY02212035194645" class="">SQL Server</dd><dd lay-value="LY02212035203846" class="">Entity Framework</dd><dd lay-value="LY02212035218423" class="">Web前端</dd><dd lay-value="LY02212035253489" class="">C#基础</dd><dd lay-value="LY02282245013546" class="">杂文随笔</dd></dl></div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">作者</label>
                        <div class="layui-input-block">
                            <input type="text" name="blogAuthor" lay-verify="required" placeholder="请输入作者" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item layui-form-text">
                        <label class="layui-form-label">文本域</label>
                        <div class="layui-input-block">
                            <!--编辑器-->
                            <input type="hidden" name="context" id="context">
                            <textarea id="demo" style="display: none;"></textarea>
                        </div>
                    </div>
                    <div class="layui-form-item" style="position:relative;">
                        <label class="layui-form-label">封面</label>
                        <div class="layui-input-inline">
                            <input name="blogCover" type="hidden" id="blogCover">
                            <img id="articleCoverImg" class="img-cover" src="${pageContext.request.contextPath}/resources/lay/images/Logo_40.png" alt="封面">
                        </div>
                        <div class="layui-input-inline" style="position:absolute;bottom:0;">
                            <div class="layui-box layui-upload-button">
                                <form target="layui-upload-iframe" method="post" key="set-mine" enctype="multipart/form-data" action="/uploadFile/cover">
                                    <input id="articleCoverInput" type="file" name="myFileName" class="layui-upload-file" lay-title="点击上传" lay-ext="jpg|png|bmp"></form>
                                <span class="layui-upload-icon"><i class="layui-icon"></i>点击上传</span>
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn site-demo-layedit" lay-submit data-type="content" lay-filter="addBlog">立即提交</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </fieldset>
    <!-- layui.js -->
    <script src="${pageContext.request.contextPath}/resources/lay/plugin/layui/layui.js"></script>
    <!-- layui规范化用法 -->
    <script type="text/javascript">
        layui.config({
            base: '${pageContext.request.contextPath}/resources/lay/js/'
        }).use('datalist');
    </script>
</body>
</html>