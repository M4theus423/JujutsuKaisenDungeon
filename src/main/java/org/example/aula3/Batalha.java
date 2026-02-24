package org.example.aula3;
    
import java.util.Scanner;

public class Batalha {

    private Heroi heroi;
    private Monstro monstro;
    private Scanner scanner;

    public Batalha(Heroi heroi, Monstro monstro, Scanner scanner) {
        this.heroi = heroi;
        this.monstro = monstro;
        this.scanner = scanner;
    }

    /**
     * Inicia e controla o loop de batalha
     * @return true se o heroi venceu, false se foi derrotado.
     */

    public boolean iniciar() {
        exibirCabecalhoBatalha();

        int turno = 1;

        while (heroi.estaVivo() && monstro.estaVivo()) {
            System.out.println("-------------- Turno " + turno + " -------------");
            exibirStatusBatalha();

            turnoHeroi(); // jogador escolhe a ação

            if (monstro.estaVivo()) {
                turnoMonstro();
            }
            turno++;
        }

        return resolverFinal();
    }

    //---------------- Metodos Privados ---------------------

    private void turnoHeroi() {
        System.out.println("\n O que " + heroi.getNome() + " faz?");
        System.out.println(" [1] Atacar");
        System.out.println(" [2] Usar Poção ( " +heroi.getPocoes() + " restantes)");
        System.out.println(" Escolha: ");

        int escolha = lerEscolha();

        switch (escolha) {
            case 1:
                int dano = heroi.atacar();
                System.out.println("\n ⚔️ " + heroi.getNome() + " atacou por " + dano + "!");
                monstro.receberDano(dano);
                break;
            case 2:
                heroi.usarPocao();
                break;
            default:
                System.out.println(" ❓ Opção inválida - turno perdido!!");
        }
    }

    private void turnoMonstro() {
        int dano = monstro.atacar();
        System.out.println("\n " + monstro.getNome() + " ataca por " + dano + "!");
        heroi.receberDano(dano);
    }

    private boolean resolverFinal() {
        System.out.println("\n------------------------------------");
        if (heroi.estaVivo()) {
            System.out.println(" 🎉 VITÓRIA!");
            System.out.println(" Você derrotou " + monstro.getNome() + "!");
            heroi.ganharXp(monstro.getXpRecompensa());
            return true;
        } else {
            System.out.println(" 💀 DERROTA!");
            System.out.println(" " + heroi.getNome() + " foi derrotado...");
            return false;
        }
    }

    private void exibirCabecalhoBatalha() {
        System.out.println("---------------------------------");
        System.out.println("     ⚔️ BATALHA INICIADA!        ");
        System.out.println("----------------------------------");
        System.out.println(" " + heroi.getNome() + " vs " + monstro.getNome());
    }

    private void exibirStatusBatalha() {
        heroi.exibirStatus();
        System.out.println();
        monstro.exibirStatus();
    }

    private int lerEscolha() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }

}
