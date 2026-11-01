package combate;

import util.Dados;

public class Dano {
    //Atributos
    private int quantidade;
    private int lados;
    private int modificador;

    //Construtores
    public Dano(int quantidade, int lados, int modificador) {
        if (quantidade < 1) {
            throw new IllegalArgumentException(String.format("A quantidade de dados precisa ser pelo menos 1, recebido: %d", quantidade));
        }
        if (lados < 2) {
            throw new IllegalArgumentException(String.format("O dado precisa ter pelo menos 2 lados, recebido: %d", lados));
        }
        this.quantidade = quantidade;
        this.lados = lados;
        this.modificador = modificador;
    }

    public Dano(int quantidade, int lados) {
        this(quantidade, lados, 0);
    }

    public Dano(int lados) {
        this(1, lados);
    }

    //Métodos Públicos
    public int rolar() {
        return Dados.rolar(quantidade, lados) + modificador;
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
