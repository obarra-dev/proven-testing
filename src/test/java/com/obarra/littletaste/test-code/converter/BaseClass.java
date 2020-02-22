package com.example.springboot.poc.converter;

import com.example.springboot.poc.dto.ExampleInfoResponseDTO;
import com.example.springboot.poc.entity.ExampleEntity;

/**
 * Implementation of {@link ExampleInfoConverter}.
 * Created by [YOUR ID] on 8/7/2018.
 */
public class  ExampleInfoConverterImpl implements ExampleInfoConverter<ExampleEntity, ExampleInfoResponseDTO> {

    @Override
    public ExampleInfoResponseDTO apply(final ExampleEntity exampleEntity) { // best practice: use final modifier for parameters
        ExampleInfoResponseDTO exampleInfoResponseDTO = new ExampleInfoResponseDTO();
        exampleInfoResponseDTO.setName(exampleEntity.getColumn2());
        exampleInfoResponseDTO.setDescription(exampleEntity.getColumn3());

        return exampleInfoResponseDTO;
    }
}
