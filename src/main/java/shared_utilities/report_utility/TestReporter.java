package shared_utilities.report_utility;

import java.lang.annotation.Retention;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface TestReporter {
    String title() default "Test";

    String description() default "Description";

}
