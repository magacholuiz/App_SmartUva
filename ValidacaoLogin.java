package com.magacho.smartuva;

/**
 * Created by luizmagacho on 19/10/15.
 */
public class ValidacaoLogin {

    private boolean valido;

    private String mensagem;

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
