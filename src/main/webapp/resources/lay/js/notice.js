//@ sourceURL=announcement-add.js
layui.use(['layedit', 'form'], function () {
    var layedit = layui.layedit;
    var $ = layui.jquery;
    var form = layui.form();
    var editIndex = layedit.build('demo', {
        tool: ['strong', 'italic', 'underline', 'del', '|', 'left', 'center', 'right', 'link', 'unlink', 'face'],
        height: '150px'
    }); //建立编辑器

    //自定义验证规则
    form.verify({
        demo: function (value) {
            value = $.trim(layedit.getText(editIndex));
            if (value == "") return "自少得有一个字吧";
            layedit.sync(editIndex);
        }
    });

    //监听添加提交
    form.on('submit(formAnnouncement)', function () {
        var htmls = layedit.getContent(editIndex);
        $('#context').val(htmls);
        $("#myform").submit();
    });
});