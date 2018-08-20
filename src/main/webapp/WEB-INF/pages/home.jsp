<%@page import="com.jwt.service.BookStoreService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.jwt.model.BookStore"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
  
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://www.decorplanit.com/plugin/autoNumeric-1.9.18.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/rateYo/2.3.2/jquery.rateyo.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link
	href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css"
	rel="stylesheet" />



<title>Book Catalog</title>
<style>
	.rating {
    float:left;
}

/* :not(:checked) is a filter, so that browsers that don’t support :checked don’t 
   follow these rules. Every browser that supports :checked also supports :not(), so
   it doesn’t make the test unnecessarily selective */
.rating:not(:checked) > input {
    position:absolute;
    top:-9999px;
    clip:rect(0,0,0,0);
}

.rating:not(:checked) > label {
    float:right;
    width:1em;
    padding:0 .1em;
    overflow:hidden;
    white-space:nowrap;
    cursor:pointer;
    font-size:200%;
    line-height:1.2;
    color:#ddd;
    text-shadow:1px 1px #bbb, 2px 2px #666, .1em .1em .2em rgba(0,0,0,.5);
}

.rating:not(:checked) > label:before {
    content: '★ ';
}

.rating > input:checked ~ label {
    color: #f70;
    text-shadow:1px 1px #c60, 2px 2px #940, .1em .1em .2em rgba(0,0,0,.5);
}

.rating:not(:checked) > label:hover,
.rating:not(:checked) > label:hover ~ label {
    color: gold;
    text-shadow:1px 1px goldenrod, 2px 2px #B57340, .1em .1em .2em rgba(0,0,0,.5);
}

.rating > input:checked + label:hover,
.rating > input:checked + label:hover ~ label,
.rating > input:checked ~ label:hover,
.rating > input:checked ~ label:hover ~ label,
.rating > label:hover ~ input:checked ~ label {
    color: #ea0;
    text-shadow:1px 1px goldenrod, 2px 2px #B57340, .1em .1em .2em rgba(0,0,0,.5);
}

.rating > label:active {
    position:relative;
    top:2px;
    left:2px;
}
	</style>
</head>

<body>

	<div align="center" style="overflow: scroll;">
		<h1>Book Catalog</h1>
		<div>
			<h1>New/Edit Book</h1>
			<form:form action="saveBook" method="post" modelAttribute="Book" enctype="multipart/form-data">
				<table>
					<form:hidden path="id" />
					<tr>
						<td>Book Name:</td>
						<td><form:input path="bookName" pattern="([A-Za-z0-9\s]){2,200}" /></td>
					</tr>
					<tr>
						<td>Author Name:</td>
						<td><form:input path="author"  maxlength="200"/></td>
					</tr>
					<tr>
						<td>Publisher Name:</td>
						<td><form:input path="publisher"   maxlength="200"/></td>
					</tr>
					
					<tr>
						<td>Release Date:</td>
						<td><form:input path="releaseDate" id="datepicker"/></td>
					</tr>
					<tr>
					
						<td>Book Collection:</td>
						<td><form:input path="collection"  placeholder="$" id="txtNumber" /> </td>
						<td>Collection should be in $</td>
						
					</tr>
					
					<tr>
						<td colspan="2" align="center"><input type="submit"
							value="Save"></td>
					</tr>
				</table>
			</form:form>
		</div>
		<div>

         
		</div>
		<div>
			<table id="example" class="display" width="100%"></table>
		</div>
		<div>
			<h4>
				New Book Register <a href="home">here</a>
			</h4>
		</div>

	</div>
	
</body>
</html>