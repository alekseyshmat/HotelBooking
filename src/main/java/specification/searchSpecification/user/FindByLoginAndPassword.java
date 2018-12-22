package specification.searchSpecification.user;

import org.apache.commons.codec.digest.DigestUtils;
import specification.Specification;

import java.util.Arrays;
import java.util.List;

public class FindByLoginAndPassword implements Specification {

    private String login;
    private String password;

    public FindByLoginAndPassword(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toSql() {
        return "where username = ? AND password = ?";
    }

    @Override
    public List<Object> getParametres() {
        String encryptedPassword = decryptPassword(password);
        return Arrays.asList(login, encryptedPassword);
    }

    private String decryptPassword(String password) {
        return DigestUtils.md5Hex(password);
    }
}
