package nure.labs.db.jdbc.impl;

import nure.labs.db.jdbc.PilotDao;
import nure.labs.db.model.Pilot;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Евгений on 23.12.2016.
 */
@Component
public class PilotDaoImpl extends JdbcDao implements PilotDao {
    @Override
    public List<Pilot> selectPilots() {
        List<Pilot> pilots = new ArrayList<>();
        String sql = "select * from Pilots";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            int id = ((java.math.BigDecimal) row.get("id")).intValue();
            String name = (String) row.get("name");
            int age = ((java.math.BigDecimal) row.get("age")).intValue();
            int aircraftId = ((java.math.BigDecimal) row.get("aircraftId")).intValue();
            pilots.add(new Pilot(id, name, age, aircraftId));
        }
        return pilots;
    }

    @Override
    public boolean insertPilot(Pilot pilot) {
        String sql = "call insert_pilot(?, ?, ?)";
        jdbcTemplate.update(sql, pilot.getName(), pilot.getAge(), pilot.getAircraftId());
        return true;
    }

    @Override
    public boolean updatePilot(int oldId, Pilot pilot) {
        String sql = "update Pilots set id=?, name=?, age=?, aircraftId=? where id=?";
        jdbcTemplate.update(sql, pilot.getId(), pilot.getName(), pilot.getAge(), pilot.getAircraftId(), oldId);
        return true;
    }

    @Override
    public boolean deletePilot(int id) {
        String sql = "delete from Pilots where id=?";
        jdbcTemplate.update(sql, id);
        return true;
    }

    @Override
    public Pilot selectOldestPilotForModel(String model) {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withFunctionName("THE_OLDEST_PILOT_FOR_MODEL");
        String pilotName = simpleJdbcCall.executeFunction(String.class, model);
        String sql = "select * from Pilots where name = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{pilotName}, (rs, rowNum) -> {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int aircraftId = rs.getInt("aircraftId");
                return new Pilot(id, name, age, aircraftId);
            });
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }
}
