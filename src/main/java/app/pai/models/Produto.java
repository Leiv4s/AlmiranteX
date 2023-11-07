package app.pai.models;

public class Produto {
    private String categoria;
    private String tamanho;
    private float precoCusto;
    private float precoAlmejado;
    private float precoDeVenda;



    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public float getPrecoAlmejado() {
        return precoAlmejado;
    }

    public void setPrecoAlmejado(float precoAlmejado) {
        this.precoAlmejado = precoAlmejado;
    }

    public float getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(float precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }


}
