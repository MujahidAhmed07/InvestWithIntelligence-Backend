package com.InvestWithIntelligence.Controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InvestWithIntelligence.Models.EntreprenuerMetaData;
import com.InvestWithIntelligence.Services.EmetaServices;

@RestController
@RequestMapping("api/iwi/emeta")
public class EmetadataController {
    @Autowired
    private EmetaServices emetaServices;

    private static final Logger logger = LoggerFactory.getLogger(EmetaServices.class);

    @PutMapping("/update/{id}")
    private ResponseEntity<?> add_e_meta(@PathVariable("id") long meta_id,
            @RequestBody EntreprenuerMetaData emodel) {

        try {
            logger.info("in EmetaServices.add_e_meta() : {}");
            return new ResponseEntity<>(this.emetaServices.updateEntreprenuermeta(meta_id, emodel), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
