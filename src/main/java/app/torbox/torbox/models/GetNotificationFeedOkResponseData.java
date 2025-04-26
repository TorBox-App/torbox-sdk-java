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
public class GetNotificationFeedOkResponseData {

  @JsonProperty("auth_id")
  private String authId;

  @JsonProperty("created_at")
  private String createdAt;

  private Double id;

  private String message;

  private String title;
}
