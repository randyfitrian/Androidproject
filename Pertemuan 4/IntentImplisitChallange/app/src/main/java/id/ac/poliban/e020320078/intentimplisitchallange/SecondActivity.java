package id.ac.poliban.e020320078.intentimplisitchallange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    final static String EXTRA_ITEM_VALUE = "SecondActivity.extra.itemValue";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    public void addItemToMainAct(View view) {
        Intent returnIntent = new Intent();
        Button f = (Button) view;
        returnIntent.putExtra(EXTRA_ITEM_VALUE, f.getText().toString());
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}