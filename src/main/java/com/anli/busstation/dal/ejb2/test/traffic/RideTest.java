package com.anli.busstation.dal.ejb2.test.traffic;

import com.anli.busstation.dal.ejb2.entities.geography.StationImpl;
import com.anli.busstation.dal.ejb2.entities.traffic.RideImpl;
import com.anli.busstation.dal.ejb2.test.Ejb2ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.traffic.Ride;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigInteger;
import java.util.List;

public class RideTest extends com.anli.busstation.dal.sql.test.traffic.RideTest {

    @Override
    protected Ride getNewRide(BigInteger id, BigInteger busId, List<BigInteger> ridePoints,
            List<BigInteger> rideRoads, List<BigInteger> tickets, boolean load) {
        RideImpl ride = new RideImpl();
        ride.setId(id);
        ride.setBus(getBusById(busId, load));
        ride.setRidePoints((List) getRidePointsByIds(ridePoints, load));
        ride.setRideRoads((List) getRideRoadsByIds(rideRoads, load));
        ride.setTickets((List) getTicketsByIds(tickets, load));
        return ride;
    }

    @Override
    protected void nullifyRidePoints(Ride ride) {
        ((RideImpl) ride).setRidePoints(null);
    }

    @Override
    protected void nullifyRideRoads(Ride ride) {
        ((RideImpl) ride).setRideRoads(null);
    }

    @Override
    protected void nullifyTickets(Ride ride) {
        ((RideImpl) ride).setTickets(null);
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

    @Override
    protected Ride nullifyCollections(Ride ride) {
        RideImpl rideImpl = (RideImpl) ride;
        rideImpl.setRidePoints(null);
        rideImpl.setRideRoads(null);
        rideImpl.setTickets(null);
        return rideImpl;
    }
}
