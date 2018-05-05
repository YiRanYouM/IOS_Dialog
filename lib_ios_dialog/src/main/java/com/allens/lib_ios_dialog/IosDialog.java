package com.allens.lib_ios_dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

/**
 * @author allens
 */
public class IosDialog {
    private Context context;
    private Dialog dialog;
    private LinearLayout lLayout_bg;
    private TextView txt_title;
    private TextView txt_msg;
    private Button btn_neg;
    private Button btn_pos;
    private ImageView img_line;
    private Display display;

    /**
     * 是否显示title
     */
    private boolean showTitle = false;
    /***
     * 是否显示msg
     */
    private boolean showMsg = false;
    /***
     * 是否显示确定按钮
     */
    private boolean showPosBtn = false;

    /**
     * 是否显示取消按钮
     */
    private boolean showNegBtn = false;


    /**
     * dialog  宽度
     */
    private float dialogWidth = 0.7f;


    public IosDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public IosDialog builder() {
        View view = LayoutInflater.from(context).inflate(R.layout.view_dialog, null);

        lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
        txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setVisibility(View.GONE);
        txt_msg = (TextView) view.findViewById(R.id.txt_msg);
        txt_msg.setVisibility(View.GONE);
        btn_neg = (Button) view.findViewById(R.id.btn_neg);
        btn_neg.setVisibility(View.GONE);
        btn_pos = (Button) view.findViewById(R.id.btn_pos);
        btn_pos.setVisibility(View.GONE);
        img_line = (ImageView) view.findViewById(R.id.img_line);
        img_line.setVisibility(View.GONE);

        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);

        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * dialogWidth), LayoutParams.WRAP_CONTENT));

        return this;
    }

    public IosDialog setTitle(@NonNull String title) {
        showTitle = true;
        txt_title.setText(title);
        return this;
    }

    public IosDialog setMsg(@NonNull String msg) {
        showMsg = true;
        txt_msg.setText(msg);
        return this;
    }

    /***
     * 是否点击返回能够取消
     * @param cancel
     * @return
     */
    public IosDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param isCancelOutside
     * @return
     */
    public IosDialog setCancelOutside(boolean isCancelOutside) {
        dialog.setCanceledOnTouchOutside(isCancelOutside);
        return this;
    }

    /**
     * 设置确定
     *
     * @param text
     * @param listener
     * @return
     */
    public IosDialog setPositiveButton(String text,
                                       final OnClickListener listener) {
        showPosBtn = true;
        btn_pos.setText(text);
        btn_pos.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    public IosDialog setPositiveButton(final OnClickListener listener) {
        setPositiveButton("确定", listener);
        return this;
    }

    /***
     * 设置取消
     * @param text
     * @param listener
     * @return
     */
    public IosDialog setNegativeButton(String text,
                                       final OnClickListener listener) {
        showNegBtn = true;
        btn_neg.setText(text);
        btn_neg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    public IosDialog setNegativeButton(
            final OnClickListener listener) {
        setNegativeButton("取消", listener);
        return this;
    }


    private void setLayout() {
        if (!showTitle && !showMsg) {
            txt_msg.setVisibility(View.GONE);
            txt_title.setVisibility(View.GONE);
        }

        if (showTitle) {
            txt_title.setVisibility(View.VISIBLE);
        }

        if (showMsg) {
            txt_msg.setVisibility(View.VISIBLE);
        }

        if (!showPosBtn && !showNegBtn) {
            btn_pos.setVisibility(View.GONE);
            btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
            btn_pos.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }

        if (showPosBtn && showNegBtn) {
            btn_pos.setVisibility(View.VISIBLE);
            btn_pos.setBackgroundResource(R.drawable.alertdialog_right_selector);
            btn_neg.setVisibility(View.VISIBLE);
            btn_neg.setBackgroundResource(R.drawable.alertdialog_left_selector);
            img_line.setVisibility(View.VISIBLE);
        }

        if (showPosBtn && !showNegBtn) {
            btn_pos.setVisibility(View.VISIBLE);
            btn_pos.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }

        if (!showPosBtn && showNegBtn) {
            btn_neg.setVisibility(View.VISIBLE);
            btn_neg.setBackgroundResource(R.drawable.alertdialog_single_selector);
        }
    }

    public void show() {
        setLayout();
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }


    /***
     * 获取dialog  宽度
     * @return
     */
    public float getDialogWidth() {
        return dialogWidth;
    }

    /**
     * 设置dialog  宽度
     *
     * @param dialogWidth
     * @return
     */
    public IosDialog setDialogWidth(float dialogWidth) {
        if (lLayout_bg != null) {
            lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * dialogWidth), LayoutParams.WRAP_CONTENT));
        }
        this.dialogWidth = dialogWidth;
        return this;
    }


    /***
     * 获取title
     * @return
     */
    public TextView getTxt_title() {
        return txt_title;
    }

    /***
     * 获取msg
     * @return
     */
    public TextView getTxt_msg() {
        return txt_msg;
    }

    /**
     * 获取确定按钮
     *
     * @return
     */
    public Button getBtn_neg() {
        return btn_neg;
    }


    /**
     * 获取取消按钮
     *
     * @return
     */
    public Button getBtn_pos() {
        return btn_pos;
    }
}
