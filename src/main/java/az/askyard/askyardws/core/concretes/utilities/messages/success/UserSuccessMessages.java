package az.askyard.askyardws.core.concretes.utilities.messages.success;

import az.askyard.askyardws.core.concretes.utilities.messages.Messages;

/**
 * @author Vugar Mammadli
 */
public enum UserSuccessMessages implements Messages {
    SAVE("İstifadəçi uğurla əlavə edildi"),
    FIND_BY_ID("Axtarılan sorğu üzrə nəticə tapıldı"),
    FIND_ALL("Axtarılan sorğu üzrə bütün nəticələr"),
    CONTAIN("Axtarılan sorğu üzrə bir sıra nəticələr"),
    START_WITH("Axtarılan sorğu üzrə bir sıra nəticələr"),
    DELETE("Hesabınız silindi"),
    AUTH("Hesabınıza giriş edildi")
    ;
    private final String value;
    UserSuccessMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }




}
