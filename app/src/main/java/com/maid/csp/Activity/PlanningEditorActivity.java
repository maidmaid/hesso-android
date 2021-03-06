package com.maid.csp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.DatePicker;

import com.maid.csp.Activity.Base.EditorActivity;
import com.maid.csp.Db.Db;
import com.maid.csp.R;
import com.maid.csp.UI.ChildSpinner;
import com.maid.csp.UI.SportSpinner;

import java.util.Calendar;

public class PlanningEditorActivity extends EditorActivity {
    private DatePicker datePicker;
    private ChildSpinner childSpinner;
    private SportSpinner sportSpinner;
    private long planning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // View
        setContentView(R.layout.activity_planning_editor);
        datePicker = (DatePicker) findViewById(R.id.pe_datepicker);
        childSpinner = (ChildSpinner) findViewById(R.id.pe_childspinner);
        sportSpinner = (SportSpinner) findViewById(R.id.pe_sportspinner);

        // Intent
        Intent intent = getIntent();
        editMode = intent.getBooleanExtra("edit_mode", false);
        if(editMode) {
            // Get data
            planning = intent.getLongExtra("id", 0);
            long idSport = intent.getLongExtra("id_sport", 0);
            long idChild = intent.getLongExtra("id_child", 0);
            Calendar date = (Calendar) intent.getSerializableExtra("date");

            // Update UI
            sportSpinner.select(idSport);
            childSpinner.select(idChild);
            datePicker.updateDate(date.get(Calendar.YEAR), date.get(Calendar.MONTH), date.get(Calendar.DAY_OF_MONTH));
        }
    }

    @Override
    public void addAction() {
        Db.insertPlanning(
            childSpinner.cursor.getId(),
            sportSpinner.cursor.getId(),
            getDate()
        );
        finish();
    }

    @Override
    public void updateAction() {
        Db.updatePlanning(
            planning,
            childSpinner.cursor.getId(),
            sportSpinner.cursor.getId(),
            getDate()
        );
        finish();
    }

    @Override
    public void deleteAction() {
        Db.deletePlanning(planning);
        finish();
    }

    /**
     * Get date from date picker
     */
    public Calendar getDate() {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        return c;
    }
}
