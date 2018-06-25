package io.github.cepr0.demo;

import java.io.Serializable;
import java.util.Objects;

public class HashId implements Serializable {

	private Long value;
	
	public HashId(Long value) {
		this.value = value;
	}
	
	public Long getValue() {
		return value;
	}
	
	public void setValue(Long value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		HashId hashId = (HashId) o;
		return Objects.equals(value, hashId.value);
	}
	
	@Override
	public int hashCode() {
		return value.hashCode();
	}
	
	@Override
	public String toString() {
		return HashIdUtil.encode(value);
	}
}
