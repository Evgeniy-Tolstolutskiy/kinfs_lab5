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
                <c:forEach items="${aircrafts}" var="aircraft">
                    <tr class='table_row'>
                        <form action="/admin/aircraft/update" method="post">
                            <input type="hidden" name="oldId" value="${aircraft.id}"/>
                            <td class="table_cell">Id: <input type="text" name="newId" value="${aircraft.id}"></input></td>
                            <td class="table_cell">Model: <input type="text" name="model" value="${aircraft.name}"></input></td>
                            <td class="table_cell">
                                <input type="submit" class="btn btn-success button" value="update"></input>
                            </td>
                        </form>
                        <td class="table_cell">
                            <form action="/admin/aircraft/delete" method="post" >
                                <input type="hidden" name="id" value="${aircraft.id}"/>
                                <input type="submit" value="delete" class="btn btn-success button"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr class='table_row'>
                    <form action="/admin/aircraft/insert" method="post">
                        <td class="table_cell">Model: <input type="text" name="model"></input></td>
                        <td class="table_cell">
                            <input type="submit" value="insert" class="btn btn-success button"/>
                        </td>
                    </form>
                </tr>
            </tbody>
        </table>
</t:wrapper>