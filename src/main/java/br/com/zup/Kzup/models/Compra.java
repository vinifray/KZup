package br.com.zup.Kzup.models;

import java.util.List;

public class Compra {
    private List<Produto> carrinho;

    public Compra() {
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    public void setCarrinho(List<Produto> carrinho) {
        this.carrinho = carrinho;
    }
}
