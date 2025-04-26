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
public class GetRssFeedItemsParameters {

  /**
   * The RSS Feed ID of the RSS Feed you want to retrieve the scraped items of.
   */
  @JsonProperty("rss_feed_id")
  private String rssFeedId;
}
