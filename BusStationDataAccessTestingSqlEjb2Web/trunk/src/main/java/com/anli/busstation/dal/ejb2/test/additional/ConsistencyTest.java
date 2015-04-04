package com.anli.busstation.dal.ejb2.test.additional;

import com.anli.busstation.dal.ejb2.test.Ejb2ModuleAccessor;
import com.anli.busstation.dal.test.ModuleAccessor;

public class ConsistencyTest extends com.anli.busstation.dal.test.additional.ConsistencyTest {

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb2ModuleAccessor();
    }
}
