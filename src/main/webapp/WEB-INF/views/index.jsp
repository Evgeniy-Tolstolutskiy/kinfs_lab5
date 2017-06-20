<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:wrapper homePage="/">
    <table class="table">
        <thead>
            <tr>
                <th class="table_heading">Aircraft</th>
                <th class="table_heading">Pilots</th>
                <th class="table_heading">From</th>
                <th class="table_heading">To</th>
                <th class="table_heading">Date</th>
                <th class="table_heading">Seat number</th>
                <th class="table_heading">The oldest pilot for model</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${schedule}" var="scheduleItem">
            <jsp:useBean id="dateObject" class="java.util.Date" />
            <jsp:setProperty name="dateObject" property="time" value="${scheduleItem.getDate()}" />
            <form action="/passengerInfo" method="get">
                <input type="hidden" name="aircraftName" value="${scheduleItem.getAircraftName()}"/>
                <input type="hidden" name="pilotList" value="${scheduleItem.getPilotList()}"/>
                <input type="hidden" name="from" value="${scheduleItem.getFrom()}"/>
                <input type="hidden" name="to" value="${scheduleItem.getTo()}"/>
                <input type="hidden" name="date" value="${scheduleItem.getDate()}"/>
                <tr class='table_row'>
                    <td class="table_cell">${scheduleItem.getAircraftName()}</td>
                    <td class="table_cell">${scheduleItem.getPilotList()}</td>
                    <td class="table_cell">${scheduleItem.getFrom()}</td>
                    <td class="table_cell">${scheduleItem.getTo()}</td>
                    <td class="table_cell"><fmt:formatDate value="${dateObject}" pattern="MM/dd/yyyy"/></td>
                    <td class="table_cell">
                         <select name="seatClass">
                          <option value="classA">A</option>
                          <option value="classB">B</option>
                          <option value="classC">C</option>
                        </select>
                    </td>
                    <td class="table_cell">${oldestPilots.get(scheduleItem.getAircraftName()).getName()},
                        ${oldestPilots.get(scheduleItem.getAircraftName()).getAge()}</td>
                    <td class="table_cell">
                        <input type="submit" value="book ticket" class="btn btn-success button"></input>
                    </td>
                </tr>
                </form>
            </c:forEach>
        </tbody>
    </table>
</t:wrapper>