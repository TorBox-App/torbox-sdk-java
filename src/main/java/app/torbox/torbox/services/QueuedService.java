package app.torbox.torbox.services;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.HttpMethod;
import app.torbox.torbox.http.util.RequestBuilder;
import app.torbox.torbox.models.GetQueuedDownloadsParameters;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * QueuedService Service
 */
public class QueuedService extends BaseService {

  public QueuedService(@NonNull OkHttpClient httpClient, TorboxApiConfig config) {
    super(httpClient, config);
  }

  /**
   * Get Queued Downloads
   *
   * @param apiVersion String
   * @param requestParameters {@link GetQueuedDownloadsParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void getQueuedDownloads(@NonNull String apiVersion, @NonNull GetQueuedDownloadsParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetQueuedDownloadsRequest(apiVersion, requestParameters);
    this.execute(request);
  }

  /**
   * Get Queued Downloads
   *
   * @param apiVersion String
   * @param requestParameters {@link GetQueuedDownloadsParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> getQueuedDownloadsAsync(
    @NonNull String apiVersion,
    @NonNull GetQueuedDownloadsParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetQueuedDownloadsRequest(apiVersion, requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildGetQueuedDownloadsRequest(
    @NonNull String apiVersion,
    @NonNull GetQueuedDownloadsParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/queued/getqueued"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("bypass_cache", requestParameters.getBypassCache())
      .setOptionalQueryParameter("id", requestParameters.getId())
      .setOptionalQueryParameter("offset", requestParameters.getOffset())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .setOptionalQueryParameter("type", requestParameters.getType())
      .build();
  }

  /**
   * Control Queued Downloads
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void controlQueuedDownloads(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildControlQueuedDownloadsRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Control Queued Downloads
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> controlQueuedDownloadsAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildControlQueuedDownloadsRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildControlQueuedDownloadsRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/queued/controlqueued"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }
}
