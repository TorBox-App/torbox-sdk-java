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
public class RequestDownloadLink2Parameters {

  /**
   * Your API Key
   */
  private String token;

  /**
   * The web download's ID that you want to download
   */
  @JsonProperty("web_id")
  private String webId;

  /**
   * The files's ID that you want to download
   */
  @JsonProperty("file_id")
  private String fileId;

  /**
   * If you want a zip link. Required if no file_id. Takes precedence over file_id if both are given.
   */
  @JsonProperty("zip_link")
  private String zipLink;

  /**
   * The user's IP to determine the closest CDN. Optional.
   */
  @JsonProperty("user_ip")
  private String userIp;

  /**
   * If you want to redirect the user to the CDN link. This is useful for creating permalinks so that you can just make this request URL the link.
   */
  private String redirect;
}
