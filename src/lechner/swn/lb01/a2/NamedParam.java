/**
 * 
 */
package lechner.swn.lb01.a2;

import java.lang.annotation.*;

/**
 * @author Mike
 *
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface NamedParam {

	String value();

}
