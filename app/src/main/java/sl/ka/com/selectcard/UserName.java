package sl.ka.com.selectcard;

/**
 * Created by seung_hee on 2017. 5. 27..
 */

public class UserName {

    private String user1, user2;
    private int user1_num1, user1_num2, user1_num3;     //1, 2, 3게임 클릭횟수
    private int user2_num1, user2_num2, user2_num3;     //1, 2, 3게임 클릭횟수

    private long user1_time1, user1_time2, user1_time3;  //1, 2, 3게임 클리어시간
    private long user2_time1, user2_time2, user2_time3;  //1, 2, 3게임 클리어시간
    private static UserName instacne = new UserName();
    private int user1_total=0, user2_total=0;

    public int getUser1_total() {
        return user1_total;
    }

    public int getUser2_total() {
        return user2_total;
    }

    public void setUser1_total(int user1_total) {
        this.user1_total += user1_total;
    }

    public void setUser2_total(int user2_total) {
        this.user2_total = user2_total;
    }

    public long getUser1_time1() {
        return user1_time1;
    }

    public void setUser2_time3(long user2_time3) {
        this.user2_time3 = user2_time3;
    }

    public void setUser2_time1(long user2_time1) {
        this.user2_time1 = user2_time1;
    }

    public void setUser2_time2(long user2_time2) {
        this.user2_time2 = user2_time2;
    }

    public void setUser1_time3(long user1_time3) {
        this.user1_time3 = user1_time3;
    }

    public long getUser1_time2() {
        return user1_time2;
    }

    public long getUser1_time3() {
        return user1_time3;
    }

    public long getUser2_time1() {
        return user2_time1;
    }

    public long getUser2_time2() {
        return user2_time2;
    }

    public long getUser2_time3() {
        return user2_time3;
    }

    public void setUser1_time1(long user1_time1) {
        this.user1_time1 = user1_time1;
    }

    public void setUser1_time2(long user1_time2) {
        this.user1_time2 = user1_time2;
    }

    public int getUser1_num1() {
        return user1_num1;
    }

    public int getUser1_num2() {
        return user1_num2;
    }

    public int getUser1_num3() {
        return user1_num3;
    }

    public int getUser2_num2() {
        return user2_num2;
    }

    public int getUser2_num1() {
        return user2_num1;
    }

    public int getUser2_num3() {
        return user2_num3;
    }

    public void setUser1_num1(int user1_num1) {
        this.user1_num1 = user1_num1;
    }

    public void setUser1_num2(int user1_num2) {
        this.user1_num2 = user1_num2;
    }

    public void setUser1_num3(int user1_num3) {
        this.user1_num3 = user1_num3;
    }

    public void setUser2_num1(int user2_num1) {
        this.user2_num1 = user2_num1;
    }

    public void setUser2_num3(int user2_num3) {
        this.user2_num3 = user2_num3;
    }

    public void setUser2_num2(int user2_num2) {
        this.user2_num2 = user2_num2;
    }

    private UserName(){
    }

    public static UserName getInstacne() {
        return instacne;
    }

    public String getUser1() {
        return user1;
    }

    public String getUser2() {
        return user2;
    }

    public void setUser1(String user1) {
        this.user1 = user1;
    }

    public void setUser2(String user2) {
        this.user2 = user2;
    }
}
