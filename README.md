pundle
======

<%@taglib prefix="pnd" uri="pundle" %>
<pnd:define name="mybundle" combine="true" minify="true" rel="stylesheet" type="text/css" />
<pnd:add name="mybundle" href="/path/to/styles.css" />
<pnd:add name="mybundle" href="http://www.somehost.com/path/to/styles.css" />
<pnd:flush name="mybundle" />
