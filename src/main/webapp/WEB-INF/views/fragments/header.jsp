<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div id="header" class="bg3">
	<div id="top-banner">
		<div id="logo"></div>
		<div id="social-icons">
			<a href="http://stackoverflow.com/users/714969/kevin-bowersox" target="_blank"><img src="<c:url value="/resources/images/stackoverflow-48.png" />"/></a>
			<a href="https://github.com/kmb385" target="_blank"><img src="<c:url value="/resources/images/github-48.png" />"/></a>
			<a href="https://twitter.com/bowersox_kevin" target="_blank"><img src="<c:url value="/resources/images/twitter-48.png" />"/></a>
			<a href="https://www.linkedin.com/pub/kevin-bowersox/8/7b0/30/" target="_blank"><img src="<c:url value="/resources/images/linkedin-48.png" />"/></a>
		</div>
	</div>
	<div id="nav-menu" class="clearfix">
		<ul>
			<li class="font-large fg1"><a
				href="<c:url value="/blog/page/0"/>">Blog</a></li><li class="font-large fg1"><a href="<c:url value="/about/"/>">About</a></li><li class="font-large fg1"><a href="<c:url value="/resume/profile"/>">Resume</a></li><li id="login" class="font-large fg1"><a href="<c:url value="/login.jsp"/>">Admin</a></li>
		</ul>
	</div>
</div>
