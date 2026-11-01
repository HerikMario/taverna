package combate;

public class Dano {
    //Atributos
    private int quantidade;
    private int lados;
    private int modificador;

    //Construtores
    public Dano(int quantidade, int lados, int modificador) {
        this.quantidade = quantidade;
        this.lados = lados;
        this.modificador = modificador;
    }

    public Dano(int quantidade, int lados) {
        this.quantidade = quantidade;
        this.lados = lados;
        this.modificador = 0;
    }

    public Dano(int lados) {
        this.quantidade = 1;
        this.lados = lados;
        this.modificador = 0;
    }

    //Getters e Setters
    public int getQuantidade() {
        return quantidade;
    }

    public int getLados() {
        return lados;
    }

    public int getModificador() {
        return modificador;
    }
}
