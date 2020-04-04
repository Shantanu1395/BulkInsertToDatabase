package com.industry_buying.industry_buying.controller;

import com.industry_buying.industry_buying.model.FormattedResponse;
import com.industry_buying.industry_buying.service.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class APIController {

    private static final Logger logger = LoggerFactory.getLogger(APIController.class);

    @Autowired
    SearchService searchService;

    @GetMapping(value = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
    public FormattedResponse response(@RequestParam(value = "query") String query){
        logger.info("Got request to process results on the basis of query " + query);
        return searchService.getSearchResults(query);
    }
}
