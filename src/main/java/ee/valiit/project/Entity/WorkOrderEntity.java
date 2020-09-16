package ee.valiit.project.Entity;

public class WorkOrderEntity {
    private int deviceId;
    private String jobDescription;
//  TODO? lets make status "false" by default
    private boolean status; //true means work done, false means work not done
    private int technicianId;

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
        this.jobDescription = jobDescription;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
    }
}
