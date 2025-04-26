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
public class GetUserDataOkResponseData {

  @JsonProperty("auth_id")
  private String authId;

  @JsonProperty("base_email")
  private String baseEmail;

  @JsonProperty("cooldown_until")
  private String cooldownUntil;

  @JsonProperty("created_at")
  private String createdAt;

  private String customer;

  private String email;

  private Double id;

  @JsonProperty("is_subscribed")
  private Boolean isSubscribed;

  private Double plan;

  @JsonProperty("premium_expires_at")
  private String premiumExpiresAt;

  private Double server;

  private Settings settings;

  @JsonProperty("total_downloaded")
  private Double totalDownloaded;

  @JsonProperty("updated_at")
  private String updatedAt;

  @JsonProperty("user_referral")
  private String userReferral;
}
