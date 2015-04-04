package com.anli.busstation.dal.ejb2.test.traffic;

import com.anli.busstation.dal.ejb2.entities.geography.StationImpl;
import com.anli.busstation.dal.ejb2.entities.traffic.RidePointImpl;
import com.anli.busstation.dal.ejb2.test.Ejb2ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.traffic.RidePoint;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class RidePointTest extends com.anli.busstation.dal.sql.test.traffic.RidePointTest {

    @Override
    protected RidePoint getNewRidePoint(BigInteger id, DateTime arrivalTime, DateTime departureTime,
            BigInteger routePointId, boolean load) {
        RidePointImpl ridePoint = new RidePointImpl();
        ridePoint.setId(id);
        ridePoint.setArrivalTime(arrivalTime);
        ridePoint.setDepartureTime(departureTime);
        ridePoint.setRoutePoint(getRoutePointById(routePointId, load));
        return ridePoint;
    }

    @Override
    protected void nullifyStationCollections(Station station) {
        StationImpl stationImpl = (StationImpl) station;
        stationImpl.setBuses(null);
        stationImpl.setEmployees(null);
    }

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb2ModuleAccessor();
    }
}
