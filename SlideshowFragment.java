package com.example.pos.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.pos.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private ArrayList<String> info=new ArrayList<String>();
    private ArrayList<String> info1=new ArrayList<String>();
    private ArrayList<String> info2=new ArrayList<String>();
    private ArrayList<String> info3=new ArrayList<String>();

    TableLayout table;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_slideshow, container, false);
        return view;
    }

}