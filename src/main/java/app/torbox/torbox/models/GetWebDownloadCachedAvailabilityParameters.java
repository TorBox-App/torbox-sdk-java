package app.torbox.torbox.models;

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
public class GetWebDownloadCachedAvailabilityParameters {

  /**
   * The list of web hashes you want to check. Comma seperated. To find the hash, md5 the link.
   *
   */
  private String hash;

  /**
   * Format you want the data in. Acceptable is either "object" or "list". List is the most performant option as it doesn't require modification of the list.
   */
  private String format;
}
