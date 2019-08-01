package com.idonans.example.backstack;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.idonans.backstack.dialog.ViewDialog;
import com.idonans.lang.util.ViewUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.btn_show_dialog);
        ViewUtil.onClick(view, v -> {
                    ViewDialog viewDialog =
                            new ViewDialog.Builder(MainActivity.this)
                                    .setContentView(R.layout.dialog_view)
                                    .setParentView(findViewById(R.id.content_parent_view))
                                    .dimBackground(true)
                                    .setContentViewShowAnimation(R.anim.backstack_slide_in_from_top)
                                    .setContentViewHideAnimation(R.anim.backstack_slide_out_to_top)
                                    .create();
                    ViewUtil.onClick(viewDialog.findViewById(R.id.menu_container), innerView -> viewDialog.hide(false));
                    viewDialog.show();
                }
        );
    }

}
