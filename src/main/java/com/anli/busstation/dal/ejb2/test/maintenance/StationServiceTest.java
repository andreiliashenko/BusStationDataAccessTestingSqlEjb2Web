package com.anli.busstation.dal.ejb2.test.maintenance;

import com.anli.busstation.dal.ejb2.entities.maintenance.StationServiceImpl;
import com.anli.busstation.dal.ejb2.test.Ejb2ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.maintenance.StationService;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class StationServiceTest extends com.anli.busstation.dal.sql.test.maintenance.StationServiceTest {

    @Override
    protected StationService getNewService(BigInteger id, BigInteger mechanicId, DateTime beginTime,
            DateTime endTime, BigDecimal cost, String description, boolean load) {
        StationServiceImpl service = new StationServiceImpl();
        service.setId(id);
        service.setMechanic(getMechanicById(mechanicId, load));
        service.setBeginTime(beginTime);
        service.setEndTime(endTime);
        service.setServiceCost(cost);
        service.setDescription(description);
        return service;
    }

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb2ModuleAccessor();
    }
}
