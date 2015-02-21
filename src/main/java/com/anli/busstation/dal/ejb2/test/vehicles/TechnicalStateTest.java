package com.anli.busstation.dal.ejb2.test.vehicles;

import com.anli.busstation.dal.ejb2.entities.vehicles.TechnicalStateImpl;
import com.anli.busstation.dal.ejb2.factories.ProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.vehicles.TechnicalState;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigInteger;

public class TechnicalStateTest extends com.anli.busstation.dal.sql.test.vehicles.TechnicalStateTest {

    @Override
    protected TechnicalState getNewState(BigInteger id, String description, Integer diffLevel) {
        TechnicalStateImpl state = new TechnicalStateImpl();
        state.setId(id);
        state.setDescription(description);
        state.setDifficultyLevel(diffLevel);
        return state;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new ProxyFactory();
    }

    @Override
    protected void setEntityId(TechnicalState entity, BigInteger id) {
        ((TechnicalStateImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }
}
