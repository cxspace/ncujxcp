<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<META http-equiv=Content-Type content="text/html; charset=UTF-8">

 <base href="">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>

南昌大学本科教学审核评估网

</title>
<!-- html之后到</title>==end -->
<link href="${pageContext.request.contextPath}/common/css/basic.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath}/common/css/pages.css" rel="stylesheet" type="text/css" />
</head>

<body>
<div class="header_p">
  <div class="logo_p">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
 <ul>
     <li><a href="${pageContext.request.contextPath}/">首页</a></li>
     <li><a href="${pageContext.request.contextPath}/">组织机构</a></li>
     <li><a href="${pageContext.request.contextPath}/front_inform_infoList.action">通知公告</a></li>
     <li><a href="${pageContext.request.contextPath}/front_policy_policyList.action">政策文件</a></li>
     <li><a href="${pageContext.request.contextPath}/front_dynamic_dynamicList.action">评估动态</a></li>
     <li><a href="${pageContext.request.contextPath}/front_assessment_assessmentList.action">学校自评</a></li>
     <li><a href="${pageContext.request.contextPath}/front_advice_adviceList.action">他山之石</a></li>
     <li><a href="${pageContext.request.contextPath}/front_document_documentList.action">资料下载</a></li>
  </ul>
  </div>
</div>
<div class="clear"></div>
<div class="content_p">
<div class="title1"><a href="${pageContext.request.contextPath}/">首页</a>&nbsp;&gt;&nbsp;
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
			 
</div>
<div class="title2">
<h3><s:property value="advice.title"></s:property> </h3>
<span>浏览次数：<s:property value="advice.count"></s:property> </span>
</div>
<div class="main">

<p><s:property value="advice.content" escape="false"></s:property>
</p>

</h5>

    <p>附件列表:</p>


    <s:iterator value="adviceDocList" status="st">
        <p>
            <a href="${pageContext.request.contextPath}/<s:property value="link"></s:property>"> <s:property value="title"></s:property></a>

        </p>
    </s:iterator>


</div>
<div class="clear"></div>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<div class="links">
    <ul>
        <li><a href="http://www.moe.gov.cn" target="_blank"><img src="${pageContext.request.contextPath}/common/images/link01.jpg" /></a></li>
        <li><a href="http://www.pgzx.edu.cn/" target="_blank"><img src="${pageContext.request.contextPath}/common/images/link02.jpg" /></a></li>
        <li><a href="#" target="_blank"><img src="${pageContext.request.contextPath}/common/images/ncu-logo.png" /></a></li>
        <li><a href="http://jwc.ncu.edu.cn" target="_blank"><img src="${pageContext.request.contextPath}/common/images/ncu-jwc.PNG" /></a></li>
        <li><a href="http://dpb.ncu.edu.cn" target="_blank"><img src="${pageContext.request.contextPath}/common/images/ncu-ddb.PNG" /></a></li>
    </ul>
</div>
<div class="clear"></div>
    <div class="footer">


        <p>南昌大学 版权所有</p>

        <p>南昌大学审核评估办公室联系方式:079183968568,079183968162</p>
        <p>Copyright &copy; 2016 南昌大学信息工程学院. </p>



    </div>
</div>
</body>
</html>
