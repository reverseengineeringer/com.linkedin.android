package butterknife;

import butterknife.internal.ListenerClass;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@ListenerClass(method={@butterknife.internal.ListenerMethod(name="doClick", parameters={"android.view.View"})}, setter="setOnClickListener", targetType="android.view.View", type="butterknife.internal.DebouncingOnClickListener")
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnClick
{
  int[] value() default {-1};
}

/* Location:
 * Qualified Name:     butterknife.OnClick
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */