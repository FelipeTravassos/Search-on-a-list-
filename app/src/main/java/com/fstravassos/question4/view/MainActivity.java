package com.fstravassos.question4.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.fstravassos.question4.viewmodel.MainViewModel;
import com.fstravassos.question4.R;
import com.fstravassos.question4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainViewModel viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        ActivityMainBinding binding= DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);

        ListAdapter adapter = new ListAdapter();
        binding.list.setAdapter(adapter);
        viewModel.getList().observe(this, adapter::onListUpdate);
    }
}
