package com.aryatech.kisan;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private Context mcontext;
    private Cursor mcursor;

    public DataAdapter(Context context, Cursor cursor){
        mcontext=context;
        mcursor=cursor;

    }


    public class DataViewHolder extends RecyclerView.ViewHolder{
        public TextView regNo;
        public TextView kname;
        public TextView fname;
        CardView cardView;

        public DataViewHolder(View itemView) {
            super(itemView);
            regNo=itemView.findViewById(R.id.textView_reg);
            kname=itemView.findViewById(R.id.textView_name);
            fname=itemView.findViewById(R.id.textView_father);
            cardView=itemView.findViewById(R.id.mCardView);

        }
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        View view=inflater.inflate(R.layout.registration_data,parent,false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        if(!mcursor.moveToPosition(position)){

            return;
        }
        String registration=mcursor.getString(mcursor.getColumnIndex(DatabaseHelper.COL_1));
        String name=mcursor.getString(mcursor.getColumnIndex(DatabaseHelper.COL_2));
        String father_name=mcursor.getString(mcursor.getColumnIndex(DatabaseHelper.COL_3));
        long reg=mcursor.getLong(mcursor.getColumnIndex(DatabaseHelper.COL_1));
        holder.regNo.setText(registration);
        holder.kname.setText(name);
        holder.fname.setText(father_name);
        holder.itemView.setTag(reg);
    }


    @Override
    public int getItemCount() {
        return mcursor.getCount();
    }



    public void swapCursor(Cursor newCursor)
    {
         if(mcursor!=null)
         {
            mcursor.close();

         }

         mcursor=newCursor;
         if(newCursor!=null){
            notifyDataSetChanged();

         }
    }



}
