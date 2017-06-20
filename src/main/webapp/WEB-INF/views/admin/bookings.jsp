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
                <c:forEach items="${bookings}" var="booking">
                    <tr class='table_row'>
                        <form action="/admin/bookings/update" method="post">
                            <input type="hidden" name="oldId" value="${booking.id}"/>
                            <td class="table_cell">Id: <input type="text" name="newId" value="${booking.id}"></input></td>
                            <td class="table_cell">Schedule id: <input type="text" name="scheduleId" value="${booking.scheduleId}"></input></td>
                            <td class="table_cell">Seat number: <input type="text" name="seatNumber" value="${booking.seatNumber}"></input></td>
                            <td class="table_cell">Cost: <input type="text" name="cost" value="${booking.cost}"></input></td>
                            <td class="table_cell">
                                <input type="submit" class="btn btn-success button" value="update"></input>
                            </td>
                        </form>
                        <td class="table_cell">
                            <form action="/admin/bookings/delete" method="post" >
                                <input type="hidden" name="id" value="${booking.id}"/>
                                <input type="submit" value="delete" class="btn btn-success button"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr class='table_row'>
                    <form action="/admin/bookings/insert" method="post">
                        <td class="table_cell">Schedule id: <input type="text" name="scheduleId"></input></td>
                        <td class="table_cell">Seat number: <input type="text" name="seatNumber"></input></td>
                        <td class="table_cell">Cost: <input type="text" name="cost"></input></td>
                        <td class="table_cell">
                            <input type="submit" value="insert" class="btn btn-success button"/>
                        </td>
                    </form>
                </tr>
            </tbody>
        </table>
	</t:wrapper>