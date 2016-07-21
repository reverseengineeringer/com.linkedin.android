package com.linkedin.CrossPromoLib.api;

import com.linkedin.CrossPromoLib.models.PromoModel;
import java.util.Map;

public abstract interface PromoSource
{
  public abstract String getPageKey();
  
  public abstract PromoInflater getPromoInflater();
  
  public abstract PromoModel getPromoModel();
  
  public abstract Map<String, String> getQueryParameters();
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */