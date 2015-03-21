package com.anli.busstation.dal.ejb2.test.traffic;

import com.anli.busstation.dal.ejb2.entities.geography.StationImpl;
import com.anli.busstation.dal.ejb2.entities.traffic.RideImpl;
import com.anli.busstation.dal.ejb2.entities.traffic.RouteImpl;
import com.anli.busstation.dal.ejb2.factories.Ejb2ProviderProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.traffic.Ride;
import com.anli.busstation.dal.interfaces.entities.traffic.Route;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class RouteTest extends com.anli.busstation.dal.sql.test.traffic.RouteTest {

    @Override
    protected Route getNewRoute(BigInteger id, String numCode,
            BigDecimal ticketPrice, List<BigInteger> routePoints, List<BigInteger> rides, boolean load) {
        RouteImpl route = new RouteImpl();
        route.setId(id);
        route.setNumCode(numCode);
        route.setTicketPrice(ticketPrice);
        route.setRoutePoints((List) getRoutePointsByIds(routePoints, load));
        route.setRides((List) getRidesByIds(rides, load));
        return route;
    }

    @Override
    protected void nullifyRoutePoints(Route route) {
        ((RouteImpl) route).setRoutePoints(null);
    }

    @Override
    protected void nullifyRides(Route route) {
        ((RouteImpl) route).setRides(null);
    }

    @Override
    protected void nullifyStationCollections(Station station) {
        StationImpl stationImpl = (StationImpl) station;
        stationImpl.setBuses(null);
        stationImpl.setEmployees(null);
    }

    @Override
    protected void nullifyRideCollections(Ride ride) {
        RideImpl rideImpl = (RideImpl) ride;
        rideImpl.setRidePoints(null);
        rideImpl.setRideRoads(null);
        rideImpl.setTickets(null);
    }

    @Override
    protected ProviderFactory getFactory() {
        return new Ejb2ProviderProxyFactory();
    }

    @Override
    protected void setEntityId(Route entity, BigInteger id) {
        ((RouteImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }

    @Override
    protected Route nullifyCollections(Route entity) {
        RouteImpl impl = (RouteImpl) entity;
        impl.setRoutePoints(null);
        impl.setRides(null);
        return impl;
    }
}
