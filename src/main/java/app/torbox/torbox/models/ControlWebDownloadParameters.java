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
public class ControlWebDownloadParameters {

  @JsonProperty("bypass_cache")
  private String bypassCache;

  /**
   * Determines the web download requested, will return an object rather than list. Optional.
   */
  private String id;

  private Object requestBody;
}
