<%@page import="com.jwt.model.BookStore"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="http://www.decorplanit.com/plugin/autoNumeric-1.9.18.js"></script>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  
<script>
  $( function() {
    $( "#datepicker" ).datepicker();
  } );
  </script>
  
  <script type='text/javascript'>
    $(function($) {
      $('#txtNumber').autoNumeric('init', {  lZero: 'deny', aSep: ',', mDec: 0 });    
    });  
  </script>
  
<title>New/Edit Contact</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Movie</h1>
        <form:form action="saveMovie" method="post" modelAttribute="Movie">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Movie Name:</td>
                <td><form:input path="movieName"  pattern="([A-Za-z0-9\s]){2,200}"/></td>
            </tr>
            <tr>
                <td>Rating:</td>
                <td><form:input path="rating" maxlength="200"/></td>
            </tr>
            <tr>
                <td>Director Name:</td>
                <td><form:input path="directorName" maxlength="200"/></td>
            </tr>
             <tr>
                <td>Producer Name:</td>
                <td><form:input path="producerName" maxlength="200"/></td>
            </tr>
             <tr>
                <td>Lead Hero:</td>
                <td><form:input path="heroName" maxlength="200"/></td>
            </tr>
            <tr>
                <td>Lead Heroine:</td>
                <td><form:input path="heroineName" maxlength="200"/></td>
            </tr>
            <tr>
                <td>Release Date:</td>
                <td><form:input path="releaseDate" id="datepicker"/></td>
            </tr>
            <tr>
                <td>Movie Collection:</td>
                <td><form:input path="collection" id="txtNumber" /></td>
            </tr>
            <tr>
            <td>Image Upload:</td>
            <td> <img id="img1" height="100" width="100"  src="data:image/jpeg;base64,${Movie.imgData}">   </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
    </div>
    <script>
    
 // this example uses the id selector & no options passed    
  jQuery(function($) {
      $('#someID_defaults').autoNumeric('init');
      $(document).ready(function() {
    	  
      });
  });
</script>




<div>
<%-- <div align="left">Image: <%=.getBlob("ProdImage")+"\t" %></div> --%>
</div>
</body>
</html>