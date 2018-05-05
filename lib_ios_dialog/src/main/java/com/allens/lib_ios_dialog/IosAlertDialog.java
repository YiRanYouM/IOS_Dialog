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
public class IosAlertDialog {
    private Context context;
    private Dialog dialog;
    private LinearLayout lLayout_bg;
    private Display display;

    /**
     * dialog  宽度
     */
    private float dialogWidth = 0.7f;


    public IosAlertDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public IosAlertDialog builder() {
        View view = LayoutInflater.from(context).inflate(R.layout.view_etalertdialog, null);
        lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);



        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);

        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * dialogWidth), LayoutParams.WRAP_CONTENT));

        return this;
    }

    private void setLayout() {

    }

    /***
     * 是否点击返回能够取消
     * @param cancel
     * @return
     */
    public IosAlertDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    /**
     * 设置是否可以取消
     *
     * @param isCancelOutside
     * @return
     */
    public IosAlertDialog setCancelOutside(boolean isCancelOutside) {
        dialog.setCanceledOnTouchOutside(isCancelOutside);
        return this;
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
    public IosAlertDialog setDialogWidth(float dialogWidth) {
        if (lLayout_bg != null) {
            lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * dialogWidth), LayoutParams.WRAP_CONTENT));
        }
        this.dialogWidth = dialogWidth;
        return this;
    }


}
