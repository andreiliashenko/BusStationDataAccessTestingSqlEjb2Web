package com.anli.busstation.dal.ejb2.test.additional;

import com.anli.busstation.dal.ejb2.test.Ejb2ModuleAccessor;
import com.anli.busstation.dal.test.ModuleAccessor;

public class ReferenceMutationTest extends com.anli.busstation.dal.test.additional.ReferenceMutationTest {

    @Override
    protected ModuleAccessor createModuleAccessor() {
        return new Ejb2ModuleAccessor();
    }
}
