package br.com.alura.challenge.casosdeuso;

import br.com.alura.challenge.service.IConversorDeMoedas;

import java.util.Map;

public class ConversaoDeCambio {
    private final IConversorDeMoedas IConversorDeMoedas;

    public ConversaoDeCambio(IConversorDeMoedas IConversorDeMoedas) {
        this.IConversorDeMoedas = IConversorDeMoedas;
    }

    public double obtenhaTaxaDeCambio(String moedaOrigem, String moedaDestino){
        Map<String, Double> taxasDeCambio = IConversorDeMoedas.obtemMapeamento();
        double taxaOrigem = taxasDeCambio.getOrDefault(moedaOrigem, 1.0);
        double taxaDestino = taxasDeCambio.getOrDefault(moedaDestino, 1.0);
        return taxaDestino / taxaOrigem;
    }
}
