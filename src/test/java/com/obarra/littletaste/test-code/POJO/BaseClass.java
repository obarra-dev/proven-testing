package com.example.springboot.poc.entity;

/**
 * Example entity.
 * Created by [YOUR ID] on 8/1/2018.
 */
public class ExampleEntity {
    private String column1;  // best practice: use private scope + descriptive names for attributes
    private String column2;
    private String column3;

    /**
     * Gets column1 value.
     * @return column1 value
     */
    public String getColumn1() {
        return column1;
    }

    /**
     * Sets the column1
     * @param column1 the column1
     */
    public void setColumn1(final String column1) {
        this.column1 = column1;
    }

    /**
     * Gets column2 value.
     * @return column2 value
     */
    public String getColumn2() {
        return column2;
    }

    /**
     * Sets the column2
     * @param column2 the column2
     */
    public void setColumn2(final String column2) {
        this.column2 = column2;
    }

    /**
     * Gets column3 value.
     * @return column3 value
     */
    public String getColumn3() {
        return column3;
    }

    /**
     * Sets the column3
     * @param column3 the column3
     */
    public void setColumn3(final String column3) {
        this.column3 = column3;
    }
}