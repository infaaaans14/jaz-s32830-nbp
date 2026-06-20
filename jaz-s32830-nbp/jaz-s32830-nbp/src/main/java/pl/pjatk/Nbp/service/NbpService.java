package pl.pjatk.Nbp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.Nbp.model.NbpResponse;
import pl.pjatk.Nbp.model.QueryLog;
import pl.pjatk.Nbp.model.Rate;
import pl.pjatk.Nbp.repository.QueryLogRepository;

import java.time.LocalDateTime;

@Service
public class NbpService {

    private final RestTemplate restTemplate;
    private final QueryLogRepository queryLogRepository;

    public NbpService(RestTemplate restTemplate, QueryLogRepository queryLogRepository) {
        this.restTemplate = restTemplate;
        this.queryLogRepository = queryLogRepository;
    }

    public double calculateAverageExchangeRate(String currency, String startDate, String endDate) {
        String url = "http://api.nbp.pl/api/exchangerates/rates/a/" + currency + "/" + startDate + "/" + endDate + "/?format=json";

        NbpResponse response = restTemplate.getForObject(url, NbpResponse.class);

        if (response == null || response.getRates() == null || response.getRates().isEmpty()) {
            throw new RuntimeException("Pusta odpowiedź");
        }

        double sum = 0;
        for (Rate rate : response.getRates()) {
            sum += rate.getMid();
        }
        double averageRate = sum / response.getRates().size();

        QueryLog log = new QueryLog(currency, startDate, endDate, averageRate, LocalDateTime.now());
        queryLogRepository.save(log);

        return averageRate;
    }
}