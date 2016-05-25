package com.louisgeek.louispopupmenudemo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView idtv2 = (TextView) findViewById(R.id.id_tv_2);

        View popupView = getLayoutInflater().inflate(R.layout.layout_popupwindow, null);

        final PopupWindow mPopupWindow = new PopupWindow(popupView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), (Bitmap) null));

        idtv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPopupWindow.showAsDropDown(v);
        }
        });
        final TextView idtv = (TextView) findViewById(R.id.id_tv);
        idtv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //v7 下的PopupMenu只接受 activity的context
                PopupMenu popup = new PopupMenu(MainActivity.this, idtv);
                //Inflating the Popup using xml file
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item){

                        return true;
                    }
                });

                popup.show(); //showing popup menu
            }
        });




    }
}
