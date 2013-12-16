import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;

//@Target(ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TypeAnnotation {

	Class<ArrayList> sammlung();
	


}
