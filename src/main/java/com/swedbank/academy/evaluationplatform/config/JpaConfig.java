package com.swedbank.academy.evaluationplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.swedbank.academy.evaluationplatform.mentor"})
public class JpaConfig {
}
