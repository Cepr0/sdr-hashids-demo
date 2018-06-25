package io.github.cepr0.demo.optional;

import io.github.cepr0.demo.HashId;

import javax.persistence.AttributeConverter;

//@Converter(autoApply = true)
public class HashIdConverter implements AttributeConverter<HashId, Long> {
	
	@Override
	public Long convertToDatabaseColumn(HashId attribute) {
		return attribute.getValue();
	}
	
	@Override
	public HashId convertToEntityAttribute(Long dbData) {
		return new HashId(dbData);
	}
}
