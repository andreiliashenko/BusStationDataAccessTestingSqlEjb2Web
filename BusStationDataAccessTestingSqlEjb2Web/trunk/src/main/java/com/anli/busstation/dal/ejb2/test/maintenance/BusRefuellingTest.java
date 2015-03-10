package com.anli.busstation.dal.ejb2.test.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.BusRefuellingImpl;
import com.anli.busstation.dal.ejb2.factories.Ejb2ProviderProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.maintenance.BusRefuelling;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class BusRefuellingTest extends com.anli.busstation.dal.sql.test.maintenance.BusRefuellingTest {

    @Override
    protected BusRefuelling getNewRefuelling(BigInteger id, BigInteger mechanicId, DateTime beginTime,
            DateTime endTime, BigDecimal cost, BigInteger busId, Integer volume, boolean load) {
        BusRefuellingImpl busRefuelling = new BusRefuellingImpl();
        busRefuelling.setId(id);
        busRefuelling.setMechanic(getMechanicById(mechanicId, load));
        busRefuelling.setBeginTime(beginTime);
        busRefuelling.setEndTime(endTime);
        busRefuelling.setServiceCost(cost);
        busRefuelling.setBus(getBusById(busId, load));
        busRefuelling.setVolume(volume);
        return busRefuelling;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new Ejb2ProviderProxyFactory();
    }

    @Override
    protected void setEntityId(BusRefuelling entity, BigInteger id) {
        ((BusRefuellingImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }
}
