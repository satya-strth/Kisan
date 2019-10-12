package com.aryatech.kisan;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import static com.aryatech.kisan.DatabaseHelper.COL_1;
import static com.aryatech.kisan.DatabaseHelper.TABLE_NAME;

public class SearchUserFragment extends Fragment implements AdapterView.OnItemSelectedListener {
   private SQLiteDatabase mDatabase;
    Spinner spinner;
    private SearchDataAdapter mAdapter;
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
        DatabaseHelper dbhelper=new DatabaseHelper(getContext());
        mDatabase=dbhelper.getReadableDatabase();
        RecyclerView recyclerView=view.findViewById(R.id.recycleview_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter=new SearchDataAdapter(getContext(),this.searchData());
        recyclerView.setAdapter(mAdapter);



    }

    private Cursor searchData() {
        String item1= (String) spinner.getSelectedItem();
        DatabaseHelper dbhelper=new DatabaseHelper(getContext());
        mDatabase=dbhelper.getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME+" WHERE "+COL_1+" like '%"+item1+"%'";
        Cursor row = mDatabase.rawQuery(query, null);
        return row;

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
                        searchData();
                        Toast.makeText(getActivity(), "Selected: " + item1, Toast.LENGTH_LONG).show();

                    }
                }
        );

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
