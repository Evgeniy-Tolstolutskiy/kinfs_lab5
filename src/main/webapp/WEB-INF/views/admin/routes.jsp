<!DOCTYPE html>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:wrapper homePage="/admin/login">
        <table class="table">
            <thead>
                <tr>
                    <th class="table_heading">Id</th>
                    <th class="table_heading">Model</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${routes}" var="route">
                    <tr class='table_row'>
                        <form action="/admin/routes/update" method="post">
                            <input type="hidden" name="oldId" value="${route.id}"/>
                            <td class="table_cell">Id: <input type="text" name="newId" value="${route.id}"></input></td>
                            <td class="table_cell">From: <input type="text" name="from" value="${route.from}"></input></td>
                            <td class="table_cell">To: <input type="text" name="to" value="${route.to}"></input></td>
                            <td class="table_cell">
                                <input type="submit" class="btn btn-success button" value="update"></input>
                            </td>
                        </form>
                        <td class="table_cell">
                            <form action="/admin/routes/delete" method="post" >
                                <input type="hidden" name="id" value="${route.id}"/>
                                <input type="submit" value="delete" class="btn btn-success button"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr class='table_row'>
                    <form action="/admin/routes/insert" method="post">
                        <td class="table_cell">From: <input type="text" name="from"></input></td>
                        <td class="table_cell">To: <input type="text" name="to"></input></td>
                        <td class="table_cell">
                            <input type="submit" value="insert" class="btn btn-success button"/>
                        </td>
                    </form>
                </tr>
            </tbody>
        </table>
</t:wrapper>