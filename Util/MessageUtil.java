package com.magacho.smartuva.Util;

import android.app.Activity;
import android.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by luizmagacho on 05/10/15.
 */
public class MessageUtil {

    public static void addMsg(Activity activity, String msg){

        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();

    }

    public static void addMsgOk(Activity activity, String titulo, String msg, int icone){

        AlertDialog.Builder builderDialog = new AlertDialog.Builder(activity);
        builderDialog.setTitle(titulo);

    }
}
