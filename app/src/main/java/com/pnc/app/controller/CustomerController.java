package com.pnc.app.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.pnc.app.domain.Customer;
import com.pnc.app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/app")
public class CustomerController {
    @Autowired
    CustomerService customerService;

   // @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;

    }

//    @GetMapping
//    public ResponseEntity<List<CustomerModel>> get() {
//        return ResponseEntity.ok(customerService.getAll().stream()
//                .map(p->CustomerMapper.toModel(p))
//                .collect(Collectors.toList()));
//    }
    @GetMapping("/creditcheck")
    @HystrixCommand(fallbackMethod = "getFallback")
    public ResponseEntity<Response> get(@RequestParam (name = "ssn")int ssn) throws Exception{
        Optional<Customer> customer = customerService.get(ssn);
        if (!customer.isPresent()) {
            return ResponseEntity.notFound().build();
        }

      ResponseEntity<AgencyModel> agencyModel = restTemplate.getForEntity("http://localhost:8080/agency/1234", AgencyModel.class );
      AgencyModel agency = agencyModel.getBody();
      if(agency.getEligibility().equals("ELIGIBLE"))
      {
          Response response = new Response();
          response.setData("xyz");
          response.setError("not");
          response.setStatus("Eligible-good");
          return ResponseEntity.ok(response);
      }
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Response>  getFallback(int ssn) throws Exception {
        Response response = new Response();
        response.setData("in fallback method");
        response.setStatus("try again later");
        return ResponseEntity.ok(response);
    }


}









