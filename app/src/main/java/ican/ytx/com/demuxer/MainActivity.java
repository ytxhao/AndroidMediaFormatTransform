package ican.ytx.com.demuxer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    MediaDemuxer mMediaDemuxer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.sample_button).setOnClickListener(this);
        mMediaDemuxer = new MediaDemuxer();

    }

    @Override
    public void onClick(View v) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                mMediaDemuxer.demuxer("/storage/emulated/0/cuc_ieschool.flv","/storage/emulated/0/cuc_ieschool.mp4");
            }
        }).start();
    }
}
