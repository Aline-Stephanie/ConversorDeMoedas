package br.com.alura.challenge;

import br.com.alura.challenge.casosdeuso.ListagemDeConversoes;
import br.com.alura.challenge.controllers.ConversorDeMoedasController;
import br.com.alura.challenge.repository.ConversorDeMoedaApiExterna;

public class Main {
    public static void main(String[] args) {
        ConversorDeMoedaApiExterna conversorDeMoedaApi = new ConversorDeMoedaApiExterna();
        ListagemDeConversoes listarConversoes = new ListagemDeConversoes(conversorDeMoedaApi);
        ConversorDeMoedasController conversorDeMoedasController = new ConversorDeMoedasController(listarConversoes);

        conversorDeMoedasController.iniciar();
    }
}