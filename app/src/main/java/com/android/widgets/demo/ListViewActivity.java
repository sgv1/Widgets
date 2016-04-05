package com.android.widgets.demo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListViewActivity extends Activity {

    private String mPlantillaMensajeItemSelected;
    Context context = ListViewActivity.this;
    List<ListMarca> myList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_listview);
        ListView listv = (ListView) findViewById(R.id.listView);
        getDataMarks();
//        List<String> futureAndroidVendors = getFutureAndroidVendors();
//        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, futureAndroidVendors);
//        listv.setAdapter(listAdapter);
        listv.setAdapter(new MyBaseAdapter(this, myList));
        listv.setOnItemClickListener(new ListViewInfo());
    }

    private class ListViewInfo implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> listv, View selectedView, int position, long id) {
            String selection = listv.getItemAtPosition(position).toString();
            String message = String.format(mPlantillaMensajeItemSelected, selection);
            showToast(message);
        }
    }

    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = getResources().getStringArray(R.array.entradas_spinner1);
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return (vendorList);
    }

    private void getDataMarks() {

        List<ListMarca> tmp = new ArrayList<>();
        String[] vendorArray = getResources().getStringArray(R.array.entradas_spinner1);
        int[] vendorInteger = getResources().getIntArray(R.array.entradas_spinner2);
        for (int i = 0; i < vendorArray.length; i++) {
            ListMarca lm = new ListMarca();
            lm.setTitle(vendorArray[i]);
            lm.setImgResId(vendorInteger[i]);
            tmp.add(lm);
        }
        Collections.shuffle(tmp);
        myList.addAll(tmp);
    }
}
