package com.pnc.app.controller;

import com.pnc.app.domain.Customer;

public class CustomerMapper {
    public static CustomerModel toModel(Customer entity) {
        CustomerModel model = new CustomerModel();
        model.setFirstName(entity.getFirstName());
        model.setLastName(entity.getLastName());
        model.setSSN(entity.getSSN());
        model.setZipCode(entity.getZipCode());
        model.setCreditCardNo(entity.getCreditCardNo());
        return model;
    }

    public static Customer newEntity(CustomerModel model) {
        Customer entity = new Customer(model.getCreditCardNo());
        entity.setCreditCardNo(model.getCreditCardNo());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setSSN(model.getSSN());
        entity.setZipCode(model.getZipCode());
        return entity;
    }

    public static Customer merge(CustomerModel model, Customer entity) {
        entity.setCreditCardNo(model.getCreditCardNo());
        entity.setFirstName(model.getFirstName());
        entity.setLastName(model.getLastName());
        entity.setSSN(model.getSSN());
        entity.setZipCode(model.getZipCode());
        return entity;
    }

}
