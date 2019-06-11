package cc.xuepeng.service.user.secret;

/**
 * 密码生成策略。
 *
 * @author xuepeng
 */
public interface SecretGenerateStrategy {

    /**
     * 密码生成。
     *
     * @param secret 密码。
     * @return 密码。
     */
    String generate(final String secret);

}
