package org.example.aula3;

public class Item {

    private String nome;
    private String tipo;
    private int valor;

    public Item(String nome, String tipo, int valor) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = valor;
    }

    // Aplicar o efeito da técnica no feiticeiro (ex: usar técnica amaldiçoada para aumentar ataque) 
    public void usar(Heroi heroi) {
        if(tipo.equals("Técnica Jujutsu")) {
            heroi.usarTecnicaAmaldiçoada();
            System.out.println(" ⚡" + nome + " foi usado!");
        }
    }

    // Exemplo: "Técnica Amaldiçoada [Restantes: 3]"
    public String getDescricao() {
        return nome + " [" + tipo + " +" + valor + "]";
    }

    // Getters getNome(), getTipo(), getValor()
    public String getNome() {return nome; }
    public String getTipo() { return tipo; }
    public int getValor() { return valor; }
}
