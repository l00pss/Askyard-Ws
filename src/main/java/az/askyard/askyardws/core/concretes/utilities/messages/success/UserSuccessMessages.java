package az.askyard.askyardws.core.concretes.utilities.messages.success;

import az.askyard.askyardws.core.concretes.utilities.messages.Messages;

/**
 * @author Vugar Mammadli
 */
public enum UserSuccessMessages implements Messages {
    REGISTER("İstifadəçi uğurla əlavə edildi"),
    FIND_BY_ID("Axtarılan sorğu üzrə nəticələr"),
    FIND_ALL("Axtarılan sorğu üzrə bütün nəticələr"),
    CONTAIN("Axtarılan sorğu üzrə bir sıra nəticələr"),
    START_WITH("Axtarılan sorğu üzrə bir sıra nəticələr"),
    DELETE("Hesabınız silindi"),
    UPDATE("Dəyişikliklər icra olundu"),
    AUTH("Hesabınıza giriş edildi"),
    FOLLOW("Istifadəçi indi izlənilir"),
    UNFOLLOW("İstifadəçi indi izlənilmir"),
    FROZEN("Hesabınız dondurulmuşdur"),
    UNFROZEN("Hesabınız dondurulmuşdur")
    ;
    private final String value;
    UserSuccessMessages(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }




}
