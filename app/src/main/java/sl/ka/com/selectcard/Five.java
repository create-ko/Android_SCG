package sl.ka.com.selectcard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by seung_hee on 2017. 6. 3..
 */

public class Five extends AppCompatActivity {

    TextView tx_user1, tx_user2, tx_num_1, tx_num_2, tx_num_3, tx2_num1, tx2_num2, tx2_num3, tx_total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finish);
        setTitle("승자 결정");
        tx_user1 = (TextView) findViewById(R.id.tx_user1);
        tx_user2 = (TextView) findViewById(R.id.tx_user2);
        tx_num_1 = (TextView) findViewById(R.id.tx1);
        tx_num_2 = (TextView) findViewById(R.id.tx3);
        tx_num_3 = (TextView) findViewById(R.id.tx5);

        tx2_num1 = (TextView) findViewById(R.id.tx2);
        tx2_num2 = (TextView) findViewById(R.id.tx4);
        tx2_num3 = (TextView) findViewById(R.id.tx6);
        tx_total = (TextView) findViewById(R.id.tx7);

        tx_user1.setText(UserName.getInstacne().getUser1());
        tx_user2.setText(UserName.getInstacne().getUser2());

        tx_num_1.setText(Integer.toString(UserName.getInstacne().getUser1_num1()+(int)UserName.getInstacne().getUser1_time1()));
        tx_num_2.setText(Integer.toString(UserName.getInstacne().getUser1_num2()+(int)UserName.getInstacne().getUser1_time2()));
        tx_num_3.setText(Integer.toString(UserName.getInstacne().getUser1_num3()+(int)UserName.getInstacne().getUser1_time3()));

        tx2_num1.setText(Integer.toString(UserName.getInstacne().getUser2_num1()+(int)UserName.getInstacne().getUser2_time1()));
        tx2_num2.setText(Integer.toString(UserName.getInstacne().getUser2_num2()+(int)UserName.getInstacne().getUser2_time2()));
        tx2_num3.setText(Integer.toString(UserName.getInstacne().getUser2_num3()+(int)UserName.getInstacne().getUser2_time3()));

        UserName.getInstacne().setUser1_total(UserName.getInstacne().getUser1_sum1()+UserName.getInstacne().getUser1_sum2()+UserName.getInstacne().getUser1_sum3());
        UserName.getInstacne().setUser2_total(UserName.getInstacne().getUser2_sum1()+UserName.getInstacne().getUser2_sum2()+UserName.getInstacne().getUser2_sum3());

        System.out.println(UserName.getInstacne().getUser1_total());
        System.out.println(UserName.getInstacne().getUser2_total());


        tx_total.setText(UserName.getInstacne().getUser1_total()<UserName.getInstacne().getUser2_total()?
                UserName.getInstacne().getUser2_total()-UserName.getInstacne().getUser1_total()+" 점 차이로" +
                UserName.getInstacne().getUser1()+" 이 승리하셨습니다!":
                UserName.getInstacne().getUser1_total()-UserName.getInstacne().getUser2_total()+" 점 차이로" +
                UserName.getInstacne().getUser2()+" 이 승리하셨습니다!");
    }
}