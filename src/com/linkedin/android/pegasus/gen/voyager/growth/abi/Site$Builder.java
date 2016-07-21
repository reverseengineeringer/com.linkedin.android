package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class Site$Builder
  implements RecordTemplateBuilder<Site>
{
  private boolean hasName = false;
  public boolean hasSiteType = false;
  public boolean hasUrl = false;
  private String name = null;
  public String siteType = null;
  public String url = null;
  
  public final Site build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (Site.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new Site(url, name, siteType, hasUrl, hasName, hasSiteType);
    } while (hasUrl);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.abi.Site", "url");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.Site.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */