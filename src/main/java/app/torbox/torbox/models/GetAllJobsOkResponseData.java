package app.torbox.torbox.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class GetAllJobsOkResponseData {

  @JsonProperty("auth_id")
  private String authId;

  @JsonProperty("created_at")
  private String createdAt;

  private String detail;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  @JsonProperty("download_url")
  private String downloadUrl;

  @JsonProperty("file_id")
  private Double fileId;

  private String hash;

  private Double id;

  private String integration;

  private Double progress;

  private String status;

  private String type;

  @JsonProperty("updated_at")
  private String updatedAt;

  private Boolean zip;
}
