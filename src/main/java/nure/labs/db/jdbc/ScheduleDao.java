package nure.labs.db.jdbc;

import nure.labs.db.model.ScheduleItem;
import nure.labs.service.pojo.PrettyScheduleItem;

import java.util.List;

/**
 * Created by Евгений on 23.12.2016.
 */
public interface ScheduleDao {
    List<ScheduleItem> selectSchedule();

    List<PrettyScheduleItem> selectPrettySchedule();

    ScheduleItem selectScheduleByAircraftIdAndRouteId(int aircraftId, int routeId);

    boolean insertScheduleItem(ScheduleItem scheduleItem);

    boolean updateScheduleItem(int oldId, ScheduleItem scheduleItem);

    boolean deleteScheduleItem(int id);
}
