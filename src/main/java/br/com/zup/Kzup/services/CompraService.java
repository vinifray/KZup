package br.com.zup.Kzup.services;

import br.com.zup.Kzup.exceptions.ProdutosForaDeEstoqueException;
import br.com.zup.Kzup.models.Compra;
import br.com.zup.Kzup.models.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {
    @Autowired
    private ProdutoService produtoService;
    private List<Compra> compras = new ArrayList<>();

    public void registrarCompra(Compra compra){
        List<String> nomeDosProdutosForaDeEstoque = new ArrayList<>();

        for (Produto produto : compra.getCarrinho()){
            if(produtoService.produtoEsgotado(produto)){
                nomeDosProdutosForaDeEstoque.add(produto.getNome());
            }else{
                compra.getCarrinho().remove(produto);
                compra.getCarrinho().add(produtoService.buscarProdutoPeloNome(produto));
            }
        }

        if(!nomeDosProdutosForaDeEstoque.isEmpty()){
            throw new ProdutosForaDeEstoqueException(nomeDosProdutosForaDeEstoque);
        }

        compras.add(compra);
    }

}
