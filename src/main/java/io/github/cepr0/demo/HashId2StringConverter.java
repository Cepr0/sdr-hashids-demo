package io.github.cepr0.demo;

import org.hashids.Hashids;
import org.springframework.core.convert.converter.Converter;

public class HashId2StringConverter implements Converter<HashId, String> {
	
	private final Hashids hashids;
	
	public HashId2StringConverter(Hashids hashids) {
		this.hashids = hashids;
	}
	
	@Override
	public String convert(HashId source) {
		return hashids.encode(source.getValue());
	}
}
