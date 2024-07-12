package br.com.alura.challenge.service;
import com.google.gson.Gson;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import br.com.alura.challenge.model.TaxaDeCambioApiExterna;

public class ConversorDeMoedaApiExterna implements IConversorDeMoedas {
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/fbdfba541e1364f24b938601/latest/BRL";

    @Override
    public Map<String, Double> obtemMapeamento(){
        Map<String, Double> taxasDeCambio = new HashMap<>();
        URI url = URI.create(API_URL);

        try{
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(url)
                    .GET()
                    .build();
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if(response.statusCode() == 200){
                Gson gson = new Gson();
                TaxaDeCambioApiExterna taxaDeCambioApi = gson.fromJson(response.body(), TaxaDeCambioApiExterna.class);
                taxasDeCambio = taxaDeCambioApi.getRates();
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter as taxas de câmbio. Erro: " + e.getMessage(), e);
        }
        return taxasDeCambio;
    }
}
