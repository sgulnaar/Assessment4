package com.credit.agency.controller;

import com.credit.agency.domain.Agency;
import com.credit.agency.service.AgencyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/agency")
public class AgencyController {

    private AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    public ResponseEntity<List<AgencyModel>> get() {
        return ResponseEntity.ok(agencyService.getAll().stream()
                .map(p -> AgencyMapper.toModel(p))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{ssn}")
    public ResponseEntity<AgencyModel> getBySsn(@PathVariable int ssn) throws Exception {
       Optional <Agency> agency =  agencyService.getById(ssn);
       if (!agency.isPresent()){
           throw new Exception("provide proper ssn");
       }
       return ResponseEntity.ok(AgencyMapper.toModel(agency.get()));
    }
}
