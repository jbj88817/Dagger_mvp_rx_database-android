package us.bojie.dagger_mvp_rx_database_android;

import android.os.Bundle;

public class MainActivity extends BasicActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected int getContentView() {
        return 0;
    }
}
