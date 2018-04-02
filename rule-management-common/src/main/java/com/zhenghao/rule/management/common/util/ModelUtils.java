package com.zhenghao.rule.management.common.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;
import java.util.List;

public class ModelUtils {

    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <F, T> T map(F from, Class<T> to) {
        return modelMapper.map(from, to);
    }

    public static <F, T> T map(F from, Type T) {
        return modelMapper.map(from, T);
    }

    public static <F, T> List<T> listMap(List<F> fromList, Class<T> to) {
        Type type = new TypeToken<List<T>>() {
        }.getType();

        return modelMapper.map(fromList, type);
    }

    public static <F, T> T listMap(List<F> fromList, TypeToken<T> typeTokenOfList) {
        return modelMapper.map(fromList, typeTokenOfList.getType());
    }
}
