﻿<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <title>数据列表页面</title>
    <!-- layui.css -->
    <link href="${pageContext.request.contextPath}/resources/lay/plugin/layui/css/layui.css" rel="stylesheet" />
    <style>
        .layui-btn-small {
            padding: 0 15px;
        }

        .layui-form-checkbox {
            margin: 0;
        }

        tr td:not(:nth-child(0)),
        tr th:not(:nth-child(0)) {
            text-align: center;
        }

        #dataConsole {
            text-align: center;
        }
        /*分页页容量样式*/
        /*可选*/
        .layui-laypage {
            display: block;
        }

            /*可选*/
            .layui-laypage > * {
                float: left;
            }
            /*可选*/
            .layui-laypage .laypage-extend-pagesize {
                float: right;
            }
            /*可选*/
            .layui-laypage:after {
                content: ".";
                display: block;
                height: 0;
                clear: both;
                visibility: hidden;
            }

            /*必须*/
            .layui-laypage .laypage-extend-pagesize {
                height: 30px;
                line-height: 30px;
                margin: 0px;
                border: none;
                font-weight: 400;
            }
        /*分页页容量样式END*/
    </style>
</head>
<body>
<input type="hidden" id="allpath" value="${pageContext.request.contextPath}"/>
    <fieldset id="dataConsole" class="layui-elem-field layui-field-title"  style="display:none;">
        <legend>控制台</legend>
        <div class="layui-field-box">
            <div id="articleIndexTop">
                <form id="blogfrom" class="layui-form layui-form-pane" action="${pageContext.request.contextPath}/user/list">
                    <div class="layui-form-item" style="margin:0;margin-top:15px;">
                            <input type="hidden" id="pageNum" name="pageNum" value="${page.pageNum}"/>
                            <input type="hidden" id="pages" name="pages" value="${page.pages}" />
                            <div class="layui-inline">
                                <label class="layui-form-label">分类</label>
                                <div class="layui-input-inline">
                                    <select name="blogType">
                                        <option value=''></option>
                                        <c:forEach items="${rlist}" var = "role">
                                            <option value="${role.roleId}" ${role.roleId eq userVo.roleId ? 'selected=\"selected\"' : ''}>${role.roleName}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                                <label class="layui-form-label">用户名</label>
                                <div class="layui-input-inline">
                                    <input type="text" name="blogName" autocomplete="off" class="layui-input" value="${userVo.userName}">
                                </div>
                                <div class="layui-input-inline" style="width:auto">
                                    <button class="layui-btn" lay-submit lay-filter="formSearch">搜索</button>
                                </div>
                            </div>
                        <div class="layui-inline">
                            <div class="layui-input-inline" style="width:auto">
                                <a id="toAddUser" class="layui-btn layui-btn-normal">新增用户</a>
                            </div>
                        </div>
                    </div>

                </form>
            </div>
        </div>
    </fieldset>
    <fieldset id="dataList" class="layui-elem-field layui-field-title sys-list-field" style="display:none;">
        <legend style="text-align:center;">用户列表</legend>
        <div class="layui-field-box">
            <div id="dataContent" class="">
                <!--内容区域 ajax获取-->
                <table style="" class="layui-table" lay-even="">
                    <colgroup>
                        <col width="180">
                        <col>
                        <col width="150">
                        <col width="180">
                        <col width="90">
                        <col width="90">
                        <col width="50">
                        <col width="50">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>创建时间</th>
                            <th>用户名</th>
                            <th>账号</th>
                            <th>角色</th>
                            <th>锁定</th>
                            <th colspan="2">选项</th>
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${page.list}" var = "user" varStatus="status">
                        <tr>
                            <td><fmt:formatDate value="${user.createDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                            <td>${user.userName}</td>
                            <td>${user.accountName}</td>
                            <td>${user.roleName}</td>
                            <td>
                                <form class="layui-form" action="">
                                    <div class="layui-form-item" style="margin:0;">
                                        <input type="checkbox" name="lock" lay-filter="lock" lay-skin="switch" lay-text="锁定|可用"  value="${user.userId}" ${user.locked == 0 ? 'checked' : ''}>
                                    </div>
                                </form>
                            </td>
                            <td>
                                <button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.userlist.editData(${user.userId})"><i class="layui-icon">&#xe642;</i></button>
                            </td>
                            <td>
                                <button class="layui-btn layui-btn-small layui-btn-danger" onclick="layui.userlist.deleteData(${user.userId})"><i class="layui-icon">&#xe640;</i></button>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div id="pageNav"></div>
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