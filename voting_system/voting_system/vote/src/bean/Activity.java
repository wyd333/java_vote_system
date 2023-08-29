package bean;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: 12569
 * Date: 2023-05-23
 * Time: 20:53
 */
public class Activity {
    private int aid;
    private String aname;
    private String astartTime;
    private String aendTime;
    private int atotals;
    private int avotespd;
    private String adesc;
    private int atype;
    private String aimg;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAstartTime() {
        return astartTime;
    }

    public void setAstartTime(String astartTime) {
        this.astartTime = astartTime;
    }

    public String getAendTime() {
        return aendTime;
    }

    public void setAendTime(String aendTime) {
        this.aendTime = aendTime;
    }

    public int getAtotals() {
        return atotals;
    }

    public void setAtotals(int atotals) {
        this.atotals = atotals;
    }

    public int getAvotespd() {
        return avotespd;
    }

    public void setAvotespd(int avotespd) {
        this.avotespd = avotespd;
    }

    public String getAdesc() {
        return adesc;
    }

    public void setAdesc(String adesc) {
        this.adesc = adesc;
    }

    public int getAtype() {
        return atype;
    }

    public void setAtype(int atype) {
        this.atype = atype;
    }

    public String getAimg() {
        return aimg;
    }

    public void setAimg(String aimg) {
        this.aimg = aimg;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", astartTime='" + astartTime + '\'' +
                ", aendTime='" + aendTime + '\'' +
                ", atotals=" + atotals +
                ", avotespd=" + avotespd +
                ", adesc='" + adesc + '\'' +
                ", atype=" + atype +
                ", aimg='" + aimg + '\'' +
                '}';
    }
}
