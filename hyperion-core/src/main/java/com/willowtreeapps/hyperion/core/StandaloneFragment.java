package com.willowtreeapps.hyperion.core;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.willowtreeapps.hyperion.plugin.v1.HyperionIgnore;

/**
 * 支持fragment
 * @author guoyang
 */
@HyperionIgnore
public class StandaloneFragment extends Fragment {
    private final PluginViewFactory factory = Hyperion.getPluginViewFactory();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_standalone, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        final LinearLayout rootView = view.findViewById(R.id.rootView);
        rootView.addView(createPluginView());
    }

    private View createPluginView() {
        View pluginView = factory.create(this.requireActivity());
        pluginView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return pluginView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            factory.destroy(this.requireActivity());
        } catch (Exception ignore) {
        }
    }

}
