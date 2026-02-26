package org.example.aula3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        exibirTitulo();

        System.out.println("🦸🏽‍♂ Digite o nome do seu feitceiro: ️");
        String nomeHeroi = scanner.next();

        Heroi heroi = new Heroi(nomeHeroi, 150,35,5);

        // Dando itens iniciais para o herói
        heroi.adicionarItem(new Item("Poção de cura pequena", "cura", 30));
        heroi.adicionarItem(new Item("Poção de cura média", "cura", 50));
        heroi.adicionarItem(new Item("Poção de cura Grande", "cura", 70));
        System.out.println("\n✅ Feiticeiro criado com sucesso!");
        heroi.exibirStatus();

        Monstro[] monstros = {
                new Monstro("Maldição Grau 5", "👾", 20,5,10,40),
                new Monstro("Maldição Grau 4", "👹", 40,11,23,70),
                new Monstro("Maldição Grau 3", "👻", 80,22,75,150),
                new Monstro("Maldição Grau 2", "👽", 530,76,85,900),
                new Monstro("Maldição Grau 1", "👺", 780,90,87,1100),
                new Monstro("Maldição Grau Especial" , "👿", 23890,90,800,1500),
        };

        int vitorias = 0;

        for(Monstro monstro: monstros) {
            System.out.println("\n\n🗺️ Você avança pela estação...");
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
                System.out.println(" 🏃🏽 Você fugiu para o proximo andar da estação...");
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
        System.out.println("-         ⚔️ CURSED QUEST                -");
        System.out.println("-  Programação Orientação a Objeto        -");
        System.out.println("-------------------------------------------");
        System.out.println();
    }

    private static void exibirGameOver(String nome, int vitorias, int xp) {
        System.out.println("-------------------------------------------");
        System.out.println("-            ☠️ GAME OVER                 -");
        System.out.println("-------------------------------------------");
        System.out.println(" Fim da Jornada de " + nome);
        System.out.println(" Vitórias: "+ vitorias);
        System.out.println(" XP Total: " + xp);
        System.out.println();
    }

    private static void exibirVitoria(Heroi heroi, int vitorias) {
        System.out.println("-----------------------------------------------");
        System.out.println("-           👑 ESTAÇÃO EXORCIZADA!              -");
        System.out.println("-----------------------------------------------");
        System.out.println(" Parabéns, " + heroi.getNome() + "!");
        System.out.println(" Vitórias: " + vitorias);
        System.out.println(" XP Total: " + heroi.getXp());
        heroi.exibirStatus();
    }
} 