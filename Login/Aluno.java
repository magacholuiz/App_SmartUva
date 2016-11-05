package com.magacho.smartuva.Login;

/**
 * Created by luizmagacho on 16/10/15.
 */
public class Aluno {

    private Integer id;
    private String matricula;
    private String senha;

    public Aluno (){

    }

    public Aluno( String matricula, String senha) {


        this.matricula = matricula;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
