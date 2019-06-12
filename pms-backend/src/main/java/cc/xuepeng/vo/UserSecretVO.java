package cc.xuepeng.vo;

/**
 * 用户修改密码时的VO。
 *
 * @author xuepeng
 */
public class UserSecretVO {

    /**
     * @return 获得旧密码。
     */
    public String getOldSecret() {
        return oldSecret;
    }

    /**
     * 设置旧密码。
     *
     * @param oldSecret 旧密码。
     */
    public void setOldSecret(String oldSecret) {
        this.oldSecret = oldSecret;
    }

    /**
     * @return 获得新密码。
     */
    public String getNewSecret() {
        return newSecret;
    }

    /**
     * 设置新密码。
     *
     * @param newSecret 新密码。
     */
    public void setNewSecret(String newSecret) {
        this.newSecret = newSecret;
    }

    /**
     * 旧密码。
     */
    private String oldSecret;
    /**
     * 新密码。
     */
    private String newSecret;

}
