package io.github.cepr0.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfigurer extends RepositoryRestConfigurerAdapter {
	
	@Override
	public void configureConversionService(ConfigurableConversionService conversionService) {
//		conversionService.addConverter(new HashId2StringConverter());
		conversionService.addConverter(new String2HashIdConverter());
		super.configureConversionService(conversionService);
	}
}
