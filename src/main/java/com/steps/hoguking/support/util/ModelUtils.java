package com.steps.hoguking.support.util;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ModelUtils {
	private static final ModelMapper MODEL_MAPPER;
	private static final ModelMapper SKIP_NULL_MODEL_MAPPER;

	static {
		MODEL_MAPPER = new ModelMapper();
		Configuration configuration = MODEL_MAPPER.getConfiguration();
		configuration.setMatchingStrategy(MatchingStrategies.STRICT);

		SKIP_NULL_MODEL_MAPPER = new ModelMapper();
		SKIP_NULL_MODEL_MAPPER.getConfiguration()
				.setMatchingStrategy(MatchingStrategies.STRICT)
				.setPropertyCondition(Conditions.isNotNull());

	}

	public static ModelMapper getModelMapper() {
		return MODEL_MAPPER;
	}

	private static ModelMapper getSkipNullModelMapper() {
		return SKIP_NULL_MODEL_MAPPER;
	}

	public static <D> D convertValue(Object source, Class<D> destinationType) {
		if (source != null) {
			return getModelMapper().map(source, destinationType);
		}

		return null;
	}

	public static <D> List<D> convertValue(List<?> source, Class<D> destinationType) {
		return Optional.ofNullable(source)
				.map(List::stream)
				.orElse(Stream.empty())
				.map(value -> convertValue(value, destinationType))
				.collect(Collectors.toList());
	}

	public static void map(Object source, Object destination) {
		if (source != null && destination != null) {
			getModelMapper().map(source, destination);
		}
	}

	public static <T, S> List<S> getDistinctFromCollection(List<T> list, Function<? super T, ? extends S> mapper) {
		return list.stream()
				.map(mapper)
				.distinct()
				.collect(Collectors.toList());
	}

	public static void mapSkipNull(Object source, Object destination) {
		if (source != null && destination != null) {
			getSkipNullModelMapper().map(source, destination);
		}
	}
}
