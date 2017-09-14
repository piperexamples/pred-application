package beans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class Prediction {
    private String who;
    private String what;

    public Prediction() { }
    public void setWho(String who) {
	this.who = who;
    }
    public String getWho() {
	return this.who;
    }
    public void setWhat(String what) {
	this.what = what;
    }
    public String getWhat() {
	return this.what;
    }
}