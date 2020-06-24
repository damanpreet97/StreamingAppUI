package com.example.weblooms.ui.dashboard;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.dgreenhalgh.android.simpleitemdecoration.grid.GridDividerItemDecoration;
import com.example.weblooms.R;
import com.example.weblooms.ui.adapters.FeedRecyclerViewAdapter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private static DashboardFragment dashboardFragment;
    private RecyclerView recyclerView;
    private ArrayList<String> imagesArrayList = new ArrayList<>();
    private FeedRecyclerViewAdapter feedRecyclerViewAdapter;
//
//    public static DashboardFragment newInstance(String type){
//            dashboardFragment = new DashboardFragment();
//            Bundle bundle = new Bundle();
//            bundle.putString("type", type);
//            dashboardFragment.setArguments(bundle);
//            return dashboardFragment;
//    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        recyclerView = root.findViewById(R.id.recycler_view);
        Log.e("TAG", "onCreateView: dashboardFragment");

        feedRecyclerViewAdapter = new FeedRecyclerViewAdapter(imagesArrayList);

        dashboardViewModel.getList().observe(getViewLifecycleOwner(), new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                imagesArrayList.addAll(strings);
                feedRecyclerViewAdapter.notifyDataSetChanged();
                Log.e("TAG", "obser live data called: dashboardFragment " + imagesArrayList.size());
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        Drawable horizontalDivider = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);
        Drawable verticalDivider = ContextCompat.getDrawable(getContext(), R.drawable.line_divider);
        recyclerView.addItemDecoration(new GridDividerItemDecoration(horizontalDivider, verticalDivider, 3));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(feedRecyclerViewAdapter);
    }
}