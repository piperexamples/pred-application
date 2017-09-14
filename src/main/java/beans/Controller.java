package beans;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.model.SelectItem;

@ManagedBean(eager = true) // encourage the container to load the instance right away
@ApplicationScoped         // single instance, lives until container releases it
public class Controller {

    private String[] predictions = {  // the data--hard coded for convenience and simplicity
	"Cornelius Tillman!Managed holistic contingency will grow killer action-items.",
	"Conner Kulas!Vision-oriented zero administration time-frame will generate back-end interfaces.",
	"Loraine Ryan!Triple-buffered scalable function will productize visionary infomediaries.",
	"Patricia Zulauf!Reactive radical knowledge base will aggregate extensible vortals.",
	"River Wiza!Face to face client-server pricing structure will whiteboard robust communities.",
	"Jarred Wehner!Future-proofed 5th generation protocol will strategize web-enabled networks.",
	"Emily Roob!Cross-group fresh-thinking encoding will reinvent dot-com systems.",
	"Elvis Ernser!Customizable assymetric database will visualize virtual action-items.",
	"Kathryn Hilpert!User-centric non-volatile open architecture will iterate world-class vortals.",
	"Tanner Dietrich!Enhanced zero tolerance system engine will evolve turn-key deliverables.",
	"Linnie Funk!Distributed dynamic moratorium will iterate magnetic e-commerce.",
	"Emery Ward!Synergistic demand-driven functionalities will visualize compelling vortals.",
	"Craig Leuschke!Robust intermediate extranet will facilitate best-of-breed synergies.",
	"Shayna Lehner!Digitized optimal conglomeration will exploit proactive relationships.",
	"Hollis McCullough!Universal fault-tolerant architecture will synthesize bleeding-edge channels.",
	"Mina Hayes!Cloned assymetric intranet will enable innovative functionalities.",
	"River Friesen!Decentralized 24/7 hub will target robust web-readiness.",
	"Carmel Becker!Synergistic disintermediate policy will expedite back-end experiences.",
	"Bartholome Walsh!Triple-buffered didactic emulation will visualize integrated channels.",
	"Russel Robel!Configurable intangible alliance will scale sexy ROI.",
	"Charlene Mertz!Triple-buffered neutral collaboration will incubate B2B deliverables.",
	"Letitia Pacocha!User-centric multi-state success will transform proactive convergence.",
	"Lottie Marks!Open-source multi-tasking time-frame will monetize rich partnerships.",
	"Kaden Crona!Optional static definition will unleash dynamic e-tailers.",
	"Everardo Lind!De-engineered systematic emulation will deploy out-of-the-box partnerships.",
	"Lilyan Thompson!Synergistic 24/7 website will transition 24/7 methodologies.",
	"Alessia O'Connell!Reactive value-added middleware will engineer next-generation partnerships.",
	"Reymundo Champlin!Self-enabling reciprocal synergy will generate seamless portals.",
	"Immanuel Bergstrom!Assimilated intermediate superstructure will drive vertical methodologies.",
	"Dahlia Robel!Proactive demand-driven open architecture will innovate impactful networks.",
	"Deven Blanda!Balanced clear-thinking utilisation will expedite collaborative initiatives.",
	"Hiram Gulgowski!Versatile tangible application will maximize rich e-business."
    };

    private String[ ] organizations = {     // organization names
	"Crystal Balling, Inc.",
	"Looking Ahead, LLC",
	"The Predictive Synthetics Group",
	"Beyond New Horizons, Inc."
    };

    private String orgName;                    // currently selected organization's name
    private Organization org;                  // currently selected organization
    private List<SelectItem> menuChoices;      // Populates UI menu
    private Map<String, Organization> orgMap;  // name maps to Organization
    private static final int predsPerOrg = 8;  // sayings per organization
    private static final int orgCount = 4;     // number of organizations

    public Controller() {
	init();
    }

    // Create the organizations, and populate each with the specified number of
    // predictions. For identification, each organization has a name, which is
    // displayed in a list on the UI. The default choice of an organization is
    // the first. Each organization also encapsulates its list of Predictions.
    private void init() {
	int k = 0;
	menuChoices = new ArrayList<SelectItem>();
	orgMap = new HashMap<String, Organization>();

	for (int i = 0; i < orgCount; i++) {
	    Organization orgT = new Organization();
	    Prediction[ ] preds = new Prediction[predsPerOrg];
	    for (int j = 0; j < predsPerOrg; j++) {
		String[ ] parts = predictions[k].split("!");
		Prediction p = new Prediction();
		p.setWho(parts[0]);
		p.setWhat(parts[1]);
		preds[j] = p;
		k++;
	    }
	    orgT.setName(organizations[i]);
	    orgT.setPredictions(preds);

	    SelectItem menuChoice = new SelectItem(orgT.getName());
	    menuChoices.add(menuChoice);
	    orgMap.put(orgT.getName(), orgT);
	}
	setOrgName(organizations[0]);
    }

    // properties: a map from an organization's name to the organization
    // is used to handle UI input. JSF does the required 'dependency injections'.
    public void setOrgName(String orgName) {
	this.orgName = orgName;
    }

    public String getOrgName() {
	return orgName;
    }

    public Organization getOrganization() {
	return orgMap.get(orgName); // orgMap is the map from a name to an organization
    }

    public void setOrganization(Organization org) {
	this.org = org;
    }

    public List<SelectItem> getMenuChoices() {  // the menu choices: organization names
	return menuChoices;
    }
}
