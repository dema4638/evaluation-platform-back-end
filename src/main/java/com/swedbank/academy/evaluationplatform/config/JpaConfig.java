package com.swedbank.academy.evaluationplatform.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.swedbank.academy.evaluationplatform.mentor", "com.swedbank.academy.evaluationplatform.student", "com.swedbank.academy.evaluationplatform.studentMentor",
        "com.swedbank.academy.evaluationplatform.evaluationForm"})
public class JpaConfig {
}
