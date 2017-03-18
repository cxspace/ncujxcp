<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: liujie
  Date: 2017/2/23
  Time: 下午4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<!-- html之后到</title>==begin -->

<meta name="renderer" content="webkit">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />



<base href="">
<head>
  <title>

    南昌大学本科教学审核评估网
    
  </title>
  <!-- html之后到</title>==end -->
  <link href="${pageContext.request.contextPath}/common/css/style.css" rel="stylesheet" type="text/css" />
  <link href="${pageContext.request.contextPath}/common/css/basic.css" rel="stylesheet" type="text/css" />
  <%--<script src="${pageContext.request.contextPath}/common/script/jquery-1.9.1.min.js" type="text/javascript"></script>--%>
  <script src="${pageContext.request.contextPath}/common/script/jquery.slides.js" type="text/javascript"></script>

  <link href="${pageContext.request.contextPath}/common/css/jquery.slideBox.css" rel="stylesheet" type="text/css" />

  <script src="${pageContext.request.contextPath}/common/script/jquery-1.9.1.min.js" type="text/javascript"></script>

  <script src="${pageContext.request.contextPath}/common/js/jquery.slideBox.js" type="text/javascript"></script>

  <script>

      jQuery(function($){

          $('#box1').slideBox();

          $('#box2').slideBox();

      });

  </script>

</head>

<body>



<div class="header">
  <div class="logo"></div>
</div>


<div class="topline">
  <div class="login"><a href="${pageContext.request.contextPath}/sys_user_loginUI.action" target="_blank"></a></div>
</div>

<div class="nav">

  <ul>
    <%--<li><a href="${pageContext.request.contextPath}/"> << </a></li>--%>
    <li><a href="${pageContext.request.contextPath}/zzjg.html">
      组织机构
    </a></li>
    <li><a href="${pageContext.request.contextPath}/front_inform_infoList.action">
    通知公告
    </a></li>
    <li><a href="${pageContext.request.contextPath}/front_dynamic_dynamicList.action">评估动态</a></li>
    <li><a href="${pageContext.request.contextPath}/front_policy_policyList.action">政策文件</a></li>
    <li><a href="${pageContext.request.contextPath}/front_assessment_assessmentList.action">学院评建</a></li>
    <li><a href="${pageContext.request.contextPath}/front_advice_adviceList.action">他山之石</a></li>
    <li><a href="${pageContext.request.contextPath}/front_document_documentList.action">资料下载</a></li>
    <li><a href="${pageContext.request.contextPath}/">状态数据</a></li>

  </ul>
</div>


<div class="content">


  <%--第一个轮播开始--%>
  <div class="slide_content">

    <div id="box1" class="slideBox">

      <ul class="items">

        <li><a><img src="${pageContext.request.contextPath}/common/images/title_01.jpg" style="width:1280px;height:220px" ></a></li>

        <li><a><img src="${pageContext.request.contextPath}/common/images/title_02.jpg" style="width:1280px;height:220px"></a></li>

        <li><a><img src="${pageContext.request.contextPath}/common/images/title_03.jpg" style="width:1280px;height:220px"></a></li>


      </ul>

    </div>
  </div>

    <%--第一个轮播结束--%>


    <%--新闻和评估动态开始--%>


    <div class="content_one_two">

    <div class="one">

        <div style="margin-right: 15px">


          <div id="box2" class="slideBox1">

          <ul class="items">

          <s:iterator value="newsList" status="st">
          <li><a title="<s:property value="title"></s:property>" href="${pageContext.request.contextPath}/front_news_news_detail.action?news.id=<s:property value="id"></s:property>"><img src="${pageContext.request.contextPath}/<s:property value="img"></s:property>" style="width: 100%;height: 300px"></a></li>
          </s:iterator>

          </ul>
          </div>

          <br/>



          </div>
      </div>



    <div class="two">

    <div style="margin-left: 15px;padding-top: 0px">


      <%--评估动态--%>

        <h5><a class="more" href="${pageContext.request.contextPath}/front_dynamic_dynamicList.action">更多 >></a>评估动态</h5>
        <br>

        <s:iterator value="dynamicList" status="st">

        <li>
        <span><s:property value="time"></s:property></span> &nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/front_dynamic_dynamic_detail.action?dynamic.id=<s:property value="id"></s:property>">

          <s:if test="title.length()>24">
            <s:property value='title.substring(0,24)'/>...
          </s:if>
          <s:else>
            <s:property value='title'/>
          </s:else>

        </a>
        </li>

        <br/>

        </s:iterator>



        </div>


    </div>

    </div>


    <div class="content_one_one_one">

      <div class="one_three">

        <div style="margin-right: 15px">

        <h5><a class="more" href="${pageContext.request.contextPath}/front_inform_infoList.action">更多 >></a> 通知公告</h5>

        <br/>

        <s:iterator value="infoList" status="st">


        <li>
        <%--<span><s:property value="time"></s:property></span> --%>
          &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/front_inform_info_detail.action?info.id=<s:property value="id"></s:property>">

        <s:if test="title.length()>22">
        <s:property value='title.substring(0,22)'/>...
        </s:if>
        <s:else>
        <s:property value='title'/>
        </s:else>

        </a>

        </li>

        <%--<br/>--%>


        </s:iterator>




        </div>

      </div>

      <div class="one_three">

        <h5>
        <a class="more" href="${pageContext.request.contextPath}/front_assessment_assessmentList.action">更多 >></a>
        学院评建
        </h5>
        <br/>

        <s:iterator value="assessmentList" status="st">

        <li>

        <%--<span><s:property value="time"></s:property></span> &nbsp;&nbsp;&nbsp;--%>

          <a href="${pageContext.request.contextPath}/front_assessment_assessment_detail.action?assessment.id=<s:property value="id"></s:property>">
        <s:if test="title.length()>22">
        <s:property value='title.substring(0,22)'/>...
        </s:if>
        <s:else>
        <s:property value='title'/>
        </s:else>
        </a>
        </li>
        <%--<br/>--%>


        </s:iterator>


      </div>

      <div class="one_three">
        <div style="margin-left: 15px">


        <h5>
        <a class="more" href="${pageContext.request.contextPath}/front_document_documentList.action">更多 >></a>
        资料下载</h5>
        <br>

        <s:iterator value="documentList" status="st">
        <li>
        &nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/<s:property value="link"></s:property>">

          <s:if test="title.length()>22">
            <s:property value='title.substring(0,22)'/>...
          </s:if>
          <s:else>
            <s:property value='title'/>
          </s:else>
        </a>

        </li>
        <%--<br/>--%>
        </s:iterator>


        </div>
      </div>


    </div>

</div>



<div class="links">
  <ul>
    <li><a href="http://www.moe.gov.cn" target="_blank"><img src="${pageContext.request.contextPath}/common/images/link01.jpg" style="height: 60px" /></a></li>
    <li><a href="http://www.pgzx.edu.cn" target="_blank"><img src="${pageContext.request.contextPath}/common/images/link02.jpg" style="height: 60px"/></a></li>
    <li><a href="http://www.ncu.edu.cn" target="_blank"><img src="${pageContext.request.contextPath}/common/images/ncu-logo.png" style="height: 60px"/></a></li>
    <li><a href="http://jwc.ncu.edu.cn" target="_blank"><img src="${pageContext.request.contextPath}/common/images/ncu-jwc.PNG" style="height: 60px"/></a></li>
    <li><a href="http://dpb.ncu.edu.cn" target="_blank"><img src="${pageContext.request.contextPath}/common/images/ncu-ddb.PNG" style="height: 60px"/></a></li>
  </ul>
</div>


<div class="footer">


  <p>南昌大学 版权所有</p>

  <p>南昌大学审核评估办公室联系方式:079183968568,079183968162</p>
  <p>Copyright &copy; 2016 南昌大学信息工程学院. </p>

</div>

</body>
</html>
