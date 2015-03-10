package com.anli.busstation.dal.ejb2.test.staff;

import com.anli.busstation.dal.ejb2.entities.staff.DriverImpl;
import com.anli.busstation.dal.ejb2.factories.Ejb2ProviderProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.staff.Driver;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class DriverTest extends com.anli.busstation.dal.sql.test.staff.DriverTest {

    @Override
    protected Driver getNewDriver(BigInteger id, String name, BigDecimal salary, DateTime hiringDate,
            BigInteger skillId, boolean load) {
        DriverImpl driver = new DriverImpl();
        driver.setId(id);
        driver.setName(name);
        driver.setSalary(salary);
        driver.setHiringDate(hiringDate);
        driver.setSkill(getSkillById(skillId, load));
        return driver;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new Ejb2ProviderProxyFactory();
    }

    @Override
    protected void setEntityId(Driver entity, BigInteger id) {
        ((DriverImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }
}
