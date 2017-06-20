<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:wrapper homePage="/">
	<form action="/bookTicket" method="post">
	<input type="hidden" name="aircraftName" value="${scheduleItem.getAircraftName()}"/>
     <input type="hidden" name="pilotList" value="${scheduleItem.getPilotList()}"/>
     <input type="hidden" name="from" value="${scheduleItem.getFrom()}"/>
     <input type="hidden" name="to" value="${scheduleItem.getTo()}"/>
     <input type="hidden" name="date" value="${scheduleItem.getDate()}"/>
     <input type="hidden" name="seatClass" value="${seatClass}"/>
        <table class="table">
            <tbody>

                <tr class='table_row'>
                    <td class="table_cell">FIO</td>
                    <td class="table_cell"><input type="text"/></td>
                </tr>
                <tr class='table_row'>
                    <td class="table_cell">Phone number</td>
                    <td class="table_cell"><input type="text"/></td>
                </tr>
                <tr class='table_row'>
                    <td class="table_cell">Passport</td>
                    <td class="table_cell"><input type="text"/></td>
                </tr>
                <tr class='table_row'>
                    <td class="table_cell">Seat number</td>
                    <td class="table_cell">
                        <select name="seatNumber">
                            <c:forEach begin="1" end="50" var="i">
                                <option value="${i}">${i}</option>
                            </c:forEach>
                        </select>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="book ticket" class="btn btn-success button"></input>
        </form>
</t:wrapper>