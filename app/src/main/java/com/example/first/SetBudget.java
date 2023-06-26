package com.example.first;

import static com.example.first.R.id.budgetView1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SetBudget extends AppCompatActivity {
    private EditText budgetAmount;
    private Button budgetAmountButton;
    private TextView budgetView;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    private String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_budget);

        budgetAmount = findViewById(R.id.budgetAmount);
        budgetView = findViewById(budgetView1);
        budgetAmountButton = findViewById(R.id.budgetAmountBtn);

        budgetAmount.addTextChangedListener(txtWatcher);




        budgetAmountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                budgetView.setText(budgetAmount.getText().toString());
                saveData();

                String budget = budgetView.getText().toString();
                Intent intent2 = new Intent(SetBudget.this , HomeActivity.class);
                intent2.putExtra("dataname",budget);
                startActivity(intent2);

            }
        });
        loadData();
        updateViews();



    }
    public void saveData(){
        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, budgetView.getText().toString());
        editor.apply();
    }
    public void loadData(){
        SharedPreferences sharedPreferences =getSharedPreferences(SHARED_PREFS,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");
    }
    public void updateViews(){
        budgetView.setText(text);
    }
    private TextWatcher txtWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String innput = budgetAmount.getText().toString().trim();
            budgetAmountButton.setEnabled(!innput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };



}