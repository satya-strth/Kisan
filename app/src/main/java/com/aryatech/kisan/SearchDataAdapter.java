package com.aryatech.kisan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SearchDataAdapter extends RecyclerView.Adapter<SearchDataAdapter.SearchViewHolder> {
    private Context scontext;
    private Cursor scursor;

    public SearchDataAdapter(Context context, Cursor cursor){
        scontext=context;
        scursor=cursor;

    }


    public class SearchViewHolder extends RecyclerView.ViewHolder{
        public TextView S_reg_No;
        public TextView S_name;
        public TextView S_f_name;
       // public TextView S_ward_No;
       // public TextView S_Vill_Name;
       // public TextView S_Mobile_No;
       // public TextView S_Aadhaar_No;
       // public TextView S_Bank_No;
       // public TextView S_IFSC_Code;
        CardView cardView;

        public SearchViewHolder(View itemView) {
            super(itemView);
            S_reg_No=itemView.findViewById(R.id.textView_S_regNo);
            S_name=itemView.findViewById(R.id.textView_S_nameText);
            S_f_name=itemView.findViewById(R.id.textView_S_fnameText);
            //S_ward_No=itemView.findViewById(R.id.textView_S_wardNo);
            //S_Vill_Name=itemView.findViewById(R.id.textView_S_villName);
            //S_Mobile_No=itemView.findViewById(R.id.textView_S_MobNo);
           // S_Aadhaar_No=itemView.findViewById(R.id.textView_S_aadhaarNo);
            //S_Bank_No=itemView.findViewById(R.id.textView_S_bankName);
          //  S_IFSC_Code=itemView.findViewById(R.id.textView_S_itsc_code);
            cardView=itemView.findViewById(R.id.sCardView);


        }
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(scontext);
        View view=inflater.inflate(R.layout.search_data,parent,false);
        return new SearchViewHolder(view);




    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        if(!scursor.moveToPosition(position)){

            return;
        }
        String registration=scursor.getString(scursor.getColumnIndex(DatabaseHelper.COL_1));
        String name=scursor.getString(scursor.getColumnIndex(DatabaseHelper.COL_2));
        String father_name=scursor.getString(scursor.getColumnIndex(DatabaseHelper.COL_3));
        holder.S_reg_No.setText(registration);
        holder.S_name.setText(name);
        holder.S_f_name.setText(father_name);

    }

    @Override
    public int getItemCount() {
        return scursor.getCount();
    }
}
