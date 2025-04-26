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
public class GetSpeedtestFilesParameters {

  /**
   * Determines the size of the file used for the speedtest. May be "long" or "short". Optional.
   */
  @JsonProperty("test_length")
  private String testLength;

  /**
   * Determines what cdns are returned. May be any region that TorBox is located in. To get this value, send a request without this value to determine all of the available regions that are available.
   */
  private String region;
}
