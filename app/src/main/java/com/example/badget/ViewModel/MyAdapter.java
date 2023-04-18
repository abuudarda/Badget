package com.example.badget.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.badget.Model.Expense;
import com.example.badget.R;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private Context context;
    private List<Expense> expenseList;

    private  inter click;
    public MyAdapter(Context context, inter click) {
        this.context = context;
        expenseList= new ArrayList<>();
        this.click=click;
    }
    public void add(Expense ex){
        expenseList.add(ex);
        notifyDataSetChanged();
    }
    public void clear(){
        expenseList.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);

        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Expense expenseModel = expenseList.get(position);

//        int timeInMillisInt = (int) Calendar.getInstance().getTimeInMillis();
        long timeInMillisInt = expenseModel.getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        String dateString = formatter.format(new Date( timeInMillisInt ));

        holder.date.setText("Date :"+ dateString);
        holder.note.setText("Note: " + expenseModel.getNote());
//        holder.category.setText("Category: " + expenseModel.getCat());
        holder.amount.setText(String.valueOf(expenseModel.getAmount()));
        holder.type.setText("Type: " + expenseModel.getType());
        if(expenseModel.getType().equals("Income")){
            holder.amount.setTextColor(ContextCompat.getColor(context,R.color.teal_200));
            holder.bdt.setTextColor(ContextCompat.getColor(context,R.color.teal_200));
            holder.category.setText("Source: " + expenseModel.getCat());

        }
        else{
            holder.amount.setTextColor(ContextCompat.getColor(context,R.color.red));
            holder.bdt.setTextColor(ContextCompat.getColor(context,R.color.red));
            holder.category.setText("Category: " + expenseModel.getCat());

        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onClick(expenseModel);
            }
        });


    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView note, category, amount, date, type, bdt;
        private CardView cardview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            note = itemView.findViewById(R.id.note);
            category = itemView.findViewById(R.id.category);
            amount = itemView.findViewById(R.id.amount);
            date = itemView.findViewById(R.id.date);
            cardview = itemView.findViewById(R.id.cardview);
            type = itemView.findViewById(R.id.type);
            bdt = itemView.findViewById(R.id.bdt);
        }
    }
}
