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
public class CreateUsenetDownloadRequest {

  /**
   * An NZB File. Optional.
   */
  private byte[] file;

  /**
   * An accessible link to an NZB file. Cannot be a redirection. Optional.
   */
  private String link;
}
