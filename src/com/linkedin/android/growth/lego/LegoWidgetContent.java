package com.linkedin.android.growth.lego;

import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;

public final class LegoWidgetContent
{
  public final LegoGroupContent group;
  public LegoWidgetContent next;
  public LegoWidgetContent previous;
  public final WidgetContent widgetContent;
  
  public LegoWidgetContent(LegoGroupContent paramLegoGroupContent, WidgetContent paramWidgetContent)
  {
    group = paramLegoGroupContent;
    widgetContent = paramWidgetContent;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof LegoWidgetContent)) && (widgetContent.widgetId.equals(widgetContent.widgetId)));
  }
  
  public final int hashCode()
  {
    return widgetContent.widgetId.hashCode();
  }
  
  public final String toString()
  {
    return widgetContent.widgetId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoWidgetContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */