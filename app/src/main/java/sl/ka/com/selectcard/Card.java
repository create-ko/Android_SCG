package sl.ka.com.selectcard;

import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by seung_hee on 2017. 5. 30..
 */

public class Card {

    private ImageView imageV;           //findViewById를 이용해 실제 값을 넣어줌. 배열형태로 선언하여 출력함
    private int value;                  //카드 모양비교를 위한 변수
    private boolean flag=false;         //앞인지 뒤인지 확인하려는 플래그 true면 뒷면, false이면 앞면

    public void BackCard(int r_id){
        //만약 false면 뒷면으로 셋팅하고 true로 바꿔라
        if(!flag){
            imageV.setImageResource(r_id);
            this.flag=true;
        }
    }
    public void front_img(){
        if(flag) {
            imageV.setImageResource(value);
            this.flag=false;
        }
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean getFlag(){
        return flag;
    }


    public Card(int i){
        this.value = i;
    }
    public int getValue() {
        return value;
    }
    public ImageView getImageV() {
        return imageV;
    }
    public void setImageV(ImageView imageV) {
        this.imageV = imageV;
    }



}
