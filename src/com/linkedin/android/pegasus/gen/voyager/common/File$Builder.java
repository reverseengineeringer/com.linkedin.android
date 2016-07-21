package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class File$Builder
  implements RecordTemplateBuilder<File>
{
  public long byteSize = 0L;
  public boolean hasByteSize = false;
  public boolean hasId = false;
  public boolean hasMediaType = false;
  public boolean hasName = false;
  public boolean hasReference = false;
  public String id = null;
  public String mediaType = null;
  public String name = null;
  public File.Reference reference = null;
  
  public final File build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (File.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new File(id, name, byteSize, mediaType, reference, hasId, hasName, hasByteSize, hasMediaType, hasReference);
      if (!hasId) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "id");
      }
      if (!hasName) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "name");
      }
      if (!hasMediaType) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "mediaType");
      }
    } while (hasReference);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.common.File", "reference");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.File.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */