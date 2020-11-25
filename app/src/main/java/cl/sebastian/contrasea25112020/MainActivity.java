package cl.sebastian.contrasea25112020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import cl.sebastian.contrasea25112020.databinding.ActivityMainBinding;
import cl.sebastian.contrasea25112020.presenter.IPresenterView;
import cl.sebastian.contrasea25112020.presenter.Presenter;

public class MainActivity extends AppCompatActivity implements IPresenterView {
    public ActivityMainBinding binding;
    private Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        presenter=new Presenter(this);
        binding.editTextTextPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                presenter.evaluatePass(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    @Override
    public void showWeak() {
        binding.textView.setText(R.string.debil);
        binding.textView.setBackgroundColor(Color.RED);
    }

    @Override
    public void showMedium() {
        binding.textView.setText(R.string.medio);
        binding.textView.setBackgroundColor(Color.YELLOW);

    }

    @Override
    public void ShowStrong() {
        binding.textView.setText(R.string.fuerte);
        binding.textView.setBackgroundColor(Color.GREEN);

    }
}