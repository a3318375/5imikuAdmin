/*

@Name：不落阁后台模板源码 
@Author：Absolutely 
@Site：http://www.lyblogs.cn

*/

layui.define(['laypage', 'layer', 'form', 'pagesize','layedit','upload'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer,
        form = layui.form(),
        laypage = layui.laypage;
    var laypageId = 'pageNav';
    var allpath = $("#allpath").val();
    var layedit = layui.layedit;
    var index = layedit.build('demo'); //建立编辑器
    form.on('submit(addBlog)', function (data) {
        var htmls = layedit.getContent(index);
        $("#context").val(htmls);
        $("#myfrom").submit();
    });
    form.on('submit(addUser)', function (data) {
        $("#myfrom").submit();
    });
    layui.upload({
        url: allpath + '/uploadFile/cover'
        ,success: function(res){
            $("#articleCoverImg").attr("src", res.url);
            $("#blogCover").val(res.url);
        }
    });
    form.render('checkbox');
    $('#dataConsole,#dataList').attr('style', 'display:block'); //显示FiledBox
    var pages = $("#pages").val();
    var pageNum = $("#pageNum").val();
    laypage({
        cont: laypageId,
        pages: pages,
        groups: 8,
        skip: true,
        curr: pageNum,
        jump: function (obj, first) {
            if (!first) {
                $("#pageNum").val(obj.curr);
                var myform = $("#blogfrom");
                myform.submit();
            }
        }
    });
   //initilData(1, 8);
    //页数据初始化
    //currentIndex：当前也下标
    //pageSize：页容量（每页显示的条数）
    function initilData(currentIndex, pageSize) {
        var index = layer.load(1);
        //模拟数据
        var data = new Array();
        for (var i = 0; i < 30; i++) {
            data.push({ id: i + 1, time: '2017-3-26 15:56', title: '绮梦楼后台模板源码分享', author: 'Absolutely', category: 'Web前端' });
        }
        //模拟数据加载
        setTimeout(function () {
            layer.close(index);
            //计算总页数（一般由后台返回）
            pages = Math.ceil(data.length / pageSize);
            //模拟数据分页（实际上获取的数据已经经过分页）
            var skip = pageSize * (currentIndex - 1);
            var take = skip + Number(pageSize);
            data = data.slice(skip, take);
            var html = '';  //由于静态页面，所以只能作字符串拼接，实际使用一般是ajax请求服务器数据
            html += '<table style="" class="layui-table" lay-even>';
            html += '<colgroup><col width="180"><col><col width="150"><col width="180"><col width="90"><col width="90"><col width="50"><col width="50"></colgroup>';
            html += '<thead><tr><th>发表时间</th><th>标题</th><th>作者</th><th>类别</th><th colspan="2">选项</th><th colspan="2">操作</th></tr></thead>';
            html += '<tbody>';
            //遍历文章集合
            for (var i = 0; i < data.length; i++) {
                var item = data[i];
                html += "<tr>";
                html += "<td>" + item.time + "</td>";
                html += "<td>" + item.title + '[' + item.id + ']' + "</td>";
                html += "<td>" + item.author + "</td>";
                html += "<td>" + item.category + "</td>";
                html += '<td><form class="layui-form" action=""><div class="layui-form-item" style="margin:0;"><input type="checkbox" name="top" title="置顶" value="' + item.id + '" lay-filter="top" checked /></div></form></td>';
                html += '<td><form class="layui-form" action=""><div class="layui-form-item" style="margin:0;"><input type="checkbox" name="top" title="推荐" value="' + item.id + '" lay-filter="recommend" checked /></div></form></td>';
                html += '<td><button class="layui-btn layui-btn-small layui-btn-normal" onclick="layui.datalist.editData(\'' + item.id + '\')"><i class="layui-icon">&#xe642;</i></button></td>';
                html += '<td><button class="layui-btn layui-btn-small layui-btn-danger" onclick="layui.datalist.deleteData(\'' + item.id + '\')"><i class="layui-icon">&#xe640;</i></button></td>';
                html += "</tr>";
            }
            html += '</tbody>';
            html += '</table>';
            html += '<div id="' + laypageId + '"></div>';

            $('#dataContent').html(html);

            form.render('checkbox');  //重新渲染CheckBox，编辑和添加的时候
            $('#dataConsole,#dataList').attr('style', 'display:block'); //显示FiledBox

            laypage({
                cont: laypageId,
                pages: pages,
                groups: 8,
                skip: true,
                curr: currentIndex,
                jump: function (obj, first) {
                    var currentIndex = obj.curr;
                    if (!first) {
                        initilData(currentIndex, pageSize);
                    }
                }
            });
            //该模块是我定义的拓展laypage，增加设置页容量功能
            //laypageId:laypage对象的id同laypage({})里面的cont属性
            //pagesize当前页容量，用于显示当前页容量
            //callback用于设置pagesize确定按钮点击时的回掉函数，返回新的页容量
            layui.pagesize(laypageId, pageSize).callback(function (newPageSize) {
                //这里不能传当前页，因为改变页容量后，当前页很可能没有数据
                initilData(1, newPageSize);
            });
        }, 500);
    }

    //监听置顶CheckBox
    form.on('checkbox(top)', function (data) {
        var index = layer.load(1);
        var blogId = data.elem.value;
        var top;
        if(data.elem.checked){
            top = 0;
        }else{
            top = 1;
        }
        $.ajax({
            url: allpath + '/blog/updateTop',
            data:{
                blogId:blogId,
                top:top
            },
            success:function(data){
                if(data){
                    layer.close(index);
                    layer.msg('操作成功');
                }else{
                    data.elem.checked = false;
                    layer.msg('操作失败，返回原来状态');
                }
            },
            error:function(){
                data.elem.checked = false;
            }
        });
    });

    form.on('switch(lock)', function (data) {
        var index = layer.load(1);
        var userId = data.elem.value;
        var lock;
        if(data.elem.checked){
            lock = 0;
        }else{
            lock = 1;
        }
        $.ajax({
            url: allpath + '/user/updateLock',
            data:{
                userId:userId,
                lock:lock
            },
            success:function(data){
                if(data){
                    layer.close(index);
                    layer.msg('操作成功');
                }else{
                    data.elem.checked = false;
                    layer.msg('操作失败，返回原来状态');
                }
            },
            error:function(){
                data.elem.checked = false;
            }
        });
    });

    //监听推荐CheckBox
    form.on('checkbox(recommend)', function (data) {
        var index = layer.load(1);
        var blogId = data.elem.value;
        var recommend;
        if(data.elem.checked){
            recommend = 0;
        }else{
            recommend = 1;
        }
        $.ajax({
            url: allpath + '/blog/updateRecommend',
            data:{
                blogId:blogId,
                recommend:recommend
            },
            success:function(data){
                if(data){
                    layer.close(index);
                    layer.msg('操作成功');
                }else{
                    data.elem.checked = false;
                    layer.msg('操作失败，返回原来状态');
                }
            },
            error:function(){
                data.elem.checked = false;
            }
        });
    });
    //添加数据
    $('#addArticle').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            location.href = allpath + "/blog/addBlog"
        }, 500);
    });

    $('#toAddUser').click(function () {
        var index = layer.load(1);
        setTimeout(function () {
            layer.close(index);
            location.href = allpath + "/user/toAddUser"
        }, 500);
    });

    //输出接口，主要是两个函数，一个删除一个编辑
    var userlist = {
        deleteData: function (id) {
            layer.confirm('确定删除1？', {
                btn: ['确定', '取消'] //按钮
            }, function () {
                location.href =  allpath + '/user/delete?userId=' + id;
            });
        },
        editData: function (id) {
            location.href =  allpath + '/user/toUpdateUser?userId=' + id;
        }
    };


    exports('userlist', userlist);
});
function addAnnouncement() {
    var $ = layui.jquery;
    var index = layer.load(1);
    var allpath = $("#allpath").val();
    layer.close(index);
    var html = '<form class="layui-form" id="myform" action="' + allpath + '/notice/add">' +
        '<div class="layui-form-item"><label class="layui-form-label">内容</label><div class="layui-input-block">' +
        '<input type="hidden" name="context" id="context"><textarea id="demo" style="display: none;width: 538;"></textarea>' +
        '</div></div><div class="layui-form-item"><label class="layui-form-label">公告级别</label>' +
        '<div class="layui-input-block">' +
        '<input type="radio" name="level" value="1" title="普通" checked>' +
        '<input type="radio" name="level" value="2" title="一般">' +
        '<input type="radio" name="level" value="3" title="重要">' +
        '</div></div><div class="layui-form-item"><div class="layui-input-block">' +
        '<button class="layui-btn" lay-submit="" lay-filter="formAnnouncement">立即提交</button>' +
        '</div></div></form>' +
        '<script src="' + allpath + '/resources/lay/js/notice.js"></script>';
    parent.layer.open({
        type: 1,
        area: ['700px', '400px'],
        offset: '20vh',
        title: "发布公告",
        closeBtn: 1,
        shade: 0.6,
        scrollbar: false,
        shadeClose: false,
        skin: 'layer-css',
        content: html
    });
    parent.layui.form().render();
}
