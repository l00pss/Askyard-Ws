package az.askyard.askyardws.core.concretes.utilities.messages.success;

public enum DashboardSuccessMessages {
    DASH("Dashed");
    private final String value;
    DashboardSuccessMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
