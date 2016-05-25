
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>

    <meta name="layout" content="common">
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'style.css')}" type="text/css">
    <title>Posts</title>
</head>

<body>
    <div class="post">
        <h1 class="title">
            ${post.title}
        </h1>
        <p class="post-content">${post.content}</p>
        <p>${post.author} - <i>${post.publishDate.format('yyyy-MM-dd')}</i></p>
        <h2>Comments:</h2>
        <hr>
    </div>
    <div class="comments">
        <g:each in="${post.comments}">
            <div class="comment">
                <p class="author"><i>name:</i> ${it.author}</p>
                <p class="comment-content"><i>comment:</i> <i>${it.content}</i></p>
                <hr>
            </div>
        </g:each>
    </div>
<div class="add-comment">
    <g:form action="comment" id="${post.id}">
        <input type="text" name="author" placeholder="Enter your name"/>
        <br>
        <br>
        <g:textArea name="content" placeholder="Leave your comment here"/>
        <g:submitButton name="submit" value="Send"/>
    </g:form>
</div>
</body>
</html>