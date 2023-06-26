package com.example.first;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MonthActivity extends AppCompatActivity {
    public static final String SHARED_PREFS1 = "sharedPrefs1";
    Button jan,feb,mar,apr,may,june,july,aug,sept,oct,nov,dec,analyzeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month);
        jan = findViewById(R.id.jan);
        feb = findViewById(R.id.feb);
        mar = findViewById(R.id.mar);
        apr = findViewById(R.id.apr);
        may = findViewById(R.id.may);
        june = findViewById(R.id.june);
        july = findViewById(R.id.july);
        aug = findViewById(R.id.aug);
        sept = findViewById(R.id.sept);
        oct = findViewById(R.id.oct);
        nov = findViewById(R.id.nov);
        dec = findViewById(R.id.dec);
        analyzeButton = findViewById(R.id.analyzeButton);

        jan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, Record.class);
                startActivity(intent);
            }
        });
        jan.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA1",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        feb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, FebActivity.class);
                startActivity(intent);
            }
        });
        feb.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA2",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, MarActivity.class);
                startActivity(intent);
            }
        });
        mar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA3",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        apr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, AprActivity.class);
                startActivity(intent);
            }
        });
        apr.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA4",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        may.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, MayActivity.class);
                startActivity(intent);
            }
        });
        may.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA5",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        june.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, JuneActivity.class);
                startActivity(intent);
            }
        });
        june.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA6",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        july.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, JulyActivity.class);
                startActivity(intent);
            }
        });
        july.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA7",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        aug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, AugActivity.class);
                startActivity(intent);
            }
        });
        aug.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA8",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        sept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, SeptActivity.class);
                startActivity(intent);
            }
        });
        sept.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA9",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        oct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, OctActivity.class);
                startActivity(intent);
            }
        });
        oct.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA10",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        nov.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, NovActivity.class);
                startActivity(intent);
            }
        });
        nov.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA11",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, DecActivity.class);
                startActivity(intent);
            }
        });
        dec.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                SharedPreferences sharedPreferences1 =getSharedPreferences(SHARED_PREFS1,MODE_PRIVATE);
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("DATA12",MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferences1.edit();
                editor1.clear().apply();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear().apply();

                Toast.makeText(MonthActivity.this, "Data deleted", Toast.LENGTH_SHORT).show();
                return false;
            }
        });
        analyzeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MonthActivity.this, ChartActivity.class);
                startActivity(intent);
            }
        });
    }
}