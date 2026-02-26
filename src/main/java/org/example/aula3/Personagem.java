package org.example.aula3;

public class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;
    protected int vidaAtual;
    protected int vidaMaxima;


    public Personagem(String nome, int vida, int ataque, int defesa){
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    
    public int atacar() {
        int variacao = (int)(Math.random() * 10) - 5; // Variação de -5 a +5
        return ataque + variacao;
    }

    public void receberDano(int dano) {
        int danoReal = dano - defesa;
        if(danoReal < 1) danoReal = 1;

        vidaAtual -= danoReal;
        if(vidaAtual < 0) vidaAtual = 0;

        System.out.println(" 💔" + nome + " recebeu " + danoReal + " de dano! "
        + "[❤️ " + vidaAtual + "/" + vidaMaxima + "]");

    }

    public boolean estaVivo() {
        return vidaAtual > 0;

}

    public String getNome() {
        return nome;
    }

    public boolean getVida() {
        return vidaAtual > 0;
    }
}   
