package com.credit.agency.service;

import com.credit.agency.domain.Agency;
import com.credit.agency.repository.AgencyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyService {
    private AgencyRepository agencyRepository;

    public AgencyService(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public List<Agency> getAll() {

        return agencyRepository.findAll();
    }

    public Optional<Agency> getById(int ssn) {

        return agencyRepository.findById(ssn);
    }


}
