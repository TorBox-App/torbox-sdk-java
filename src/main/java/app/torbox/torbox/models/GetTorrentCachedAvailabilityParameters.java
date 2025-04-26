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
public class GetTorrentCachedAvailabilityParameters {

  /**
   * The list of torrent hashes you want to check. Comma seperated.
   */
  private String hash;

  /**
   * Format you want the data in. Acceptable is either "object" or "list". List is the most performant option as it doesn't require modification of the list.
   */
  private String format;

  /**
   * Allows you to list the files found inside the cached data.
   */
  @JsonProperty("list_files")
  private String listFiles;
}
