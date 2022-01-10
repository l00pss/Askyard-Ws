package az.askyard.askyardws.core.config.patterns;

/**
 * @author Vugar Mammadli
 */
public enum RequestAuthPattern {
    AUTH("/api/1.0/auth"),
    ACCOUNT_DELETE("/api/1.0/user/account/delete"),
    ACCOUNT_UPDATE("/api/1.0/user/account/update"),
    GET_ALL_FOLLOWERS("/api/1.0/user/findAllFollow"),
    FOLLOW("/api/1.0/user/follow/{id}"),
    UNFOLLOW("/api/1.0/user/unfollow/{id}")
    ;

    private String pattern;
    RequestAuthPattern(String pattern) {
        this.pattern=pattern;
    }

    public String getPattern() {
        return pattern;
    }
}