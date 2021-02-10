package com.example.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import com.example.R;

public class CopyDialog extends Dialog {
    public CopyDialog(Context context, String text) {
        this(context, 0, null, text);
    }

    public CopyDialog(Context context, int theme, View contentView, String text) {
        super(context, theme == 0 ? R.style.Theme_MaterialComponents_Dialog : theme);

        if (contentView == null) {
            contentView = View.inflate(context, R.layout.copy_dialog, null);
        }
        this.setContentView(contentView);

        LinearLayout ll = contentView.findViewById(R.id.ll);

        TextInputEditText msg = contentView.findViewById(R.id.msg);
        msg.setText(text);

        MaterialButton btn = contentView.findViewById(R.id.btn);
        btn.setOnClickListener(v -> {
            this.dismiss();
        });

        ll.setLayoutParams(new FrameLayout.LayoutParams(
                (int) (getMobileWidth(context) * 0.85),
                LayoutParams.WRAP_CONTENT)
        );
    }

    public static int getMobileWidth(Context context) {
        DisplayMetrics dm = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm.widthPixels;
    }
}
