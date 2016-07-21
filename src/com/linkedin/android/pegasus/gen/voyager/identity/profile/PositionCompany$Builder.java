package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class PositionCompany$Builder
  implements RecordTemplateBuilder<PositionCompany>
{
  private EmployeeCountRange employeeCountRange = null;
  private boolean hasEmployeeCountRange = false;
  private boolean hasIndustries = false;
  public boolean hasMiniCompany = false;
  private List<String> industries = null;
  public MiniCompany miniCompany = null;
  
  public final PositionCompany build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (PositionCompany.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (industries != null)
    {
      paramFlavor = industries.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((String)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany", "industries");
            if (!hasIndustries) {
              industries = Collections.emptyList();
            }
            if (hasMiniCompany) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany", "miniCompany");
          }
        }
      }
    }
    return new PositionCompany(miniCompany, employeeCountRange, industries, hasMiniCompany, hasEmployeeCountRange, hasIndustries);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */