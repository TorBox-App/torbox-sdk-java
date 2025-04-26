package app.torbox.torbox.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
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
public class GetTorrentListOkResponse {

  private List<GetTorrentListOkResponseData> data;

  private String detail;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private Object error;

  private Boolean success;
}
