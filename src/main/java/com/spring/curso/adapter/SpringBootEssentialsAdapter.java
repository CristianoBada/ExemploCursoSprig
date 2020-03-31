package com.spring.curso.adapter;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@Configuration
public class SpringBootEssentialsAdapter extends WebMvcConfigurerAdapter {
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		PageableHandlerMethodArgumentResolver phmar = new PageableHandlerMethodArgumentResolver();
		PageRequest pageRequest = PageRequest.of(0, 5, Sort.Direction.ASC, "name");
		phmar.setFallbackPageable(pageRequest);
		argumentResolvers.add(phmar);
	}

}
