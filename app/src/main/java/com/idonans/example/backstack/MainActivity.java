package com.idonans.example.backstack;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.idonans.backstack.ViewUtil;
import com.idonans.backstack.dialog.ViewDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View view = findViewById(R.id.btn_show_dialog);
        ViewUtil.onClick(view, v ->
                new ViewDialog.Builder(MainActivity.this)
                        .setContentView(R.layout.dialog_view)
                        .setParentView(findViewById(android.R.id.content))
                        .dimBackground(true)
                        .defaultAnimation()
                        .create()
                        .show()
        );
    }

}
