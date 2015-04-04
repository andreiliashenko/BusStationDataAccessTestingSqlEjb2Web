package com.anli.busstation.dal.ejb2.test.vehicles;

import com.anli.busstation.dal.ejb2.entities.vehicles.ModelImpl;
import com.anli.busstation.dal.ejb2.test.Ejb2ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.vehicles.Model;
import com.anli.busstation.dal.test.ModuleAccessor;
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
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb2ModuleAccessor();
    }
}
