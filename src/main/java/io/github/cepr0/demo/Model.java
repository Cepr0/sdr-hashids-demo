package io.github.cepr0.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
//@TypeDef(name = "hashId", defaultForType = HashId.class, typeClass = HashIdType.class)
public class Model {
	
//	private static final AtomicLong COUNTER = new AtomicLong();
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	public Model() {
	}
	
	public Model(String name) {
		this.name = name;
	}
	
//	@PrePersist
//	private void prePersist() {
//		id = new HashId(COUNTER.incrementAndGet());
//	}
}
