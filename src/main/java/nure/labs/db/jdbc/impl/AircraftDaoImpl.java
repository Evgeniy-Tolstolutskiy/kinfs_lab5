package nure.labs.db.jdbc.impl;

import nure.labs.db.jdbc.AircraftDao;
import nure.labs.db.model.Aircraft;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Евгений on 23.12.2016.
 */
@Component
public class AircraftDaoImpl extends JdbcDao implements AircraftDao {
    private static final Logger LOGGER = Logger.getLogger(AircraftDaoImpl.class.getName());

    @Override
    public Aircraft selectAircraftByNameAndPilot(String name, String firstPilot) {
        String sql = "select a.* from Aircrafts a, Pilots p " +
                "where a.model=? and p.aircraftId=a.id and p.id=(select id from Pilots where name=?)";
        return jdbcTemplate.queryForObject(sql, new Object[]{name, firstPilot}, (rs, rowNum) -> {
            int id = rs.getInt("id");
            String model = rs.getString("model");
            return new Aircraft(id, model);
        });
    }

    @Override
    public List<Aircraft> selectAircrafts() {
        List<Aircraft> aircrafts = new ArrayList<>();
        String sql = "select * from Aircrafts";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            int id = ((java.math.BigDecimal) row.get("id")).intValue();
            String model = (String) row.get("model");
            aircrafts.add(new Aircraft(id, model));
        }
        return aircrafts;
    }

    @Override
    public boolean insertAircraft(Aircraft aircraft) {
        String sql = "call insert_aircraft(?)";
        try {
            jdbcTemplate.update(sql, aircraft.getName());
            return true;
        } catch (DataAccessException ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAircraft(int oldId, Aircraft aircraft) {
        String sql = "update Aircrafts set id=?, model=? where id=?";
        try {
            jdbcTemplate.update(sql, aircraft.getId(), aircraft.getName(), oldId);
            return true;
        } catch (DataAccessException ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAircraft(int id) {
        String sql = "delete from Aircrafts where id=?";
        try {
            jdbcTemplate.update(sql, id);
            return true;
        } catch (DataAccessException ex) {
            LOGGER.log(Level.WARNING, ex.getMessage());
            return false;
        }
    }
}
