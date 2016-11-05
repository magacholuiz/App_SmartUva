package com.magacho.smartuva.CRListView;

/**
 * Created by luizmagacho on 28/10/15.
 */
public class MateriaNotas {

    private String materia;
    private String nota;


    public MateriaNotas(String materia, String nota){

        super();

        this.materia = materia;
        this.nota = nota;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    /*public void somarNotas(){
        for(int i = 0; i < nota.length(); i ++){
            getNota(i);
        }
    }*/

}
