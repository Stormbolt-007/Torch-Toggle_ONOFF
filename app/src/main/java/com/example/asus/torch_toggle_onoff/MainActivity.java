package com.example.asus.torch_toggle_onoff;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton tb;
    CameraManager cm;
    private boolean camera=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb=(ToggleButton)findViewById(R.id.toggleButton);
        cm=(CameraManager)getSystemService(CAMERA_SERVICE);

        tb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    try{
                        String s1=cm.getCameraIdList()[0];
                        cm.setTorchMode(s1,true);
                        camera=true;
                    }
                    catch (CameraAccessException e){

                    }
                }
                else{
                    try{
                        String s2=cm.getCameraIdList()[0];
                        cm.setTorchMode(s2,false);
                        camera=false;
                    }
                    catch (CameraAccessException e){

                    }
                }
            }
        });
    }
}
