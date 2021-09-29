package com.lqk.avsource.push.screen;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.opengl.GLES11Ext;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Surface;

import com.lqk.avsource.utl.GlUtil;

public class ScreenShare implements SurfaceTexture.OnFrameAvailableListener {
    private static final String TAG = ScreenShare.class.getSimpleName();
    private static final int FRAME_RATE = 15;
    private static final int I_FRAME_INTERVAL = 10;

    private int mWidth = 720;
    private int mHeight = 1280;
    private int mDpi;

    private int oesTextureId;
    private SurfaceTexture surfaceTexture;
    private Surface mSurface;

    private MediaProjection mMediaProjection;
    private VirtualDisplay mVirtualDisplay;

    public ScreenShare() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        mDpi = displayMetrics.densityDpi;

        oesTextureId = GlUtil.generateTexture(GLES11Ext.GL_TEXTURE_EXTERNAL_OES);
        surfaceTexture = new SurfaceTexture(oesTextureId);
        surfaceTexture.setOnFrameAvailableListener(this);
        mSurface = new Surface(surfaceTexture);

        Log.i(TAG, oesTextureId + "");
    }

    public void start(MediaProjection mediaProjection) {
        Log.i(TAG, "start");
        mMediaProjection = mediaProjection;
        mVirtualDisplay = mMediaProjection.createVirtualDisplay("lqk display",
                mWidth, mHeight, mDpi, DisplayManager.VIRTUAL_DISPLAY_FLAG_PUBLIC, mSurface, null, null);

    }

    public void stop() {
        if (mVirtualDisplay != null) {
            mVirtualDisplay.release();
        }

        if (surfaceTexture != null){
            surfaceTexture.release();
        }

        mMediaProjection = null;
    }

    @Override
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        Log.i(TAG, "onFrameAvailable");
    }
}
