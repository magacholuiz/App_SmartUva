package com.magacho.smartuva.NavigationAndFragment_Prof;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.magacho.smartuva.R;

public class FragmentComucTurma extends Fragment {

    View fragmentComucTurma;
    Button enviar;
    EditText msg;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        fragmentComucTurma = inflater.inflate(R.layout.fragment_comuc_turma, container, false);

        this.enviar = (Button) fragmentComucTurma.findViewById(R.id.bt_enviar_turma);
        this.msg = (EditText) fragmentComucTurma.findViewById(R.id.mensagem);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return fragmentComucTurma;
    }

}
