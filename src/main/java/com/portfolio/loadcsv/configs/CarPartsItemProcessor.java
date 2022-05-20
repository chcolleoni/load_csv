package com.portfolio.loadcsv.configs;

import com.portfolio.loadcsv.models.CarParts;
import org.springframework.batch.item.ItemProcessor;

public class CarPartsItemProcessor implements ItemProcessor<CarParts, CarParts> {


    @Override
    public CarParts process(CarParts item) throws  Exception {
        return item;
    }

}

