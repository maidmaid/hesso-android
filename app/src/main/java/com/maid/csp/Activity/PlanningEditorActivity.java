package com.maid.csp.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.maid.csp.Db.Db;
import com.maid.csp.R;
import com.maid.csp.UI.ChildSpinner;
import com.maid.csp.UI.SportSpinner;

import java.util.Date;

public class PlanningEditorActivity extends Activity {
    private DatePicker datePicker;
    private ChildSpinner childSpinner;
    private SportSpinner sportSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning_editor);
        datePicker = (DatePicker) findViewById(R.id.pe_datepicker);
        childSpinner = (ChildSpinner) findViewById(R.id.pe_childspinner);
        sportSpinner = (SportSpinner) findViewById(R.id.pe_sportspinner);

        Intent intent = getIntent();
        boolean editMode = intent.getBooleanExtra("edit_mode", false);
        if(editMode) {
            long idSport = intent.getLongExtra("id_sport", 0);
            sportSpinner.cursor.moveToId(idSport);
            int position = sportSpinner.cursor.getPosition();
            sportSpinner.setSelection(position);
        }
    }

    public void addPlanning(View view) {
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
