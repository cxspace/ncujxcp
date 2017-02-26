<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
 <base href="">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="${pageContext.request.contextPath}/common/css/back.css" rel="stylesheet" type="text/css" />

<title>

南昌大学本科教学审核评估网

</title>
<!-- 验证脚本开始-->
<script src="${pageContext.request.contextPath}/common/js/login.js" type="text/javascript"></script>
</head>

<body style="background:#fff;">
<div class="login_title">
<!--<img src="images/login_title.jpg" width="840" height="120" />-->
<h1><!--基础学科拔尖学生培养试验计划-->

<!--南昌大学本科教学审核评估网后台管理登录-->

</h1>


</div>


<div class="login_bg">
<form method="post" action="${pageContext.request.contextPath}/sys_user_login.action">

<div class="login">
<div class=form-item>
<img src="${pageContext.request.contextPath}/common/images/uer.png" width="58" height="50" />
<div class=item-tip>账号</div><input class="form-input" type="text" name="user.account" /> </div>
<div class=form-item>
<img src="${pageContext.request.contextPath}/common/images/password.png" width="58" height="50" />
<div class=item-tip>密码</div><input class="form-input" name="user.password" type="password"  /> </div>
<div class=form-item>


    <font color="red">
        <s:property value="errorMessage"></s:property>
    </font>


</div>
<input type="submit" name="submit" class="login_btn" value="后 台 登 录" />
</div>
</form>
<script src="${pageContext.request.contextPath}/common/script/jquery-1.9.1.min.js" type="text/javascript"></script>
<script>
			$(".form-input").on("focus", function(e){
				var $this = $(this);
				var $tip = $this.prev();

				$tip.addClass("item-tip-focus");
				$tip.css("color","#66afe9");
			});
			$(".form-input").on("blur", function(e){
				var $this = $(this);
				var $tip = $this.prev();

				if ($this.val().trim() === "") {
					$tip.removeClass("item-tip-focus");
				}
				$tip.css("color","#ccc");
			});
			$(".item-tip").on("click", function(e){
				$(this).next().focus();
			});
		</script>
</div>
<div class="footer">
<p>版权所有©南昌大学南昌大学本科教学审核评估网

<!-- 丨<a href="#" target="_blank">返回首页</a> --></p>
</div>
</body>
</html>
