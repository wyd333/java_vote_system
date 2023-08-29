package bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-27
 * Time: 15:21
 */
public class Candidate {
    private int canid;
    private String canname;
    private String candesc;
    private int aid;    //所属活动的id
    private int cannum;
    private String canavatar;

    public int getCanid() {
        return canid;
    }

    public void setCanid(int canid) {
        this.canid = canid;
    }

    public String getCanname() {
        return canname;
    }

    public void setCanname(String canname) {
        this.canname = canname;
    }

    public String getCandesc() {
        return candesc;
    }

    public void setCandesc(String candesc) {
        this.candesc = candesc;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getCannum() {
        return cannum;
    }

    public void setCannum(int cannum) {
        this.cannum = cannum;
    }

    public String getCanavatar() {
        return canavatar;
    }

    public void setCanavatar(String canavatar) {
        this.canavatar = canavatar;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "canid=" + canid +
                ", canname='" + canname + '\'' +
                ", candesc='" + candesc + '\'' +
                ", aid=" + aid +
                ", cannum=" + cannum +
                ", canavatar='" + canavatar + '\'' +
                '}';
    }
}
