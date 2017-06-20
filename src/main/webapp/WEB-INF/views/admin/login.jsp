<!DOCTYPE html>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:wrapper homePage="/admin/login">
    <form action="login" method="post">
        <input type="text" name="login"/><br/>
        <input type="password" name="password"/><br/>
        <input type="submit" value="Log in"/>
    </form>
</t:wrapper>