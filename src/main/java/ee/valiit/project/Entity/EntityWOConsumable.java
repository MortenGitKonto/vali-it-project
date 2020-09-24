package ee.valiit.project.Entity;

public class EntityWOConsumable {

    private int id;
    private int workOrderId;
    private int consumableId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    public int getConsumableId() {
        return consumableId;
    }

    public void setConsumableId(int consumableId) {
        this.consumableId = consumableId;
    }
}
