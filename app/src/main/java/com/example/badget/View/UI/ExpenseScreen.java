package com.example.badget.View.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.badget.Model.Expense;
import com.example.badget.R;
import com.example.badget.databinding.ActivityExpenseScreenBinding;
import com.example.badget.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.UUID;

public class ExpenseScreen extends AppCompatActivity {
    ActivityExpenseScreenBinding binding;
    private String type;
    private Expense expenseModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityExpenseScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        type=getIntent().getStringExtra(("type"));

        expenseModel=(Expense) getIntent().getSerializableExtra("model");

        if(expenseModel!=null){
            type=expenseModel.getType();
            binding.ammount.setText(String.valueOf(expenseModel.getAmount()));
            binding.category.setText(expenseModel.getCat());
            binding.note.setText(expenseModel.getNote());
        }
        if(type.equals("Income")){
            binding.incomeRadio.setChecked(true);
        }
        else binding.expenseRadio.setChecked(true);

        binding.incomeRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type="Income";
            }
        });
        binding.expenseRadio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                type="expense";
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.tick_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.saveExpense){
            createExpense();
            return true;
        }
        return true;
    }
    private void createExpense() {

        String expenseId = UUID.randomUUID().toString();
        String amount = binding.ammount.getText().toString();
        String note = binding.note.getText().toString();
        String category = binding.category.getText().toString();
//        String type="";
        boolean incomeChecked = binding.incomeRadio.isChecked();

        if (incomeChecked) {
            type = "Income";
        } else {
            type = "Expense";
        }

        if (amount.trim().length() == 0) {
            binding.ammount.setError("Empty Amount");
            binding.ammount.requestFocus();
            return;
        }

        Expense expenseModel = new Expense(expenseId, note, category, type, Integer.parseInt(amount),
                (int) Calendar.getInstance().getTimeInMillis(),FirebaseAuth.getInstance().getUid());
        FirebaseFirestore
                .getInstance()
                .collection("expenses")
                .document(expenseId)
                .set(expenseModel);
        finish();

    }
    private void updateExpense() {

        String expenseId = expenseModel.getEId();
        String amount = binding.ammount.getText().toString();
        String note = binding.note.getText().toString();
        String category = binding.category.getText().toString();

        boolean incomeChecked = binding.incomeRadio.isChecked();
        if (incomeChecked) {
            type = "Income";
        } else {
            type = "Expense";
        }

        if (amount.trim().length() == 0) {
            binding.ammount.setError("Empty Amount");
            return;
        }

        Expense model = new Expense(expenseId, note, category, type, Integer.parseInt(amount),
                expenseModel.getTime(), FirebaseAuth.getInstance().getUid());


        FirebaseFirestore
                .getInstance()
                .collection("expenses")
                .document(expenseId)
                .set(model);
        finish();

    }
}