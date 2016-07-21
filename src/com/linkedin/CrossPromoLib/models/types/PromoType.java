package com.linkedin.CrossPromoLib.models.types;

public final class PromoType
{
  public static final PromoType BANNER_PROMO_ICON = new PromoType("promo2");
  public static final PromoType BANNER_PROMO_IMAGE = new PromoType("promo3");
  public static final PromoType BANNER_PROMO_PANEL_ICON = new PromoType("promo4");
  public static final PromoType BANNER_PROMO_TEXT = new PromoType("promo5");
  public static final PromoType BOX_PROMO = new PromoType("promo1");
  public static final PromoType IMAGE_ROLLUP_PROMO = new PromoType("promo6");
  public static final PromoType LIGHTBOX_PROMO_ICON = new PromoType("lightbox_subview_with_logo");
  public static final PromoType LIGHTBOX_PROMO_MASTER = new PromoType("lightbox_masterview");
  public static final PromoType LIGHTBOX_PROMO_NOICON = new PromoType("lightbox_subview_without_logo");
  public static final PromoType PROMO_INVALID = new PromoType("");
  public static final PromoType TALL_HERO_PROMO = new PromoType("promo7");
  private final String value;
  
  public PromoType(String paramString)
  {
    value = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (!(paramObject instanceof PromoType)) {
        return false;
      }
      paramObject = (PromoType)paramObject;
      if (value != null) {
        break;
      }
    } while (value == null);
    return false;
    return value.equals(value);
  }
  
  public final int hashCode()
  {
    if (value == null) {
      return 0;
    }
    return value.hashCode();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.models.types.PromoType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */