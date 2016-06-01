package app.java.example.com.javaprojects;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bruce.pickerview.popwindow.DatePickerPopWin;
import com.nd.sdp.android.common.res.CommonBaseCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class PopupWindowTest extends CommonBaseCompatActivity implements View.OnClickListener{

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("LoadMoreRecycleView");

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(this);

    }

    public void onClick1(View view) {
        TextView contentView = new TextView(PopupWindowTest.this);
        contentView.setText("Test");

        PopupWindow pw = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, true);
        pw.setBackgroundDrawable(this.getDrawable(R.drawable.general_arrow_down_icon_normal));
        pw.showAtLocation(PopupWindowTest.this.getWindow().getDecorView(), Gravity.BOTTOM, 0, 0);
        pw.setTouchable(true);
        // pw.setAnimationStyle();
        pw.setOutsideTouchable(true);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        DatePickerPopWin pickerPopWin = new DatePickerPopWin.Builder(PopupWindowTest.this, new DatePickerPopWin.OnDatePickedListener() {
            @Override
            public void onDatePickCompleted(int year, int month, int day, String dateDesc) {
                Toast.makeText(PopupWindowTest.this, dateDesc, Toast.LENGTH_SHORT).show();
            }
        }).textConfirm("CONFIRM") //text of confirm button
                .textCancel("CANCEL") //text of cancel button
                .btnTextSize(16) // button text size
                .viewTextSize(25) // pick view text size
                .colorCancel(Color.parseColor("#999999")) //color of cancel button
                .colorConfirm(Color.parseColor("#009900"))//color of confirm button
                .minYear(1990) //min year in loop
                .maxYear(2550) // max year in loop
                .dateChose("2013-11-11") // date chose when init popwindow
                .build();
        pickerPopWin.showPopWin(PopupWindowTest.this);
    }
}