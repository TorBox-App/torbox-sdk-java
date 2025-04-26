package app.torbox.torbox.models;

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
public class GetTorrentInfo1OkResponseData {

  private List<DataFiles3> files;

  private String hash;

  private String name;

  private Double peers;

  private Double seeds;

  private Double size;

  private List<Object> trackers;
}
