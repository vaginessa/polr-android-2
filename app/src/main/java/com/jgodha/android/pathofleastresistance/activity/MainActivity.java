package com.jgodha.android.pathofleastresistance.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jgodha.android.pathofleastresistance.LeastResistantPathFinder;
import com.jgodha.android.pathofleastresistance.Path;
import com.jgodha.android.pathofleastresistance.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doIt();
            }
        });
    }

    private void doIt() {
        TextView resultView = (TextView) findViewById(R.id.textView3);

        String gridData = ((EditText) findViewById(R.id.editText)).getText().toString();
        try {
            Path path = new LeastResistantPathFinder().find(gridData);
            resultView.setText(path.generateResult());
            resultView.setBackgroundColor(Color.CYAN);
        } catch(Exception ex) {
            resultView.setText("Something went wrong! Please try again.");
            resultView.setBackgroundColor(Color.RED);
        }
    }
}
