package entity.types;

public enum Role {
    USER("user"),
    ADMIN("admin");
    private String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
