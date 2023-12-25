package com.InvestWithIntelligence.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.Services.EvaluationServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/model/data")
public class EvaluationController {

    @Autowired
    private EvaluationServices evaluationServices;
    private static final Logger logger = LoggerFactory.getLogger(EvaluationController.class);

    @GetMapping("/get/id/{Id}")
    private ResponseEntity<?> fetchById(@Valid @PathVariable Long Id) {
        try {
            logger.info("in EModelController.fetchById() : {}");
            return new ResponseEntity<>(this.evaluationServices.findById(Id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
