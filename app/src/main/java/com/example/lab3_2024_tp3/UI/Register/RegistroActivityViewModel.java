package com.example.lab3_2024_tp3.UI.Register;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lab3_2024_tp3.Model.User;
import com.example.lab3_2024_tp3.Services.SPService;

import kotlinx.coroutines.channels.ProduceKt;

public class RegistroActivityViewModel extends AndroidViewModel {

    private MutableLiveData<User> mUser;

    public RegistroActivityViewModel(@NonNull Application application) {
        super(application);

    }

    public LiveData<User> getMUser(){
        if (mUser == null){
            mUser = new MutableLiveData<>();
        }
        return mUser;
    }

    public void readUser(){
        mUser.setValue(SPService.read(getApplication().getApplicationContext()));
    }

    public void setUser(User user){
        SPService.saveUser(getApplication().getApplicationContext(), user);
        Toast.makeText(getApplication(), "Saved", Toast.LENGTH_SHORT).show();
    }




}
