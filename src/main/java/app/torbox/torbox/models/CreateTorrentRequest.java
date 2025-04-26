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
public class CreateTorrentRequest {

  /**
   * Tells TorBox if you want to allow this torrent to be zipped or not. TorBox only zips if the torrent is 100 files or larger.
   */
  @JsonProperty("allow_zip")
  private String allowZip;

  /**
   * Tells TorBox you want this torrent instantly queued. This is bypassed if user is on free plan, and will process the request as normal in this case. Optional.
   */
  @JsonProperty("as_queued")
  private String asQueued;

  /**
   * The torrent's torrent file. Optional.
   */
  private byte[] file;

  /**
   * The torrent's magnet link. Optional.
   */
  private String magnet;

  /**
   * The name you want the torrent to be. Optional.
   */
  private String name;

  /**
   * Tells TorBox your preference for seeding this torrent. 1 is auto. 2 is seed. 3 is don't seed. Optional. Default is 1, or whatever the user has in their settings. Overwrites option in settings.
   */
  private String seed;
}
