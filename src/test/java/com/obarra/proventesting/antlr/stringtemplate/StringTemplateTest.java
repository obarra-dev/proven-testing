package com.obarra.proventesting.antlr.stringtemplate;


import static  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.stringtemplate.v4.ST;

public class StringTemplateTest {
    @Test
    public void renderWhenHasOneAttribute(){
        ST body = new ST("Hello, <name>");
        body.add("name", "Omar");
        assertEquals("Hello, Omar", body.render());
    }


}
