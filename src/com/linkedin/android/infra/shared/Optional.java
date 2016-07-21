package com.linkedin.android.infra.shared;

import java.util.NoSuchElementException;

public final class Optional<T>
{
  private static final Optional<?> EMPTY = new Optional();
  public final T value;
  
  private Optional()
  {
    value = null;
  }
  
  private Optional(T paramT)
  {
    value = paramT;
  }
  
  public static <T> Optional<T> empty()
  {
    return EMPTY;
  }
  
  public static <T> Optional<T> of(T paramT)
  {
    return new Optional(paramT);
  }
  
  public static <T> Optional<T> ofNullable(T paramT)
  {
    if (paramT == null) {
      return EMPTY;
    }
    return of(paramT);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof Optional)) {
        return false;
      }
      paramObject = (Optional)paramObject;
      if (value != null) {
        break;
      }
    } while (value == null);
    return false;
    return value.equals(value);
  }
  
  public final T get()
  {
    if (value == null) {
      throw new NoSuchElementException("No value present");
    }
    return (T)value;
  }
  
  public final int hashCode()
  {
    if (value == null) {
      return 0;
    }
    return value.hashCode();
  }
  
  public final boolean isPresent()
  {
    return value != null;
  }
  
  public final String toString()
  {
    if (value != null) {
      return String.format("Optional[%s]", new Object[] { value });
    }
    return "Optional.empty";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.Optional
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */