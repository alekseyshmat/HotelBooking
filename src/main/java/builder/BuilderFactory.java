package builder;

public class BuilderFactory {

    public static Builder create(String builderName) {

        switch (builderName) {
            case "user":
                return new UserBuilder();
            default:
                throw new IllegalArgumentException("Unknown Builder name!");
        }
    }
}
