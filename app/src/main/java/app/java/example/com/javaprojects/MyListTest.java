package app.java.example.com.javaprojects;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.shelwee.uilistview.ui.UiListView;

public class MyListTest extends Activity {

    private UiListView uiListView1, uiListView2, uiListView3, uiListView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initUilist1();
        initUilist2();
        initUilist3();
        initUilist4();

    }

    private void initUilist1() {
        uiListView1 = (UiListView) findViewById(R.id.uilist1);
        uiListView1.addBasicItem("Ä¬ÈÏÅäÖÃ");
        uiListView1.addBasicItem("±êÌâ", "½éÉÜ");
        uiListView1.addBasicItem(R.drawable.general_navigation_title_bg, "±êÌâ");
        uiListView1.commit();
        uiListView1.setClickListener(new UiListView.ClickListener() {

            @Override
            public void onClick(int index) {
                // TODO Auto-generated method stub
                Toast.makeText(MyListTest.this, "µã»÷" + index, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initUilist2() {
        // TODO Auto-generated method stub
        uiListView2 = (UiListView) findViewById(R.id.uilist2);
        uiListView2.addBasicItem("±êÌâ¾ÓÖÐ");
        uiListView2.addBasicItem("±êÌâ", "²»ÏÔÊ¾¼ýÍ·");
        uiListView2.addBasicItem(R.drawable.general_navigation_title_bg, "±êÌâ", "±êÌâ¸ú½éÉÜ¹ý³¤µÄÊ±ºòµÄÑù×Ó");
        uiListView2.commit();
    }

    private void initUilist3() {
        // TODO Auto-generated method stub
        uiListView3 = (UiListView) findViewById(R.id.uilist3);
        uiListView3.addBasicItem("µ¥ÌõÄ£Ê½");
        uiListView3.addBasicItem("±êÌâ¾ÓÖÐ");
        uiListView3.addBasicItem("ÎÄ×Ö²»¼Ó´Ö");
        uiListView3.commit();
    }

    private void initUilist4() {
        // TODO Auto-generated method stub
        uiListView4 = (UiListView) findViewById(R.id.uilist4);
        uiListView4.addBasicItem("°´Å¥");
        uiListView4.commit();
        uiListView4.setClickListener(new UiListView.ClickListener() {

            @Override
            public void onClick(int index) {
                // TODO Auto-generated method stub
                Toast.makeText(MyListTest.this, "°´Å¥µã»÷", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
