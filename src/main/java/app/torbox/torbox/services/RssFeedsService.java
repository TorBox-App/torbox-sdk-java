package app.torbox.torbox.services;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.HttpMethod;
import app.torbox.torbox.http.util.RequestBuilder;
import app.torbox.torbox.models.GetRssFeedItemsParameters;
import app.torbox.torbox.models.GetUserRssFeedsParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * RssFeedsService Service
 */
public class RssFeedsService extends BaseService {

  public RssFeedsService(@NonNull OkHttpClient httpClient, TorboxApiConfig config) {
    super(httpClient, config);
  }

  /**
   * Add RSS Feed
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void addRssFeed(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildAddRssFeedRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Add RSS Feed
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> addRssFeedAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildAddRssFeedRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildAddRssFeedRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/rss/addrss"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Control RSS Feed
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void controlRssFeed(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildControlRssFeedRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Control RSS Feed
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> controlRssFeedAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildControlRssFeedRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildControlRssFeedRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/rss/controlrss"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Modify RSS Feed
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void modifyRssFeed(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildModifyRssFeedRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Modify RSS Feed
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> modifyRssFeedAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildModifyRssFeedRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildModifyRssFeedRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/rss/modifyrss"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Get User RSS Feeds
   *
   * @param apiVersion String
   * @param requestParameters {@link GetUserRssFeedsParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void getUserRssFeeds(@NonNull String apiVersion, @NonNull GetUserRssFeedsParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetUserRssFeedsRequest(apiVersion, requestParameters);
    this.execute(request);
  }

  /**
   * Get User RSS Feeds
   *
   * @param apiVersion String
   * @param requestParameters {@link GetUserRssFeedsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> getUserRssFeedsAsync(
    @NonNull String apiVersion,
    @NonNull GetUserRssFeedsParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetUserRssFeedsRequest(apiVersion, requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildGetUserRssFeedsRequest(
    @NonNull String apiVersion,
    @NonNull GetUserRssFeedsParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/rss/getfeeds"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("id", requestParameters.getId())
      .build();
  }

  /**
   * Get RSS Feed Items
   *
   * @param apiVersion String
   * @param requestParameters {@link GetRssFeedItemsParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void getRssFeedItems(@NonNull String apiVersion, @NonNull GetRssFeedItemsParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetRssFeedItemsRequest(apiVersion, requestParameters);
    this.execute(request);
  }

  /**
   * Get RSS Feed Items
   *
   * @param apiVersion String
   * @param requestParameters {@link GetRssFeedItemsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> getRssFeedItemsAsync(
    @NonNull String apiVersion,
    @NonNull GetRssFeedItemsParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetRssFeedItemsRequest(apiVersion, requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildGetRssFeedItemsRequest(
    @NonNull String apiVersion,
    @NonNull GetRssFeedItemsParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/rss/getfeeditems"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("rss_feed_id", requestParameters.getRssFeedId())
      .build();
  }
}
