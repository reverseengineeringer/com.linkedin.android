package com.bluelinelabs.logansquare.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface JsonIgnore
{
  IgnorePolicy ignorePolicy() default IgnorePolicy.PARSE_AND_SERIALIZE;
  
  public static enum IgnorePolicy
  {
    PARSE_AND_SERIALIZE,  PARSE_ONLY,  SERIALIZE_ONLY;
    
    private IgnorePolicy() {}
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.annotation.JsonIgnore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */