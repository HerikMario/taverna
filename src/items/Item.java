package items;

public abstract class Item {
    //Atributos
    private String nome;
    private String categoria;

    //Contrutor
    public Item(String nome, String categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    //Gettes e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
