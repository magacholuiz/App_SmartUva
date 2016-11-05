package com.magacho.smartuva.CRListView;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import com.magacho.smartuva.R;

import java.util.ArrayList;

/**
 * Created by luizmagacho on 28/10/15.
 */
public class MyListAdapterCR  extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<MateriaCR> materiaList;
    private ArrayList<MateriaCR> originalList;

    public MyListAdapterCR(Context context, ArrayList<MateriaCR> materiaList) {

        this.context = context;
        this.materiaList = new ArrayList<MateriaCR>();
        this.materiaList.addAll(materiaList);
        this.originalList = new ArrayList<MateriaCR>();
        this.originalList.addAll(materiaList);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // TODO Auto-generated method stub
        ArrayList<MateriaNotas> countryList = materiaList.get(groupPosition).getInfoList();
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

        MateriaNotas infoMateria = (MateriaNotas) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_row_cr, null);
        }

        TextView materia = (TextView) convertView.findViewById(R.id.materia);
        TextView nota = (TextView) convertView.findViewById(R.id.nota);
        materia.setText(infoMateria.getMateria().trim());
        nota.setText(infoMateria.getNota().trim());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // TODO Auto-generated method stub
        ArrayList<MateriaNotas> countryList = materiaList.get(groupPosition).getInfoList();
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
        MateriaCR continent = (MateriaCR) getGroup(groupPosition);


        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.group_row_cr, null);
        }

        TextView heading = (TextView) convertView.findViewById(R.id.heading_cr);
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

    public void filterData(String query) {
        query = query.toLowerCase();
        Log.v("MyListAdapter", String.valueOf(materiaList.size()));
        materiaList.clear();

        if (query.isEmpty()) {
            materiaList.addAll(originalList);
        } else {
            for (MateriaCR continent : originalList) {
                ArrayList<MateriaNotas> infoList = continent.getInfoList();
                ArrayList<MateriaNotas> newList = new ArrayList<MateriaNotas>();
                for (MateriaNotas materiaNotas : infoList) {
                    if (materiaNotas.getMateria().toLowerCase().contains(query) || materiaNotas.getNota().toLowerCase().contains(query)
                            ) {
                        newList.add(materiaNotas);
                    }
                }
                if (newList.size() > 0) {
                    MateriaCR nContinent = new MateriaCR(continent.getName(), newList);
                    materiaList.add(nContinent);
                }
            }
        }

        Log.v("MyListAdapter", String.valueOf(materiaList.size()));
        notifyDataSetChanged();
    }

}
