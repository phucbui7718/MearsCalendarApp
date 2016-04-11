package com.example.smf.saveapp;

import android.support.annotation.Nullable;
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
    String txtOut;
    TextView txtView;
    String txtEmpty = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datepicker = (DatePicker) findViewById(R.id.datepicker);
        showTime();
        txtView = (TextView)findViewById(R.id.txtOutputWindow);
    }

   // public void setDate(View v){

  //      Toast.makeText(getBaseContext(), "Today: " + month + "/" + day + "/" + year, Toast.LENGTH_LONG).show();
   // }

    public void showTime() {


        time_picker = (TimePicker) findViewById(R.id.timePicker);
        time_picker3 = (TimePicker) findViewById(R.id.timePicker3);
        button_show_time = (Button) findViewById(R.id.btnShowIntendedSchedule);
        time_picker.setIs24HourView(true);
        time_picker3.setIs24HourView(true);


        button_show_time.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (time_picker.getCurrentHour() != 0 && time_picker3.getCurrentHour() != 0) {//all but 0 conditions
                            if (time_picker3.getCurrentHour() > time_picker.getCurrentHour()) {//make sure end time is later than start time in non zero start time
                                if (time_picker.getCurrentHour() < 10) {//this is to append a 0 to start time
                                    if (time_picker3.getCurrentHour() < 10) {//this is to append a 0 to start time and end time
                                        txtOut = "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                                "/" + datepicker.getYear() + " from " + "0" + time_picker.getCurrentHour() + ":00 hours" + " to " + "0" + time_picker3.getCurrentHour() +
                                                ":00 hours," + " please tap the Request Work button below, or pick another day and/or time.";
                                        txtView.setText(txtOut);
                                    } else if (time_picker3.getCurrentHour() >= 10){//this is to append a 0 to start time only
                                        txtOut = "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                                "/" + datepicker.getYear() + " from " + "0" + time_picker.getCurrentHour() + ":00 hours" + " to " + time_picker3.getCurrentHour() +
                                                ":00 hours," + " please tap the Request Work button below, or pick another day and/or time.";
                                        txtView.setText(txtOut);
                                    }
                                } else if (time_picker.getCurrentHour() >= 10  && time_picker3.getCurrentHour() >= 10) {//do not append any zeros
                                    txtOut = "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                            "/" + datepicker.getYear() + " from " + time_picker.getCurrentHour() + ":00 hours" + " to " + time_picker3.getCurrentHour() +
                                            ":00 hours," + " please tap the Request Work button below, or pick another day and/or time.";
                                    txtView.setText(txtOut);
                                }
                            } else if (time_picker.getCurrentHour() >= time_picker3.getCurrentHour()) {//do not allow the start times = or > than end times
                                txtOut = "The end time must be later than the start time, and any work past 24:00 hours (00 on the End Time slider) must be scheduled on a separate day:  Please try again.";
                                txtView.setText(txtOut);
                            }
                        }else if (time_picker.getCurrentHour() == 0 && time_picker3.getCurrentHour() > 0){//allow for start time zero hour situation when end time is not 24:00
                            txtOut = "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                "/" + datepicker.getYear() + " from " + "0" + time_picker.getCurrentHour() + ":00 hours" + " to " + "0" + time_picker3.getCurrentHour() +
                                ":00 hours," + " please tap the Request Work button below, or pick another day and/or time.";
                            txtView.setText(txtOut);
                        }else if (time_picker.getCurrentHour() == 0 && time_picker3.getCurrentHour() == 0){//check independantly for 00 start and end times--do not allow
                            txtOut = "The end time must be later than the start time, and any work past 24:00 hours (00 on the End Time slider) must be scheduled on a separate day:  Please try again.";
                            txtView.setText(txtOut);  //end if tp && tp3 !=0
                        }else if (time_picker.getCurrentHour() >= 10 && time_picker3.getCurrentHour() == 0) {//allow for 24:00 hours end time situation where start time is beyond 9
                            txtOut = "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                    "/" + datepicker.getYear() + " from " + time_picker.getCurrentHour() + ":00 hours" + " to " + "24:00 hours," +
                                    " please tap the Request Work button below, or pick another day and/or time.";
                            txtView.setText(txtOut);
                        }else if (time_picker.getCurrentHour() > 0 && time_picker.getCurrentHour() < 10 && time_picker3.getCurrentHour() == 0){//allow for 24:00 hour end time with 9 or less start time
                            txtOut = "If you wish to request the following work schedule: " + (datepicker.getMonth() + 1) + "/" + datepicker.getDayOfMonth() +
                                    "/" + datepicker.getYear() + " from " + "0" + time_picker.getCurrentHour() + ":00 hours" + " to " + "24" +
                                    ":00 hours," + " please tap the Request Work button below, or pick another day and/or time.";
                            txtView.setText(txtOut);
                        }

                    }//end of public void onClick(View v)

                }//end on click listener

        );//end of button_show_time.setOnClickListener(

    }


}
 //
