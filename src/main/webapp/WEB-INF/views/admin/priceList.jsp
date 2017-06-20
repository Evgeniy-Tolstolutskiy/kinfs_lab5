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
                <c:forEach items="${priceList}" var="price">
                    <tr class='table_row'>
                        <form action="/admin/priceList/update" method="post">
                            <input type="hidden" name="oldId" value="${price.id}"/>
                            <td class="table_cell">Id: <input type="text" name="newId" value="${price.id}"></input></td>
                            <td class="table_cell">Aircraft id: <input type="text" name="aircraftId" value="${price.aircraftId}"></input></td>
                            <td class="table_cell">Class A: <input type="text" name="classAPrice" value="${price.classAPrice}"></input></td>
                            <td class="table_cell">Class B: <input type="text" name="classBPrice" value="${price.classBPrice}"></input></td>
                            <td class="table_cell">Class C: <input type="text" name="classCPrice" value="${price.classCPrice}"></input></td>
                            <td class="table_cell">
                                <input type="submit" class="btn btn-success button" value="update"></input>
                            </td>
                        </form>
                        <td class="table_cell">
                            <form action="/admin/priceList/delete" method="post" >
                                <input type="hidden" name="id" value="${price.id}"/>
                                <input type="submit" value="delete" class="btn btn-success button"/>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                <tr class='table_row'>
                    <form action="/admin/priceList/insert" method="post">
                        <td class="table_cell">Aircraft id: <input type="text" name="aircraftId"></input></td>
                        <td class="table_cell">Class A: <input type="text" name="classAPrice"></input></td>
                        <td class="table_cell">Class B: <input type="text" name="classBPrice"></input></td>
                        <td class="table_cell">Class C: <input type="text" name="classCPrice"></input></td>
                        <td class="table_cell">
                            <input type="submit" value="insert" class="btn btn-success button"/>
                        </td>
                    </form>
                </tr>
            </tbody>
        </table>
</t:wrapper>