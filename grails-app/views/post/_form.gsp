<%@ page import="gblog.Post" %>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="post.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" maxlength="140" required="" value="${postInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'content', 'error')} required">
	<label for="content">
		<g:message code="post.content.label" default="Content" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="content" required="" value="${postInstance?.content}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'author', 'error')} required">
	<label for="author">
		<g:message code="post.author.label" default="Author" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="author" required="" value="${postInstance?.author}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: postInstance, field: 'publishDate', 'error')} required">
	<label for="publishDate">
		<g:message code="post.publishDate.label" default="Publish Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="publishDate" precision="day"  value="${postInstance?.publishDate}"  />

</div>


