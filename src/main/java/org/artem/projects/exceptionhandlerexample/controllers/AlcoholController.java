package org.artem.projects.exceptionhandlerexample.controllers;

import lombok.RequiredArgsConstructor;
import org.artem.projects.exceptionhandlerexample.services.AlcoholService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AlcoholController {
    private final AlcoholService alcoholService;


    @GetMapping("/beer")
    public ResponseEntity<HttpStatus> checkBeer(String beer) {
        alcoholService.checkBeer(beer);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/wine")
    public ResponseEntity<HttpStatus> checkWine(String wine) {
        alcoholService.checkWine(wine);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/health")
    public ResponseEntity<HttpStatus> checkHealth(String cirrhosis) {
        alcoholService.checkHealth(cirrhosis);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
