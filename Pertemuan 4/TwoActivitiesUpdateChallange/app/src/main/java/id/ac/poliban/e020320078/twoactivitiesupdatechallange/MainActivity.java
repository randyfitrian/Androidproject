package id.ac.poliban.e020320078.twoactivitiesupdatechallange;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    final static int REQ_SECOND_ACT = 2;

    final static String EXTRA_MAIN_ACT_Tv1 = "MainActivity.extras.tvItem1.value";
    final static String EXTRA_MAIN_ACT_Tv2 = "MainActivity.extras.tvItem2.value";
    final static String EXTRA_MAIN_ACT_Tv3 = "MainActivity.extras.tvItem3.value";
    final static String EXTRA_MAIN_ACT_Tv4 = "MainActivity.extras.tvItem4.value";
    final static String EXTRA_MAIN_ACT_Tv5 = "MainActivity.extras.tvItem5.value";
    final static String EXTRA_MAIN_ACT_Tv6 = "MainActivity.extras.tvItem6.value";
    final static String EXTRA_MAIN_ACT_Tv7 = "MainActivity.extras.tvItem7.value";
    final static String EXTRA_MAIN_ACT_Tv8 = "MainActivity.extras.tvItem8.value";
    final static String EXTRA_MAIN_ACT_Tv9 = "MainActivity.extras.tvItem9.value";
    final static String EXTRA_MAIN_ACT_Tv10 = "MainActivity.extras.tvItem10.value";


    List<TextView> lTvItems = new ArrayList<>();
    TextView tvItem1, tvItem2, tvItem3, tvItem4, tvItem5, tvItem6, tvItem7, tvItem8, tvItem9, tvItem10;

    List<String> lMainActExtraKeys = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvItem1 = findViewById(R.id.item_1);
        tvItem2 = findViewById(R.id.item_2);
        tvItem3 = findViewById(R.id.item_3);
        tvItem4 = findViewById(R.id.item_4);
        tvItem5 = findViewById(R.id.item_5);
        tvItem6 = findViewById(R.id.item_6);
        tvItem7 = findViewById(R.id.item_7);
        tvItem8 = findViewById(R.id.item_8);
        tvItem9 = findViewById(R.id.item_9);
        tvItem10 = findViewById(R.id.item_10);


        lTvItems.add(tvItem1);
        lTvItems.add(tvItem2);
        lTvItems.add(tvItem3);
        lTvItems.add(tvItem4);
        lTvItems.add(tvItem5);
        lTvItems.add(tvItem6);
        lTvItems.add(tvItem7);
        lTvItems.add(tvItem8);
        lTvItems.add(tvItem9);
        lTvItems.add(tvItem10);

        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv1);
        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv2);
        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv3);
        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv4);
        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv5);
        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv6);
        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv7);
        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv8);
        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv9);
        lMainActExtraKeys.add(EXTRA_MAIN_ACT_Tv10);

        if (savedInstanceState != null)
        {
            for (int i = 0; i < 10; i++)
            {
                String extraKey = lMainActExtraKeys.get(i);
                String itemValue = savedInstanceState.getString(extraKey);
                lTvItems.get(i).setText(itemValue);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK)
        {
            if ( requestCode == REQ_SECOND_ACT && data != null)
            {
                String itemValue;
                itemValue = data.getStringExtra(SecondActivity.EXTRA_ITEM_VALUE);


                for ( int i = 0; i < 10; i++)
                {
                    if(lTvItems.get(i).getText().toString().isEmpty())
                    {
                        lTvItems.get(i).setText(itemValue);
                        break;
                    }
                }

            }
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        for (int i = 0; i < 10; i++)
        {
            String itemValue = lTvItems.get(i).getText().toString();

            if (!itemValue.isEmpty())
            {
                outState.putString(lMainActExtraKeys.get(i), itemValue);
            }
        }


    }

    public void addItemFromSecondAct(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQ_SECOND_ACT);
    }
}