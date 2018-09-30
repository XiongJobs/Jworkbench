<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,java.io.*,java.util.*" %>
<%@ page import="jdbc.*,bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
	boolean logined = false;
	String adminLogined = (String)session.getAttribute("adminLogined");
	if(adminLogined != null && adminLogined.trim().equals("true")) {
		logined = true;
	} 
 %>

<%
	final int PAGE_SIZE = 5;
	int pageNo = 1;
	String strPageNo = request.getParameter("pageNo");
	if(strPageNo != null && !strPageNo.trim().equals("")) {
		try {
			pageNo = Integer.parseInt(strPageNo);
		} catch (NumberFormatException e) {
			pageNo = 1;
		} 
	}
	
	if(pageNo <= 0) pageNo = 1;
	
	int totalPages = 0;
	
	List<Article> articles = new ArrayList<Article>();
	Connection conn = MysqlConector.getConnection();
	
	Statement stmtCount = MysqlConector.getStatement(conn);
	ResultSet rsCount = MysqlConector.getResult(stmtCount, "select count(*) from article where pid = 0");
	rsCount.next();
	int totalRecords = rsCount.getInt(1);
	
	totalPages = (totalRecords + PAGE_SIZE - 1)/PAGE_SIZE;
	
	if(pageNo > totalPages) pageNo = totalPages;
	
	Statement stmt = MysqlConector.getStatement(conn);
	int startPos = (pageNo-1) * PAGE_SIZE; 
	String sql = "select * from article where pid = 0 order by pdate desc limit " + startPos + "," + PAGE_SIZE ;
	System.out.println(sql);
	ResultSet rs = MysqlConector.getResult(stmt, sql);
	while(rs.next()) {
		Article a = new Article();
		a.initFromRs(rs);
		articles.add(a);
	}
	DBClose.close(rsCount);
	DBClose.close(stmtCount);
	
	DBClose.close(rs);
	DBClose.close(stmt);
	DBClose.close(conn);
%>

<html>
<head>
<title>Java语言*初级版</title>
<meta http-equiv="content-type" content="text/html; charset=utf8">
<link rel="stylesheet" type="text/css" href="images/style.css" title="Integrated Styles">
<script language="JavaScript" type="text/javascript" src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS" href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?forumID=20">
<script language="JavaScript" type="text/javascript" src="images/common.js"></script>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td width="40%"><img src="images/header-stretch.gif" alt="" border="0" height="57" width="100%">
     	</td>
      <td width="1%"><img src="images/header-right.gif" alt="" height="57" border="0"></td>
    </tr>
  </tbody>
</table>
<br>
<div id="jive-forumpage">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="98%"><p class="jive-breadcrumbs">论坛: Java语言*初级版
            (模仿)</p>
          <p class="jive-description"> 探讨Java语言基础知识,基本语法等 大家一起交流 共同提高！谢绝任何形式的广告 </p>
          </td>
      </tr>
    </tbody>
  </table>
  <div class="jive-buttons">
    <table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <td class="jive-icon"><a href="post.jsp"><img src="images/post-16x16.gif" alt="发表新主题" border="0" height="16" width="16"></a></td>
          <td class="jive-icon-label"><a id="jive-post-thread" href="post.jsp">发表新主题</a> <a href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;isBest=1"></a></td>
        </tr>
      </tbody>
    </table>
  </div>
  <br>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td><span class="nobreak"> 页: 
          第<%=pageNo %>页,共<%=totalPages %>>页 - <span class="jive-paginator"> [</span></span>
          
          <span class="nobreak"><span class="jive-paginator">
          <a href="articleFlat.jsp?pageNo=1">第一页</a></span></span>
          
          
          
          <span class="nobreak"><span class="jive-paginator">|</span></span>
          <span class="nobreak"><span class="jive-paginator">
          <a href="articleFlat.jsp?pageNo=<%=pageNo - 1 %>">上一页</a>
          </span></span>
          
         <span class="nobreak"><span class="jive-paginator">| </span></span>
         <span class="nobreak"><span class="jive-paginator">
         <a href="articleFlat.jsp?pageNo=<%=pageNo + 1 %>">下一页</a>
          |&nbsp; 
          <a href="articleFlat.jsp?pageNo=<%=totalPages %>">最末页</a> ] </span> </span> </td>
      </tr>
    </tbody>
  </table>
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="99%"><div class="jive-thread-list">
            <div class="jive-table">
              <table summary="List of threads" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                  <tr>
                    <th class="jive-first" colspan="3"> 主题 </th>
                    <th class="jive-author"> <nobr> 作者
                      &nbsp; </nobr> </th>
                    <th class="jive-view-count"> <nobr> 浏览
                      &nbsp; </nobr> </th>
                    <th class="jive-msg-count" nowrap="nowrap"> 回复 </th>
                    <th class="jive-last" nowrap="nowrap"> 最新帖子 </th>
                  </tr>
                </thead>
                <tbody>
                <%
                int lineNo = 0;
                for(Iterator<Article> it = articles.iterator(); it.hasNext(); ) {           
                	Article a = it.next();
  					String classStr = lineNo%2 == 0 ? "jive-even" : "jive-odd";
                %>
                  <tr class="<%=classStr %>">
                    <td class="jive-first" nowrap="nowrap" width="1%"><div class="jive-bullet"> <img src="images/read-16x16.gif" alt="已读" border="0" height="16" width="16">
                        <!-- div-->
                      </div></td>
                      
                    <td nowrap="nowrap" width="1%">
                    	<%
                    	String url = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
                    	url += request.getContextPath();
                    	url += request.getServletPath();
                    	url += request.getQueryString() == null ? "" : ("?" + request.getQueryString());
                    	System.out.println(url);
                    	//System.out.println(request.getRequestURI());
                    	//System.out.println(request.getRequestURL());
                    	 %>
                    	 <%-- <%if (logined) {%> --%>
                    	 	<a href="modify.jsp?id=<%=a.getId()%>">MOD</a>
                    	<%--	<a href="delete.jsp?id=<%=a.getId()%>&isLeaf=<%=a.isIsleaf()%>&pid=<%=a.getPid() %>&from=<%=url %>">DEL</a>
                    	  <%} %> --%>
                    </td>
                    
                    <td class="jive-thread-name" width="95%"><a id="jive-thread-1" href="articleDetailFlat.jsp?id=<%=a.getId() %>"><%=a.getTitle() %></a></td>
                    <td class="jive-author" nowrap="nowrap" width="1%"><span class=""> <a href="http://bbs.chinajavaworld.com/profile.jspa?userID=226030">bjsxt</a> </span></td>
                    <td class="jive-view-count" width="1%"> 10000</td>
                    <td class="jive-msg-count" width="1%"> 0</td>
                    <td class="jive-last" nowrap="nowrap" width="1%"><div class="jive-last-post"> <%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(a.getPdate()) %> <br>
                        by: <a href="http://bbs.chinajavaworld.com/thread.jspa?messageID=780182#780182" title="jingjiangjun" style="">bjsxt &#187;</a> </div></td>
                  </tr>
                 
                  <%
                  	lineNo++;
                  }
                  %>
                </tbody>
              </table>
            </div>
          </div>
          <div class="jive-legend"></div></td>
      </tr>
    </tbody>
  </table>
  <br>
  <br>
</div>
</body>
</html>