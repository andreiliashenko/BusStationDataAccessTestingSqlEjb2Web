package com.anli.busstation.dal.ejb2.test.staff;

import com.anli.busstation.dal.ejb2.entities.staff.MechanicSkillImpl;
import com.anli.busstation.dal.ejb2.test.Ejb2ModuleAccessor;
import com.anli.busstation.dal.interfaces.entities.staff.MechanicSkill;
import com.anli.busstation.dal.test.ModuleAccessor;
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
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb2ModuleAccessor();
    }
}
