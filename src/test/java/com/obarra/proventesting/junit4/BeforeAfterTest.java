package com.obarra.proventesting.junit4;


import org.junit.*;

public class BeforeAfterTest {

    private static StringBuilder object;

    @BeforeClass
    public static void beforeClass(){
        Assert.assertNull(object);
        object = new StringBuilder();
    }

    @AfterClass
    public static void afterClass(){
        clean();
        Assert.assertNull(object);
    }

    private static void clean() {
        object = null;
    }

    @Before
    public void beforeMethod(){
        object.append("I am at before method");
        Assert.assertNotNull(object);
    }

    @After
    public void afterMethod(){
        Assert.assertNotNull(object);

        object.append(";I am at after method");

        Assert.assertEquals("I am at before method;I am at after method", object.toString());
    }

    @Test
    public void test(){
        Assert.assertEquals("I am at before method", object.toString());
    }

}
