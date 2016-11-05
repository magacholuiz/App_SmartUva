package com.magacho.smartuva;

import android.app.Activity;

import com.magacho.smartuva.database.GradeDB;


/**
 * Created by luizmagacho on 31/10/16.
 */
public class GradeBO {

    private GradeDB gradeDB;



    public GradeBO(Activity activity){

        gradeDB = new GradeDB(activity);
        gradeDB.popularBD();

    }
}
