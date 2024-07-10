package br.com.alura.challenge.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;

public class TaxaDeCambioApiExterna {

    @SerializedName("conversion_rates")
    private Map<String, Double> rates;
    public Map<String, Double> getRates(){
        return rates;
    }
    public void setRates(Map<String, Double> rates){
        this.rates = rates;
    }
}
