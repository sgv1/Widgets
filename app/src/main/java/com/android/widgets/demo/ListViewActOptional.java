package com.android.widgets.demo;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ListViewActOptional extends ListActivity {
    private String mPlantillaMensajeItemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_listview);
        List<String> futureAndroidVendors = getFutureAndroidVendors();
        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,futureAndroidVendors);
        setListAdapter(listAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        String item = (String)getListAdapter().getItem(position);
        String message = String.format(mPlantillaMensajeItemSelected, item);
        showToast(message);
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = getResources().getStringArray(R.array.entradas_spinner1);
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }
}
