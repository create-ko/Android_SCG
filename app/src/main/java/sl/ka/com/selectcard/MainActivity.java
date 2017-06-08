package sl.ka.com.selectcard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText ed1, ed2;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("사용자 이름 설정");


        ed1=(EditText) findViewById(R.id.UserNum1);
        ed2=(EditText) findViewById(R.id.UserNum2);
        bt = (Button) findViewById(R.id.btn_confirm);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserName.getInstacne().setUser1(ed1.getText().toString());
                UserName.getInstacne().setUser2(ed2.getText().toString());
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
