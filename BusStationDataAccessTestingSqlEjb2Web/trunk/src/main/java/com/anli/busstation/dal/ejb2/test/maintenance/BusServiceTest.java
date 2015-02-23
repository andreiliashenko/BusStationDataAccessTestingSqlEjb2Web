package com.anli.busstation.dal.ejb2.test.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.BusRefuellingImpl;
import com.anli.busstation.dal.ejb2.entities.maintenance.BusRepairmentImpl;
import com.anli.busstation.dal.ejb2.entities.maintenance.BusServiceImpl;
import com.anli.busstation.dal.ejb2.factories.ProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.maintenance.BusRefuelling;
import com.anli.busstation.dal.interfaces.entities.maintenance.BusRepairment;
import com.anli.busstation.dal.interfaces.entities.maintenance.BusService;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class BusServiceTest extends com.anli.busstation.dal.sql.test.maintenance.BusServiceTest {

    @Override
    protected BusRefuelling getNewRefuelling(BigInteger id, BigInteger mechanicId, DateTime beginTime, DateTime endTime,
            BigDecimal cost, BigInteger busId, Integer volume, boolean load) {
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
    protected BusRepairment getNewRepairment(BigInteger id, BigInteger mechanicId, DateTime beginTime, DateTime endTime,
            BigDecimal cost, BigInteger busId, BigDecimal price, boolean load) {
        BusRepairmentImpl repairment = new BusRepairmentImpl();
        repairment.setId(id);
        repairment.setMechanic(getMechanicById(mechanicId, load));
        repairment.setBeginTime(beginTime);
        repairment.setEndTime(endTime);
        repairment.setServiceCost(cost);
        repairment.setBus(getBusById(busId, load));
        repairment.setExpendablesPrice(price);
        return repairment;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new ProxyFactory();
    }

    @Override
    protected void setEntityId(BusService entity, BigInteger id) {
        ((BusServiceImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }
}
