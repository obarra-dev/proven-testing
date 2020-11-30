package com.obarra.proventesting.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@DisabledOnOs({OS.SOLARIS, OS.OTHER})
@EnabledOnJre(JRE.JAVA_12)
public class EnabledTest {

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testIfIsSOWindows() {
        System.out.println("SO is Windows");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testIfIsSOLinux() {
        System.out.println("SO is Linux");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_8)
    void testIfIsJre8() {
        System.out.println("JRE is 8");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testIfIsJre11() {
        System.out.println("JRE is 11");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_12)
    void testIfIsJre12() {
        System.out.println("JRE is 12");
    }

    @Test
    @EnabledOnJre(JRE.JAVA_13)
    void testIfIsJre13() {
        System.out.println("JRE is 13");
    }


    void test() {

    }
}
