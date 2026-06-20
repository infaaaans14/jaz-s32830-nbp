package pl.pjatk.Nbp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.Nbp.service.NbpService;

@RestController
@RequestMapping("/exchange")
public class NbpController {

    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/{currency}/{startDate}/{endDate}")
    public ResponseEntity<Double> getAverageRate(@PathVariable("currency") String currency, @PathVariable("startDate") String startDate, @PathVariable("endDate") String endDate) {

        double average = nbpService.calculateAverageExchangeRate(currency, startDate, endDate);
        return ResponseEntity.ok(average);
    }
}