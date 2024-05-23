package com.willowtreeapps.hyperion.core;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.willowtreeapps.hyperion.plugin.v1.HyperionIgnore;

@HyperionIgnore
public class StandaloneActivity extends AppCompatActivity {
    private final PluginViewFactory factory = Hyperion.getPluginViewFactory();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.rootView, new StandaloneFragment()).commitAllowingStateLoss();
        final LinearLayout rootView = findViewById(R.id.rootView);
        rootView.addView(createPluginView());
    }

    private View createPluginView() {
        View pluginView = factory.create(this);
        pluginView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        return pluginView;
    }

    @Override
    protected void onDestroy() {
        factory.destroy(this);
        super.onDestroy();
    }
}
