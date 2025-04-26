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
public class CreateTorrentOkResponseData {

  @JsonProperty("active_limit")
  private Double activeLimit;

  @JsonProperty("auth_id")
  private String authId;

  @JsonProperty("current_active_downloads")
  private Double currentActiveDownloads;

  private String hash;

  @JsonProperty("queued_id")
  private Double queuedId;

  @JsonProperty("torrent_id")
  private Double torrentId;
}
