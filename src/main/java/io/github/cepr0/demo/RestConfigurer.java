package io.github.cepr0.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfigurer extends RepositoryRestConfigurerAdapter {
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.withEntityLookup()
				.forRepository(ModelRepo.class, model -> HashIdUtil.encode(model.getId()), ModelRepo::findByEncodedId);
		super.configureRepositoryRestConfiguration(config);
	}
}
