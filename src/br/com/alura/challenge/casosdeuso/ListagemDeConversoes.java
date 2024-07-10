package br.com.alura.challenge.casosdeuso;

import br.com.alura.challenge.repository.ConversorDeMoedasRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListagemDeConversoes {
    private final ConversorDeMoedasRepository conversorDeMoedasRepository;
    private final List<String> moedasFiltradas;

    public ListagemDeConversoes(ConversorDeMoedasRepository conversorDeMoedasRepository) {
        this.conversorDeMoedasRepository = conversorDeMoedasRepository;
        this.moedasFiltradas = List.of("USD", "EUR", "JPY", "GBP", "AUD", "CAD", "CHF", "BRL");
    }

    public List<String> listeOpcoesDeConversao(){
        List<String> opcoesDeConversao = new ArrayList<>();

        for(String opcaoMoeda : moedasFiltradas){
            String nomeDaMoeda = "";

            if(!opcaoMoeda.equals("BRL")){
                nomeDaMoeda = switch (opcaoMoeda) {
                    case "USD" -> "Dólar Americano";
                    case "EUR" -> "Euro";
                    case "JPY" -> "Iene Japônes";
                    case "GBP" -> "Libra Esterlina";
                    case "AUD" -> "Dólar Australiano";
                    case "CAD" -> "Dólar Canadense";
                    case "CHF" -> "Franco Suíço";
                    default -> nomeDaMoeda;
                };
                opcoesDeConversao.add(" BRL --> " + opcaoMoeda + " (Real para " + nomeDaMoeda + ")");
                opcoesDeConversao.add(" " + opcaoMoeda  + " --> BRL (" + nomeDaMoeda + " para Real)");
            }
        }
        return opcoesDeConversao;
    }

    public double obtenhaTaxaDeCambio(String moedaOrigem, String moedaDestino){
        Map<String, Double> taxasDeCambio = conversorDeMoedasRepository.listagemDeConversoes();
        double taxaOrigem = taxasDeCambio.getOrDefault(moedaOrigem, 1.0);
        double taxaDestino = taxasDeCambio.getOrDefault(moedaDestino, 1.0);
        return taxaDestino / taxaOrigem;
    }
}
