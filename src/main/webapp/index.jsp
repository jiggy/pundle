<%@page contentType="text/html" isELIgnored="false" pageEncoding="UTF-8"%><%@
taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%@
taglib prefix="pnd" uri="pundle"
%><!DOCTYPE html>
<html>
<head>
<pnd:define name="bdn2" rel="stylesheet" combine="true" type="text/css" />
<pnd:add name="bdn2" href="https://raw.github.com/jiggy/pundle/master/src/main/webapp/css/styles.css" />
<pnd:add name="bdn2" href="css/styles2.css" />
<pnd:add name="bdn2" href="/css/styles.css" />
<pnd:add name="bdn2" href="//raw.github.com/jiggy/pundle/master/src/main/webapp/css/styles.css" />
<!--  flush -->
<pnd:flush name="bdn2" outfile="foo" />
</head>
<body>
<h2>Hello, World!</h2>
</body>
</html>
<%--

<p:def name="xyz" combine="true|false" minify="true|false" link-attribs... />
  This will initialize a Bundle object named "xyz" with all its
  link attribs and the combine/minify flags and add it to the request context
  
<p:add name="xyz" href="/path/to/resource" />
  fetch the file at the URL and if combine=true, add its bytes to the Bundle
  if combine=false, dump the link tag.
  
<p:flush name="xyz" />

--%>