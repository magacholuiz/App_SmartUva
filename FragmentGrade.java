package com.magacho.smartuva;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import com.magacho.smartuva.GradeListView.*;
import com.magacho.smartuva.database.GradeDB;

import java.util.ArrayList;

/**
 * Created by luizmagacho on 07/10/15.
 */
public class FragmentGrade extends Fragment {





    private MyListAdapter listAdapter;
    private ExpandableListView myList;
    private ArrayList<Materia> materiaList = new ArrayList<Materia>();
    private View fragmentGrade;
    private GradeDB gradeDB;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        gradeDB = new GradeDB(this);



        ArrayList<InformacoesMateria> infoMateriaList = new ArrayList<InformacoesMateria>();
        InformacoesMateria infoMateria = new InformacoesMateria("Segunda-Feira", "18:20", "1ECP35A","MIGUEL ANGELO Z. DE FIGUEIREDO", "TJA127");
        infoMateriaList.add(infoMateria);

        Materia materia = new Materia("Técnicas Digitais", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<InformacoesMateria>();
        infoMateria = new InformacoesMateria("Segunda-Feira", "20:30", "1ECP36A","CARLOS ALBERTO ALVES LEMOS", "TJA317");
        infoMateriaList.add(infoMateria);
        materia = new Materia("Sistemas Operacionais", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<InformacoesMateria>();
        infoMateria = new InformacoesMateria("Terça-Feira", "18:20", "1ENG32H","SANDRO GOLDENGOL", "TJC214");
        infoMateriaList.add(infoMateria);
        materia = new Materia("Física III", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<InformacoesMateria>();
        infoMateria = new InformacoesMateria("Quarta-Feira", "18:20", "1INF32A","JOBSON LUIZ MAZZOLLAR DA SILVA", "TJA127");
        infoMateriaList.add(infoMateria);
        infoMateria = new InformacoesMateria("Quinta-Feira", "18:20", "1INF32A","JOBSON LUIZ MAZZOLLAR DA SILVA", "TJA127");
        infoMateriaList.add(infoMateria);
        materia = new Materia("Programação Orientada a Objetos", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<InformacoesMateria>();
        infoMateria = new InformacoesMateria("Quarta-Feira", "20:30", "INF32B","Thiago Marciel", "414C");
        infoMateriaList.add(infoMateria);
        materia = new Materia("Cálculo III", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<InformacoesMateria>();
        infoMateria = new InformacoesMateria("Sexta-Feira", "18:20", "1INF35A","VINCENZO DE ROBERTO JUNIOR", "TJA127");
        infoMateriaList.add(infoMateria);
        materia = new Materia("Banco de Dados II", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<InformacoesMateria>();
        infoMateria = new InformacoesMateria("Sábado", "07:30", "1ENG36A","VINICIUS MACIEL PINTO", "TJC315");
        infoMateriaList.add(infoMateria);
        materia = new Materia("Projeto II", infoMateriaList);
        materiaList.add(materia);



    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        fragmentGrade = inflater.inflate(R.layout.fragment_grade, container, false);

        myList = (ExpandableListView) fragmentGrade.findViewById(R.id.expandableList);
        // create the adapter by passing your ArrayList data
        listAdapter = new MyListAdapter(getActivity(), materiaList);
        // attach the adapter to the list
        myList.setAdapter(listAdapter);
        // display the list

        // expand all Groups
        //expandAll();

        return fragmentGrade;
    }


}
