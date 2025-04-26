package app.torbox.torbox.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
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
public class GetTorrentCachedAvailabilityOkResponse {

  private Map<String, GetTorrentCachedAvailabilityOkResponseData> data;

  private String detail;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String error;

  private Boolean success;
}
