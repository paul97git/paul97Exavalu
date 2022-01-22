<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <style type="text/css">
            .button-Submit {background-color: green;color: white;}
            .button-report {background-color: #000000;color: white;margin-left: 30%;}
        </style>
    </head>
    <body>
        <h2>Add your Product</h2>
         <a href="reportproduct"><button class="button-report" type="button">Report</button></a>
        <s:form action="registerProduct.action" method="post">
           <s:textfield label="ProductName" name="productName" />
            <s:textfield label="ProductMake" name="productMake" />
            <s:textfield label="Price" name="price" />
            <s:textfield label="Availability" name="availability" />
            
            <s:submit cssClass="button-register" value="Register-Product" />
        </s:form>
        <s:if test="ctr>0">
            <span style="color: green;"><s:property value="msg" /></span>
        </s:if>
        <s:else>
            <span style="color: red;"><s:property value="msg" /></span>
        </s:else>
    </body>
</html>