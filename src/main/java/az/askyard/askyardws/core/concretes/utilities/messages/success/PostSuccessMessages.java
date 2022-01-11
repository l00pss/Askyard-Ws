package az.askyard.askyardws.core.concretes.utilities.messages.success;

public enum PostSuccessMessages {
    POSTED("Post success send");
    private final String value;
    PostSuccessMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
