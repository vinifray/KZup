package br.com.zup.Kzup.services;

import br.com.zup.Kzup.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProdutoService {

    private List<Produto> estoque = Arrays.asList(
            new Produto("Maça", 0, 0.23),
            new Produto("Skate", 0, 100.00));

    public Produto buscarProdutoPeloNome(String nome){
        for (Produto produto : estoque){
            if (produto.getNome().equals(nome)){
                return produto;
            }
        }

        throw new RuntimeException("Produto não encontrado");
    }

    public Produto buscarProdutoPeloNome(Produto produto){
        return buscarProdutoPeloNome(produto.getNome());
    }

    public boolean produtoEsgotado(Produto produto){
        Produto produtoEmEstoque = buscarProdutoPeloNome(produto);

        if (produtoEmEstoque.getQuantidade() <= 0){
            return true;
        }
        return false;
    }

}
