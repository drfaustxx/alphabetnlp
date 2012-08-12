/**
 * Говнокоооод
 */
package ru.drfaust.alphabet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MySettings extends Activity {
    Integer[] data = {1,2,3,4,5};
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        initGameTimeSpiner();
        initSpeedSpiner();
        initOkButton();
    }

    /**
     * Game Speed spiner
     */
    private void initSpeedSpiner() {
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spnrSpeed = (Spinner)findViewById(R.id.spnrSpeed);
        spnrSpeed.setAdapter(adapter);
        spnrSpeed.setPrompt("Speed");
        spnrSpeed.setSelection(MyProperties.getInstance().gameSpeed);
    }

    /**
     * Gameatime spiner
     */
    private void initGameTimeSpiner() {
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, data);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner spnrGameTime = (Spinner)findViewById(R.id.spnrGameTime);
        spnrGameTime.setAdapter(adapter);
        spnrGameTime.setPrompt("Play time");
        spnrGameTime.setSelection(MyProperties.getInstance().gameTime);
    }

    private void initOkButton() {
        final Button btnOk = (Button)findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {                
               //btnOk.setText(getGameTime() + " " + getSpeed());
                Intent myActivity = new Intent(getApplicationContext(), MyActivity.class);
                myActivity.putExtra("gameTime", getGameTime() * 60 * 100);
                myActivity.putExtra("gameTick", getSpeed());
                startActivity(myActivity);
            }

        });
    }
    //говно
    public int getSpeed() {
        Spinner spnrSpeed = (Spinner)findViewById(R.id.spnrSpeed);
        MyProperties.getInstance().gameSpeed = (int)spnrSpeed.getSelectedItemId();
        int ret = data[(int)spnrSpeed.getSelectedItemId()];
        return ret;
    }
    //говно
    public int getGameTime() {
        Spinner spnrGameTime = (Spinner)findViewById(R.id.spnrGameTime);
        MyProperties.getInstance().gameTime = (int)spnrGameTime.getSelectedItemId();
        int ret = data[(int)spnrGameTime.getSelectedItemId()];
        return ret;
    }






}
