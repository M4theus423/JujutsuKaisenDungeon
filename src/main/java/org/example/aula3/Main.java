package org.example.aula3;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Personagem heroi = new Personagem("Aragorn", 100, 20, 5);
        Personagem monstro = new Personagem("Goblin", 40,12,2);
        Personagem dragao = new Personagem("Dragão", 120,30,10);

        heroi.exibirStatus();
        System.out.println();
        monstro.exibirStatus();
        System.out.println();
        dragao.exibirStatus();




    }
}