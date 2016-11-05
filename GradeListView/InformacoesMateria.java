package com.magacho.smartuva.GradeListView;


/**
 * Created by luizmagacho on 26/10/15.
 */
public class InformacoesMateria {

    private String dia;
    private String horario;
    private String turma;
    private String professor;
    private String sala;

    public InformacoesMateria(String dia, String horario, String turma, String professor, String sala){

        super();

        this.dia = dia;
        this.horario = horario;
        this.turma = turma;
        this.professor = professor;
        this.sala = sala;
    }

    public InformacoesMateria(){}

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
