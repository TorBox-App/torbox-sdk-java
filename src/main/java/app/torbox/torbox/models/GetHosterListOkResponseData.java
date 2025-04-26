package app.torbox.torbox.models;

import com.fasterxml.jackson.annotation.JsonInclude;
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
public class GetHosterListOkResponseData {

  @JsonProperty("daily_bandwidth_limit")
  private Double dailyBandwidthLimit;

  @JsonProperty("daily_bandwidth_used")
  private Double dailyBandwidthUsed;

  @JsonProperty("daily_link_limit")
  private Double dailyLinkLimit;

  @JsonProperty("daily_link_used")
  private Double dailyLinkUsed;

  private List<String> domains;

  private List<String> domais;

  private List<String> domaisn;

  private String icon;

  private Double limit;

  private String name;

  @JsonInclude(JsonInclude.Include.ALWAYS)
  private String note;

  private Boolean status;

  private String type;

  private String url;
}
