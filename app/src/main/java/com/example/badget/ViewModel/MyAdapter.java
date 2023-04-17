package com.example.badget.ViewModel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.badget.Model.Expense;
import com.example.badget.R;

import java.util.ArrayList;
import java.util.List;

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
//        holder.date.setText();
        holder.note.setText("Note: " + expenseModel.getNote());
        holder.category.setText("Category: " + expenseModel.getCat());
        holder.amount.setText(String.valueOf(expenseModel.getAmount()));
        holder.type.setText("Type: " + expenseModel.getType());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                click.onClick(expenseModel);
            }
        });

//        holder.cardview.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), R.anim.anim_one));

    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView note, category, amount, date, type;
        private CardView cardview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            note = itemView.findViewById(R.id.note);
            category = itemView.findViewById(R.id.category);
            amount = itemView.findViewById(R.id.amount);
            date = itemView.findViewById(R.id.date);
            cardview = itemView.findViewById(R.id.cardview);
            type = itemView.findViewById(R.id.type);

        }
    }
}
