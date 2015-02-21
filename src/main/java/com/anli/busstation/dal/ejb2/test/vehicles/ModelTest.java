package com.anli.busstation.dal.ejb2.test.vehicles;

import com.anli.busstation.dal.ejb2.entities.vehicles.ModelImpl;
import com.anli.busstation.dal.ejb2.factories.ProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.vehicles.Model;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;

public class ModelTest extends com.anli.busstation.dal.sql.test.vehicles.ModelTest {

    @Override
    protected Model getNewModel(BigInteger id, BigInteger gasLabelId, BigDecimal gasRate, String name,
            Integer seatsNumber, Integer tankVolume, boolean load) {
        ModelImpl model = new ModelImpl();
        model.setId(id);
        model.setGasLabel(getLabelById(gasLabelId, load));
        model.setGasRate(gasRate);
        model.setName(name);
        model.setSeatsNumber(seatsNumber);
        model.setTankVolume(tankVolume);
        return model;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new ProxyFactory();
    }

    @Override
    protected void setEntityId(Model entity, BigInteger id) {
        ((ModelImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }
}
