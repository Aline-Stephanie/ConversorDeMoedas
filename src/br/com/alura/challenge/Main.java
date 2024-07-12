package br.com.alura.challenge;

import br.com.alura.challenge.casosdeuso.ConversaoDeCambio;
import br.com.alura.challenge.controllers.ConversorDeMoedasController;
import br.com.alura.challenge.service.ConversorDeMoedaApiExterna;

public class Main {
    public static void main(String[] args) {
        ConversorDeMoedaApiExterna conversorDeMoedaApi = new ConversorDeMoedaApiExterna();
        ConversaoDeCambio conversaoDeCambio = new ConversaoDeCambio(conversorDeMoedaApi);
        ConversorDeMoedasController conversorDeMoedasController = new ConversorDeMoedasController(conversaoDeCambio);

        conversorDeMoedasController.iniciar();
    }
}