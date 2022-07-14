<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: jangsea-ung
  Date: 2022/07/14
  Time: 11:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //request, response는 사용가능(jsp 지원)
    MemberRepository memberRepository = MemberRepository.getInstance();
    System.out.println("JspClass.jsp_service_method");

    String username = request.getParameter("username");
    int age = Integer.parseInt(request.getParameter("age"));

    Member member = new Member(username, age);
    memberRepository.save(member);
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
    <li>id<%=member.getId()%></li>
    <li>username<%=member.getUsername()%></li>
    <li>age<%=member.getAge()%></li>
</ul>
<a href="/index.html">메 </a>
</body>
</html>
