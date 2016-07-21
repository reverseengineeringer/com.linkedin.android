package com.linkedin.android.pegasus.gen.voyager.growth.lego;

import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.fission.interfaces.FissionAdapter;
import com.linkedin.android.fission.interfaces.FissionTransaction;
import com.linkedin.android.pegasus.binary.PegasusBinaryUtils;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class GroupContent
  implements FissileDataModel<GroupContent>, RecordTemplate<GroupContent>
{
  public static final GroupContentBuilder BUILDER = GroupContentBuilder.INSTANCE;
  private volatile int __sizeOfObject = -1;
  private volatile int _cachedHashCode = -1;
  final String _cachedId;
  public final String groupId;
  public final boolean hasGroupId;
  public final boolean hasWidgets;
  public final List<WidgetContent> widgets;
  
  GroupContent(String paramString, List<WidgetContent> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    groupId = paramString;
    if (paramList == null) {}
    for (paramString = null;; paramString = Collections.unmodifiableList(paramList))
    {
      widgets = paramString;
      hasGroupId = paramBoolean1;
      hasWidgets = paramBoolean2;
      _cachedId = null;
      return;
    }
  }
  
  public final GroupContent accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasGroupId)
    {
      paramDataProcessor.startRecordField$505cff1c("groupId");
      paramDataProcessor.processString(groupId);
    }
    Object localObject = null;
    WidgetContent localWidgetContent = null;
    boolean bool = false;
    if (hasWidgets)
    {
      paramDataProcessor.startRecordField$505cff1c("widgets");
      widgets.size();
      paramDataProcessor.startArray$13462e();
      localObject = localWidgetContent;
      if (paramDataProcessor.shouldReturnProcessedTemplate()) {
        localObject = new ArrayList();
      }
      int i = 0;
      Iterator localIterator = widgets.iterator();
      if (localIterator.hasNext())
      {
        localWidgetContent = (WidgetContent)localIterator.next();
        paramDataProcessor.processArrayItem(i);
        if (paramDataProcessor.shouldAcceptTransitively()) {}
        for (localWidgetContent = localWidgetContent.accept(paramDataProcessor);; localWidgetContent = (WidgetContent)paramDataProcessor.processDataTemplate(localWidgetContent))
        {
          if ((localObject != null) && (localWidgetContent != null)) {
            ((List)localObject).add(localWidgetContent);
          }
          i += 1;
          break;
        }
      }
      paramDataProcessor.endArray();
      if (localObject == null) {
        break label251;
      }
    }
    label251:
    for (bool = true;; bool = false)
    {
      paramDataProcessor.endRecord();
      if (!paramDataProcessor.shouldReturnProcessedTemplate()) {
        break label344;
      }
      try
      {
        if (hasGroupId) {
          break;
        }
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent", "groupId");
      }
      catch (BuilderException paramDataProcessor)
      {
        throw new DataProcessorException(paramDataProcessor);
      }
    }
    if (!hasWidgets) {
      throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent", "widgets");
    }
    if (widgets != null)
    {
      paramDataProcessor = widgets.iterator();
      while (paramDataProcessor.hasNext()) {
        if ((WidgetContent)paramDataProcessor.next() == null) {
          throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent", "widgets");
        }
      }
    }
    return new GroupContent(groupId, (List)localObject, hasGroupId, bool);
    label344:
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (GroupContent)paramObject;
      if (groupId != null)
      {
        if (groupId.equals(groupId)) {}
      }
      else {
        while (groupId != null) {
          return false;
        }
      }
      if (widgets == null) {
        break;
      }
    } while (widgets.equals(widgets));
    for (;;)
    {
      return false;
      if (widgets == null) {
        break;
      }
    }
  }
  
  public final int getSerializedSize()
  {
    if (__sizeOfObject > 0) {
      return __sizeOfObject;
    }
    int i = 0 + 1 + 4 + 1;
    if (hasGroupId) {
      i = PegasusBinaryUtils.getEncodedLength(groupId) + 8;
    }
    i += 1;
    int j = i;
    if (hasWidgets)
    {
      i += 2;
      Iterator localIterator = widgets.iterator();
      for (;;)
      {
        j = i;
        if (!localIterator.hasNext()) {
          break;
        }
        WidgetContent localWidgetContent = (WidgetContent)localIterator.next();
        i += 1;
        if (_cachedId != null) {
          i = i + 2 + PegasusBinaryUtils.getEncodedLength(_cachedId);
        } else {
          i += localWidgetContent.getSerializedSize();
        }
      }
    }
    __sizeOfObject = j;
    return j;
  }
  
  public final int hashCode()
  {
    int j = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    if (groupId != null) {}
    for (int i = groupId.hashCode();; i = 0)
    {
      if (widgets != null) {
        j = widgets.hashCode();
      }
      i = (i + 527) * 31 + j;
      _cachedHashCode = i;
      return i;
    }
  }
  
  public final String id()
  {
    return _cachedId;
  }
  
  public final void writeToFission(FissionAdapter paramFissionAdapter, ByteBuffer paramByteBuffer, String paramString, boolean paramBoolean, FissionTransaction paramFissionTransaction)
    throws IOException
  {
    paramFissionAdapter.willWriteModel$30d0b508(this, paramBoolean);
    String str = _cachedId;
    if ((str == null) && (paramString == null) && (paramByteBuffer == null)) {
      throw new IOException("Cannot write model without at least one of ID/CacheKey/ByteBuffer to fission when building GroupContent");
    }
    if (paramBoolean)
    {
      if (paramString != null) {
        paramFissionAdapter.writeToCache(paramString, null, 0, paramFissionTransaction);
      }
      if (str != null) {
        paramFissionAdapter.writeToCache(str, null, 0, paramFissionTransaction);
      }
    }
    label283:
    do
    {
      ByteBuffer localByteBuffer;
      do
      {
        return;
        localByteBuffer = paramByteBuffer;
        if (paramByteBuffer == null) {
          localByteBuffer = paramFissionAdapter.getBuffer(getSerializedSize());
        }
        localByteBuffer.put((byte)1);
        localByteBuffer.putInt(1131509377);
        Iterator localIterator;
        if (hasGroupId)
        {
          localByteBuffer.put((byte)1);
          paramFissionAdapter.writeString(localByteBuffer, groupId);
          if (hasWidgets)
          {
            localByteBuffer.put((byte)1);
            paramFissionAdapter.writeUnsignedShort(localByteBuffer, widgets.size());
            localIterator = widgets.iterator();
          }
        }
        else
        {
          for (;;)
          {
            if (!localIterator.hasNext()) {
              break label283;
            }
            WidgetContent localWidgetContent = (WidgetContent)localIterator.next();
            if (_cachedId != null)
            {
              localByteBuffer.put((byte)0);
              paramFissionAdapter.writeString(localByteBuffer, _cachedId);
              localWidgetContent.writeToFission(paramFissionAdapter, null, null, paramBoolean, paramFissionTransaction);
              continue;
              localByteBuffer.put((byte)0);
              break;
            }
            localByteBuffer.put((byte)1);
            localWidgetContent.writeToFission(paramFissionAdapter, localByteBuffer, null, paramBoolean, paramFissionTransaction);
          }
        }
        localByteBuffer.put((byte)0);
      } while (paramByteBuffer != null);
      if (str == null)
      {
        paramFissionAdapter.writeToCache(paramString, localByteBuffer, getSerializedSize(), paramFissionTransaction);
        paramFissionAdapter.recycle(localByteBuffer);
        return;
      }
      paramFissionAdapter.writeToCache(str, localByteBuffer, getSerializedSize(), paramFissionTransaction);
      paramFissionAdapter.recycle(localByteBuffer);
    } while ((paramString == null) || (str.equals(paramString)));
    int i = PegasusBinaryUtils.getEncodedLength(str) + 3;
    paramByteBuffer = paramFissionAdapter.getBuffer(i);
    paramByteBuffer.put((byte)0);
    paramFissionAdapter.writeString(paramByteBuffer, str);
    paramFissionAdapter.writeToCache(paramString, paramByteBuffer, i, paramFissionTransaction);
    paramFissionAdapter.recycle(paramByteBuffer);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */