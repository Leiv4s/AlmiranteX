package app.pai.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venda {

    private List<Produto> carrinho = new ArrayList<>();
    private float precoTotal;
    private Date dataHoraAtual = new Date();



/*    String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
    String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
    *

 */

    public List<Produto> getVenda() {
        return carrinho;
    }

    public void setVenda(List<Produto> venda) {
        this.carrinho = venda;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Date getDataHoraAtual() {
        return dataHoraAtual;
    }

}



