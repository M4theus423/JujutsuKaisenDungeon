package org.example.aula3;

import java.util.ArrayList; 

public class Heroi {

    private String nome;
    private int vidaMaxima;
    private int vidaAtual;
    private int ataque;
    private int defesa;
    private int tecnicasAmaldiçoadasUsadas;
    private int xp;

    private ArrayList<Item> inventario = new ArrayList<>();

    private int nivel = 1;

    private void verificarNivel() {
        int xpNecessaria = nivel * 100;
        if (xp >= xpNecessaria) {
            nivel++;
            ataque += 5;
            defesa += 3;
            vidaMaxima += 20;
            vidaAtual += 20; // Cura o herói ao subir de nível
            if(vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;
            tecnicasAmaldiçoadasUsadas++;

            System.out.println("\n🎉 LEVEL UP! ");
            System.out.println(" 🎉 " + nome + " subiu para o nível " + nivel + "! Atributos aumentados!");
            System.out.println(" ⚔️ Ataque +10 | 🛡️ Defesa +5 | ❤️ Vida Máxima +50");
        }   
    }

    public int getNivel() {
        return nivel;
    }

    public Heroi(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vidaMaxima = vida;
        this.vidaAtual = vida;
        this.ataque = ataque;
        this.defesa = defesa;
        this.tecnicasAmaldiçoadasUsadas = 0;
        this.xp = 0;
    }

    public String getNome() {return nome;}
    public int getVida()    { return  vidaAtual; }
    public int getAtaque()  { return ataque; }
    public int getDefesa()  { return defesa; }
    public int getTecnicasAmaldiçoadasUsadas()  { return tecnicasAmaldiçoadasUsadas; }
    public int getXp()      { return xp; }

    public int atacar() {
        int variacao = (int)(Math.random() * 10) - 5;
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

    public void adicionarItem(Item item) {
        inventario.add(item);
        System.out.println(" 🎁 " + item.getNome() + " adicionado ao inventário!");
    }

    public void listarInventario() {
        System.out.println("\n📦 Inventário de " + nome + ":");
        if (inventario.isEmpty()) {
            System.out.println(" (vazio)");
        } else {
            for (int i = 0; i < inventario.size(); i++) {
                Item item = inventario.get(i);
                System.out.println(" [" + (i+1) + "] " + item.getDescricao());
            }
        }
    }

    public boolean usarItem(int indice) {
        if (indice < 1 || indice > inventario.size()) {
            System.out.println(" ❌ Índice inválido!");
            return false;
        }
        Item item = inventario.get(indice - 1);
        item.usar(this);
        inventario.remove(indice - 1);
        return true;
    }

    public boolean usarTecnicaAmaldiçoada() {
        if (tecnicasAmaldiçoadasUsadas >= 3) {
            System.out.println(" ❌ Máximo de técnicas amaldiçoadas usadas!");
            return false;
        }
        if (vidaAtual == vidaMaxima){
            System.out.println(" ⚠️ Vida já está cheia! Técnica amaldiçoada não foi usada.");
            return false;
        }

        int cura = 30;
        vidaAtual += cura;
        if ( vidaAtual > vidaMaxima) vidaAtual = vidaMaxima;

        tecnicasAmaldiçoadasUsadas++;
        System.out.println(" 🧪 " + nome + " usou técnica amaldiçoada! +30 💚 "
                + "[💚 " + vidaAtual + "/" + vidaMaxima + "] [Técnicas Amaldiçoadas Usadas: " + tecnicasAmaldiçoadasUsadas + "]");
        return true;
    }

    public void ganharXp(int quantidade) {
        xp += quantidade;
        System.out.println(" ⭐⬆️" + quantidade + " XP! [Total: " + xp + "]");
        verificarNivel();
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    public void exibirStatus() {
        System.out.println("\n🦸‍♂️ " + nome);
        System.out.println(" ❤️ Vida: " + vidaAtual + "/" + vidaMaxima);
        System.out.println(" ⚔️ Ataque: " + ataque);
        System.out.println(" 🛡️ Defesa: " + defesa);
        System.out.println(" ⚡ Técnicas Amaldiçoadas Usadas: " + tecnicasAmaldiçoadasUsadas);
        System.out.println(" ⭐ XP: " + xp);
        System.out.println(" nível: " + nivel);

    }
}
