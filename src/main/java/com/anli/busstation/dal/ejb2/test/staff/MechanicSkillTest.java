package com.anli.busstation.dal.ejb2.test.staff;

import com.anli.busstation.dal.ejb2.entities.staff.MechanicSkillImpl;
import com.anli.busstation.dal.ejb2.factories.Ejb2ProviderProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.staff.MechanicSkill;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigInteger;

public class MechanicSkillTest extends com.anli.busstation.dal.sql.test.staff.MechanicSkillTest {

    @Override
    protected MechanicSkill getNewMechanicSkill(BigInteger id, String name, Integer maxDiffLevel) {
        MechanicSkillImpl skill = new MechanicSkillImpl();
        skill.setId(id);
        skill.setName(name);
        skill.setMaxDiffLevel(maxDiffLevel);
        return skill;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new Ejb2ProviderProxyFactory();
    }

    @Override
    protected void setEntityId(MechanicSkill entity, BigInteger id) {
        ((MechanicSkillImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }
}
