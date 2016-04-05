package com.android.widgets.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridViewActivity extends Activity {

    private String mPlantillaMensajeItemSelected;
    private ArrayList marcas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        //setContentView(R.layout.activity2_grid_view);
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_gridview);
        GridView gridv = (GridView)findViewById(R.id.gridview);
        List<String> futureAndroidVendors = getFutureAndroidVendors();
        ArrayAdapter<String> gridAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,futureAndroidVendors);
        gridv.setAdapter(gridAdapter);
        gridv.setOnItemClickListener(new gridViewInfo());
    }

    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = getResources().getStringArray(R.array.entradas_spinner1);
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }
    private class gridViewInfo implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> listv, View selectedView, int position, long id){
            String selection = listv.getItemAtPosition(position).toString();
            String message = String.format(mPlantillaMensajeItemSelected, selection);
            showToast(message);
        }
    }
    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
