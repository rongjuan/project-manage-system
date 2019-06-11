package cc.xuepeng.service.user.secret;

import cc.xuepeng.consts.UserConst;
import cn.yesway.framework.common.security.md5.MD5Factory;
import org.springframework.stereotype.Service;

/**
 * MD5密码生成策略。
 *
 * @author xuepeng
 */
@Service("secretMD5Strategy")
public class SecretMD5Strategy implements SecretGenerateStrategy {

    /**
     * 密码生成。
     *
     * @param secret 密码。
     * @return 密码。
     */
    @Override
    public String generate(final String secret) {
        return MD5Factory.getInstance().getMD5().encodeSalt(secret + UserConst.SALT);
    }

}
