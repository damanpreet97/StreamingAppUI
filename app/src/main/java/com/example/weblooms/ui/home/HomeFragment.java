package com.example.weblooms.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.weblooms.MainActivity;
import com.example.weblooms.R;
import com.example.weblooms.ui.dashboard.DashboardFragment;
import com.example.weblooms.ui.notifications.NotificationsFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private String[] titles = new String[]{"For You", "Near You", "Popular"};
    private ViewPager2 viewPager;
    TabLayout tabLayout;
    Toolbar toolbar;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
//        final TextView textView = root.findViewById(R.id.text_home);


//        actionBar = findViewById(R.id.app_bar);
        toolbar = root.findViewById(R.id.toolbar);

//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayShowHomeEnabled(false);

//        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
//        getActivity().getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setDisplayShowHomeEnabled(false);
//
//        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
//                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewPagerFragmentAdapter viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(this);
        viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(viewPagerFragmentAdapter);
        tabLayout = view.findViewById(R.id.tab_layout);
        viewPager.setUserInputEnabled(true);

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText(titles[position]);
                    }
                }
        ).attach();

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }

    private class ViewPagerFragmentAdapter extends FragmentStateAdapter {

        public ViewPagerFragmentAdapter(@NonNull Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Log.e("TAG", "createFragment: " + position );
            switch (position) {
                case 0:
                    Log.e("TAG", "switch: " + position);
                    return new DashboardFragment();
                case 1:
                    Log.e("TAG", "switch: " + position);
                    return new NotificationsFragment();
                case 2:
                    Log.e("TAG", "switch: " + position);
                    return new NotificationsFragment();
            }
            Log.e("TAG", "createFragment outside switch: " + position );
            return new DashboardFragment();
        }

        @Override
        public int getItemCount() {
            return titles.length;
        }
    }


//    private Fragment startFragment(Fragment fragment) {
//        getChildFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
//    }
}