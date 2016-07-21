package com.linkedin.android.infra.lix;

public abstract interface LixManager
{
  public abstract void addTreatmentListener(LixDefinition paramLixDefinition, TreatmentListener paramTreatmentListener);
  
  public abstract void addTreatmentListener(String paramString, TreatmentListener paramTreatmentListener);
  
  public abstract void clearAllTreatments();
  
  public abstract String getTreatment(LixDefinition paramLixDefinition);
  
  public abstract void removeTreatmentListener(LixDefinition paramLixDefinition, TreatmentListener paramTreatmentListener);
  
  public abstract void removeTreatmentListener(String paramString, TreatmentListener paramTreatmentListener);
  
  public abstract void triggerSync();
  
  public abstract void triggerSync(boolean paramBoolean);
  
  public static abstract interface TreatmentListener
  {
    public abstract void onChange(String paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.lix.LixManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */