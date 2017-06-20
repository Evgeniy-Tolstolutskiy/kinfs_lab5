package nure.labs.db.jdbc;

import nure.labs.db.model.Pilot;

import java.util.List;

/**
 * Created by Евгений on 23.12.2016.
 */
public interface PilotDao {
    List<Pilot> selectPilots();

    boolean insertPilot(Pilot pilot);

    boolean updatePilot(int oldId, Pilot pilot);

    boolean deletePilot(int id);

    Pilot selectOldestPilotForModel(String model);
}
