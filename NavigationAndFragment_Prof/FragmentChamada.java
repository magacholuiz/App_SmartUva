package com.magacho.smartuva.NavigationAndFragment_Prof;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.magacho.smartuva.R;

public class FragmentChamada extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        return inflater.inflate(R.layout.fragment_chamada, container, false);
    }

}
