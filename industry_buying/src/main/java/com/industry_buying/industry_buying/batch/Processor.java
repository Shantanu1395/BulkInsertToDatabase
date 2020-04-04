package com.industry_buying.industry_buying.batch;

import com.industry_buying.industry_buying.model.Cunique;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class Processor implements ItemProcessor<Cunique, Cunique> {

    @Override
    public Cunique process(Cunique cunique) throws Exception {
        //cunique.setMessage(cunique.getMessage().length()>100?"Long data" : cunique.getMessage());
        cunique.setMessage(cunique.getMessage());
        return cunique;
    }
}