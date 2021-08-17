package br.com.zup.Kzup.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControladorAdvisor {

    @ExceptionHandler(ProdutosForaDeEstoqueException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemErro manipularProdutosForaDeEstoqueExcption(ProdutosForaDeEstoqueException exception){
        StringBuilder mensagem = new StringBuilder();
        mensagem.append("Os produtos a seguir estão em falta no momento: ");

        for (String nomeDoProduto : exception.nomeDosProdutos){
            mensagem.append(nomeDoProduto+" ");
        }

        return new MensagemErro(mensagem.toString());
    }
}
