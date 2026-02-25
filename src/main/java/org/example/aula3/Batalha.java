package org.example.aula3;
    
import java.util.Scanner;

public class Batalha {

    private Heroi feiticeiro;
    private Monstro monstro;
    private Scanner scanner;

    public Batalha(Heroi feiticeiro, Monstro maldicao, Scanner scanner) {
        this.feiticeiro = feiticeiro;
        this.monstro = maldicao;
        this.scanner = scanner;
    }

    /**
     * Inicia e controla o loop de batalha
     * @return true se o feiticeiro venceu, false se foi derrotado.
     */

    public boolean iniciar() {
        exibirCabecalhoBatalha();

        int turno = 1;

        while (feiticeiro.estaVivo() && monstro.estaVivo()) {
            System.out.println("-------------- Turno " + turno + " -------------");
            exibirStatusBatalha();

            turnoFeiticeiro(); // jogador escolhe a ação

            if (monstro.estaVivo()) {
                turnoMonstro();
            }
            turno++;
        }

        return resolverFinal();
    }

    //---------------- Metodos Privados ---------------------

    private void turnoFeiticeiro() {
        System.out.println("\n O que " + feiticeiro.getNome() + " faz?");
        System.out.println(" [1] Atacar");
        System.out.println(" [2] Usar técnica reversa para se curar ( " +feiticeiro.getTecnicasAmaldiçoadasUsadas() + " restantes)");
        System.out.println(" [3] USar item amaldiçoado");
        System.out.println(" Escolha: ");

        int escolha = lerEscolha();

        switch (escolha) {
            case 1:
                int dano = feiticeiro.atacar();
                System.out.println("\n ⚔️ " + feiticeiro.getNome() + " atacou por " + dano + "!");
                monstro.receberDano(dano);
                break;
            case 2:
                feiticeiro.usarTecnicaAmaldiçoada();
                break;
            case 3:
                feiticeiro.listarInventario();
                System.out.println("Digite o número do item/técnica a usar: ");
                int indice = lerEscolha();
                if (indice != -1) {
                    feiticeiro.usarItem(indice);
                } else {
                    System.out.println(" ❌ Entrada inválida - turno perdido!!");
                }
                break;
            default:
                System.out.println(" ❓ Opção inválida - turno perdido!!");
        }
    }

    private void turnoMonstro() {
        int dano = monstro.atacar();
        System.out.println("\n " + monstro.getNome() + " ataca por " + dano + "!");
        feiticeiro.receberDano(dano);
    }

    private boolean resolverFinal() {
        System.out.println("\n------------------------------------");
        if (feiticeiro.estaVivo()) {
            System.out.println(" 🎉 VITÓRIA!");
            System.out.println(" Você derrotou " + monstro.getNome() + "!");
            feiticeiro.ganharXp(monstro.getXpRecompensa());
            return true;
        } else {
            System.out.println(" 💀 DERROTA!");
            System.out.println(" " + feiticeiro.getNome() + " foi derrotado...");
            return false;
        }
    }

    private void exibirCabecalhoBatalha() {
        System.out.println("---------------------------------");
        System.out.println("     ⚔️ BATALHA INICIADA!        ");
        System.out.println("----------------------------------");
        System.out.println(" " + feiticeiro.getNome() + " vs " + monstro.getNome());
    }

    private void exibirStatusBatalha() {
        feiticeiro.exibirStatus();
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
