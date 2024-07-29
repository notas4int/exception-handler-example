package org.artem.projects.exceptionhandlerexample.controllers;

import lombok.RequiredArgsConstructor;
import org.artem.projects.exceptionhandlerexample.services.AlcoholService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AlcoholController {
    private final AlcoholService alcoholService;


    @GetMapping("/beer")
    public HttpStatus checkBeer(String beer) {
        alcoholService.checkBeer(beer);
        return HttpStatus.OK;
    }

    @GetMapping("/wine")
    public HttpStatus checkWine(String wine) {
        alcoholService.checkWine(wine);
        return HttpStatus.OK;
    }

    @GetMapping("/health")
    public HttpStatus checkHealth(String cirrhosis) {
        alcoholService.checkHealth(cirrhosis);
        return HttpStatus.OK;
    }
}
