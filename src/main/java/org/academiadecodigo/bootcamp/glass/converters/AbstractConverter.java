package org.academiadecodigo.bootcamp.glass.converters;

import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.stream.Collectors;

public class AbstractConverter<S, T> implements Converter<S, T> {
    @Override
    public T convert(S s) {
        return null;
    }
    public List<T> convert(List<S> listToConvert) {

        return listToConvert.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
