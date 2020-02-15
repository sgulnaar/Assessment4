package com.credit.agency.controller;

import com.credit.agency.domain.Agency;

public class AgencyMapper {

    public static AgencyModel toModel(Agency entity) {
        AgencyModel model = new AgencyModel();
        model.setSsn(entity.getSsn());
        model.setEligibility(entity.getEligibility());

        return model;
    }

    public static Agency newEntity(AgencyModel model) {
        Agency entity = new Agency(model.getSsn());
        entity.setEligibility(model.getEligibility());
        entity.setSsn(model.getSsn());
        return entity;
    }

    public static Agency merge(AgencyModel model, Agency entity) {
        entity.setSsn(model.getSsn());
        entity.setEligibility(model.getEligibility());
        return entity;
    }

}
