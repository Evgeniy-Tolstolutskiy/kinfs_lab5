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
                <c:forEach items="${pilots}" var="pilot">
                    <tr class='table_row'>
                        <form action="/admin/pilots/update" method="post">
                            <input type="hidden" name="oldId" value="${pilot.id}"/>
                            <td class="table_cell">Id: <input type="text" name="newId" value="${pilot.id}"></input></td>
                            <td class="table_cell">Name: <input type="text" name="name" value="${pilot.name}"></input></td>
                            <td class="table_cell">Age: <input type="text" name="age" value="${pilot.age}"></input></td>
                            <td class="table_cell">Aircraft id: <input type="text" name="aircraftId" value="${pilot.aircraftId}"></input></td>
                            <td class="table_cell">
                                <input type="submit" class="btn btn-success button" value="update"></input>
                            </td>
                        </form>
                        <td class="table_cell">
                            <form action="/admin/pilots/delete" method="post" >
                                <input type="hidden" name="id" value="${pilot.id}"/>
                                <input type="submit" value="delete" class="btn btn-success button"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr class='table_row'>
                    <form action="/admin/pilots/insert" method="post">
                        <td class="table_cell">Name: <input type="text" name="name"></input></td>
                        <td class="table_cell">Age: <input type="text" name="age"></input></td>
                        <td class="table_cell">Aircraft id: <input type="text" name="aircraftId"></input></td>
                        <td class="table_cell">
                            <input type="submit" value="insert" class="btn btn-success button"/>
                        </td>
                    </form>
                </tr>
            </tbody>
        </table>
</t:wrapper>