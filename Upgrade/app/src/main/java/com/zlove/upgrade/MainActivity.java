package com.zlove.upgrade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zlove.upgrade.rx.BufferActivity;
import com.zlove.upgrade.rx.CombineLatestActivity;
import com.zlove.upgrade.rx.ConcatActivity;
import com.zlove.upgrade.rx.ConcatMapActivity;
import com.zlove.upgrade.rx.CreateActivity;
import com.zlove.upgrade.rx.DebounceActivity;
import com.zlove.upgrade.rx.DeferActivity;
import com.zlove.upgrade.rx.DistinctActivity;
import com.zlove.upgrade.rx.DistinctUntilChangedActivity;
import com.zlove.upgrade.rx.ElementAtActivity;
import com.zlove.upgrade.rx.ErrorResumeNextActivity;
import com.zlove.upgrade.rx.ErrorReturnActivity;
import com.zlove.upgrade.rx.ExceptionResumeNextActivity;
import com.zlove.upgrade.rx.FilterActivity;
import com.zlove.upgrade.rx.FirstActivity;
import com.zlove.upgrade.rx.FlatMapActivity;
import com.zlove.upgrade.rx.FromActivity;
import com.zlove.upgrade.rx.GroupByActivity;
import com.zlove.upgrade.rx.IgnoreElementsActivity;
import com.zlove.upgrade.rx.IntervalActivity;
import com.zlove.upgrade.rx.JoinActivity;
import com.zlove.upgrade.rx.JustActivity;
import com.zlove.upgrade.rx.LastActivity;
import com.zlove.upgrade.rx.MapActivity;
import com.zlove.upgrade.rx.MergeActivity;
import com.zlove.upgrade.rx.RangeActivity;
import com.zlove.upgrade.rx.RepeatActivity;
import com.zlove.upgrade.rx.RetryActivity;
import com.zlove.upgrade.rx.RetryWhenActivity;
import com.zlove.upgrade.rx.ScanActivity;
import com.zlove.upgrade.rx.SingleActivity;
import com.zlove.upgrade.rx.SkipActivity;
import com.zlove.upgrade.rx.SkipLastActivity;
import com.zlove.upgrade.rx.StartWithActivity;
import com.zlove.upgrade.rx.Switch2Activity;
import com.zlove.upgrade.rx.SwitchActivity;
import com.zlove.upgrade.rx.TakeActivity;
import com.zlove.upgrade.rx.TakeLastActivity;
import com.zlove.upgrade.rx.ThrottleActivity;
import com.zlove.upgrade.rx.TimerActivity;
import com.zlove.upgrade.rx.ToMapActivity;
import com.zlove.upgrade.rx.ToSortedListActivity;
import com.zlove.upgrade.rx.WindowActivity;
import com.zlove.upgrade.rx.ZipActivity;
import com.zlove.upgrade.rx.ToListActivity;

public class MainActivity extends AppCompatActivity {

    private String[] data = {
            "Create",
            "Just",
            "From",
            "Defer",
            "Interval",
            "Timer",
            "Range",
            "Repeat",
            "Map",
            "FlatMap",
            "ConcatMap",
            "SwitchMap",
            "Buffer",
            "Window",
            "Scan",
            "GroupBy",
            "debounce",
            "Distinct",
            "DistinctUntilChanged",
            "ElementAt",
            "Filter",
            "First",
            "Single",
            "Last",
            "Take",
            "TakeLast",
            "Skip",
            "SkipLast",
            "IgnoreElements",
            "Throttle",
            "Zip",
            "Merge",
            "Concat",
            "CombineLatest",
            "Join",
            "StartWith",
            "Switch2",
            "ErrorReturn",
            "ErrorResumeNext",
            "ExceptionResumeNext",
            "Retry",
            "RetryWhen",
            "ToList",
            "ToMap",
            "ToSortedList"
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
                    case 7:
                        startActivity(new Intent(MainActivity.this, RepeatActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, MapActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, FlatMapActivity.class));
                        break;
                    case 10:
                        startActivity(new Intent(MainActivity.this, ConcatMapActivity.class));
                        break;
                    case 11:
                        startActivity(new Intent(MainActivity.this, SwitchActivity.class));
                        break;
                    case 12:
                        startActivity(new Intent(MainActivity.this, BufferActivity.class));
                        break;
                    case 13:
                        startActivity(new Intent(MainActivity.this, WindowActivity.class));
                        break;
                    case 14:
                        startActivity(new Intent(MainActivity.this, ScanActivity.class));
                        break;
                    case 15:
                        startActivity(new Intent(MainActivity.this, GroupByActivity.class));
                        break;
                    case 16:
                        startActivity(new Intent(MainActivity.this, DebounceActivity.class));
                        break;
                    case 17:
                        startActivity(new Intent(MainActivity.this, DistinctActivity.class));
                        break;
                    case 18:
                        startActivity(new Intent(MainActivity.this, DistinctUntilChangedActivity.class));
                        break;
                    case 19:
                        startActivity(new Intent(MainActivity.this, ElementAtActivity.class));
                        break;
                    case 20:
                        startActivity(new Intent(MainActivity.this, FilterActivity.class));
                        break;
                    case 21:
                        startActivity(new Intent(MainActivity.this, FirstActivity.class));
                        break;
                    case 22:
                        startActivity(new Intent(MainActivity.this, SingleActivity.class));
                        break;
                    case 23:
                        startActivity(new Intent(MainActivity.this, LastActivity.class));
                        break;
                    case 24:
                        startActivity(new Intent(MainActivity.this, TakeActivity.class));
                        break;
                    case 25:
                        startActivity(new Intent(MainActivity.this, TakeLastActivity.class));
                        break;
                    case 26:
                        startActivity(new Intent(MainActivity.this, SkipActivity.class));
                        break;
                    case 27:
                        startActivity(new Intent(MainActivity.this, SkipLastActivity.class));
                        break;
                    case 28:
                        startActivity(new Intent(MainActivity.this, IgnoreElementsActivity.class));
                        break;
                    case 29:
                        startActivity(new Intent(MainActivity.this, ThrottleActivity.class));
                        break;
                    case 30:
                        startActivity(new Intent(MainActivity.this, ZipActivity.class));
                        break;
                    case 31:
                        startActivity(new Intent(MainActivity.this, MergeActivity.class));
                        break;
                    case 32:
                        startActivity(new Intent(MainActivity.this, ConcatActivity.class));
                        break;
                    case 33:
                        startActivity(new Intent(MainActivity.this, CombineLatestActivity.class));
                        break;
                    case 34:
                        startActivity(new Intent(MainActivity.this, JoinActivity.class));
                        break;
                    case 35:
                        startActivity(new Intent(MainActivity.this, StartWithActivity.class));
                        break;
                    case 36:
                        startActivity(new Intent(MainActivity.this, Switch2Activity.class));
                        break;
                    case 37:
                        startActivity(new Intent(MainActivity.this, ErrorReturnActivity.class));
                        break;
                    case 38:
                        startActivity(new Intent(MainActivity.this, ErrorResumeNextActivity.class));
                        break;
                    case 39:
                        startActivity(new Intent(MainActivity.this, ExceptionResumeNextActivity.class));
                        break;
                    case 40:
                        startActivity(new Intent(MainActivity.this, RetryActivity.class));
                        break;
                    case 41:
                        startActivity(new Intent(MainActivity.this, RetryWhenActivity.class));
                        break;
                    case 42:
                        startActivity(new Intent(MainActivity.this, ToListActivity.class));
                        break;
                    case 43:
                        startActivity(new Intent(MainActivity.this, ToMapActivity.class));
                        break;
                    case 44:
                        startActivity(new Intent(MainActivity.this, ToSortedListActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
