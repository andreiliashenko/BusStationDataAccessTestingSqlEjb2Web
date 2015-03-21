package com.anli.busstation.dal.ejb2.test.staff;

import com.anli.busstation.dal.ejb2.entities.staff.SalesmanImpl;
import com.anli.busstation.dal.ejb2.factories.ProviderProxyFactory;
import com.anli.busstation.dal.ejb2.test.Ejb2FixtureCreator;
import com.anli.busstation.dal.interfaces.entities.staff.Salesman;
import com.anli.busstation.dal.interfaces.factories.ProviderFactory;
import com.anli.busstation.dal.test.FixtureCreator;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class SalesmanTest extends com.anli.busstation.dal.sql.test.staff.SalesmanTest {

    @Override
    protected Salesman getNewSalesman(BigInteger id, String name, BigDecimal salary, DateTime hiringDate,
            Integer totalSales) {
        SalesmanImpl salesman = new SalesmanImpl();
        salesman.setId(id);
        salesman.setName(name);
        salesman.setSalary(salary);
        salesman.setHiringDate(hiringDate);
        salesman.setTotalSales(totalSales);
        return salesman;
    }

    @Override
    protected ProviderFactory getFactory() {
        return new ProviderProxyFactory();
    }

    @Override
    protected void setEntityId(Salesman entity, BigInteger id) {
        ((SalesmanImpl) entity).setId(id);
    }

    @Override
    protected FixtureCreator getFixtureCreator() {
        return new Ejb2FixtureCreator();
    }
}
