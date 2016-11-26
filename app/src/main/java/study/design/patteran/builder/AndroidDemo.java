package study.design.patteran.builder;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import study.design.patteran.R;

/**
 * android中的Build示例
 * Created by fengyulong on 2016/11/26.
 */

public class AndroidDemo {

    public static void showDialog(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setIcon(R.mipmap.ic_launcher)
                .setTitle("title")
                .setMessage("message")
                .setPositiveButton("Button1",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                // do something
                            }
                        })
                .create()
                .show();
    }
}
