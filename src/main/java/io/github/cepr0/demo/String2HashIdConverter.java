package io.github.cepr0.demo;

import org.hashids.Hashids;
import org.springframework.core.convert.converter.Converter;

public class String2HashIdConverter implements Converter<String, HashId> {
	
	private final Hashids hashids;
	
	public String2HashIdConverter(Hashids hashids) {
		this.hashids = hashids;
	}
	
	@Override
	public HashId convert(String source) {
		return new HashId(hashids.decode(source)[0]);
	}
}
