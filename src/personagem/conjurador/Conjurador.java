package personagem.conjurador;

import combate.ResultadoAcerto;
import itens.Arma;
import personagem.Personagem;
import util.Dados;

public abstract class Conjurador extends Personagem {
    //Constantes
    public static final int CUSTO_MAGIA = 5;
    public static final int MANA_BASE = 10;
    public static final int MULTIPLICADOR_INTELECTO_MANA = 2;

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
        if (!estaVivo()) {
            return 0;
        }
        // Decisão de regra: o teste de acerto vem antes da escolha entre magia e arma,
        // então a mana só é gasta quando o ataque acerta. Um erro não consome mana.
        ResultadoAcerto resultado = testarAcerto(alvo);
        if (resultado == ResultadoAcerto.ERRO) {
            return 0;
        }
        int dano;
        if (this.mana < CUSTO_MAGIA) {
            dano = getArma().getDano().rolar();
        } else {
            this.mana -= CUSTO_MAGIA;
            dano = Dados.rolar(1, 10) + getIntelecto()/2;
        }
        if (resultado == ResultadoAcerto.CRITICO) {
            dano *= 2;
        }
        return dano;
    }

    public int calcularMana(){
        return MANA_BASE + (getIntelecto() * MULTIPLICADOR_INTELECTO_MANA);
    }

    //Métodos Protegidos
    // Conjuradores usam o Intelecto no teste de acerto, inclusive quando atacam com a arma.
    @Override
    protected int getAtributoPrincipal() {
        return getIntelecto();
    }

    //Getters e Setters
    public int getMana(){
        return mana;
    }
}
