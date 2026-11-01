package itens;

import combate.Dano;

public class Arma extends Item{
    //Atributos
    private Dano dano;

    //Construtor
    public Arma(String nome, Dano dano) {
        super(nome, "Arma");
        this.dano = dano;
    }

    //Getters
    public Dano getDano() {
        return dano;
    }
}
