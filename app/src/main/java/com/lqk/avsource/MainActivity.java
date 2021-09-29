package com.lqk.avsource;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lqk.avsource.push.screen.ScreenShare;

public class MainActivity extends AppCompatActivity {
    private static final int CAPTURE_PERMISSION_REQUEST_CODE_SHARE = 1;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn_test);



    }


    @Override
    protected void onResume() {
        super.onResume();


//        btn.post(() -> {
//            while (true){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAPTURE_PERMISSION_REQUEST_CODE_SHARE) {
            ScreenShare screenShare = new ScreenShare();
            screenShare.start(((MediaProjectionManager) getSystemService(
                    Context.MEDIA_PROJECTION_SERVICE)).getMediaProjection(Activity.RESULT_OK, data));
        }
    }

    public void btnScreenShare(View view) {
        MediaProjectionManager mediaProjectionManager =
                (MediaProjectionManager) getApplication().getSystemService(Context.MEDIA_PROJECTION_SERVICE);
        startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(),
                CAPTURE_PERMISSION_REQUEST_CODE_SHARE);
    }


    public void btnTestActivity(View view) {
        startActivity(new Intent(this, TestActivity.class));
    }
}
