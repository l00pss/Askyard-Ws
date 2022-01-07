package az.askyard.askyardws.core.concretes.utilities.messages.error;

public enum UserRegisterErrors {
    EMAIL_EXIST("Bu email artıq qeydiyyatdan keçmişdir"),
    USERNAME_EXIST("Bu adlı istifadəçi artıq qeydiyyatdan keçmişdir");



    private final String value;

    UserRegisterErrors(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
