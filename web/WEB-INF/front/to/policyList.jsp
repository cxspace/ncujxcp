<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<!-- html之后到</title>==begin -->

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
<div class="header">
  <div class="logo"></div>
</div>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<div class="topline">
  <div class="login"><a href="${pageContext.request.contextPath}/../sys/admin.html" target="_blank"></a></div>
</div> 
<div class="nav">

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

  <div class="underline"></div>
</div>
<div class="content">
<div class="title">
<p>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />


政策文件


</p>

</div>
<ul class="list">

    <s:iterator value="pageResult.items" status="st">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

        <li>
            <a target="_parent"  href="${pageContext.request.contextPath}/front_policy_policy_detail.action?policy.id=<s:property value="id"></s:property>"><span><s:property value="time"></s:property></span><s:property value="title"></s:property></a>
        </li>

    </s:iterator>

</ul>

<div class="paging">

    <s:if test="pageResult.totalCount > 0">
        <ul class="pagination">

            <s:if test="pageResult.pageNo > 1">

                <li><a href="javascript:doGoPage(<s:property value="pageResult.pageNo-1"></s:property>)"><i class="entypo-left-open-mini"></i> 上一页</a></li>

            </s:if>

            &nbsp;&nbsp;&nbsp;&nbsp;

            <s:if test="pageResult.pageNo < pageResult.totalPageCount">


                <li><a href="javascript:doGoPage(<s:property value="pageResult.pageNo+1"></s:property>)"> 下一页<i class="entypo-right-open-mini"></i> </a></li>

            </s:if>
        </ul>


        <hr>

        <br/>
        <br/>

        总共 <s:property value="pageResult.totalCount"/>条记录

        &nbsp;&nbsp;&nbsp;&nbsp;

        当前<s:property value="pageResult.pageNo"/>页

        &nbsp;&nbsp;&nbsp;&nbsp;


        共<s:property value="pageResult.totalPageCount"></s:property>页


        &nbsp;&nbsp;&nbsp;&nbsp;

    </s:if>
    <s:else>暂无数据！</s:else>



<!--翻页开始-->
<form name="pageform" method="post" action="#"><!-- 因为session相互影响，如果没有下面的iframe长形slideshow就只需要：action="../EditorAction.do?dispatch=findPageResult&af=/bajian/findPageResultOk.jsp" -->


<script language="javascript">

    function doGoPage(pageNo) {
        document.forms[0].action = "${pageContext.request.contextPath}/front_policy_policyList.action?pageNo="+pageNo;
        document.forms[0].submit();
    }

</script>

  
</form>							 

</div>
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

<p>Copyright &copy; 2016 Peking University. All Rights Reserved</p>

</div>
</body>
</html>
