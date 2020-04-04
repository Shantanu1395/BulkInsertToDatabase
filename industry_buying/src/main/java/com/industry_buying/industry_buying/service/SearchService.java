package com.industry_buying.industry_buying.service;

import com.industry_buying.industry_buying.controller.APIController;
import com.industry_buying.industry_buying.model.*;
import com.industry_buying.industry_buying.repository.CuniqueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    private static final Logger logger = LoggerFactory.getLogger(SearchService.class);

    @Autowired
    CuniqueRepository cuniqueRepository;

    public FormattedResponse getSearchResults(String query){
        List<Cunique> results = cuniqueRepository.getAllResultsWithMessage(query);

        logger.info("Fetched " + results.size() + " matching records from db");

        int total_matches = results.size();
        int truth_spams = 0;
        int truth_not_spams = 0;

        int cube_spams = 0;
        int cube_not_spams = 0;

        int google_spams = 0;
        int google_not_spams = 0;
        double google_avg_spams = 0;
        double google_avg_not_spams = 0;

        int ibm_spams = 0;
        int ibm_not_spams = 0;
        double ibm_avg_spams = 0;
        double ibm_avg_not_spams = 0;

        for(Cunique cunique:results){
            if(cunique.getTruth().equals("spam")){
                truth_spams++;
            }else{
                truth_not_spams++;
            }

            if(cunique.getCube().equals("spam")){
                cube_spams++;
            }else{
                cube_not_spams++;
            }

            if(cunique.getGoogle().equals("spam")){
                google_spams++;
            }else{
                google_not_spams++;
            }

            if(cunique.getIbm().equals("spam")){
                ibm_spams++;
            }else{
                ibm_not_spams++;
            }

            google_avg_spams += Double.parseDouble(cunique.getGoogle_spam());
            google_avg_not_spams += Double.parseDouble(cunique.getGoogle_not_spam());

            ibm_avg_spams += cunique.getIbm_spam();
            ibm_avg_not_spams += cunique.getIbm_not_spam();
        }

        google_avg_spams = google_avg_spams / total_matches;
        google_avg_not_spams = google_avg_spams / total_matches;

        ibm_avg_spams = ibm_avg_spams / total_matches;
        ibm_avg_not_spams = ibm_avg_spams / total_matches;

        FormattedResponse formattedResponse = new FormattedResponse(total_matches, new truth(truth_spams, truth_not_spams), new cube(cube_spams, cube_not_spams), new google(google_spams, google_not_spams, google_avg_spams, google_avg_not_spams) , new ibm(ibm_spams, ibm_not_spams, ibm_avg_spams, ibm_avg_not_spams));
        return formattedResponse;
    }

}
