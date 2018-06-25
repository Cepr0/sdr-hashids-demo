package io.github.cepr0.demo;

import org.hibernate.dialect.Dialect;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.DiscriminatorType;
import org.hibernate.type.descriptor.sql.BigIntTypeDescriptor;

public class HashIdType extends AbstractSingleColumnStandardBasicType<HashId> implements DiscriminatorType<HashId> {
	
	public HashIdType() {
		super(BigIntTypeDescriptor.INSTANCE, HashIdTypeDescriptor.INSTANCE);
	}
	
	@Override
	public HashId stringToObject(String xml) {
		return fromString(xml);
	}
	
	@Override
	public String objectToSQLString(HashId value, Dialect dialect) {
		return toString(value);
	}
	
	@Override
	public String getName() {
		return "hashId";
	}
}
