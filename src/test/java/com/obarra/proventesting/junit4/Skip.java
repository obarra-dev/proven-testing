package com.obarra.proventesting.junit4;

import org.junit.Assume;

public class Skip {
    public static void IF(Boolean condition) {
        Assume.assumeFalse(condition);
    }

    public static void UNLESS(Boolean condition) {
        Assume.assumeTrue(condition);
    }
}
