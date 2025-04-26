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
public class CreateUsenetDownloadOkResponseData {

  @JsonProperty("auth_id")
  private String authId;

  private String hash;

  @JsonProperty("usenetdownload_id")
  private String usenetdownloadId;
}
