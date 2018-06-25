package io.github.cepr0.demo;

import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.AbstractTypeDescriptor;

public class HashIdTypeDescriptor extends AbstractTypeDescriptor<HashId> {
	
	public static final HashIdTypeDescriptor INSTANCE = new HashIdTypeDescriptor();
	
	public HashIdTypeDescriptor() {
		super(HashId.class);
	}
	
	@Override
	public String toString(HashId value) {
		return value.getValue().toString();
	}
	
	@Override
	public HashId fromString(String string) {
		return new HashId(Long.valueOf(string));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public <X> X unwrap(HashId value, Class<X> type, WrapperOptions options) {
		if (value == null) {
			return null;
		}
		if (Long.class.isAssignableFrom(type)) {
			return (X) value.getValue();
		}
		if (String.class.isAssignableFrom(type)) {
			return (X) toString(value);
		}
		throw unknownUnwrap(type);
	}
	
	@Override
	public <X> HashId wrap(X value, WrapperOptions options) {
		if (value == null) {
			return null;
		}
		if (String.class.isInstance(value)) {
			return fromString((String) value);
		}
		if (Long.class.isInstance(value)) {
			return new HashId((Long) value);
		}
		throw unknownWrap(value.getClass());
	}
}
