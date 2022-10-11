package com.example.midterm_android;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midterm_android.databinding.FragmentProfileBinding;

public class ProfileFragment extends Fragment {

    private FragmentProfileBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentProfileBinding.inflate(inflater, container, false);

        binding.ibLogout.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), LoginActivity.class);
            startActivity(intent);
        });

        SinhVien sinhVien = (SinhVien) getActivity().getIntent().getSerializableExtra("sinhVienNe");

        if (sinhVien != null) {
            binding.tvName.setText(sinhVien.getHoTen().toString());
            binding.tvEmail.setText(sinhVien.getEmail().toString());
        }

        return binding.getRoot();
    }
}