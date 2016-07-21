package org.acra.sender;

public enum HttpSender$Type
{
  FORM,  JSON;
  
  private HttpSender$Type() {}
  
  public abstract String getContentType();
}

/* Location:
 * Qualified Name:     org.acra.sender.HttpSender.Type
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */