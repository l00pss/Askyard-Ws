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
    BAD_REQUEST("Please try see Request`s URI"),
    USER_NOT_FOUND("İstifadəçi adınız və ya şifrəniz səhvdir");



    private final String value;

    UserErrorMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
