package com.fstravassos.question4.view;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;

import com.fstravassos.question4.viewmodel.MainViewModel;

public class DataBindingAdapters {

    @BindingAdapter("listener")
    public static void setFilter(EditText search, final MainViewModel viewModel) {
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                viewModel.filter(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Not used
            }
        });
    }
}
