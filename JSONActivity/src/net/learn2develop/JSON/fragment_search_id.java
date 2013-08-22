package net.learn2develop.JSON;



/**
 * Created by dae-0024 on 7/08/13.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
public class fragment_search_id extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
//---Inflate the layout for this fragment---
        return inflater.inflate(
                R.layout.fragment_search_id, container, false);
    }
}