import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@WorkedOnAnnotation(worker1 = "Maisriemler", comment1 = "", comment2 = "", worker2 = "")
@Retention(value = RetentionPolicy.RUNTIME)
public @interface WorkedOnAnnotation {

	String worker1();

	String comment1();

	String worker2();

	String comment2();
}