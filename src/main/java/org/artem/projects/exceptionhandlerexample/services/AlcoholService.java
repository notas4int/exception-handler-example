package org.artem.projects.exceptionhandlerexample.services;

import org.artem.projects.exceptionhandlerexample.exceptions.BeerNotFoundException;
import org.artem.projects.exceptionhandlerexample.exceptions.DetectedLiverCirrhosisException;
import org.artem.projects.exceptionhandlerexample.exceptions.PoorWineQualityException;
import org.springframework.stereotype.Service;

@Service
public class AlcoholService {

    public void checkWine(String wine) {
        throw new PoorWineQualityException("Wine is not good((");
    }

    public void checkBeer(String beer) {
        throw new BeerNotFoundException("Beer is not found((");
    }

    public void checkHealth(String cirrhosis) {
        throw new DetectedLiverCirrhosisException("Cirrhosis is detected(( so sorry<3");
    }
}
