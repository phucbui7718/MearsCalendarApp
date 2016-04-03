package com.mears.mearscalendarapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatePicker datepicker;
    private TimePicker time_picker;
    private TimePicker time_picker3;
    private Button button_show_time;
    private TextView textOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datepicker = (DatePicker) findViewById(R.id.datepicker);
        showTime();
    }

    // public void setDate(View v){

    //      Toast.makeText(getBaseContext(), "Today: " + month + "/" + day + "/" + year, Toast.LENGTH_LONG).show();
    // }

    public void showTime(){


        time_picker = (TimePicker)findViewById(R.id.timePicker);
        time_picker3 = (TimePicker)findViewById(R.id.timePicker3);
        button_show_time = (Button)findViewById(R.id.btnShowIntendedSchedule);
        time_picker.setIs24HourView(true);
        time_picker3.setIs24HourView(true);




        button_show_time.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//future                        textOutput = (TextView) findViewById(R.id.textView);
//must figure out                     if ((datepicker.getMonth() + datepicker.getDayOfMonth()) > ((datepicker.getMonth() + datepicker.getDayOfMonth() + 7))) {
                        if (time_picker3.getCurrentHour() > time_picker.getCurrentHour()) {
                            if (time_picker.getCurrentHour() < 10) {
                                if (time_picker3.getCurrentHour() < 10) {
                                    Toast.makeText(getBaseContext(), "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                                    "/" + datepicker.getYear() + " from " + "0" + time_picker.getCurrentHour() + ":00 hours" + " to " + "0" + time_picker3.getCurrentHour() +
                                                    ":00 hours," + " please push the Request Work button below, or pick another day and/or time.",
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getBaseContext(), "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                                    "/" + datepicker.getYear() + " from " + "0" + time_picker.getCurrentHour() + ":00 hours" + " to " + time_picker3.getCurrentHour() +
                                                    ":00 hours," + " please push the Request Work button below, or pick another day and/or time.",
                                            Toast.LENGTH_SHORT).show();
                                }

                            } else if (time_picker3.getCurrentHour() < 10) {
                                Toast.makeText(getBaseContext(), "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                                "/" + datepicker.getYear() + " from " + time_picker.getCurrentHour() + ":00 hours" + " to " + "0" + time_picker3.getCurrentHour() +
                                                ":00 hours," + " please push the Request Work button below, or pick another day and/or time.",
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getBaseContext(), "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                                "/" + datepicker.getYear() + " from " + time_picker.getCurrentHour() + ":00 hours" + " to " + time_picker3.getCurrentHour() +
                                                ":00 hours, " + " please push the Request Work button below, or pick another day and/or time.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getBaseContext(), "The end time must be later than the start time:  Please try again.", Toast.LENGTH_SHORT).show();
                        }//end of else


                    }//end of   if (time_picker3.getCurrentHour() > time_picker.getCurrentHour())
                    //must figure out                     else {
                    //must figure out                        Toast.makeText(getBaseContext(), "You must select a day that is at least 7 days later than today.", Toast.LENGTH_SHORT).show();
                    //must figure out                   }
                    //must figure out            }//end of if (datepicker.getDayOfMonth() > (datepicker.getDayOfMonth() + 7))
                }
        );//end of button_show_time.setOnClickListener(

    }//end showtime





}