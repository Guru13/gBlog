
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="common">
    <title></title>
</head>

<body>
<g:each in="${posts}">
    <div class="post">
        <h1 class="title">
            <g:link action="showpost" id="${it.id}">
                ${it.title}
            </g:link>
         </h1>
        <p>${it.content}</p>
        <p>${it.author} - <i>${it.publishDate.format('yyyy-MM-dd')}</i></p>
    </div>
</g:each>
</body>
</html>