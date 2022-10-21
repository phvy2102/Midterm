package com.example.midterm_android;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    private RecyclerView rcvCata;
    private CataAdapter cataAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_list, container, false);
        rcvCata = rootView.findViewById(R.id.rcvCate);
        cataAdapter = new CataAdapter(getContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rcvCata.setLayoutManager((linearLayoutManager));
        cataAdapter.setData(getListCata());
        rcvCata.setAdapter(cataAdapter);

        return rootView;
    }

    private List<Cata> getListCata(){
        List<Cata> listCata = new ArrayList<>();

        List<Senda> listSenda = new ArrayList<>();
        listSenda.add(new Senda(R.drawable.img1,"Thạch Ngọc" ));
        listSenda.add(new Senda(R.drawable.img2,"Tai thỏ" ));
        listSenda.add(new Senda(R.drawable.img3,"Thái xanh" ));
        listSenda.add(new Senda(R.drawable.img4,"Hàm cá mập" ));
        listSenda.add(new Senda(R.drawable.img1,"Thạch Ngọc" ));
        listSenda.add(new Senda(R.drawable.img2,"Tai thỏ" ));
        listSenda.add(new Senda(R.drawable.img3,"Thái xanh" ));
        listSenda.add(new Senda(R.drawable.img4,"Hàm cá mập" ));

        listCata.add(new Cata("Sen Thái Xanh", listSenda));
        listCata.add(new Cata("Sen Việt Nam", listSenda));
        listCata.add(new Cata("Sen Đá Úc", listSenda));
        listCata.add(new Cata("Sen Xanh", listSenda));
        listCata.add(new Cata("Sen Đỏ", listSenda));
        listCata.add(new Cata("Sen Hồng", listSenda));
        listCata.add(new Cata("Sen Trắng", listSenda));
        return  listCata;
    }
}