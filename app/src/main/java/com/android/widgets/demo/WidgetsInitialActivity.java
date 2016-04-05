package com.android.widgets.demo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class WidgetsInitialActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    
    /** Switches to the ButtonActivity when the associated button is clicked. */
    
    public void muestraBotones (View clickedButton) {
    	Intent in = new Intent(this, ButtonActivity.class);
        startActivity(in);
    }
    
    /** Switches to the SpinnerActivity when the associated button is clicked. */
    
    public void muestraSpinners(View clickedButton) {
    	Intent in = new Intent(this, SpinnerActivity.class);
        startActivity(in);
    }
    public void showListView(View clickedButton){
        Intent in = new Intent(this, ListViewActivity.class);
        //Intent in = new Intent(this, ListViewActOptional.class);
        startActivity(in);
    }
    public void showGridView(View clickedButton){
        startActivity(new Intent(this, GridViewActivity.class));
    }
}