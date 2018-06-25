package io.github.cepr0.demo;

import org.springframework.core.convert.converter.Converter;

public class String2HashIdConverter implements Converter<String, HashId> {
	
	@Override
	public HashId convert(String source) {
		try {
			return new HashId(Long.valueOf(source));
		} catch (NumberFormatException e) {
			return new HashId(HashIdUtil.decode(source));
		}
	}
}
