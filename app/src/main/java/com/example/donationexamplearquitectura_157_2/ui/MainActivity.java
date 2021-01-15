package com.example.donationexamplearquitectura_157_2.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.example.donationexamplearquitectura_157_2.R;
import com.example.donationexamplearquitectura_157_2.databinding.ActivityMainBinding;
import com.example.donationexamplearquitectura_157_2.presentador.DonationPresenter;
import com.example.donationexamplearquitectura_157_2.presentador.IViewPresenter;

public class MainActivity extends AppCompatActivity implements IViewPresenter {

    private ActivityMainBinding mBinding;
    private DonationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        //No olvidar instanciar el presenter
        presenter = new DonationPresenter(this);
        mBinding.button.setOnClickListener(v -> makeDonation());

    }

    private void makeDonation() {
      presenter.saveDonation(mBinding.etDonation.getText().toString());
      mBinding.etDonation.setText("");
      presenter.checkTotal();
    }


    @Override
    public void updateTotalDonation(int totalAmount) {
        String total = getString(R.string.total_donation, String.valueOf(totalAmount));
        mBinding.tvTotal.setText(total);
    }

    @Override
    public void displayConfirmationMessage() {
        Toast.makeText(this, "Donación Realizada", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayErrorMessage() {
        Toast.makeText(this, "Algo Ocurrio Error en la donación",
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayColorAlert(String color) {
        mBinding.textView.setBackgroundColor(Color.parseColor(color));
    }


}