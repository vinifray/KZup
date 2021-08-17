package br.com.zup.Kzup.exceptions;

public class MensagemErro {

    private String mensagem;

    public MensagemErro(String s) {
        mensagem = s;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
