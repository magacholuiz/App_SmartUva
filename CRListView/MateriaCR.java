package com.magacho.smartuva.CRListView;



import java.util.ArrayList;

/**
 * Created by luizmagacho on 28/10/15.
 */
public class MateriaCR {

    private String name;
    private ArrayList<MateriaNotas> infoList = new ArrayList<MateriaNotas>();

    public MateriaCR(String name, ArrayList<MateriaNotas> infoList) {
        super();
        this.name = name;
        this.infoList = infoList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<MateriaNotas> getInfoList() {
        return infoList;
    }

    public void setCountryList(ArrayList<MateriaNotas> countryList) {
        this.infoList = countryList;
    }
}
