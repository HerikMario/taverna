package personagem.conjurador;

import items.Arma;
import personagem.Personagem;
import util.Dados;

public class Conjurador extends Personagem {
    //Atributos
    private int mana;

    //Construtores
    public Conjurador(String nome, int forca, int agilidade, int intelecto, Arma arma) {
        super(nome, forca, agilidade, intelecto, arma);
        this.mana = calcularMana();
    }

    //Métodos Públicos
    @Override
    public int atacar(Personagem alvo){
        if ((Dados.rolar(1, 20) < alvo.getDefesa()) || !estaVivo()){
            return 0;
        }
        if (this.mana < 5) {
            return Dados.rolar(getArma().getDano().getQuantidade(), getArma().getDano().getLados()) + getArma().getDano().getModificador();
        }
        this.mana -= 5;
        return Dados.rolar(1, 10) + getIntelecto()/2;
    }

    //Métodos Privados
    public int calcularMana(){
        return 10 + (getIntelecto() * 2);
    }

    //Getters e Setters
    public int getMana(){
        return mana;
    }
}
