package com.anli.busstation.dal.ejb2.test;

import com.anli.busstation.dal.ejb2.entities.BSEntityImpl;
import com.anli.busstation.dal.ejb2.factories.ProviderProxyFactory;
import com.anli.busstation.dal.interfaces.entities.BSEntity;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigInteger;

public class Ejb2ModuleAccessor implements ModuleAccessor {

    @Override
    public ProviderFactory getProviderFactory() {
        return new ProviderProxyFactory();
    }

    @Override
    public FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }

    @Override
    public void resetCaches() {
    }

    @Override
    public void setEntityId(BSEntity entity, BigInteger id) {
        ((BSEntityImpl) entity).setId(id);
    }
}
