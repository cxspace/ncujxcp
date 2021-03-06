<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="description" content="Neon Admin Panel" />
    <meta name="author" content="" />

    <title>后台管理</title>

    <%
        if (session.getAttribute("USER_INFO")==null){

            response.sendRedirect("sys_user_loginUI.action");
        }
    %>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/js/jquery-ui/css/no-theme/jquery-ui-1.10.3.custom.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/font-icons/entypo/css/entypo.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/neon-core.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/neon-theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/neon-forms.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/custom.css">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/skins/white.css">

    <script src="${pageContext.request.contextPath}/assets/js/jquery-1.11.0.min.js"></script>
    <script>$.noConflict();</script>


    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/assets/js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/assets/js/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath}/assets/js/ueditor/lang/zh-cn/zh-cn.js"></script>

    <script>
        window.UEDITOR_HOME_URL = "${pageContext.request.contextPath}/assets/js/ueditor/";
        var ue = UE.getEditor('editor');
    </script>

    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->


</head>

<body class="page-body  page-fade">

<div class="page-container"><!-- add class "sidebar-collapsed" to close sidebar by default, "chat-visible" to make chat appear always -->

    <div class="sidebar-menu">

        <div class="sidebar-menu-inner">

            <header class="logo-env">

                <!-- logo -->
                <div class="logo">
                    <a href="${pageContext.request.contextPath}/home_index.action">
                        <img src="${pageContext.request.contextPath}/assets/images/logo/LOGO.png" width="120" alt="" />
                    </a>
                </div>

                <!-- logo collapse icon -->
                <div class="sidebar-collapse">
                    <a href="#" class="sidebar-collapse-icon"><!-- add class "with-animation" if you want sidebar to have animation during expanding/collapsing transition -->
                        <i class="entypo-menu"></i>
                    </a>
                </div>


                <!-- open/close menu icon (do not remove if you want to enable menu on mobile devices) -->
                <div class="sidebar-mobile-menu visible-xs">
                    <a href="#" class="with-animation"><!-- add class "with-animation" to support animation -->
                        <i class="entypo-menu"></i>
                    </a>
                </div>

            </header>


            <ul id="main-menu" class="main-menu">
                <!-- add class "multiple-expanded" to allow multiple submenus to open -->
                <!-- class "auto-inherit-active-class" will automatically add "active" class for parent elements who are marked already with class "active" -->
                <li>
                    <a>
                        <i class="entypo-tools"></i>
                        <span class="title">系统管理</span>
                    </a>
                    <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/sys_inform_listUI.action">
                                <span class="title">通知公告管理</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/sys_informDoc_info_list.action">
                                <span class="title">通知公告附件管理</span>
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/sys_policy_listUI.action">
                                <span class="title">政策文件管理</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/sys_policyDoc_policy_list.action">
                                <span class="title">政策文件附件管理</span>
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/sys_dynamic_listUI.action">
                                <span class="title">评估动态管理</span>
                            </a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/sys_dynamicDoc_dynamic_list.action">
                                <span class="title">评估动态附件管理</span>
                            </a>
                        </li>


                        <li>
                            <a href="${pageContext.request.contextPath}/sys_assessment_listUI.action">
                                <span class="title">学校自评管理</span>
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/sys_assessmentDoc_assessment_list.action">
                                <span class="title">学校自评附件管理</span>
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/sys_advice_listUI.action">
                                <span class="title">它山之石管理</span>
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/sys_adviceDoc_advice_list.action">
                                <span class="title">它山之石附件管理</span>
                            </a>
                        </li>


                        <li>
                            <a href="${pageContext.request.contextPath}/sys_document_listUI.action">
                                <span class="title">资料管理</span>
                            </a>
                        </li>

                        <li>
                            <a href="${pageContext.request.contextPath}/sys_news_listUI.action">
                                <span class="title">主页新闻管理</span>
                            </a>
                        </li>



                    </ul>
                </li>


            </ul>

        </div>

    </div>

    <div class="main-content">

        <div class="row">

            <!-- Profile Info and Notifications -->
            <div class="col-md-6 col-sm-8 clearfix">

                <ul class="user-info pull-left pull-none-xsm">

                    <!-- Profile Info -->
                    <li class="profile-info dropdown"><!-- add class "pull-right" if you want to place this from right -->

                    </li>

                </ul>

            </div>


            <!-- Raw Links -->
            <div class="col-md-6 col-sm-4 clearfix hidden-xs">

                <ul class="list-inline links-list pull-right">


                    <li>
                        <a href="${pageContext.request.contextPath}/sys_user_loginOut.action">
                            注销 <i class="entypo-logout right"></i>
                        </a>
                    </li>
                </ul>

            </div>

        </div>

        <script type="text/javascript">
            jQuery(document).ready(function($) {
                // Sample Toastr Notification
                setTimeout(function () {
                    var opts = {
                        "closeButton": true,
                        "debug": false,
                        "positionClass": rtl() || public_vars.$pageContainer.hasClass('right-sidebar') ? "toast-top-left" : "toast-top-right",
                        "toastClass": "black",
                        "onclick": null,
                        "showDuration": "300",
                        "hideDuration": "1000",
                        "timeOut": "5000",
                        "extendedTimeOut": "1000",
                        "showEasing": "swing",
                        "hideEasing": "linear",
                        "showMethod": "fadeIn",
                        "hideMethod": "fadeOut"
                    };


                }, 3000);


            });

        </script>

        <hr />


        <script type="text/javascript">
            // Code used to add Todo Tasks
            jQuery(document).ready(function($)
            {
                var $todo_tasks = $("#todo_tasks");

                $todo_tasks.find('input[type="text"]').on('keydown', function(ev)
                {
                    if(ev.keyCode == 13)
                    {
                        ev.preventDefault();

                        if($.trim($(this).val()).length)
                        {
                            var $todo_entry = $('<li><div class="checkbox checkbox-replace color-white"><input type="checkbox" /><label>'+$(this).val()+'</label></div></li>');
                            $(this).val('');

                            $todo_entry.appendTo($todo_tasks.find('.todo-list'));
                            $todo_entry.hide().slideDown('fast');
                            replaceCheckboxes();
                        }
                    }
                });
            });
        </script>


        <ol class="breadcrumb bc-3" >


            <li>
                <a>系统管理</a>
            </li>


            <li>
                <a>政策文件管理</a>
            </li>
            <li class="active">

                <strong>新增</strong>
            </li>
        </ol>

        <h3>新增政策文件</h3>


        <form role="form" class="form-horizontal form-groups-bordered" method="post" action="${pageContext.request.contextPath}/sys_policy_edit.action">

            <div class="form-group">
                <label for="field-1" class="col-sm-3 control-label">政策文件标题</label>

                <div class="col-sm-5">
                    <input type="text" name="policy.title" value="<s:property value="policy.title"></s:property>" class="form-control" id="field-1" placeholder="请输入政策文件标题">
                </div>
            </div>

            <br>

            <label class="control-label">政策文件内容</label>

            <br><br>

            <textarea  name="policy.content"  id="editor" style="width: 100%;height: 360px;">
                <s:property value="policy.content"></s:property>
            </textarea>

            <br>
            <br>

            <hr>

            <s:hidden value="%{policy.id}" name="policy.id"></s:hidden>

            <s:hidden value="%{policy.time}" name="policy.time"></s:hidden>

            <s:hidden value="%{policy.count}" name="policy.count"></s:hidden>


            <div class="form-group">

                <div class="col-sm-offset-5 col-sm-5">

                    <button onclick="javascript:history.go(-1)" class="btn btn-default">返回</button>

                    <button type="submit" class="btn btn-default">提交</button>


                </div>
            </div>



        </form>





        <br>
        <br>
        <br>
        <br>
        <br>
        <br>


        <br>
        <br>
        <br>
        <br>


        <!-- Footer -->
        <footer class="main">

            &copy; 2016 <strong>PowerBy</strong>  <a href="http://github.com/cxspace" target="_blank">cxspace</a>

        </footer>
    </div>



</div>







<!-- Bottom scripts (common) -->
<script src="${pageContext.request.contextPath}/assets/js/gsap/main-gsap.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/jquery-ui/js/jquery-ui-1.10.3.minimal.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/joinable.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/resizeable.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/neon-api.js"></script>
<!--<script src="../assets/js/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>-->

<script src="${pageContext.request.contextPath}/assets/js/bootstrap-datepicker.js"></script>

<!-- Imported scripts on this page -->
<script src="${pageContext.request.contextPath}/assets/js/jquery.sparkline.min.js"></script>

<script src="${pageContext.request.contextPath}/assets/js/raphael-min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/morris.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/toastr.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/neon-chat.js"></script>


<!-- JavaScripts initializations and stuff -->
<script src="${pageContext.request.contextPath}/assets/js/neon-custom.js"></script>


<!-- Demo Settings -->
<script src="${pageContext.request.contextPath}/assets/js/neon-demo.js"></script>

</body>
</html>