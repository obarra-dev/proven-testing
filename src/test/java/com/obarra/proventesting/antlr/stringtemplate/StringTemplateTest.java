package com.obarra.proventesting.antlr.stringtemplate;


import org.junit.jupiter.api.Test;
import org.stringtemplate.v4.ST;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTemplateTest {
    @Test
    public void renderWhenHasOneAttribute() {
        ST body = new ST("Hello, <name>");
        body.add("name", "Omar");
        assertEquals("Hello, Omar", body.render());
    }


}
