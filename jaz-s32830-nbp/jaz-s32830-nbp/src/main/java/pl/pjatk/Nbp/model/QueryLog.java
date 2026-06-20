package pl.pjatk.Nbp.model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class QueryLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String currency;
    private String startDate;
    private String endDate;
    private double calculatedAverage;
    private LocalDateTime queryDateTime;

    public QueryLog() {
    }

    public QueryLog(String currency, String startDate, String endDate, double calculatedAverage, LocalDateTime queryDateTime) {
        this.currency = currency;
        this.startDate = startDate;
        this.endDate = endDate;
        this.calculatedAverage = calculatedAverage;
        this.queryDateTime = queryDateTime;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCurrency() {
        return currency;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public double getCalculatedAverage() {
        return calculatedAverage;
    }
    public void setCalculatedAverage(double calculatedAverage) {
        this.calculatedAverage = calculatedAverage;
    }
    public LocalDateTime getQueryDateTime() {
        return queryDateTime;
    }
    public void setQueryDateTime(LocalDateTime queryDateTime) {
        this.queryDateTime = queryDateTime;
    }
}