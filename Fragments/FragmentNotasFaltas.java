package com.magacho.smartuva.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.magacho.smartuva.CRListView.MyListAdapterCR;
import com.magacho.smartuva.R;

/**
 * Created by luizmagacho on 04/11/15.
 */
public class FragmentNotasFaltas extends Fragment {

    private View fragmentNotas;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        fragmentNotas = inflater.inflate(R.layout.fragment_notas_e_faltas, container, false);



        return fragmentNotas;
    }
}
