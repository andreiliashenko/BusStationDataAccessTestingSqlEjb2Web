package com.anli.busstation.dal.ejb2.test.traffic;

import com.anli.busstation.dal.ejb2.entities.geography.StationImpl;
import com.anli.busstation.dal.ejb2.entities.traffic.RoutePointImpl;
import com.anli.busstation.dal.ejb2.factories.ProviderProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.entities.traffic.RoutePoint;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigInteger;

public class RoutePointTest extends com.anli.busstation.dal.sql.test.traffic.RoutePointTest {

    @Override
    protected RoutePoint getNewRoutePoint(BigInteger id, BigInteger stationId, boolean load) {
        RoutePointImpl routePoint = new RoutePointImpl();
        routePoint.setId(id);
        routePoint.setStation(getStationById(stationId, load));
        return routePoint;
    }

    @Override
    protected void nullifyStationCollections(Station station) {
        StationImpl stationImpl = (StationImpl) station;
        stationImpl.setBuses(null);
        stationImpl.setEmployees(null);
    }

    @Override
    protected ProviderFactory getFactory() {
        return new ProviderProxyFactory();
    }

    @Override
    protected void setEntityId(RoutePoint entity, BigInteger id) {
        ((RoutePointImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }
}
