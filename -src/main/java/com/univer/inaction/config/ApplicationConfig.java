package com.univer.inaction.config;

import com.univer.inaction.Application;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import static org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(basePackageClasses = Application.class, excludeFilters = @Filter({Controller.class, Configuration.class}))
public class ApplicationConfig {
}
