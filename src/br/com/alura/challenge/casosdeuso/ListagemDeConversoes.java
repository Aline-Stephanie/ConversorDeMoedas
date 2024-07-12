package br.com.alura.challenge.casosdeuso;

import br.com.alura.challenge.service.IConversorDeMoedas;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListagemDeConversoes {
    private final List<String> moedasFiltradas;

    public ListagemDeConversoes() {
        this.moedasFiltradas = List.of("ARS", "BOB", "CLP", "COP", "EUR", "JPY", "USD", "BRL");
    }

    public List<String> listeOpcoesDeConversao(){
        List<String> opcoesDeConversao = new ArrayList<>();

        for(String opcaoMoeda : moedasFiltradas){
            String nomeDaMoeda = "";

            if(!opcaoMoeda.equals("BRL")){
                nomeDaMoeda = switch (opcaoMoeda) {
                    case "ARS" -> "Peso argentino";
                    case "BOB" -> "Boliviano da Bolívia";
                    case "CLP" -> "Peso chileno";
                    case "COP" -> "Peso colombiano";
                    case "EUR" -> "Euro";
                    case "JPY" -> "Iene Japônes";
                    case "USD" -> "Dólar Americano";
                    default -> nomeDaMoeda;
                };
                opcoesDeConversao.add(" BRL --> " + opcaoMoeda + " (Real para " + nomeDaMoeda + ")");
                opcoesDeConversao.add(" " + opcaoMoeda  + " --> BRL (" + nomeDaMoeda + " para Real)");
            }
        }
        return opcoesDeConversao;
    }
}
