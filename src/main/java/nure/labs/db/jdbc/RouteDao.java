package nure.labs.db.jdbc;

import nure.labs.db.model.Route;

import java.util.List;

/**
 * Created by Евгений on 23.12.2016.
 */
public interface RouteDao {
    Route selectRouteByFromAndTo(String from, String to);

    List<Route> selectRoutes();

    boolean insertRoute(Route route);

    boolean updateRoute(int oldId, Route route);

    boolean deleteRoute(int id);
}
