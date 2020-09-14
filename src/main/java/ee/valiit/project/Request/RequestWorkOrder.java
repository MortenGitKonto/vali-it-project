package ee.valiit.project.Request;

public class RequestWorkOrder {
    private int deviceId;
    private String jobDescription;
//  TODO? lets make status "false" by default
    private boolean status; //true means work done, false means work not done
    private String technicianName;


    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = this.jobDescription;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    public void setTechnicianName(String technicianName) {
        this.technicianName = technicianName;
    }
}
