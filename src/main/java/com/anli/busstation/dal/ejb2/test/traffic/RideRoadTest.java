package com.anli.busstation.dal.ejb2.test.traffic;

import com.anli.busstation.dal.ejb2.entities.geography.StationImpl;
import com.anli.busstation.dal.ejb2.entities.traffic.RideRoadImpl;
import com.anli.busstation.dal.ejb2.test.Ejb2ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.traffic.RideRoad;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigInteger;

public class RideRoadTest extends com.anli.busstation.dal.sql.test.traffic.RideRoadTest {

    @Override
    protected RideRoad getNewRideRoad(BigInteger id, BigInteger driverId, BigInteger roadId, boolean load) {
        RideRoadImpl road = new RideRoadImpl();
        road.setId(id);
        road.setDriver(getDriverById(driverId, load));
        road.setRoad(getRoadById(roadId, load));
        return road;
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
