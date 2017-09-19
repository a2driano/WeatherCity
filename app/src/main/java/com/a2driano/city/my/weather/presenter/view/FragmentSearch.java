package com.a2driano.city.my.weather.presenter.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.a2driano.city.my.weather.R;
import com.a2driano.city.my.weather.presenter.PresenterSearch;

import static com.a2driano.city.my.weather.utils.converter.animation.AnimationCommon.hideAnimation;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentSearch#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentSearch extends Fragment implements View.OnClickListener {
    private Button mButtonSearch;
    private Button mButtonAddToFavorites;
    private ImageView mWeatherIcon;
    private TextView mCityName;
    private TextView mTemperature;
    private TextView mCloudWeather;
    private EditText mSearchEditText;
    private RelativeLayout mWeatherCityLayout;

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
        //buttons
        mButtonSearch = (Button) rootView.findViewById(R.id.button_start_search);
        mButtonSearch.setOnClickListener(this);
        mButtonAddToFavorites = (Button) rootView.findViewById(R.id.button_add_to_favorites);
        mButtonAddToFavorites.setOnClickListener(this);
        //layout
        mWeatherCityLayout = (RelativeLayout) rootView.findViewById(R.id.weather_layout);
        //icon
        mWeatherIcon = (ImageView) rootView.findViewById(R.id.icon_weather);
        //edit search view text
        mSearchEditText = (EditText) rootView.findViewById(R.id.search_edit_text);
        //text view`s
        mCityName = (TextView) rootView.findViewById(R.id.city_name_text);
        mTemperature = (TextView) rootView.findViewById(R.id.temperature_main_text);
        mCloudWeather = (TextView) rootView.findViewById(R.id.cloud_info);

        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_start_search:
                String cityName = mSearchEditText.getText().toString();
                if (cityName.length() > 0) {
                    if (mWeatherCityLayout.getVisibility() == View.VISIBLE) {
                        mWeatherCityLayout.setVisibility(View.GONE);
                        hideAnimation(getActivity(), mWeatherCityLayout);
                    }
                    Log.d("probe download", "******************* mSearchEditText.getText().toString(): " + mSearchEditText.getText().toString());
//                    mPresenter.searchCityWeather("Dnipropetrovsk", "metric", null);
                    mPresenter.searchCityWeather(cityName, "metric", mWeatherCityLayout);
                } else {
                    Toast.makeText(getActivity(), R.string.edit_text_is_empty, Toast.LENGTH_SHORT).show();
                }


//                new WeatherProvider(709930, "metric").getCurrentWeather();
                break;
        }


    }
}
