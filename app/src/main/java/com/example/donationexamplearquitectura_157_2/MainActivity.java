package com.example.donationexamplearquitectura_157_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.donationexamplearquitectura_157_2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        controller = new Controller();
        mBinding.button.setOnClickListener(v -> makeDonation());
    }

    private void makeDonation() {
        boolean donation = controller.saveDonation(mBinding.etDonation.getText().toString());
        if (donation){
            int totalDonation = controller.totalDonation();
            String total = getString(R.string.total_donation, String.valueOf(totalDonation));
            mBinding.tvTotal.setText(total);
            mBinding.etDonation.setText("");
        } else {
            showMessage("Donacion no realizada");
        }
    }

    private void showMessage(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}