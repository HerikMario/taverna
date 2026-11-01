package items;

import combate.Dano;

public class Arma extends Item{
    //Atributos
    private Dano dano;

    //Construtor
    public Arma(String nome, Dano dano) {
        super(nome, "Arma");
        this.dano = dano;
    }

    //Getters e Setters
    public Dano getDano() {
        return dano;
    }

    public void setDano(Dano dano) {
        this.dano = dano;
    }
}
