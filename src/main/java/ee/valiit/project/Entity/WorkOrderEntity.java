package ee.valiit.project.Entity;

import java.math.BigInteger;

public class WorkOrderEntity {
    private int id;
    private int deviceId;
    private String jobDescription;
    private boolean status; //true means work done, false means work not done
    private int technicianId;
    private int productId;
    private int consumableId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(int consumableId) {
        this.consumableId = consumableId;
    }
}
