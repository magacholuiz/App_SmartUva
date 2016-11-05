package com.magacho.smartuva.GradeListView;

import java.util.ArrayList;

/**
 * Created by luizmagacho on 26/10/15.
 */
public class Materia {

    private String name;
    private ArrayList<InformacoesMateria> infoList = new ArrayList<InformacoesMateria>();

    public Materia(String name, ArrayList<InformacoesMateria> infoList) {
        super();
        this.name = name;
        this.infoList = infoList;
    }

    public Materia(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<InformacoesMateria> getInfoList() {
        return infoList;
    }

    public void setCountryList(ArrayList<InformacoesMateria> countryList) {
        this.infoList = countryList;
    }
}
