package com.zlove.upgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zlove.upgrade.rx.CreateActivity;
import com.zlove.upgrade.rx.DeferActivity;
import com.zlove.upgrade.rx.FromActivity;
import com.zlove.upgrade.rx.IntervalActivity;
import com.zlove.upgrade.rx.JustActivity;
import com.zlove.upgrade.rx.RangeActivity;
import com.zlove.upgrade.rx.TimerActivity;

public class MainActivity extends AppCompatActivity {

    private String[] data = {
            "Create",
            "Just",
            "From",
            "Defer",
            "Interval",
            "Timer",
            "Range"
    };

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, CreateActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, JustActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, FromActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, DeferActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, IntervalActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, TimerActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, RangeActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
