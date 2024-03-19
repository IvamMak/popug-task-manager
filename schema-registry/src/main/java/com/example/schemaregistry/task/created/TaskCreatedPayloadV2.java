/**
 * Autogenerated by Avro
 *
 * DO NOT EDIT DIRECTLY
 */
package com.example.schemaregistry.task.created;

import org.apache.avro.generic.GenericArray;
import org.apache.avro.specific.SpecificData;
import org.apache.avro.util.Utf8;
import org.apache.avro.message.BinaryMessageEncoder;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.SchemaStore;

@org.apache.avro.specific.AvroGenerated
public class TaskCreatedPayloadV2 extends org.apache.avro.specific.SpecificRecordBase implements org.apache.avro.specific.SpecificRecord {
  private static final long serialVersionUID = -8394827684588739427L;
  public static final org.apache.avro.Schema SCHEMA$ = new org.apache.avro.Schema.Parser().parse("{\"type\":\"record\",\"name\":\"TaskCreatedPayloadV2\",\"namespace\":\"com.example.schemaregistry.task.created\",\"fields\":[{\"name\":\"publicId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"executorId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"creatorId\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"description\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}},{\"name\":\"jira_id\",\"type\":{\"type\":\"string\",\"avro.java.string\":\"String\"}}]}");
  public static org.apache.avro.Schema getClassSchema() { return SCHEMA$; }

  private static SpecificData MODEL$ = new SpecificData();

  private static final BinaryMessageEncoder<TaskCreatedPayloadV2> ENCODER =
      new BinaryMessageEncoder<TaskCreatedPayloadV2>(MODEL$, SCHEMA$);

  private static final BinaryMessageDecoder<TaskCreatedPayloadV2> DECODER =
      new BinaryMessageDecoder<TaskCreatedPayloadV2>(MODEL$, SCHEMA$);

  /**
   * Return the BinaryMessageEncoder instance used by this class.
   * @return the message encoder used by this class
   */
  public static BinaryMessageEncoder<TaskCreatedPayloadV2> getEncoder() {
    return ENCODER;
  }

  /**
   * Return the BinaryMessageDecoder instance used by this class.
   * @return the message decoder used by this class
   */
  public static BinaryMessageDecoder<TaskCreatedPayloadV2> getDecoder() {
    return DECODER;
  }

  /**
   * Create a new BinaryMessageDecoder instance for this class that uses the specified {@link SchemaStore}.
   * @param resolver a {@link SchemaStore} used to find schemas by fingerprint
   * @return a BinaryMessageDecoder instance for this class backed by the given SchemaStore
   */
  public static BinaryMessageDecoder<TaskCreatedPayloadV2> createDecoder(SchemaStore resolver) {
    return new BinaryMessageDecoder<TaskCreatedPayloadV2>(MODEL$, SCHEMA$, resolver);
  }

  /**
   * Serializes this TaskCreatedPayloadV2 to a ByteBuffer.
   * @return a buffer holding the serialized data for this instance
   * @throws java.io.IOException if this instance could not be serialized
   */
  public java.nio.ByteBuffer toByteBuffer() throws java.io.IOException {
    return ENCODER.encode(this);
  }

  /**
   * Deserializes a TaskCreatedPayloadV2 from a ByteBuffer.
   * @param b a byte buffer holding serialized data for an instance of this class
   * @return a TaskCreatedPayloadV2 instance decoded from the given buffer
   * @throws java.io.IOException if the given bytes could not be deserialized into an instance of this class
   */
  public static TaskCreatedPayloadV2 fromByteBuffer(
      java.nio.ByteBuffer b) throws java.io.IOException {
    return DECODER.decode(b);
  }

  @Deprecated public java.lang.String publicId;
  @Deprecated public java.lang.String executorId;
  @Deprecated public java.lang.String creatorId;
  @Deprecated public java.lang.String description;
  @Deprecated public java.lang.String jira_id;

  /**
   * Default constructor.  Note that this does not initialize fields
   * to their default values from the schema.  If that is desired then
   * one should use <code>newBuilder()</code>.
   */
  public TaskCreatedPayloadV2() {}

  /**
   * All-args constructor.
   * @param publicId The new value for publicId
   * @param executorId The new value for executorId
   * @param creatorId The new value for creatorId
   * @param description The new value for description
   * @param jira_id The new value for jira_id
   */
  public TaskCreatedPayloadV2(java.lang.String publicId, java.lang.String executorId, java.lang.String creatorId, java.lang.String description, java.lang.String jira_id) {
    this.publicId = publicId;
    this.executorId = executorId;
    this.creatorId = creatorId;
    this.description = description;
    this.jira_id = jira_id;
  }

  public org.apache.avro.specific.SpecificData getSpecificData() { return MODEL$; }
  public org.apache.avro.Schema getSchema() { return SCHEMA$; }
  // Used by DatumWriter.  Applications should not call.
  public java.lang.Object get(int field$) {
    switch (field$) {
    case 0: return publicId;
    case 1: return executorId;
    case 2: return creatorId;
    case 3: return description;
    case 4: return jira_id;
    default: throw new IndexOutOfBoundsException("Invalid index: " + field$);
    }
  }

  // Used by DatumReader.  Applications should not call.
  @SuppressWarnings(value="unchecked")
  public void put(int field$, java.lang.Object value$) {
    switch (field$) {
    case 0: publicId = value$ != null ? value$.toString() : null; break;
    case 1: executorId = value$ != null ? value$.toString() : null; break;
    case 2: creatorId = value$ != null ? value$.toString() : null; break;
    case 3: description = value$ != null ? value$.toString() : null; break;
    case 4: jira_id = value$ != null ? value$.toString() : null; break;
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
   * Gets the value of the 'creatorId' field.
   * @return The value of the 'creatorId' field.
   */
  public java.lang.String getCreatorId() {
    return creatorId;
  }


  /**
   * Sets the value of the 'creatorId' field.
   * @param value the value to set.
   */
  public void setCreatorId(java.lang.String value) {
    this.creatorId = value;
  }

  /**
   * Gets the value of the 'description' field.
   * @return The value of the 'description' field.
   */
  public java.lang.String getDescription() {
    return description;
  }


  /**
   * Sets the value of the 'description' field.
   * @param value the value to set.
   */
  public void setDescription(java.lang.String value) {
    this.description = value;
  }

  /**
   * Gets the value of the 'jira_id' field.
   * @return The value of the 'jira_id' field.
   */
  public java.lang.String getJiraId() {
    return jira_id;
  }


  /**
   * Sets the value of the 'jira_id' field.
   * @param value the value to set.
   */
  public void setJiraId(java.lang.String value) {
    this.jira_id = value;
  }

  /**
   * Creates a new TaskCreatedPayloadV2 RecordBuilder.
   * @return A new TaskCreatedPayloadV2 RecordBuilder
   */
  public static com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder newBuilder() {
    return new com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder();
  }

  /**
   * Creates a new TaskCreatedPayloadV2 RecordBuilder by copying an existing Builder.
   * @param other The existing builder to copy.
   * @return A new TaskCreatedPayloadV2 RecordBuilder
   */
  public static com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder newBuilder(com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder other) {
    if (other == null) {
      return new com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder();
    } else {
      return new com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder(other);
    }
  }

  /**
   * Creates a new TaskCreatedPayloadV2 RecordBuilder by copying an existing TaskCreatedPayloadV2 instance.
   * @param other The existing instance to copy.
   * @return A new TaskCreatedPayloadV2 RecordBuilder
   */
  public static com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder newBuilder(com.example.schemaregistry.task.created.TaskCreatedPayloadV2 other) {
    if (other == null) {
      return new com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder();
    } else {
      return new com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder(other);
    }
  }

  /**
   * RecordBuilder for TaskCreatedPayloadV2 instances.
   */
  @org.apache.avro.specific.AvroGenerated
  public static class Builder extends org.apache.avro.specific.SpecificRecordBuilderBase<TaskCreatedPayloadV2>
    implements org.apache.avro.data.RecordBuilder<TaskCreatedPayloadV2> {

    private java.lang.String publicId;
    private java.lang.String executorId;
    private java.lang.String creatorId;
    private java.lang.String description;
    private java.lang.String jira_id;

    /** Creates a new Builder */
    private Builder() {
      super(SCHEMA$);
    }

    /**
     * Creates a Builder by copying an existing Builder.
     * @param other The existing Builder to copy.
     */
    private Builder(com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder other) {
      super(other);
      if (isValidValue(fields()[0], other.publicId)) {
        this.publicId = data().deepCopy(fields()[0].schema(), other.publicId);
        fieldSetFlags()[0] = other.fieldSetFlags()[0];
      }
      if (isValidValue(fields()[1], other.executorId)) {
        this.executorId = data().deepCopy(fields()[1].schema(), other.executorId);
        fieldSetFlags()[1] = other.fieldSetFlags()[1];
      }
      if (isValidValue(fields()[2], other.creatorId)) {
        this.creatorId = data().deepCopy(fields()[2].schema(), other.creatorId);
        fieldSetFlags()[2] = other.fieldSetFlags()[2];
      }
      if (isValidValue(fields()[3], other.description)) {
        this.description = data().deepCopy(fields()[3].schema(), other.description);
        fieldSetFlags()[3] = other.fieldSetFlags()[3];
      }
      if (isValidValue(fields()[4], other.jira_id)) {
        this.jira_id = data().deepCopy(fields()[4].schema(), other.jira_id);
        fieldSetFlags()[4] = other.fieldSetFlags()[4];
      }
    }

    /**
     * Creates a Builder by copying an existing TaskCreatedPayloadV2 instance
     * @param other The existing instance to copy.
     */
    private Builder(com.example.schemaregistry.task.created.TaskCreatedPayloadV2 other) {
      super(SCHEMA$);
      if (isValidValue(fields()[0], other.publicId)) {
        this.publicId = data().deepCopy(fields()[0].schema(), other.publicId);
        fieldSetFlags()[0] = true;
      }
      if (isValidValue(fields()[1], other.executorId)) {
        this.executorId = data().deepCopy(fields()[1].schema(), other.executorId);
        fieldSetFlags()[1] = true;
      }
      if (isValidValue(fields()[2], other.creatorId)) {
        this.creatorId = data().deepCopy(fields()[2].schema(), other.creatorId);
        fieldSetFlags()[2] = true;
      }
      if (isValidValue(fields()[3], other.description)) {
        this.description = data().deepCopy(fields()[3].schema(), other.description);
        fieldSetFlags()[3] = true;
      }
      if (isValidValue(fields()[4], other.jira_id)) {
        this.jira_id = data().deepCopy(fields()[4].schema(), other.jira_id);
        fieldSetFlags()[4] = true;
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
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder setPublicId(java.lang.String value) {
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
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder clearPublicId() {
      publicId = null;
      fieldSetFlags()[0] = false;
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
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder setExecutorId(java.lang.String value) {
      validate(fields()[1], value);
      this.executorId = value;
      fieldSetFlags()[1] = true;
      return this;
    }

    /**
      * Checks whether the 'executorId' field has been set.
      * @return True if the 'executorId' field has been set, false otherwise.
      */
    public boolean hasExecutorId() {
      return fieldSetFlags()[1];
    }


    /**
      * Clears the value of the 'executorId' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder clearExecutorId() {
      executorId = null;
      fieldSetFlags()[1] = false;
      return this;
    }

    /**
      * Gets the value of the 'creatorId' field.
      * @return The value.
      */
    public java.lang.String getCreatorId() {
      return creatorId;
    }


    /**
      * Sets the value of the 'creatorId' field.
      * @param value The value of 'creatorId'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder setCreatorId(java.lang.String value) {
      validate(fields()[2], value);
      this.creatorId = value;
      fieldSetFlags()[2] = true;
      return this;
    }

    /**
      * Checks whether the 'creatorId' field has been set.
      * @return True if the 'creatorId' field has been set, false otherwise.
      */
    public boolean hasCreatorId() {
      return fieldSetFlags()[2];
    }


    /**
      * Clears the value of the 'creatorId' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder clearCreatorId() {
      creatorId = null;
      fieldSetFlags()[2] = false;
      return this;
    }

    /**
      * Gets the value of the 'description' field.
      * @return The value.
      */
    public java.lang.String getDescription() {
      return description;
    }


    /**
      * Sets the value of the 'description' field.
      * @param value The value of 'description'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder setDescription(java.lang.String value) {
      validate(fields()[3], value);
      this.description = value;
      fieldSetFlags()[3] = true;
      return this;
    }

    /**
      * Checks whether the 'description' field has been set.
      * @return True if the 'description' field has been set, false otherwise.
      */
    public boolean hasDescription() {
      return fieldSetFlags()[3];
    }


    /**
      * Clears the value of the 'description' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder clearDescription() {
      description = null;
      fieldSetFlags()[3] = false;
      return this;
    }

    /**
      * Gets the value of the 'jira_id' field.
      * @return The value.
      */
    public java.lang.String getJiraId() {
      return jira_id;
    }


    /**
      * Sets the value of the 'jira_id' field.
      * @param value The value of 'jira_id'.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder setJiraId(java.lang.String value) {
      validate(fields()[4], value);
      this.jira_id = value;
      fieldSetFlags()[4] = true;
      return this;
    }

    /**
      * Checks whether the 'jira_id' field has been set.
      * @return True if the 'jira_id' field has been set, false otherwise.
      */
    public boolean hasJiraId() {
      return fieldSetFlags()[4];
    }


    /**
      * Clears the value of the 'jira_id' field.
      * @return This builder.
      */
    public com.example.schemaregistry.task.created.TaskCreatedPayloadV2.Builder clearJiraId() {
      jira_id = null;
      fieldSetFlags()[4] = false;
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TaskCreatedPayloadV2 build() {
      try {
        TaskCreatedPayloadV2 record = new TaskCreatedPayloadV2();
        record.publicId = fieldSetFlags()[0] ? this.publicId : (java.lang.String) defaultValue(fields()[0]);
        record.executorId = fieldSetFlags()[1] ? this.executorId : (java.lang.String) defaultValue(fields()[1]);
        record.creatorId = fieldSetFlags()[2] ? this.creatorId : (java.lang.String) defaultValue(fields()[2]);
        record.description = fieldSetFlags()[3] ? this.description : (java.lang.String) defaultValue(fields()[3]);
        record.jira_id = fieldSetFlags()[4] ? this.jira_id : (java.lang.String) defaultValue(fields()[4]);
        return record;
      } catch (org.apache.avro.AvroMissingFieldException e) {
        throw e;
      } catch (java.lang.Exception e) {
        throw new org.apache.avro.AvroRuntimeException(e);
      }
    }
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumWriter<TaskCreatedPayloadV2>
    WRITER$ = (org.apache.avro.io.DatumWriter<TaskCreatedPayloadV2>)MODEL$.createDatumWriter(SCHEMA$);

  @Override public void writeExternal(java.io.ObjectOutput out)
    throws java.io.IOException {
    WRITER$.write(this, SpecificData.getEncoder(out));
  }

  @SuppressWarnings("unchecked")
  private static final org.apache.avro.io.DatumReader<TaskCreatedPayloadV2>
    READER$ = (org.apache.avro.io.DatumReader<TaskCreatedPayloadV2>)MODEL$.createDatumReader(SCHEMA$);

  @Override public void readExternal(java.io.ObjectInput in)
    throws java.io.IOException {
    READER$.read(this, SpecificData.getDecoder(in));
  }

  @Override protected boolean hasCustomCoders() { return true; }

  @Override public void customEncode(org.apache.avro.io.Encoder out)
    throws java.io.IOException
  {
    out.writeString(this.publicId);

    out.writeString(this.executorId);

    out.writeString(this.creatorId);

    out.writeString(this.description);

    out.writeString(this.jira_id);

  }

  @Override public void customDecode(org.apache.avro.io.ResolvingDecoder in)
    throws java.io.IOException
  {
    org.apache.avro.Schema.Field[] fieldOrder = in.readFieldOrderIfDiff();
    if (fieldOrder == null) {
      this.publicId = in.readString();

      this.executorId = in.readString();

      this.creatorId = in.readString();

      this.description = in.readString();

      this.jira_id = in.readString();

    } else {
      for (int i = 0; i < 5; i++) {
        switch (fieldOrder[i].pos()) {
        case 0:
          this.publicId = in.readString();
          break;

        case 1:
          this.executorId = in.readString();
          break;

        case 2:
          this.creatorId = in.readString();
          break;

        case 3:
          this.description = in.readString();
          break;

        case 4:
          this.jira_id = in.readString();
          break;

        default:
          throw new java.io.IOException("Corrupt ResolvingDecoder.");
        }
      }
    }
  }
}










