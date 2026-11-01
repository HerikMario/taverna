package personagem;

import items.Arma;
import combate.Dano;
import util.Dados;

public abstract class Personagem {
    //Constantes
    public static final int VALOR_BASE_DEFESA = 10;
    public static final int VALOR_BASE_VIDA = 20;
    public static final int ATRIBUTO_MAXIMO = 10;
    public static final int ATRIBUTO_MINIMO = 1;

    //Atributos
    private String nome;
    private int forca;
    private int agilidade;
    private int intelecto;
    private int vidaAtual;
    private int vidaMaxima;
    private int defesa;
    private Arma arma;

    //Construtores
    public Personagem(String nome, int forca, int agilidade, int intelecto, Arma arma) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O personagem precisa ter um nome");
        }
        this.nome = nome;
        this.forca = validarAtributo("Força", forca);
        this.agilidade = validarAtributo("Agilidade", agilidade);
        this.intelecto = validarAtributo("Intelecto", intelecto);
        this.arma = arma;
        this.vidaAtual = calcularVidaMaxima();
        this.vidaMaxima = calcularVidaMaxima();
        this.defesa = calcularDefesa();
    }

    public Personagem(String nome, int forca, int agilidade, int intelecto) {
        this(nome, forca, agilidade, intelecto, new Arma("Mãos", new Dano(1,4)));
    }

    //Métodos Abstratos
    public abstract int atacar(Personagem alvo);

    //Métodos Públicos
    public int calcularVidaMaxima() {
        return VALOR_BASE_VIDA + (forca * 2);
    }

    public int calcularDefesa() {
        return VALOR_BASE_DEFESA + agilidade;
    }

    public int rolarIniciativa() {
        return Dados.rolar(1, 20) + getAgilidade();
    }

    public void receberDano(int dano) {
        if (dano < 0) {
            throw new IllegalArgumentException("O dano não pode ser negativo");
        }
        vidaAtual -= dano;
        if (vidaAtual <= 0) {
            vidaAtual = 0;
        }
    }

    public void curar(int pontosDeCura) {
        if (pontosDeCura < 0) {
            throw new IllegalArgumentException("Os pontos de cura não podem ser negativos");
        }
        if (!estaVivo()) {
            throw new IllegalStateException("Não se pode curar um personagem morto");
        }
        vidaAtual += pontosDeCura;
        int vidaMaxima = calcularVidaMaxima();
        if (vidaAtual > vidaMaxima) {
            vidaAtual = vidaMaxima;
        }
    }

    public boolean estaVivo() {
        return vidaAtual > 0;
    }

    //Métodos Privados
    private int validarAtributo(String nomeDoAtributo, int atributo) {
        if (atributo < ATRIBUTO_MINIMO || atributo > ATRIBUTO_MAXIMO) {
            throw new IllegalArgumentException(String.format("O atributo %s precisa estar entre 1 e 10", nomeDoAtributo));
        }
        return atributo;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public int getForca() {
        return forca;
    }

    public int getAgilidade() {
        return agilidade;
    }

    public int getIntelecto() {
        return intelecto;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public int getDefesa() {
        return defesa;
    }

    public Arma getArma() {
        return arma;
    }

    //toString
    @Override
    public String toString() {
        return String.format("Nome: %s%nForça: %d%nAgilidade: %d%nIntelecto: %d%nVida: %d/%d%nDefesa: %d%Arma: %d%n", nome, forca, agilidade, intelecto, vidaAtual, vidaMaxima, defesa, arma.getNome());
    }
}
