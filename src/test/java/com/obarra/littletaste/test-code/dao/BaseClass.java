package com.example.springboot.poc.dao;

import com.example.springboot.poc.dao.mapper.ExampleInfoMapper;
import com.example.springboot.poc.dto.ExampleInfoRequestDTO;
import com.example.springboot.poc.entity.ExampleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Implementation of {@link ExampleDAO}.
 * Created by [YOUR ID] on 8/1/2018.
 */
@Component // you also can use @Repository (it inherits from @Component)
public class ExampleDAOImpl implements ExampleDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExampleDAOImpl.class); // best practice: declared first Logger
    private static final String SELECT_EXAMPLE_ALL = "SELECT * FROM EXAMPLE " // best practice: declared first constants
            + "WHERE EXAMPLE_NAME NOT IN (?, ?) "; // doesn't make sense only for test purpose

    private JdbcTemplate jdbcTemplate;

    /**
     * Constructor for {@link ExampleDAOImpl}.
     * @param jdbcTemplate jdbc template
     */
    @Autowired // best practice: use injection by constructor makes unit test class easier
    public ExampleDAOImpl(final JdbcTemplate jdbcTemplate) { // best practice: use final modifier for parameters
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Gets example info for given {@link ExampleInfoRequestDTO}.
     * @param exampleInfoRequestDTO example info request parameters
     * @return an {@link ExampleEntity} with retrieved values from table
     */
  
    public ExampleEntity getExampleInfo(final ExampleInfoRequestDTO exampleInfoRequestDTO) { // best practice: use final modifier for parameters
        List<ExampleEntity> entityList = this.getExampleInfoList(exampleInfoRequestDTO);
        return entityList.get(0);
    }

    /**
     * Gets example info for given {@link ExampleInfoRequestDTO}.
     * @param exampleInfoRequestDTO example info request parameters
     * @return a {@link List} of {@link ExampleEntity} with retrieved values from table
     */
    public List<ExampleEntity> getExampleInfoList(final ExampleInfoRequestDTO exampleInfoRequestDTO) { // best practice: use final modifier
        LOGGER.info("getExampleInfo - parameter 1: {}", exampleInfoRequestDTO.getParameter1()); // best practice: use {} instead +
        LOGGER.info("getExampleInfo - parameter 2: {}", exampleInfoRequestDTO.getParameter2()); // best practice: use info for relevant info
        LOGGER.debug("getExampleInfo - parameter 3: {}", exampleInfoRequestDTO.getParameter3()); // best practice: use debug for developer info

        return jdbcTemplate.query(SELECT_EXAMPLE_ALL, getQueryParameters(exampleInfoRequestDTO), new ExampleInfoMapper());
    }

    /**
     * Gets query parameters from given example info request values.
     * @param exampleInfoRequestDTO example info request parameters
     * @return an array with query parameters
     */
    private Object[] getQueryParameters(final ExampleInfoRequestDTO exampleInfoRequestDTO) { // best practice: use final modifier for parameters
        Object[] parameters = new Object[2];
        parameters[0] = exampleInfoRequestDTO.getParameter1();
        parameters[1] = exampleInfoRequestDTO.getParameter2();

        return parameters;
    }
}
