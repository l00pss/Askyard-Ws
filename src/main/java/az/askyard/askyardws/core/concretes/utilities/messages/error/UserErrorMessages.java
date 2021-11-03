package az.askyard.askyardws.core.concretes.utilities.messages.error;

import az.askyard.askyardws.core.concretes.utilities.messages.Messages;
/**
 * @author Vugar Mammadli
 */
public enum UserErrorMessages implements Messages {
    ERROR("Bilinməyən Xəta. Bir neçə dəqiqə sonra təkrar sınayın"),
    NULL_VALUE("Boş dəyər keçilə bilməz"),
    INVALID_CHARACTER("Icazə verilməyən sinvol istifadəsi"),
    UNAUTH("Giriş münkün olmadı."),
    USER_NOT_FOUND("Qeyd olunan sorğu üzrə istifadəçi tapılmadı");



    private final String value;

    UserErrorMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
