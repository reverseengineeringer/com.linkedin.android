package com.linkedin.CrossPromoLib.api;

import com.linkedin.CrossPromoLib.models.PromoModel;
import java.util.Map;

final class PromoInflater$Source
  implements PromoSource
{
  private final String pageKey;
  private final PromoInflater promoInflater;
  private final PromoModel promoModel;
  private final Map<String, String> queryParams;
  
  PromoInflater$Source(PromoInflater paramPromoInflater, String paramString, Map<String, String> paramMap, PromoModel paramPromoModel)
  {
    promoInflater = paramPromoInflater;
    pageKey = paramString;
    queryParams = paramMap;
    promoModel = paramPromoModel;
  }
  
  public final String getPageKey()
  {
    return pageKey;
  }
  
  public final PromoInflater getPromoInflater()
  {
    return promoInflater;
  }
  
  public final PromoModel getPromoModel()
  {
    return promoModel;
  }
  
  public final Map<String, String> getQueryParameters()
  {
    return queryParams;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.api.PromoInflater.Source
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */