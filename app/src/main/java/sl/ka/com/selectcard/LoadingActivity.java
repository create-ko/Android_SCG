package sl.ka.com.selectcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by seung_hee on 2017. 6. 8..
 */

public class LoadingActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
