package edu.ustc.mix.core.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import edu.ustc.mix.core.util.MixConstants;

@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemUser {
	
	String value() default MixConstants.CURRENT_USER;
}
