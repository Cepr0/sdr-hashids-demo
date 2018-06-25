package io.github.cepr0.demo;

import org.hashids.Hashids;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfigurer extends RepositoryRestConfigurerAdapter {
	
	private final Hashids hashids;
	
	public RestConfigurer() {
		hashids = new Hashids();
	}
	
	@Override
	public void configureConversionService(ConfigurableConversionService conversionService) {
		conversionService.addConverter(new String2HashIdConverter(hashids));
		super.configureConversionService(conversionService);
	}
}
