package com.example.joe.stormy.UI;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

import com.example.joe.stormy.R;

/**
 * Created by Joe on 9/9/2015.
 */
public class AlertDialogFragment extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(R.string.Error_Title)
                .setMessage(R.string.Error_Message)
                .setPositiveButton(R.string.Error_OK_message, null);
        AlertDialog dialog= builder.create();
        return dialog;
    }
}
