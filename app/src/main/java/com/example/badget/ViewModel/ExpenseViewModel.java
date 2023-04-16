package com.example.badget.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.badget.Model.Expense;

public class ExpenseViewModel extends ViewModel {

    private MutableLiveData<String> EId = new MutableLiveData<>();
    private MutableLiveData<String> note = new MutableLiveData<>();
    private MutableLiveData<String> cat = new MutableLiveData<>();
    private MutableLiveData<String> type = new MutableLiveData<>();
    private MutableLiveData<String> Uid = new MutableLiveData<>();
    private MutableLiveData<Integer> amount = new MutableLiveData<>();
    private MutableLiveData<Integer> time = new MutableLiveData<>();

    // getters and setters for the LiveData variables
    public LiveData<String> getEId() { return EId; }
    public void setEId(String EId) { this.EId.setValue(EId); }
    public LiveData<String> getNote() { return note; }
    public void setNote(String note) { this.note.setValue(note); }
    public LiveData<String> getCat() { return cat; }
    public void setCat(String cat) { this.cat.setValue(cat); }
    public LiveData<String> getType() { return type; }
    public void setType(String type) { this.type.setValue(type); }
    public LiveData<String> getUid() { return Uid; }
    public void setUid(String uid) { this.Uid.setValue(uid); }
    public LiveData<Integer> getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount.setValue(amount); }
    public LiveData<Integer> getTime() { return time; }
    public void setTime(Integer time) { this.time.setValue(time); }

    public void setExpense(Expense expense) {
        EId.setValue(expense.getEId());
        note.setValue(expense.getNote());
        cat.setValue(expense.getCat());
        type.setValue(expense.getType());
        Uid.setValue(expense.getUid());
        amount.setValue(expense.getAmount());
        time.setValue(expense.getTime());
    }
}
