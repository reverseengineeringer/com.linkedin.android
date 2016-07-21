package com.bluelinelabs.logansquare.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface JsonObject
{
  FieldDetectionPolicy fieldDetectionPolicy() default FieldDetectionPolicy.ANNOTATIONS_ONLY;
  
  FieldNamingPolicy fieldNamingPolicy() default FieldNamingPolicy.FIELD_NAME;
  
  boolean serializeNullCollectionElements() default false;
  
  boolean serializeNullObjects() default false;
  
  public static enum FieldDetectionPolicy
  {
    ANNOTATIONS_ONLY,  NONPRIVATE_FIELDS,  NONPRIVATE_FIELDS_AND_ACCESSORS;
    
    private FieldDetectionPolicy() {}
  }
  
  public static enum FieldNamingPolicy
  {
    FIELD_NAME,  LOWER_CASE_WITH_UNDERSCORES;
    
    private FieldNamingPolicy() {}
  }
}

/* Location:
 * Qualified Name:     com.bluelinelabs.logansquare.annotation.JsonObject
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */