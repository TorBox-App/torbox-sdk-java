package app.torbox.torbox.services;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.HttpMethod;
import app.torbox.torbox.http.ModelConverter;
import app.torbox.torbox.http.util.RequestBuilder;
import app.torbox.torbox.models.GetNotificationFeedOkResponse;
import app.torbox.torbox.models.GetRssNotificationFeedParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * NotificationsService Service
 */
public class NotificationsService extends BaseService {

  public NotificationsService(@NonNull OkHttpClient httpClient, TorboxApiConfig config) {
    super(httpClient, config);
  }

  /**
   * Get RSS Notification Feed
   *
   * @param apiVersion String
   * @param requestParameters {@link GetRssNotificationFeedParameters} Request Parameters Object
   * @return response of {@code Object}
   */
  public Object getRssNotificationFeed(
    @NonNull String apiVersion,
    @NonNull GetRssNotificationFeedParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetRssNotificationFeedRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<Object>() {});
  }

  /**
   * Get RSS Notification Feed
   *
   * @param apiVersion String
   * @param requestParameters {@link GetRssNotificationFeedParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getRssNotificationFeedAsync(
    @NonNull String apiVersion,
    @NonNull GetRssNotificationFeedParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetRssNotificationFeedRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<Object>() {}));
  }

  private Request buildGetRssNotificationFeedRequest(
    @NonNull String apiVersion,
    @NonNull GetRssNotificationFeedParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/notifications/rss"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("token", requestParameters.getToken())
      .build();
  }

  /**
   * Get Notification Feed
   *
   * @param apiVersion String
   * @return response of {@code GetNotificationFeedOkResponse}
   */
  public GetNotificationFeedOkResponse getNotificationFeed(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetNotificationFeedRequest(apiVersion);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetNotificationFeedOkResponse>() {});
  }

  /**
   * Get Notification Feed
   *
   * @param apiVersion String
   * @return response of {@code CompletableFuture<GetNotificationFeedOkResponse>}
   */
  public CompletableFuture<GetNotificationFeedOkResponse> getNotificationFeedAsync(@NonNull String apiVersion)
    throws ApiException {
    Request request = this.buildGetNotificationFeedRequest(apiVersion);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetNotificationFeedOkResponse>() {})
    );
  }

  private Request buildGetNotificationFeedRequest(@NonNull String apiVersion) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/notifications/mynotifications"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .build();
  }

  /**
   * Clear All Notifications
   *
   * @param apiVersion String
   * @return response of {@code void}
   */
  public void clearAllNotifications(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildClearAllNotificationsRequest(apiVersion);
    this.execute(request);
  }

  /**
   * Clear All Notifications
   *
   * @param apiVersion String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> clearAllNotificationsAsync(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildClearAllNotificationsRequest(apiVersion);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildClearAllNotificationsRequest(@NonNull String apiVersion) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/notifications/clear"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .build();
  }

  /**
   * Clear Single Notification
   *
   * @param apiVersion String
   * @param notificationId String
   * @return response of {@code void}
   */
  public void clearSingleNotification(@NonNull String apiVersion, @NonNull String notificationId) throws ApiException {
    Request request = this.buildClearSingleNotificationRequest(apiVersion, notificationId);
    this.execute(request);
  }

  /**
   * Clear Single Notification
   *
   * @param apiVersion String
   * @param notificationId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> clearSingleNotificationAsync(
    @NonNull String apiVersion,
    @NonNull String notificationId
  ) throws ApiException {
    Request request = this.buildClearSingleNotificationRequest(apiVersion, notificationId);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildClearSingleNotificationRequest(@NonNull String apiVersion, @NonNull String notificationId) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/notifications/clear/{notification_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setPathParameter("notification_id", notificationId)
      .build();
  }

  /**
   * Send Test Notification
   *
   * @param apiVersion String
   * @return response of {@code void}
   */
  public void sendTestNotification(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildSendTestNotificationRequest(apiVersion);
    this.execute(request);
  }

  /**
   * Send Test Notification
   *
   * @param apiVersion String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> sendTestNotificationAsync(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildSendTestNotificationRequest(apiVersion);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildSendTestNotificationRequest(@NonNull String apiVersion) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/notifications/test"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .build();
  }
}
