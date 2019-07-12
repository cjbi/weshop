package tech.wetech.weshop.wechat.annotations;

import java.lang.annotation.*;

/**
 * @author cjbi
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface AuthLogin {
}
