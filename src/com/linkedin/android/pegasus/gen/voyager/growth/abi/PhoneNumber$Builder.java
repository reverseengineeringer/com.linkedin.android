package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class PhoneNumber$Builder
  implements RecordTemplateBuilder<PhoneNumber>
{
  private String extension = null;
  private boolean hasExtension = false;
  public boolean hasNumber = false;
  public boolean hasPrimary = false;
  public boolean hasType = false;
  public String number = null;
  public boolean primary = false;
  public String type = null;
  
  public final PhoneNumber build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PhoneNumber.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new PhoneNumber(number, extension, type, primary, hasNumber, hasExtension, hasType, hasPrimary);
      if (!hasPrimary) {
        primary = false;
      }
    } while (hasNumber);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumber", "number");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.PhoneNumber.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */