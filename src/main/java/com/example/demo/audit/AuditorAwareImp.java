package com.example.demo.audit;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImp implements AuditorAware {
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of("Free Bus Doctor");

    }
}
