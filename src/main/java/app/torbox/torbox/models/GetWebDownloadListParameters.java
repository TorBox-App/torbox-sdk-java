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
public class GetWebDownloadListParameters {

  /**
   * Allows you to bypass the cached data, and always get fresh information. Useful if constantly querying for fresh download stats. Otherwise, we request that you save our database a few calls.
   */
  @JsonProperty("bypass_cache")
  private String bypassCache;

  /**
   * Determines the torrent requested, will return an object rather than list. Optional.
   */
  private String id;

  /**
   * Determines the offset of items to get from the database. Default is 0. Optional.
   */
  private String offset;

  /**
   * Determines the number of items to recieve per request. Default is 1000. Optional.
   */
  private String limit;
}
