package com.example.midterm_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.midterm_android.databinding.FragmentExercisesListBinding;

import java.util.ArrayList;

public class ExercisesListFragment extends Fragment {

    private FragmentExercisesListBinding binding;
    private ArrayList<Exercise> pets;
    private ExerciseAdapter petAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentExercisesListBinding.inflate(inflater, container, false);

        addPets();

        petAdapter = new ExerciseAdapter(getContext(), pets);
        binding.rvPet.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        binding.rvPet.setAdapter(petAdapter);

        return binding.getRoot();
    }

    private void addPets() {
        pets = new ArrayList<>();
        pets.add(new Exercise("2022 Workout 1", "28 days", "20-30 min/day", R.drawable.td1));
        pets.add(new Exercise("2022 Workout 2", "2 weeks", "20-50 min/day", R.drawable.td2));
        pets.add(new Exercise("2022 Workout 3", "3 days", "10-20 min/day", R.drawable.td3));
        pets.add(new Exercise("2022 Workout 4", "2 months", "2-3 min/day", R.drawable.td4));
        pets.add(new Exercise("2022 Workout 5", "1 days", "5-10 min/day", R.drawable.td5));
    }
}