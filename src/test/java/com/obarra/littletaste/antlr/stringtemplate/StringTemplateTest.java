package com.obarra.littletaste.antlr.stringtemplate;


import org.junit.Assert;
import org.junit.Test;
import org.stringtemplate.v4.ST;

public class StringTemplateTest {
    @Test
    public void renderWhenHasOneAttribute(){
        ST body = new ST("Hello, <name>");
        body.add("name", "Omar");
        Assert.assertEquals("Hello, Omar", body.render());
    }


}
