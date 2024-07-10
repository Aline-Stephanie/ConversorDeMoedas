package br.com.alura.challenge.controllers;
import br.com.alura.challenge.casosdeuso.ListagemDeConversoes;
import java.util.List;
import java.util.Scanner;

public class ConversorDeMoedasController {
    private final ListagemDeConversoes listaConversoes;
    private final Scanner scanner = new Scanner(System.in);

    public ConversorDeMoedasController(ListagemDeConversoes listaConversoes) {
        this.listaConversoes = listaConversoes;
    }

    public void iniciar(){
        boolean continuar;
        do{
            exibeMenu();
            continuar = executaOpcao();
        } while(continuar);
    }

    private void exibeMenu(){
        List<String> opcoesMenu = listaConversoes.listeOpcoesDeConversao();

        System.out.println("\nQual conversão deseja realizar?\n");

        for (int i = 0; i < opcoesMenu.size(); i++){
            System.out.println((i+1) + "." + opcoesMenu.get(i));
        }
        System.out.println("0. Sair");
    }

    private boolean executaOpcao() {
        System.out.println("\nDigite o número da opção escolhida:");
        int opcaoSelecionada = -1;
        try {
            opcaoSelecionada = scanner.nextInt();
        }catch (Exception e){
            System.out.println("A opção escolhida é inválida.");
        }
        scanner.nextLine();

        if(opcaoSelecionada == 0){
            System.out.println("Saindo...");
            return false;
        } else if (opcaoSelecionada >= 1 && opcaoSelecionada <= 14) {
            realizeConversao(opcaoSelecionada, scanner);
        }else {
            System.out.println("A opção escolhida é inválida.");
        }
        return continuaConversao();
    }

    private void realizeConversao(int opcao, Scanner scanner){
        List<String> opcoesConversoes = listaConversoes.listeOpcoesDeConversao();
        String opcaoSelecionada = opcoesConversoes.get(opcao - 1);
        String[] moedas = opcaoSelecionada.split(" --> ");

        String moedaOrigem = moedas[0].trim();
        String moedaDestino = moedas[1].substring(0, 3);
        String conversao = moedas[1].substring(4).replaceAll("[()]","");

        System.out.println("Valor a converter (Formato 00,00):");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        double taxaDeCambio = listaConversoes.obtenhaTaxaDeCambio(moedaOrigem, moedaDestino);
        double valorConvertido = valor * taxaDeCambio;

        System.out.printf("O valor de %.2f em %s equivale a %.2f \n", valor, conversao, valorConvertido);

    }
    private boolean continuaConversao(){
        System.out.println("\n***********************\n");
        System.out.println("Deseja realizar outra conversão? (S/N):");
        String continua = scanner.nextLine().trim().toUpperCase();
        return continua.equals("S");
    }
}
