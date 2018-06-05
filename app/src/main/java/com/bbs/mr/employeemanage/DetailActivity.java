package com.bbs.mr.employeemanage;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {
    public static int position = 0;
    public static String toMail="@gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView id = (TextView) findViewById(R.id.tvIDDetail);
        TextView name = (TextView) findViewById(R.id.tvNameDetail);
        TextView birthday = (TextView) findViewById(R.id.tvBirthdayDetail);
        TextView phone = (TextView) findViewById(R.id.tvPhoneDetail);
        TextView email = (TextView) findViewById(R.id.tvEmailDetail);
        ImageView img = (ImageView) findViewById(R.id.ivIconEmDetail);
        final Employee ee = ListActivity.employees.get(position);
        if (position % 3 == 1)
            img.setImageResource(R.drawable.contact);
        else if (position % 3 == 2)
            img.setImageResource(R.drawable.contact);
        else img.setImageResource(R.drawable.contact);
        id.setText("ID: " + ee.getId().toString());
        name.setText("Name: " + ee.getName().toString());
        birthday.setText("Birthday: " + ee.getBirthDay().toString());
        phone.setText("Phone: " + ee.getPhone().toString());
        email.setText("Email: " + ee.getEmail().toString());
        toMail = ee.getEmail();
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse(String.format("tel:%s",
                        ee.getPhone())));
                if (ActivityCompat.checkSelfPermission(DetailActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(callIntent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailActivity.this,"Chưa có chức năng này",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
