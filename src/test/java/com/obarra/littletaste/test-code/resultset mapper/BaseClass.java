package com.example.springboot.poc.dao.mapper;

import com.example.springboot.poc.entity.ExampleEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Implementation fo {@link RowMapper} for {@link ExampleEntity}.
 * Created by [YOUR ID] on 8/9/2018.
 */
public class ExampleInfoMapper implements RowMapper<ExampleEntity> {
    private static final int EXAMPLE_ID_COL_INDEX = 1;  // best practice: use private scope + descriptive names for attributes
    private static final int EXAMPLE_DESC_COL_INDEX = 3;
    private static final String EXAMPLE_NAME_COL_NAME = "example_name";

    @Override
    public ExampleEntity mapRow(final ResultSet resultSet, final int i) throws SQLException { // best practice: use final modifier for parameters
        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setColumn1(resultSet.getString(EXAMPLE_ID_COL_INDEX)); // best practice: access by index avoid issues when column's name change
        exampleEntity.setColumn2(resultSet.getString(EXAMPLE_NAME_COL_NAME)); // best practice: use constants instead magic number or string values
        exampleEntity.setColumn3(resultSet.getString(EXAMPLE_DESC_COL_INDEX)); // best practice: use constants instead magic number or string values

        return exampleEntity;
    }
}