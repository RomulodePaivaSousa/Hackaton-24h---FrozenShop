package org.academiadecodigo.bootcamp.glass.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<S, T> implements Converter<S, T> {
    @Override
    public T convert(S s) {
        return null;
    }
  
}
