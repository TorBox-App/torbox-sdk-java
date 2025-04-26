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
public class GetStatsOkResponseData {

  @JsonProperty("active_torrents")
  private Double activeTorrents;

  @JsonProperty("active_usenet_downloads")
  private Double activeUsenetDownloads;

  @JsonProperty("active_web_downloads")
  private Double activeWebDownloads;

  @JsonProperty("total_bytes_downloaded")
  private Double totalBytesDownloaded;

  @JsonProperty("total_bytes_uploaded")
  private Double totalBytesUploaded;

  @JsonProperty("total_downloads")
  private Double totalDownloads;

  @JsonProperty("total_servers")
  private Double totalServers;

  @JsonProperty("total_torrent_downloads")
  private Double totalTorrentDownloads;

  @JsonProperty("total_usenet_downloads")
  private Double totalUsenetDownloads;

  @JsonProperty("total_users")
  private Double totalUsers;

  @JsonProperty("total_web_downloads")
  private Double totalWebDownloads;
}
