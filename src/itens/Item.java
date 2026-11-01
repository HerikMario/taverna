package itens;

public abstract class Item {
    //Atributos
    private String nome;
    private String categoria;

    //Contrutor
    public Item(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }
}
