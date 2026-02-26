package org.example.aula3;

public class Personagem {
    protected String nome;
    protected int vida;
    protected int ataque;
    protected int defesa;


    public Personagem(String nome, int vida, int ataque, int defesa){
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    
    public void receberDano(int d) { /*Lógica com defesa, minimo 1 */ }
    public boolean estaVivo() { return vida > 0; }
    public String getNome() { return nome;}
    public int getVida() { return vida; }
    }

