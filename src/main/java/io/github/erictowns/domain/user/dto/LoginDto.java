package io.github.erictowns.domain.user.dto;

/**
 * Description: Login
 *
 * @author EricTowns
 * @date 2023/10/20 16:24
 */
public class LoginDto {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
