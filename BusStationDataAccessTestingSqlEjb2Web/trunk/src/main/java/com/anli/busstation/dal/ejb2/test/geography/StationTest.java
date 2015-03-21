package com.anli.busstation.dal.ejb2.test.geography;

import com.anli.busstation.dal.ejb2.entities.geography.StationImpl;
import com.anli.busstation.dal.ejb2.factories.ProviderProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class StationTest extends com.anli.busstation.dal.sql.test.geography.StationTest {

    @Override
    protected Station getNewStation(BigInteger id, BigDecimal latitude, BigDecimal longitude, String name,
            List<BigInteger> busList, List<BigInteger> employeeList, boolean load) {
        StationImpl station = new StationImpl();
        station.setId(id);
        station.setLatitude(latitude);
        station.setLongitude(longitude);
        station.setName(name);
        station.setBuses((List) getBusesByIds(busList, load));
        station.setEmployees((List) getEmployeesByIds(employeeList, load));
        return station;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new ProviderProxyFactory();
    }

    @Override
    protected void setEntityId(Station entity, BigInteger id) {
        ((StationImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }

    @Override
    protected Station nullifyCollections(Station entity) {
        StationImpl station = (StationImpl) entity;
        station.setBuses(null);
        station.setEmployees(null);
        return station;
    }

    @Override
    protected void nullifyBuses(Station station) {
        StationImpl stationImpl = (StationImpl) station;
        stationImpl.setBuses(null);
    }

    @Override
    protected void nullifyEmployees(Station station) {
        StationImpl stationImpl = (StationImpl) station;
        stationImpl.setEmployees(null);
    }
}
