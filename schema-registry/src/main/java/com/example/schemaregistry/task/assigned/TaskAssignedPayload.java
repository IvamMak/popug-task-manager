/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.schemaregistry.task.assigned;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class TaskAssignedPayload extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = 586553466477426194L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TaskAssignedPayload\",\"namespace\":\"com.example.schemaregistry.task.assigned\",\"fields\":[{\"name\":\"publicId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"assignerId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"executorId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TaskAssignedPayload> ENCODER =
      new BinaryMessageEncoder<TaskAssignedPayload>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TaskAssignedPayload> DECODER =
      new BinaryMessageDecoder<TaskAssignedPayload>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TaskAssignedPayload> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TaskAssignedPayload> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TaskAssignedPayload> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TaskAssignedPayload>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TaskAssignedPayload to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TaskAssignedPayload from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TaskAssignedPayload instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TaskAssignedPayload fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String publicId;
  @Deprecated public java.lang.String assignerId;
  @Deprecated public java.lang.String executorId;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TaskAssignedPayload() {}

  /**
   * All-args constructor.
   * @param publicId The new value for publicId
   * @param assignerId The new value for assignerId
   * @param executorId The new value for executorId
   */
  public TaskAssignedPayload(java.lang.String publicId, java.lang.String assignerId, java.lang.String executorId) {
    this.publicId = publicId;
    this.assignerId = assignerId;
    this.executorId = executorId;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return publicId;
    case 1: return assignerId;
    case 2: return executorId;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: publicId = value$ != null ? value$.toString() : null; break;
    case 1: assignerId = value$ != null ? value$.toString() : null; break;
    case 2: executorId = value$ != null ? value$.toString() : null; break;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  /**
   * Gets the value of the 'publicId' field.
   * @return The value of the 'publicId' field.
   */
  public java.lang.String getPublicId() {
    return publicId;
  }


  /**
   * Sets the value of the 'publicId' field.
   * @param value the value to set.
   */
  public void setPublicId(java.lang.String value) {
    this.publicId = value;
  }

  /**
   * Gets the value of the 'assignerId' field.
   * @return The value of the 'assignerId' field.
   */
  public java.lang.String getAssignerId() {
    return assignerId;
  }


  /**
   * Sets the value of the 'assignerId' field.
   * @param value the value to set.
   */
  public void setAssignerId(java.lang.String value) {
    this.assignerId = value;
  }

  /**
   * Gets the value of the 'executorId' field.
   * @return The value of the 'executorId' field.
   */
  public java.lang.String getExecutorId() {
    return executorId;
  }


  /**
   * Sets the value of the 'executorId' field.
   * @param value the value to set.
   */
  public void setExecutorId(java.lang.String value) {
    this.executorId = value;
  }

  /**
   * Creates a new TaskAssignedPayload RecordBuilder.
   * @return A new TaskAssignedPayload RecordBuilder
   */
  public static com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder newBuilder() {
    return new com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder();
  }

  /**
   * Creates a new TaskAssignedPayload RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TaskAssignedPayload RecordBuilder
   */
  public static com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder newBuilder(com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder other) {
    if (other == null) {
      return new com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder();
    } else {
      return new com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder(other);
    }
  }

  /**
   * Creates a new TaskAssignedPayload RecordBuilder by copying an existing TaskAssignedPayload instance.
   * @param other The existing instance to copy.
   * @return A new TaskAssignedPayload RecordBuilder
   */
  public static com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder newBuilder(com.example.schemaregistry.task.assigned.TaskAssignedPayload other) {
    if (other == null) {
      return new com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder();
    } else {
      return new com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder(other);
    }
  }

  /**
   * RecordBuilder for TaskAssignedPayload instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TaskAssignedPayload>
    implements org.apache.avro.data.RecordBuilder<TaskAssignedPayload> {

    private java.lang.String publicId;
    private java.lang.String assignerId;
    private java.lang.String executorId;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.publicId)) {
        this.publicId = data().deepCopy(fields()[0].schema(), other.publicId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.assignerId)) {
        this.assignerId = data().deepCopy(fields()[1].schema(), other.assignerId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.executorId)) {
        this.executorId = data().deepCopy(fields()[2].schema(), other.executorId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
    }

    /**
     * Creates a Builder by copying an existing TaskAssignedPayload instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.schemaregistry.task.assigned.TaskAssignedPayload other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.publicId)) {
        this.publicId = data().deepCopy(fields()[0].schema(), other.publicId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.assignerId)) {
        this.assignerId = data().deepCopy(fields()[1].schema(), other.assignerId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.executorId)) {
        this.executorId = data().deepCopy(fields()[2].schema(), other.executorId);
        fieldSetFlags()[2] = true;
      }
    }

    /**
      * Gets the value of the 'publicId' field.
      * @return The value.
      */
    public java.lang.String getPublicId() {
      return publicId;
    }


    /**
      * Sets the value of the 'publicId' field.
      * @param value The value of 'publicId'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder setPublicId(java.lang.String value) {
      validate(fields()[0], value);
      this.publicId = value;
      fieldSetFlags()[0] = true;
      return this;
    }

    /**
      * Checks whether the 'publicId' field has been set.
      * @return True if the 'publicId' field has been set, false otherwise.
      */
    public boolean hasPublicId() {
      return fieldSetFlags()[0];
    }


    /**
      * Clears the value of the 'publicId' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder clearPublicId() {
      publicId = null;
      fieldSetFlags()[0] = false;
      return this;
    }

    /**
      * Gets the value of the 'assignerId' field.
      * @return The value.
      */
    public java.lang.String getAssignerId() {
      return assignerId;
    }


    /**
      * Sets the value of the 'assignerId' field.
      * @param value The value of 'assignerId'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder setAssignerId(java.lang.String value) {
      validate(fields()[1], value);
      this.assignerId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'assignerId' field has been set.
      * @return True if the 'assignerId' field has been set, false otherwise.
      */
    public boolean hasAssignerId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'assignerId' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder clearAssignerId() {
      assignerId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'executorId' field.
      * @return The value.
      */
    public java.lang.String getExecutorId() {
      return executorId;
    }


    /**
      * Sets the value of the 'executorId' field.
      * @param value The value of 'executorId'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder setExecutorId(java.lang.String value) {
      validate(fields()[2], value);
      this.executorId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'executorId' field has been set.
      * @return True if the 'executorId' field has been set, false otherwise.
      */
    public boolean hasExecutorId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'executorId' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.assigned.TaskAssignedPayload.Builder clearExecutorId() {
      executorId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TaskAssignedPayload build() {
      try {
        TaskAssignedPayload record = new TaskAssignedPayload();
        record.publicId = fieldSetFlags()[0] ? this.publicId : (java.lang.String) defaultValue(fields()[0]);
        record.assignerId = fieldSetFlags()[1] ? this.assignerId : (java.lang.String) defaultValue(fields()[1]);
        record.executorId = fieldSetFlags()[2] ? this.executorId : (java.lang.String) defaultValue(fields()[2]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TaskAssignedPayload>
    WRITER$ = (org.apache.avro.io.DatumWriter<TaskAssignedPayload>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TaskAssignedPayload>
    READER$ = (org.apache.avro.io.DatumReader<TaskAssignedPayload>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.publicId);

    out.writeString(this.assignerId);

    out.writeString(this.executorId);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.publicId = in.readString();

      this.assignerId = in.readString();

      this.executorId = in.readString();

    } else {
      for (int i = 0; i < 3; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.publicId = in.readString();
          break;

        case 1:
          this.assignerId = in.readString();
          break;

        case 2:
          this.executorId = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










