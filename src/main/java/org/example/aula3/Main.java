package org.example.aula3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        exibirTitulo();

        System.out.println("🦸🏽‍♂ Digite o nome do seu heroí: ️");
        String nomeHeroi = scanner.next();

        Heroi heroi = new Heroi(nomeHeroi, 100,20,5);

        System.out.println("\n✅ Herói criado com sucesso!");
        heroi.exibirStatus();

        Monstro[] monstros = {
                new Monstro("Goblin", "👿", 40,12,2,20),
                new Monstro("Orc Guerreiro", "👺", 70,12,2,20),
                new Monstro("Dragão Negro", "👽", 120,28,10,100)
        };

        int vitorias = 0;

        for(Monstro monstro: monstros) {
            System.out.println("\n\n🗺️ Você avança pela dungeon...");
            System.out.println("🚪 Um " + monstro.getNome() + " bloqueia o caminho!");
            System.out.println("\n [1] Lutar");
            System.out.println(" [2] Fugir (pula essa batalha)");
            System.out.println(" Escolha: ");

            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (Exception e ){
                opcao = 1;
                scanner.nextLine();
            }

            if (opcao == 2) {
                System.out.println(" 🏃🏽 Você fugiu para o proximo corredor...");
                continue;
            }

            Batalha batalha = new Batalha(heroi, monstro, scanner);
            boolean venceu = batalha.iniciar();

            if (venceu) {
                vitorias++;
                System.out.println("\n [Pressione ENTER para continuar]");
                scanner.nextLine();
                scanner.nextLine();
            } else {
                exibirGameOver(nomeHeroi, vitorias, heroi.getXp());
                scanner.close();
                return;
            }

        }

        exibirVitoria(heroi, vitorias);
        scanner.close();
    }

    private static void exibirTitulo() {
        System.out.println("-------------------------------------------");
        System.out.println("-         ⚔️ DUNGEON QUEST                -");
        System.out.println("-  Programação Orientação a Objeto        -");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private static void exibirGameOver() {

    }

}