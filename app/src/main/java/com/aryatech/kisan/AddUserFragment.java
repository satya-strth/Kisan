package com.aryatech.kisan;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class AddUserFragment extends Fragment {
    DatabaseHelper myDb;

    EditText registration, name, fathers_name, ward, village, mobile, aadhaar, bank, ifsc;
    Button button_save, button_reset;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_adduser, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        myDb = new DatabaseHelper(getActivity());
        registration = view.findViewById(R.id.registration);
        name = view.findViewById(R.id.name);
        fathers_name = view.findViewById(R.id.fathers_name);
        ward = view.findViewById(R.id.ward);
        village = view.findViewById(R.id.village);
        mobile = view.findViewById(R.id.mobile);
        aadhaar = view.findViewById(R.id.aadhaar);
        bank = view.findViewById(R.id.bank);
        ifsc = view.findViewById(R.id.ifsc);
        button_save = view.findViewById(R.id.button_save);
        button_reset = view.findViewById(R.id.button_reset);
        AddData();
        Back();
    }

    public void AddData() {
        button_save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insertData(registration.getText().toString(),
                                name.getText().toString(),
                                fathers_name.getText().toString(),
                                ward.getText().toString(),
                                village.getText().toString(),
                                mobile.getText().toString(),
                                aadhaar.getText().toString(),
                                bank.getText().toString(),
                                ifsc.getText().toString());
                        if (isInserted == true) {
                            GoHome();

                        } else {
                            Snackbar.make(getView(), "Data Not Saved", Snackbar.LENGTH_LONG).show();
                            //Toast.makeText(getActivity(), "Data Not Inserted", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }
public void GoHome(){

    AlertDialog.Builder builder
            = new AlertDialog
            .Builder(getActivity());

builder.setIcon(R.drawable.ic_check_circle_black_24dp);
    // Set Alert Title
    builder.setTitle("Data Saved");


    // Set Cancelable false
    // for when the user clicks on the outside
    // the Dialog Box then it will remain show
    builder.setCancelable(false);

    // Set the positive button with yes name
    // OnClickListener method is use of
    // DialogInterface interface.

    builder
            .setPositiveButton(
                    "Ok",
                    new DialogInterface
                            .OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog,
                                            int which)
                        {

                            // When the user click yes button
                            // then app will close
                            dialog.dismiss();
                            getFragmentManager().beginTransaction().replace(R.id.fragment_container,new DashboardFragment()).commit();
                        }
                    });

    AlertDialog alertDialog = builder.create();

    // Show the Alert Dialog box
    alertDialog.show();
}

    public void Back() {
        button_reset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                            clearForm();

                    }
                }
        );

    }


    private void clearForm() {
        registration.getText().clear();
        registration.setFocusableInTouchMode(true);
        name.setText("");
        fathers_name.setText("");
        ward.setText("");
        village.setText("");
        mobile.setText("");
        aadhaar.setText("");
        bank.setText("");
        ifsc.setText("");
    }


}
