package io.github.cepr0.demo;

import org.springframework.core.convert.converter.Converter;

public class HashId2StringConverter implements Converter<HashId, String> {
	
	@Override
	public String convert(HashId source) {
		return HashIdUtil.encode(source.getValue());
	}
}
