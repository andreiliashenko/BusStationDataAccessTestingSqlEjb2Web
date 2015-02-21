package com.anli.busstation.dal.ejb2.test.geography;

import com.anli.busstation.dal.ejb2.entities.geography.RegionImpl;
import com.anli.busstation.dal.ejb2.entities.geography.StationImpl;
import com.anli.busstation.dal.ejb2.factories.ProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.geography.Region;
import com.anli.busstation.dal.interfaces.entities.geography.Station;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigInteger;
import java.util.List;

public class RegionTest extends com.anli.busstation.dal.sql.test.geography.RegionTest {

    @Override
    protected Region getNewRegion(BigInteger id, Integer code, String name, List<BigInteger> stationList, boolean load) {
        RegionImpl region = new RegionImpl();
        region.setId(id);
        region.setCode(code);
        region.setName(name);
        region.setStations((List) getStationsByIds(stationList, load));
        return region;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new ProxyFactory();
    }

    @Override
    protected void setEntityId(Region entity, BigInteger id) {
        ((RegionImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }

    @Override
    protected Region nullifyCollections(Region entity) {
        RegionImpl region = (RegionImpl) entity;
        region.setStations(null);
        return region;
    }

    @Override
    protected void nullifyStationCollections(Station station) {
        StationImpl stationImpl = (StationImpl) station;
        stationImpl.setBuses(null);
        stationImpl.setEmployees(null);
    }
}
