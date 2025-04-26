package app.torbox.torbox.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class ExportTorrentDataOkResponse {

  private String data;

  private String detail;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Object error;

  private Boolean success;
}
