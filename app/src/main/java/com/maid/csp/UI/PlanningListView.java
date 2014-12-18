package com.maid.csp.UI;

import android.content.Context;
import android.util.AttributeSet;

import com.maid.csp.Db.DbContract;
import com.maid.csp.R;

public class PlanningListView extends DbListView {
    public PlanningListView(Context context) {
        super(context);
    }

    public PlanningListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlanningListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public int getLayout() {
        return R.layout.simple_list_item_3;
    }

    @Override
    public int[] getViews() {
        return new int[] {
            R.id.lvp_title,
            R.id.lvp_subtitle,
            R.id.lvp_description
        };
    }

    @Override
    public String[] getColumns() {
        return new String[] {
            DbContract.Child.COLUMN_NAME_FIRSTNAME,
            DbContract.Sport.COLUMN_NAME_NAME,
            DbContract.Planning.COLUMN_NAME_DATE
        };
    }
}
