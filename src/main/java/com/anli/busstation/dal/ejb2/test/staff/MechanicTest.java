package com.anli.busstation.dal.ejb2.test.staff;

import com.anli.busstation.dal.ejb2.entities.staff.MechanicImpl;
import com.anli.busstation.dal.ejb2.test.Ejb2ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.staff.Mechanic;
import com.anli.busstation.dal.test.ModuleAccessor;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.joda.time.DateTime;

public class MechanicTest extends com.anli.busstation.dal.sql.test.staff.MechanicTest {

    @Override
    protected Mechanic getNewMechanic(BigInteger id, String name, BigDecimal salary, DateTime hiringDate,
            BigInteger skillId, boolean load) {
        MechanicImpl mechanic = new MechanicImpl();
        mechanic.setId(id);
        mechanic.setName(name);
        mechanic.setSalary(salary);
        mechanic.setHiringDate(hiringDate);
        mechanic.setSkill(getSkillById(skillId, load));
        return mechanic;
    }

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb2ModuleAccessor();
    }
}
