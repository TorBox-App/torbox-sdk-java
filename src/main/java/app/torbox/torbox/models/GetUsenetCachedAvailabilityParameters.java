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
public class GetUsenetCachedAvailabilityParameters {

  /**
   * The list of usenet hashes you want to check. Comma seperated. To find the hash, md5 the link of the usenet link or file.
   */
  private String hash;

  /**
   * Format you want the data in. Acceptable is either "object" or "list". List is the most performant option as it doesn't require modification of the list.
   */
  private String format;
}
