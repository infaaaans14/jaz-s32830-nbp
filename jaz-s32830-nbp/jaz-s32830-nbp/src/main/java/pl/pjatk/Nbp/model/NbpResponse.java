package pl.pjatk.Nbp.model;

import java.util.List;

public class NbpResponse {
    private List<Rate> rates;

    public NbpResponse() {}

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}