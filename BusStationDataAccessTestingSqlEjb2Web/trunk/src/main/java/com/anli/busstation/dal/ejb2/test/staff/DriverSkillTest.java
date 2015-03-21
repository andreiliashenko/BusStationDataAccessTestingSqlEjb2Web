package com.anli.busstation.dal.ejb2.test.staff;

import com.anli.busstation.dal.ejb2.entities.staff.DriverSkillImpl;
import com.anli.busstation.dal.ejb2.factories.ProviderProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.staff.DriverSkill;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigInteger;

public class DriverSkillTest extends com.anli.busstation.dal.sql.test.staff.DriverSkillTest {

    @Override
    protected DriverSkill getNewDriverSkill(BigInteger id, String name, Integer maxPass,
            Integer maxRideLength) {
        DriverSkillImpl skill = new DriverSkillImpl();
        skill.setId(id);
        skill.setName(name);
        skill.setMaxPassengers(maxPass);
        skill.setMaxRideLength(maxRideLength);
        return skill;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new ProviderProxyFactory();
    }

    @Override
    protected void setEntityId(DriverSkill entity, BigInteger id) {
        ((DriverSkillImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }
}
