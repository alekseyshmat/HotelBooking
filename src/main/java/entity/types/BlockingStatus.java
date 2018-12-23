package entity.types;

public enum BlockingStatus {
    BLOCKED("blocked"),
    UNBLOCKED("unblocked");
    private String value;
    BlockingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
