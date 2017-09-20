package com.a2driano.city.my.weather.presenter.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.a2driano.city.my.weather.R;
import com.a2driano.city.my.weather.presenter.PresenterFavorite;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link FragmentFavorite#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFavorite extends Fragment {
    private LinearLayout mLinearLayout;
    private PresenterFavorite mPresenterFavorite;

    public FragmentFavorite() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentFavorite.
     */
    public static FragmentFavorite newInstance() {
        FragmentFavorite fragment = new FragmentFavorite();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(false);

        mPresenterFavorite = new PresenterFavorite(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_favorite, container, false);

        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.container_scroll);

        mPresenterFavorite.loadFavorites(mLinearLayout);

        return rootView;
    }

    @Override
    public void onResume() {


        super.onResume();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            mPresenterFavorite.loadFavorites(mLinearLayout);
        } else {
        }
    }
}
