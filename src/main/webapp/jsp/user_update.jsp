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
    <link href="${pageContext.request.contextPath}/resources/lay/css/main.css" rel="stylesheet" />
</head>
<body>
<input type="hidden" id="allpath" value="${pageContext.request.contextPath}"/>
    <fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field" style="display:none;">
        <legend style="text-align:center;">文章列表</legend>
        <div class="layui-field-box">
            <div id="dataContent" class="">
                <form class="layui-form form-main" id="myfrom" action="${pageContext.request.contextPath}/user/add">
                    <div class="layui-form-item">
                        <label class="layui-form-label">昵称</label>
                        <div class="layui-input-block">
                            <input type="text" name="userName" required="" value="${user.userName}" lay-verify="required" placeholder="请输入昵称" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-block">
                            <input type="password" name="password" value="${user.password}" lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <label class="layui-form-label">权限</label>
                        <div class="layui-input-block">
                            <select name="roleId" lay-verify="required">
                                <option value="0">请选择</option>
                                <c:forEach items="${rlist}" var = "role">
                                    <option value="${role.roleId}" ${role.roleId eq user.password ? 'selected=\"selected\"' : ''}>${role.roleName}</option>
                                </c:forEach>
                            </select><div class="layui-unselect layui-form-select"><div class="layui-select-title">
                            <input type="text" placeholder="请选择" value="" readonly="" class="layui-input layui-unselect"><i class="layui-edge"></i></div><dl class="layui-anim layui-anim-upbit"><dd lay-value="LY02212035178403" class="">ASP.NET MVC</dd><dd lay-value="LY02212035194645" class="">SQL Server</dd><dd lay-value="LY02212035203846" class="">Entity Framework</dd><dd lay-value="LY02212035218423" class="">Web前端</dd><dd lay-value="LY02212035253489" class="">C#基础</dd><dd lay-value="LY02282245013546" class="">杂文随笔</dd></dl></div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn site-demo-layedit" lay-submit data-type="content" lay-filter="addUser">立即提交</button>
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
        }).use('userlist');
    </script>
</body>
</html>