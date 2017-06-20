package nure.labs.service.impl;

import nure.labs.db.jdbc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Евгений on 23.12.2016.
 */
@Component
public class ApplicationService {
    @Autowired
    PriceListDao priceListDao;
    @Autowired
    AircraftDao aircraftDao;
    @Autowired
    BookingDao bookingDao;
    @Autowired
    PilotDao pilotDao;
    @Autowired
    RouteDao routeDao;
    @Autowired
    ScheduleDao scheduleDao;
}
