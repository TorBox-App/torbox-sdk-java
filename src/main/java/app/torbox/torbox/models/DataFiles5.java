package app.torbox.torbox.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.With;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@With
@ToString
@EqualsAndHashCode
@Jacksonized
public class DataFiles5 {

  private Double id;

  private String md5;

  private String mimetype;

  private String name;

  @JsonProperty("s3_path")
  private String s3Path;

  @JsonProperty("short_name")
  private String shortName;

  private Double size;
}
