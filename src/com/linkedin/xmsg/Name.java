package com.linkedin.xmsg;

import com.linkedin.xmsg.util.Utils;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Name
{
  private Object _familyName;
  private Object _givenName;
  private Object _maidenName;
  private final Collection<Name.Style> _styles = new HashSet();
  
  public static Name builder()
  {
    return new Name();
  }
  
  public Name addStyle(Collection<Name.Style> paramCollection)
  {
    if (paramCollection != null) {
      _styles.addAll(paramCollection);
    }
    return this;
  }
  
  public Name addStyle(Name.Style... paramVarArgs)
  {
    if (paramVarArgs != null) {
      _styles.addAll(Arrays.asList(paramVarArgs));
    }
    return this;
  }
  
  public Name clearStyles()
  {
    _styles.clear();
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (Name)paramObject;
        if (_familyName == null)
        {
          if (_familyName != null) {
            return false;
          }
        }
        else if (!_familyName.equals(_familyName)) {
          return false;
        }
        if (_givenName == null)
        {
          if (_givenName != null) {
            return false;
          }
        }
        else if (!_givenName.equals(_givenName)) {
          return false;
        }
        if (_maidenName == null)
        {
          if (_maidenName != null) {
            return false;
          }
        }
        else if (!_maidenName.equals(_maidenName)) {
          return false;
        }
        if (_styles != null) {
          break;
        }
      } while (_styles == null);
      return false;
    } while (_styles.equals(_styles));
    return false;
  }
  
  public String getFamilyName()
  {
    if ((_familyName instanceof WithFormat)) {
      return ((WithFormat)_familyName).getFormattedValue();
    }
    if (_familyName == null) {
      return null;
    }
    return _familyName.toString();
  }
  
  public String getFamilyName(boolean paramBoolean)
  {
    if ((_familyName instanceof WithFormat))
    {
      if (paramBoolean) {
        return ((WithFormat)_familyName).getPlainValue();
      }
      return ((WithFormat)_familyName).getFormattedValue();
    }
    if (_familyName == null) {
      return null;
    }
    return _familyName.toString();
  }
  
  public String getGivenName()
  {
    if ((_givenName instanceof WithFormat)) {
      return ((WithFormat)_givenName).getFormattedValue();
    }
    if (_givenName == null) {
      return null;
    }
    return _givenName.toString();
  }
  
  public String getGivenName(boolean paramBoolean)
  {
    if ((_givenName instanceof WithFormat))
    {
      if (paramBoolean) {
        return ((WithFormat)_givenName).getPlainValue();
      }
      return ((WithFormat)_givenName).getFormattedValue();
    }
    if (_givenName == null) {
      return null;
    }
    return _givenName.toString();
  }
  
  public String getMaidenName()
  {
    if ((_maidenName instanceof WithFormat)) {
      return ((WithFormat)_maidenName).getFormattedValue();
    }
    if (_maidenName == null) {
      return null;
    }
    return _maidenName.toString();
  }
  
  public String getMaidenName(boolean paramBoolean)
  {
    if ((_maidenName instanceof WithFormat))
    {
      if (paramBoolean) {
        return ((WithFormat)_maidenName).getPlainValue();
      }
      return ((WithFormat)_maidenName).getFormattedValue();
    }
    if (_maidenName == null) {
      return null;
    }
    return _maidenName.toString();
  }
  
  public Set<Name.Style> getStyles()
  {
    return new HashSet(_styles);
  }
  
  public boolean hasFamilyName()
  {
    if ((_familyName instanceof WithFormat)) {
      return !Utils.isBlank(((WithFormat)_familyName).getFormattedValue());
    }
    return (_familyName != null) && (!Utils.isBlank(_familyName.toString()));
  }
  
  public boolean hasGivenName()
  {
    if ((_givenName instanceof WithFormat)) {
      return !Utils.isBlank(((WithFormat)_givenName).getFormattedValue());
    }
    return (_givenName != null) && (!Utils.isBlank(_givenName.toString()));
  }
  
  public boolean hasMaidenName()
  {
    if ((_maidenName instanceof WithFormat)) {
      return !Utils.isBlank(((WithFormat)_maidenName).getFormattedValue());
    }
    return (_maidenName != null) && (!Utils.isBlank(_maidenName.toString()));
  }
  
  public boolean hasMultiplePrimaryStyles()
  {
    if (_styles.contains(Name.Style.micro)) {
      if (_styles.size() < 3) {}
    }
    while (_styles.size() >= 2)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public boolean hasNoPrimaryStyles()
  {
    return (_styles.size() == 0) || ((_styles.size() == 1) && (isStyleMicro()));
  }
  
  public boolean hasStyles()
  {
    return _styles.size() > 0;
  }
  
  public int hashCode()
  {
    int m = 0;
    int i;
    int j;
    label21:
    int k;
    if (_familyName == null)
    {
      i = 0;
      if (_givenName != null) {
        break label69;
      }
      j = 0;
      if (_maidenName != null) {
        break label80;
      }
      k = 0;
      label30:
      if (_styles != null) {
        break label91;
      }
    }
    for (;;)
    {
      return (((i + 31) * 31 + j) * 31 + k) * 31 + m;
      i = _familyName.hashCode();
      break;
      label69:
      j = _givenName.hashCode();
      break label21;
      label80:
      k = _maidenName.hashCode();
      break label30;
      label91:
      m = _styles.hashCode();
    }
  }
  
  public boolean isFamilyEncoded()
  {
    return _familyName instanceof WithFormat;
  }
  
  public boolean isGivenEncoded()
  {
    return _givenName instanceof WithFormat;
  }
  
  public boolean isMaidenEncoded()
  {
    return _maidenName instanceof WithFormat;
  }
  
  public boolean isStyleFamiliar()
  {
    return _styles.contains(Name.Style.familiar);
  }
  
  public boolean isStyleFamily()
  {
    return _styles.contains(Name.Style.family);
  }
  
  public boolean isStyleFull()
  {
    return _styles.contains(Name.Style.full);
  }
  
  public boolean isStyleGiven()
  {
    return _styles.contains(Name.Style.given);
  }
  
  public boolean isStyleList()
  {
    return _styles.contains(Name.Style.list);
  }
  
  public boolean isStyleMaiden()
  {
    return _styles.contains(Name.Style.maiden);
  }
  
  public boolean isStyleMicro()
  {
    return _styles.contains(Name.Style.micro);
  }
  
  public Name setFirstName(Object paramObject)
  {
    _givenName = paramObject;
    return this;
  }
  
  public Name setLastName(Object paramObject)
  {
    _familyName = paramObject;
    return this;
  }
  
  public Name setMaidenName(Object paramObject)
  {
    _maidenName = paramObject;
    return this;
  }
  
  public String toString()
  {
    return "[" + _givenName + "," + _familyName + "," + _maidenName + "]";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.xmsg.Name
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */