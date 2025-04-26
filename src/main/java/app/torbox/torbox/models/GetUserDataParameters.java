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
public class GetUserDataParameters {

  /**
   * Allows you to retrieve user settings.
   */
  private String settings;
}
