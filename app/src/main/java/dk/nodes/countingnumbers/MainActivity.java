package dk.nodes.countingnumbers;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {

    private TextSwitcher tv1, tv10, tv100, tv1000;
    private int count1 = 0, count10 = 0, count100 = 0, count1000 = 0, count1Stop = 0, count10Stop = 5, count100Stop = 4, count1000Stop = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1000 = (TextSwitcher) findViewById(R.id.tv1000);
        tv100 = (TextSwitcher) findViewById(R.id.tv100);
        tv10 = (TextSwitcher) findViewById(R.id.tv10);
        tv1 = (TextSwitcher) findViewById(R.id.tv1);

        tv1000.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                final TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(24);
                return tv;
            }
        });
        tv100.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                final TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(24);
                return tv;
            }
        });
        tv10.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                final TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(24);
                return tv;
            }
        });
        tv1.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                final TextView tv = new TextView(MainActivity.this);
                tv.setTextSize(24);
                return tv;
            }
        });

        tv1.setText(String.valueOf(count1));
        tv10.setText(String.valueOf(count10));
        tv100.setText(String.valueOf(count100));
        tv1000.setText(String.valueOf(count1000));

        startAnimation();
    }

    public void startAnimation() {
        new Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        countUp();

                        //Check if it should stop animation, since it should stop at specific number
                        if (count1 == count1Stop && count10 == count10Stop && count100 == count100Stop && count1000 == count1000Stop) {
                            return;
                        }

                        startAnimation();
                    }
                },
                15);
    }

    public void countUp() {
        count1++;

        if (count1 == 10) {

            count10++;
            if (count10 == 10) {

                count100++;
                if (count100 == 10) {

                    count1000++;
                    if (count1000 == 10) {
                        count1000 = 0;
                    }
                    tv1000.setText(String.valueOf(count1000));

                    count1000 = 0;
                }
                tv100.setText(String.valueOf(count100));

                count10 = 0;
            }
            tv10.setText(String.valueOf(count10));

            count1 = 0;
        }
        tv1.setText(String.valueOf(count1));

    }
}
