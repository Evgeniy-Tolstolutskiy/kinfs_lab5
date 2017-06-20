package nure.labs.db.jdbc;

import nure.labs.db.model.Aircraft;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Евгений on 23.12.2016.
 */
public interface AircraftDao {
    Aircraft selectAircraftByNameAndPilot(String name, String firstPilot);

    List<Aircraft> selectAircrafts();

    boolean insertAircraft(Aircraft aircraft);

    boolean updateAircraft(int oldId, Aircraft aircraft);

    boolean deleteAircraft(int id);
}
