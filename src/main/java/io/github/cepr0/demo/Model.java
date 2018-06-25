package io.github.cepr0.demo;

import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.util.concurrent.atomic.AtomicLong;

@Data
@Entity
@TypeDef(name = "hashId", defaultForType = HashId.class, typeClass = HashIdType.class)
public class Model {
	
	private static final AtomicLong COUNTER = new AtomicLong();
	
	@Id
	@Type(type = "hashId")
	private HashId id;
	
	private String name;
	
	public Model() {
	}
	
	public Model(String name) {
		this.name = name;
	}
	
	@PrePersist
	private void prePersist() {
		id = new HashId(COUNTER.incrementAndGet());
	}
}
