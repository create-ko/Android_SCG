package sl.ka.com.selectcard;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by seung_hee on 2017. 5. 28..
 */

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    private final static int MAX_CARD_NUMBER = 12;
    private long start_time, end_time;
    int num_sel1=0, num_sel2=0;
    Card card[] = new Card[MAX_CARD_NUMBER];
    public int random[]= new int[MAX_CARD_NUMBER];
    int img_id[], va[], back_img;
    int click_number=0, result=0, count=0;
    private boolean flag_fi = false;
    LayoutInflater inflater;
    TextView tx1, tx2, tx3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("첫번째 게임");

        //imageView id 모음
        va = new int[]{R.id.imageView1, R.id.imageView2, R.id.imageView3,
                R.id.imageView4, R.id.imageView5, R.id.imageView6,
                R.id.imageView7, R.id.imageView8, R.id.imageView9,
                R.id.imageView10, R.id.imageView11, R.id.imageView12,};

        //drawable id 모음
        img_id= new int[]{R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6};

        //back img
        back_img = R.drawable.back;

        ran_num(random);

        start();

        for(int i=0;i<MAX_CARD_NUMBER;i++){
            findViewById(va[random[i]]).setOnClickListener(this);
        }
        count=0;
        click_number=0;




    }

    public void ran_num(int[] q){
        int a;
        boolean flag;

        for (int i=0; i<q.length; i++) {
            while(true) {
                flag = false;
                a = (int) (Math.random() * q.length);
                for (int j=0; j<i; j++) {
                    if (q[j] == a) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) break;
            }
            q[i] = a;
        }

    }


    @Override
    public void onClick(View v) {
        switch (count){
            case 0:
                for(int i=0;i<MAX_CARD_NUMBER;i++){
                    if(card[i].getImageV()== (ImageView) v){
                        num_sel1 = i;
                        break;
                    }
                }
                if(card[num_sel1].getFlag()){
                    card[num_sel1].front_img();
                    count = 1;
                }
                System.out.println(card[num_sel1].getFlag());
                break;

            case 1:
                count =0;
                for(int i=0;i<MAX_CARD_NUMBER;i++){
                    if(card[i].getImageV() == (ImageView) v){
                        num_sel2 = i;
                        break;

                    }
                }
                if(card[num_sel2].getFlag()){
                    card[num_sel2].front_img();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                if(card[num_sel1].getValue()==card[num_sel2].getValue()){
                                    System.out.println("맞음");
                                    result++;
                                    click_number++;
                                    if(result==6 && !flag_fi){
                                        end_time = System.currentTimeMillis();
                                        UserName.getInstacne().setUser1_num1(click_number);
                                        UserName.getInstacne().setUser1_time1((long)((end_time-start_time)/1000.0));
                                        show();
                                    }else if(result==6 && flag_fi){
                                        end_time = System.currentTimeMillis();
                                        UserName.getInstacne().setUser2_num1(click_number);
                                        UserName.getInstacne().setUser2_time1((long)((end_time-start_time)/1000.0));
                                        show_number2();
                                    }

                                }else{
                                    System.out.println("안맞음");
                                    card[num_sel1].BackCard(back_img);
                                    card[num_sel2].BackCard(back_img);
                                    click_number++;
                                }
                            }catch (Exception e){
                                e.printStackTrace();
                            }
                        }
                    }, 200);


                }
                break;
        }


    }


    void show()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Finish");
        builder.setMessage("사용자이름 : " + UserName.getInstacne().getUser1() + "\n클릭횟수 : " + UserName.getInstacne().getUser1_num1() + "번" +
                "\n시간 : " +UserName.getInstacne().getUser1_time1()+ "초" +"\n한번 더 하시겠습니까?" );
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        flag_fi=true;
                        result=0;
                        start();
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int pid = android.os.Process.myPid();
                        android.os.Process.killProcess(pid);
                    }
                });
        builder.show();
    }

    void show_number2()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Finish");
        builder.setMessage("사용자이름 : " + UserName.getInstacne().getUser2() + "\n클릭횟수 : " + UserName.getInstacne().getUser2_num1() + "번" +
                "\n시간 : " +UserName.getInstacne().getUser2_time1()+"초" + "\n승자를 보시겠습니까?" );
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        show_winner();
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int pid = android.os.Process.myPid();
                        android.os.Process.killProcess(pid);
                    }
                });
        builder.show();
    }


    void show_winner()
    {
        int num1=0, num2=0;
        num1 = UserName.getInstacne().getUser1_num1() + (int)UserName.getInstacne().getUser1_time1();
        num2 = UserName.getInstacne().getUser2_num1() + (int)UserName.getInstacne().getUser2_time1();
        UserName.getInstacne().setUser1_total(num1);
        UserName.getInstacne().setUser2_total(num2);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("승자는?");
        builder.setMessage("사용자 이름 : " + UserName.getInstacne().getUser1() +"\n클릭횟수 : " + UserName.getInstacne().getUser1_num1() +
                "   시간 : " + UserName.getInstacne().getUser1_time1()+
                "\n사용자 이름 : " + UserName.getInstacne().getUser2() +"\n클릭횟수 : " + UserName.getInstacne().getUser2_num1() +
                "   시간 : " + UserName.getInstacne().getUser2_time1()+
                "\n\n"+ "총 합 : "+ (num1 > num2?(num1-num2) +"점 차이로 "+ UserName.getInstacne().getUser1() +"이 승리하셨습니다":
                (num2-num1) +"점 차이로 "+ UserName.getInstacne().getUser2() +"이 승리하셨습니다") + "\n다음게임으로 넘어가시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getApplicationContext(), Thrid.class);
//                        Intent intent = new Intent(getApplicationContext(), Five.class);
                        startActivity(intent);
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int pid = android.os.Process.myPid();
                        android.os.Process.killProcess(pid);
                    }
                });
        builder.show();

    }

    void start(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("게임시작");
        builder.setMessage("게임을 시작하시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        start_time = System.currentTimeMillis();
                        ran_num(random);
                        for(int i=0;i<MAX_CARD_NUMBER;i++){
                            card[i] = new Card(img_id[i/2]);
                            card[i].setImageV((ImageView)findViewById(va[random[i]]));
                            card[i].BackCard(back_img);
                        }

                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        int pid = android.os.Process.myPid();
                        android.os.Process.killProcess(pid);
                    }
                });
        builder.show();
    }
}
