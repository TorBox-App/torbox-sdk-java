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
public class GetChangelogsJsonOkResponseData {

  @JsonProperty("created_at")
  private String createdAt;

  private String html;

  private String id;

  private String link;

  private String markdown;

  private String name;
}
