package nure.labs.db.jdbc.impl;

import nure.labs.db.jdbc.RouteDao;
import nure.labs.db.model.Route;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Евгений on 23.12.2016.
 */
@Component
public class RouteDaoImpl extends JdbcDao implements RouteDao {
    @Override
    public Route selectRouteByFromAndTo(String from, String to) {
        String sql = "select id from Routs where \"from\"=? and \"to\"=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{from, to}, (rs, rowNum) -> {
            int id = rs.getInt("id");
            return new Route(id, from, to);
        });
    }

    @Override
    public List<Route> selectRoutes() {
        List<Route> routes = new ArrayList<>();
        String sql = "select * from Routs";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            int id = ((java.math.BigDecimal) row.get("id")).intValue();
            String from = (String) row.get("from");
            String to = (String) row.get("to");
            routes.add(new Route(id, from, to));
        }
        return routes;
    }

    @Override
    public boolean insertRoute(Route route) {
        String sql = "call insert_rout(?, ?)";
        jdbcTemplate.update(sql, route.getFrom(), route.getTo());
        return true;
    }

    @Override
    public boolean updateRoute(int oldId, Route route) {
        String sql = "update Routs set id=?, \"from\"=?, \"to\"=? where id=?";
        jdbcTemplate.update(sql, route.getId(), route.getFrom(), route.getTo(), oldId);
        return true;
    }

    @Override
    public boolean deleteRoute(int id) {
        String sql = "delete from Routs where id=?";
        jdbcTemplate.update(sql, id);
        return true;
    }
}
