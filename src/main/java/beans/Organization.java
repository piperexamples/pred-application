package beans;

//import javax.faces.bean.ApplicationScoped;
//import javax.faces.bean.ManagedBean;

//@ManagedBean
//@ApplicationScoped
public class Organization {
    private String name; 
    private Prediction[] predictions;

    public Organization() { }

    public String getName() { 
	return this.name;
    }
    public void setName(String name) {
	this.name = name;
    }

    public Prediction[] getPredictions() {
	return this.predictions;
    }
    public void setPredictions(Prediction[ ] predictions) {
	this.predictions = predictions;
    }
}