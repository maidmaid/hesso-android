package com.maid.csp.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.maid.csp.Db.Db;
import com.maid.csp.R;
import com.maid.csp.UI.ChildSpinner;
import com.maid.csp.UI.SportSpinner;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class PlanningEditorActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_editor);
    }

    public void addPlanning(View view) {
        DatePicker datePicker = (DatePicker) findViewById(R.id.pe_datepicker);
        ChildSpinner childSpinner = (ChildSpinner) findViewById(R.id.pe_childspinner);
        SportSpinner sportSpinner = (SportSpinner) findViewById(R.id.pe_sportspinner);

        long child = childSpinner.cursor.getId();
        long sport = sportSpinner.cursor.getId();
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear() - 1900;
        Date date = new Date(year, month, day);

        Db.insertPlanning(child, sport, date);
        finish();
    }
}
