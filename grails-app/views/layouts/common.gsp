<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title><g:layoutTitle default="gBlog"/></title>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Ledger" rel="stylesheet" type="text/css">
    <g:layoutHead/>
    <r:layoutResources/>
</head>

<body>
    <div class="header">
        <div class="logo">
            <a href="/gBlog/post/list"><img src="${resource(dir: 'images', file: 'Smokes1.jpg')}" alt="Grails"/></a>
        </div>
        <h1>Welcome to Pandorium</h1>
    </div>
    <div class="container">
        <div class="content">
            <g:if test="${flash.error}">
                <div class="error">${flash.error}</div>
            </g:if>
            <g:if test="${flash.success}">
                <div class="success">${flash.success}</div>
            </g:if>
            <g:layoutBody/>

        </div>
        <div class="side">
            <ul class="side-shadow">
                <h2 class="menu-title">Grails Tutorals</h2>
                <g:each in="${posts}">
                    <li><a href="${createLink(controller: 'post', action: 'showpost', id: it.id)}">${it.title}</a> </li>
                </g:each>
            </ul>
        </div>
    </div>
<r:layoutResources />
</body>
</html>