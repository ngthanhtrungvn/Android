package com.example.tuan12_1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tuan12_1.databinding.FragmentInformationEmployeeBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformationEmployeeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformationEmployeeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    // TODO: Rename and change types of parameters

    static MyItemRecyclerViewAdapter NVs;

    public InformationEmployeeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment InformationEmployeeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static InformationEmployeeFragment newInstance(MyItemRecyclerViewAdapter adapter) {
        InformationEmployeeFragment fragment = new InformationEmployeeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        NVs = adapter;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentInformationEmployeeBinding binding = FragmentInformationEmployeeBinding.inflate(inflater, container,false);
        binding.btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean sex = null;
                if (binding.rbNam.isChecked()) {
                    sex = true;
                }
                else {
                    sex = false;
                }
                NVs.add(binding.edtManv.getText().toString(), binding.edtTennv.getText().toString(), sex);
            }
        });
        return binding.getRoot();
    }
}