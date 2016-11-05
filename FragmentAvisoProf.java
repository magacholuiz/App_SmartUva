package com.magacho.smartuva;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by luizmagacho on 08/10/15.
 */
public class FragmentAvisoProf extends Fragment{

    private View fragmentAvisoProf;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        fragmentAvisoProf = inflater.inflate(R.layout.fragment_avisoprof, container, false);

        return fragmentAvisoProf;
    }
}
