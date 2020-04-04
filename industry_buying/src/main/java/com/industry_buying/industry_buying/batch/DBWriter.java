package com.industry_buying.industry_buying.batch;

import com.industry_buying.industry_buying.model.Cunique;
import com.industry_buying.industry_buying.repository.CuniqueRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DBWriter implements ItemWriter<Cunique> {

    @Autowired
    private CuniqueRepository cuniqueRepository;

    @Override
    public void write(List<? extends Cunique> list) throws Exception {
        cuniqueRepository.saveAll(list);
    }
}
