package com.example.conferencedemo.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable
public class ConfigurationBeans {

	@Bean
	ModelMapper mapper() {
		return new ModelMapper();
	}
}
