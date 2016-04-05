package com.android.widgets.demo;

import android.app.Activity;
import android.provider.MediaStore;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonActivity extends Activity {
	
    private String mPlantillaMensajeBoton;
    private String mPlantillaMensajeImageBoton;
    private String mPlantillaMensajeToggleBotonSimple;
    private String mButton;
    private String mRadioButton;
    private String mCheckBox;
    private String mToggleBotton;
    private CheckBox checkAux;
    private RadioButton [] radioAux = new RadioButton[3];
    private String prevText;
    private Boolean first = true;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons); 
        mPlantillaMensajeBoton = getString(R.string.plantilla_mensaje_boton);
        mPlantillaMensajeImageBoton = getString(R.string.plantilla_mensaje_imagebutton);
        mPlantillaMensajeToggleBotonSimple = getString(R.string.plantilla_mensaje_togglebutton_simple);
        mButton = getString(R.string.missatge_boto);
        mRadioButton = getString(R.string.missatge_radioButton);
        mCheckBox = getString(R.string.missatge_checkBox);
        mToggleBotton = getString(R.string.missatge_togglebutton);
    }
    
    /** Makes a Toast showing the label of the Button, RadioButton, or CheckBox.
     *  ImageButtons do not have text, and are not subclasses of Button, so you
     *  cannot pass an ImageButton to this method.
     *  You need the muestraInfoImageButton method.
     */
    
    public void muestraTextoBoton(View clickedButton) { 
        Button button = (Button)clickedButton;
        CharSequence text = button.getText();
        String message = null;
        switch (clickedButton.getId()){
            case R.id.button1 :
                message = String.format(mButton, text);
                break;
            case R.id.button2:
                message = String.format(mButton, text);
                break;
            case R.id.button3:
                message = String.format(mButton, text);
                break;
            case R.id.radio_button1 :
                radioAux[1] = (RadioButton)findViewById(R.id.radio_button2);
                if(radioAux[1].isChecked()) radioAux[1].setChecked(false);
                radioAux[2] = (RadioButton)findViewById(R.id.radio_button3);
                if(radioAux[2].isChecked()) radioAux[2].setChecked(false);

               if(first){
                   message = String.format(mRadioButton,text + " "+ getString(R.string.no_selec_prev));
                    prevText = (String)text;
                   first = false;
                }
               else{
                    message = String.format(mRadioButton,text+" La selecció previa era "+prevText);
                    prevText = (String)text;
                }
                break;
            case R.id.radio_button2:
                radioAux[0] = (RadioButton)findViewById(R.id.radio_button1);
                if(radioAux[0].isChecked()) radioAux[0].setChecked(false);
                radioAux[2] = (RadioButton)findViewById(R.id.radio_button3);
                if(radioAux[2].isChecked()) radioAux[2].setChecked(false);

                if(first){
                    message = String.format(mRadioButton,text + " "+ getString(R.string.no_selec_prev));
                    prevText = (String)text;
                    first = false;
                }
                else{
                    message = String.format(mRadioButton,text+" La selecció previa era "+prevText);
                    prevText = (String)text;
                }
                break;
            case R.id.radio_button3:
                radioAux[0] = (RadioButton)findViewById(R.id.radio_button1);
                if(radioAux[0].isChecked()) radioAux[0].setChecked(false);
                radioAux[1] = (RadioButton)findViewById(R.id.radio_button2);
                if(radioAux[1].isChecked()) radioAux[1].setChecked(false);

                if(first){
                    message = String.format(mRadioButton,text + " "+ getString(R.string.no_selec_prev));
                    prevText = (String)text;
                    first = false;
                }
                else{
                    message = String.format(mRadioButton,text + " La selecció previa era " + prevText);
                    prevText = (String)text;
                }
                break;
            case R.id.check_button1 :
                message = String.format(mCheckBox, text);
                checkAux = (CheckBox)findViewById(R.id.check_button1);
                if (checkAux.isChecked()) message = message + getString(R.string.checkedMss);
                else message = message + getString(R.string.uncheckedMss);
                break;
            case R.id.check_button2:
                message = String.format(mCheckBox, text);
                checkAux = (CheckBox)findViewById(R.id.check_button2);
                if (checkAux.isChecked()) message = message + getString(R.string.checkedMss);
                else message = message + getString(R.string.uncheckedMss);
                break;
            case R.id.check_button3:
                message = String.format(mCheckBox, text);
                checkAux = (CheckBox)findViewById(R.id.check_button3);
                if (checkAux.isChecked()) message = message + getString(R.string.checkedMss);
                else message = message + getString(R.string.uncheckedMss);
                break;
        }

        showToast(message);
    }
    /*
    public void muestraInfoImageButton1(View clickedImageButton) {
    	muestraInfoImageButton(R.string.info_imagebutton_1);
    }
    
    public void muestraInfoImageButton2(View clickedImageButton) {
    	muestraInfoImageButton(R.string.info_imagebutton_2);
    }
    
    public void muestraInfoImageButton3(View clickedImageButton) {
    	muestraInfoImageButton(R.string.info_imagebutton_3);
    }
    
    public void muestraInfoImageButton4(View clickedImageButton) {
    	muestraInfoImageButton(R.string.info_imagebutton_4);
    }
    
    public void muestraInfoImageButton5(View clickedImageButton) {
    	muestraInfoImageButton(R.string.info_imagebutton_5);
    }
    
    public void muestraInfoImageButton6(View clickedImageButton) {
    	muestraInfoImageButton(R.string.info_imagebutton_6);
    }
    
    private void muestraInfoImageButton(int imageId) {
        String imageString = getString(imageId);
        String message = String.format(mPlantillaMensajeImageBoton, imageString);
        showToast(message);
    }*/

    public void showInfoImageButton(View clickedImageButton){
        ImageButton imgButton = (ImageButton)clickedImageButton;
        String message = null;
        switch (imgButton.getId()){
            case R.id.image_button1:
                message = String.format(mPlantillaMensajeImageBoton, getString(R.string.info_imagebutton_1));
                break;
            case R.id.image_button2:
                message = String.format(mPlantillaMensajeImageBoton, getString(R.string.info_imagebutton_2));
                break;
            case R.id.image_button3:
                message = String.format(mPlantillaMensajeImageBoton, getString(R.string.info_imagebutton_3));
                break;
            case R.id.image_button4:
                message = String.format(mPlantillaMensajeImageBoton, getString(R.string.info_imagebutton_4));
                break;
            case R.id.image_button5:
                message = String.format(mPlantillaMensajeImageBoton, getString(R.string.info_imagebutton_5));
                break;
            case R.id.image_button6:
                message = String.format(mPlantillaMensajeImageBoton, getString(R.string.info_imagebutton_6));
                break;
        }
        showToast(message);
    }

    
    /** Makes a Toast showing whether you turned ToggleButton on or off. Also
     *  shows the resultant text (label).
     */
    
    public void muestraInfoToggleBoton(View clickedToggleButton) { 
        ToggleButton toggleButton = (ToggleButton)clickedToggleButton;
        String status;
        if (toggleButton.isChecked()) {
            status = "ON";
        } else {
            status = "OFF";
        }
        String message = String.format(mToggleBotton, status);
        showToast(message);
    }
    
    
    private void showToast(String text) {
    	Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

  
}
