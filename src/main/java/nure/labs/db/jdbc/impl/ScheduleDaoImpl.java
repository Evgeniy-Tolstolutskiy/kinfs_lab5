package nure.labs.db.jdbc.impl;

import nure.labs.db.jdbc.ScheduleDao;
import nure.labs.db.model.ScheduleItem;
import nure.labs.service.pojo.PrettyScheduleItem;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Евгений on 23.12.2016.
 */
@Component
public class ScheduleDaoImpl extends JdbcDao implements ScheduleDao {
    @Override
    public List<ScheduleItem> selectSchedule() {
        List<ScheduleItem> schedule = new ArrayList<>();
        String sql = "select * from Scedule";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            int id = ((java.math.BigDecimal) row.get("id")).intValue();
            int aircraftId = ((java.math.BigDecimal) row.get("aircraftId")).intValue();
            int routeId = ((java.math.BigDecimal) row.get("routId")).intValue();
            Date date = new Date(((java.sql.Timestamp) row.get("date")).getTime());
            schedule.add(new ScheduleItem(id, aircraftId, routeId, date.getTime()));
        }
        return schedule;
    }

    @Override
    public List<PrettyScheduleItem> selectPrettySchedule() {
        List<PrettyScheduleItem> prettySchedule = new ArrayList<>();
        String sql = "select * from result";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            String aircraftName = (String) row.get("aircraft");
            String pilotNames = (String) row.get("pilots");
            String from = (String) row.get("from");
            String to = (String) row.get("to");
            Date date = new Date(((java.sql.Timestamp) row.get("date")).getTime());
            prettySchedule.add(new PrettyScheduleItem(aircraftName, pilotNames, from, to, date.getTime()));
        }
        return prettySchedule;
    }

    @Override
    public ScheduleItem selectScheduleByAircraftIdAndRouteId(int aircraftId, int routeId) {
        String sql = "select * from Scedule where aircraftId=? and routId=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{aircraftId, routeId}, (rs, rowNum) -> {
            int id = rs.getInt("id");
            Date date = rs.getDate("date");
            return new ScheduleItem(id, aircraftId, routeId, date.getTime());
        });
    }

    @Override
    public boolean insertScheduleItem(ScheduleItem scheduleItem) {
        String sql = "call insert_scedule(?, ?, ?)";
        jdbcTemplate.update(sql, scheduleItem.getAircraftId(), scheduleItem.getRouteId(), new Date(scheduleItem.getDate()));
        return true;
    }

    @Override
    public boolean updateScheduleItem(int oldId, ScheduleItem scheduleItem) {
        String sql = "update Scedule set id=?, aircraftId=?, routId=?, \"date\"=? where id=?";
        jdbcTemplate.update(sql, scheduleItem.getId(), scheduleItem.getAircraftId(), scheduleItem.getRouteId(),
                new Date(scheduleItem.getDate()), oldId);
        return true;
    }

    @Override
    public boolean deleteScheduleItem(int id) {
        String sql = "delete from Scedule where id=?";
        jdbcTemplate.update(sql, id);
        return true;
    }
}
