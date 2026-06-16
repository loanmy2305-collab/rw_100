package org.example.backend.service.impl;

import org.example.backend.repository.ICandidateRepository;
import org.example.backend.repository.impl.CandidateRepositoryImpl;
import org.example.backend.service.ICandidateService;

public class CandidateServiceImpl implements ICandidateService {
    private ICandidateRepository candidateRepository = new CandidateRepositoryImpl();

}