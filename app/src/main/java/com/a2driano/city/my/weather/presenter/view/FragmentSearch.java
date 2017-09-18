package com.a2driano.city.my.weather.presenter.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.a2driano.city.my.weather.R;
import com.a2driano.city.my.weather.presenter.PresenterSearch;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSearch extends Fragment implements View.OnClickListener {
    private Button mButton;
    private PresenterSearch mPresenter;

    public FragmentSearch() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentSearch.
     */
    public static FragmentSearch newInstance() {
        FragmentSearch fragment = new FragmentSearch();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter = new PresenterSearch(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        mButton = (Button) rootView.findViewById(R.id.button);
        mButton.setOnClickListener(this);
        // Inflate the layout for this fragment
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
//                Log.d("probe download", "******************* : " + new WeatherProvider(709930, "metric").getCurrentWeather().toString());
                mPresenter.searchCityWeather("Dnipropetrovsk", "metric", null);
//                new WeatherProvider(709930, "metric").getCurrentWeather();
                break;
        }


    }
}
