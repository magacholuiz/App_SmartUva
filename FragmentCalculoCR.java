package com.magacho.smartuva;

import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.magacho.smartuva.CRListView.*;

import java.util.ArrayList;

/**
 * Created by luizmagacho on 07/10/15.
 */
public class FragmentCalculoCR extends Fragment {

    private MyListAdapterCR listAdapter;
    private ExpandableListView myList;
    private ArrayList<MateriaCR> materiaList = new ArrayList<MateriaCR>();
    private View fragmentCalCR;
    private float calculoCR = 0;
    private String cr;
    ArrayList<MateriaNotas> infoMateriaList;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        infoMateriaList = new ArrayList<MateriaNotas>();
        MateriaNotas infoMateria = new MateriaNotas("COMUNICAÇÃO ORAL E ESCRITA", "5.70");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("CALCULO VETORIAL E GEOMETRIA ANALITICA", "5.60");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("QUIMICA GERAL", "8.50");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("PRINCIPIOS DA ENGENHARIA", "10.00");
        infoMateriaList.add(infoMateria);

        MateriaCR materia = new MateriaCR("2013.1", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<MateriaNotas>();
        infoMateria = new MateriaNotas("CALCULO ELEMENTAR", "5.50");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("LABORATÓRIO DE CRIATIVIDADE E INOVAÇÃO", "8.00");
        infoMateriaList.add(infoMateria);

        infoMateria = new MateriaNotas("TÉCNICAS DE LAB. DE FISICA I", "6.00");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("ALGEBRA LINEAR", "5.00");
        infoMateriaList.add(infoMateria);

        materia = new MateriaCR("2013.2", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<MateriaNotas>();
        infoMateria = new MateriaNotas("PROJETO I", "8.50");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("CALCULO DIFERENCIAL E INTEGRAL I", "6.50");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("TÉCNICAS DE LAB. DE FISICA II", "6.50");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("ALGORITMOS", "9.30");
        infoMateriaList.add(infoMateria);

        infoMateria = new MateriaNotas("ESTATISTICA", "9.50");
        infoMateriaList.add(infoMateria);

        infoMateria = new MateriaNotas("EXPRESSAO GRAFICA I", "8.30");
        infoMateriaList.add(infoMateria);

        materia = new MateriaCR("2014.1", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<MateriaNotas>();
        infoMateria = new MateriaNotas("FISICA I", "6.30");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("CIENCIAS DOS MATERIAIS", "6.30");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("PROGRAMAÇAO DE APLICATIVOS", "10.00");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("FILOSOFIA", "7.30");
        infoMateriaList.add(infoMateria);

        infoMateria = new MateriaNotas("CALCULO NUMERICO", "6.80");
        infoMateriaList.add(infoMateria);

        infoMateria = new MateriaNotas("PROGRAMAÇAO ESTRUTURADA", "8.80");
        infoMateriaList.add(infoMateria);

        materia = new MateriaCR("2014.2", infoMateriaList);
        materiaList.add(materia);

        infoMateriaList = new ArrayList<MateriaNotas>();
        infoMateria = new MateriaNotas("FISICA I", "6.30");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("BANCO DE DADOS I", "6.50");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("MATEMATICA DISCRETA I", "7.30");
        infoMateriaList.add(infoMateria);


        infoMateria = new MateriaNotas("CALCULO DIFERENCIAL E INTEGRAL II", "7.30");
        infoMateriaList.add(infoMateria);

        infoMateria = new MateriaNotas("FISICA II", "6.80");
        infoMateriaList.add(infoMateria);

        materia = new MateriaCR("2015.1", infoMateriaList);
        materiaList.add(materia);




/*
        calculoCR = 5.7f + 5.6f + 8.5f + 10 + 5.5f + 8 + 6 + 5 + 8.5f + 6.5f + 6.5f + 9.3f + 9.5f + 8.3f + 6.3f + 10 + 7.3f
        + 6.8f + 8.8f + 6.3f + 6.5f + (7.3f * 2) + 6.8f;

        calculoCR = calculoCR / 24;

        cr = String.valueOf(calculoCR);

        Toast.makeText(getActivity(),cr,Toast.LENGTH_LONG).show();

        cr_calculo.setText(cr);
*/

    }

    public void setText(String text){
        TextView cr_calculo = (TextView) getView().findViewById(R.id.cr_calculo);
        cr_calculo.setText(text);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        fragmentCalCR = inflater.inflate(R.layout.fragment_calculocr, container, false);

        //cr_calculo = (TextView) getView().findViewById(R.id.cr_calculo);

       /* for(int i = 0; i < infoMateriaList.size(); i++){
            calculoCR += Float.parseFloat(infoMateriaList.get(i).getNota()) ;
        }
        cr = String.valueOf(calculoCR);

        setText(cr);*/

        //cr_calculo.setText(cr);

        myList = (ExpandableListView) fragmentCalCR.findViewById(R.id.expandableList_cr);
        // create the adapter by passing your ArrayList data
        listAdapter = new MyListAdapterCR(getActivity(), materiaList);
        // attach the adapter to the list
        myList.setAdapter(listAdapter);
        // display the list

        // expand all Groups
        //expandAll();

        return fragmentCalCR;
    }

}
