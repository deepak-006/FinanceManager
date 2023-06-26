package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class HomeActivity extends AppCompatActivity {

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SHARED_PREFS1 = "sharedPrefs1";

    public static final String TEXT1 = "text1";
    public String text1;

    public static final String TEXT = "text";
    private String text;
    Handler Handler = new Handler();
    int time = 0;
    private String moneyL;
    ProgressBar progressBar;
    TextView budgetView,moneySpentView,moneyLeftView,marquee_tv;
    Button setBudget,recordBtn;
    String budget;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        marquee_tv = findViewById(R.id.marquee_tv);
        recordBtn = findViewById(R.id.recordBtn);
        budgetView = findViewById(R.id.budgetView);
        setBudget = findViewById(R.id.setBudgetBtn);
        moneySpentView = findViewById(R.id.moneySpent);
        moneyLeftView = findViewById(R.id.moneyLeft);

        Intent intent = getIntent();
        budget = intent.getStringExtra("dataname");
        budgetView.setText(budget);
        marquee_tv.setSelected(true);

        String[] name = getResources().getStringArray(R.array.name);
        Random random = new Random();
        int n;
        n = random.nextInt(name.length);
        marquee_tv.setText(name[n]);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification","My Notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel );
        }



        moneySpentView.setText("0");
        setBudget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this , SetBudget.class);
                startActivity(intent);
                saveData();
            }
        });

        loadData();
        loadData1();
        updateViews();
        updateViews1();

        recordBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //
                Intent intent = new Intent(HomeActivity.this , MonthActivity.class);
                startActivity(intent);
            }
        });


    }

    public void saveData() {
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TEXT, budgetView.getText().toString());
        editor.apply();
    }
    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT, "0");

    }

    public void updateViews() {
        budgetView.setText(text);
        SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
        text1 = sharedPreferences1.getString(TEXT1,"0");
        int ml = Integer.parseInt(text) - Integer.parseInt(text1);
        if(ml<0){
            showNotif(ml);
        }
        moneyL = String.valueOf(ml);
        moneyLeftView.setText(moneyL);
        progressBar = findViewById(R.id.progressBar);
        int lim = Integer.parseInt(text);
        int done = Integer.parseInt(text1);
        if(lim == 0){
            counter = 0;
        }else {
            counter = (done * 100) / lim;
        }
        progressBar.setProgress(counter);


    }

    public void loadData1(){
        SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
        text1 = sharedPreferences1.getString(TEXT1,"0");
    }
    public void updateViews1(){

        moneySpentView.setText(text1);
    }
    private void showNotif(int amt) {
        int nom = -amt;
        NotificationCompat.Builder builder = new NotificationCompat.Builder(HomeActivity.this, "My Notification");
                       builder
                        .setSmallIcon(R.drawable.money_icon)
                        .setContentTitle("Alert")
                        .setContentText("Your spending exceeded the set limit by " + nom + " rupees")
                               .setAutoCancel(true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(HomeActivity.this);
               managerCompat.notify(1, builder.build());


    }



}