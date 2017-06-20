<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
                <c:forEach items="${schedule}" var="scheduleItem">
                    <jsp:useBean id="dateObject" class="java.util.Date" />
                    <jsp:setProperty name="dateObject" property="time" value="${scheduleItem.date}" />

                    <tr class='table_row'>
                        <form action="/admin/schedule/update" method="post">
                            <input type="hidden" name="oldId" value="${scheduleItem.id}"/>
                            <td class="table_cell">Id: <input type="text" name="newId" value="${scheduleItem.id}"></input></td>
                            <td class="table_cell">Aircraft id: <input type="text" name="aircraftId" value="${scheduleItem.aircraftId}"></input></td>
                            <td class="table_cell">Route id: <input type="text" name="routeId" value="${scheduleItem.routeId}"></input></td>
                            <td class="table_cell">Date: <input type="date" name="date" value=<fmt:formatDate value="${dateObject}" pattern="MM/dd/yyyy"/>/></td>
                            <td class="table_cell">
                                <input type="submit" class="btn btn-success button" value="update"></input>
                            </td>
                        </form>
                        <td class="table_cell">
                            <form action="/admin/schedule/delete" method="post" >
                                <input type="hidden" name="id" value="${scheduleItem.id}"/>
                                <input type="submit" value="delete" class="btn btn-success button"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr class='table_row'>
                    <form action="/admin/schedule/insert" method="post">
                        <td class="table_cell">Aircraft id: <input type="text" name="aircraftId"></input></td>
                        <td class="table_cell">Route id: <input type="text" name="routeId"></input></td>
                        <td class="table_cell"><input type="date" name="date"/></td>
                        <td class="table_cell">
                            <input type="submit" value="insert" class="btn btn-success button"/>
                        </td>
                    </form>
                </tr>
            </tbody>
        </table>
</t:wrapper>