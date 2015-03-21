package com.anli.busstation.dal.ejb2.test.additional;

import com.anli.busstation.dal.ejb2.factories.ProviderProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;

public class ReferenceMutationTest extends com.anli.busstation.dal.test.additional.ReferenceMutationTest {

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }

    @Override
    protected ProviderFactory getFactory() {
        return new ProviderProxyFactory();
    }
}
