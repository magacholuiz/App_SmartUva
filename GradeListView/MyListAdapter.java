package com.magacho.smartuva.GradeListView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.magacho.smartuva.R;

import com.magacho.smartuva.FragmentGrade;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by luizmagacho on 26/10/15.
 */
public class MyListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Materia> materiaList;
    private ArrayList<Materia> originalList;

    public MyListAdapter(Context context, ArrayList<Materia> materiaList) {

        this.context = context;
        this.materiaList = new ArrayList<Materia>();
        this.materiaList.addAll(materiaList);
        this.originalList = new ArrayList<Materia>();
        this.originalList.addAll(materiaList);
    }
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        ArrayList<InformacoesMateria> countryList = materiaList.get(groupPosition).getInfoList();
        return countryList.get(childPosition);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        InformacoesMateria infoMateria = (InformacoesMateria) getChild(groupPosition, childPosition);
        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_row, null);
        }

        TextView dia = (TextView) convertView.findViewById(R.id.dia);
        TextView horario = (TextView) convertView.findViewById(R.id.horario);
        TextView turma = (TextView) convertView.findViewById(R.id.turma);
        TextView professor = (TextView) convertView.findViewById(R.id.professor);
        TextView sala = (TextView) convertView.findViewById(R.id.sala);
        dia.setText(infoMateria.getDia().trim());
        horario.setText(infoMateria.getHorario().trim());
        turma.setText(infoMateria.getTurma().trim());
        professor.setText(infoMateria.getProfessor().trim());
        sala.setText(infoMateria.getSala().trim());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        ArrayList<InformacoesMateria> countryList = materiaList.get(groupPosition).getInfoList();
        return countryList.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // TODO Auto-generated method stub
        return materiaList.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return materiaList.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        // TODO Auto-generated method stub
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Materia continent = (Materia) getGroup(groupPosition);


        if(convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.group_row, null);
        }

        TextView heading = (TextView) convertView.findViewById(R.id.heading);
        heading.setText(continent.getName().trim());

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        return true;
    }

    public void filterData(String query)
    {
        query = query.toLowerCase();
        Log.v("MyListAdapter", String.valueOf(materiaList.size()));
        materiaList.clear();

        if(query.isEmpty())
        {
            materiaList.addAll(originalList);
        } else {
            for(Materia continent: originalList)
            {
                ArrayList<InformacoesMateria> infoList = continent.getInfoList();
                ArrayList<InformacoesMateria> newList = new ArrayList<InformacoesMateria>();
                for(InformacoesMateria informacoesMateria: infoList)
                {
                    if(informacoesMateria.getDia().toLowerCase().contains(query) || informacoesMateria.getHorario().toLowerCase().contains(query)
                            || informacoesMateria.getTurma().toLowerCase().contains(query) || informacoesMateria.getProfessor().toLowerCase().contains(query)
                            || informacoesMateria.getSala().toLowerCase().contains(query))
                    {
                        newList.add(informacoesMateria);
                    }
                }
                if(newList.size() > 0)
                {
                    Materia nContinent = new Materia(continent.getName(), newList);
                    materiaList.add(nContinent);
                }
            }
        }

        Log.v("MyListAdapter", String.valueOf(materiaList.size()));
        notifyDataSetChanged();
    }
}
