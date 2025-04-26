package app.torbox.torbox.models;

import com.fasterxml.jackson.annotation.JsonProperty;
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
public class GetTorrentListOkResponseData {

  private Boolean active;

  @JsonProperty("auth_id")
  private String authId;

  private Double availability;

  @JsonProperty("created_at")
  private String createdAt;

  @JsonProperty("download_finished")
  private Boolean downloadFinished;

  @JsonProperty("download_present")
  private Boolean downloadPresent;

  @JsonProperty("download_speed")
  private Double downloadSpeed;

  @JsonProperty("download_state")
  private String downloadState;

  private Double eta;

  @JsonProperty("expires_at")
  private String expiresAt;

  private List<DataFiles1> files;

  private String hash;

  private Double id;

  @JsonProperty("inactive_check")
  private Double inactiveCheck;

  private String magnet;

  private String name;

  private Double peers;

  private Double progress;

  private Double ratio;

  private Double seeds;

  private Double server;

  private Double size;

  @JsonProperty("torrent_file")
  private Boolean torrentFile;

  @JsonProperty("updated_at")
  private String updatedAt;

  @JsonProperty("upload_speed")
  private Double uploadSpeed;
}
