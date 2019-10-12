package com.aryatech.kisan;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class SearchUserFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    EditText registration, name, fathers_name, ward, village, mobile, aadhaar, bank, ifsc;
    Button button_save, button_reset,button_search;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_searchuser, container, false);

    }




    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinner=view.findViewById(R.id.search_spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.search_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        button_search = view.findViewById(R.id.button_search);
        Search();
    }





    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
        //Toast.makeText(getActivity(), "Selected: " + item, Toast.LENGTH_LONG).show();
    }


    public void Search() {
        button_search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String item1= (String) spinner.getSelectedItem();
                        Toast.makeText(getActivity(), "Selected: " + item1, Toast.LENGTH_LONG).show();




                    }
                }
        );

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
