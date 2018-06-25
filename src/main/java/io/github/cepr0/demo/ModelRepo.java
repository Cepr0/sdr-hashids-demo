package io.github.cepr0.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepo extends JpaRepository<Model, Long> {
	
	default Model findByEncodedId(String encodedId) {
		return getById(HashIdUtil.decode(encodedId));
	}
	
	Model getById(Long id);
}
