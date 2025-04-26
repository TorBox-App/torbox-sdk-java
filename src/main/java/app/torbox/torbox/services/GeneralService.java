package app.torbox.torbox.services;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.HttpMethod;
import app.torbox.torbox.http.ModelConverter;
import app.torbox.torbox.http.util.RequestBuilder;
import app.torbox.torbox.models.GetChangelogsJsonOkResponse;
import app.torbox.torbox.models.GetSpeedtestFilesParameters;
import app.torbox.torbox.models.GetStatsOkResponse;
import app.torbox.torbox.models.GetUpStatusOkResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * GeneralService Service
 */
public class GeneralService extends BaseService {

  public GeneralService(@NonNull OkHttpClient httpClient, TorboxApiConfig config) {
    super(httpClient, config);
  }

  /**
   * Get Up Status
   *
   * @return response of {@code GetUpStatusOkResponse}
   */
  public GetUpStatusOkResponse getUpStatus() throws ApiException {
    Request request = this.buildGetUpStatusRequest();
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetUpStatusOkResponse>() {});
  }

  /**
   * Get Up Status
   *
   * @return response of {@code CompletableFuture<GetUpStatusOkResponse>}
   */
  public CompletableFuture<GetUpStatusOkResponse> getUpStatusAsync() throws ApiException {
    Request request = this.buildGetUpStatusRequest();
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetUpStatusOkResponse>() {})
    );
  }

  private Request buildGetUpStatusRequest() {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      ""
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .build();
  }

  /**
   * Get Stats
   *
   * @param apiVersion String
   * @return response of {@code GetStatsOkResponse}
   */
  public GetStatsOkResponse getStats(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetStatsRequest(apiVersion);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetStatsOkResponse>() {});
  }

  /**
   * Get Stats
   *
   * @param apiVersion String
   * @return response of {@code CompletableFuture<GetStatsOkResponse>}
   */
  public CompletableFuture<GetStatsOkResponse> getStatsAsync(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetStatsRequest(apiVersion);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetStatsOkResponse>() {})
    );
  }

  private Request buildGetStatsRequest(@NonNull String apiVersion) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/stats"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .build();
  }

  /**
   * Get Changelogs RSS Feed
   *
   * @param apiVersion String
   * @return response of {@code Object}
   */
  public Object getChangelogsRssFeed(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetChangelogsRssFeedRequest(apiVersion);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<Object>() {});
  }

  /**
   * Get Changelogs RSS Feed
   *
   * @param apiVersion String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getChangelogsRssFeedAsync(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetChangelogsRssFeedRequest(apiVersion);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<Object>() {}));
  }

  private Request buildGetChangelogsRssFeedRequest(@NonNull String apiVersion) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/changelogs/rss"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .build();
  }

  /**
   * Get Changelogs JSON
   *
   * @param apiVersion String
   * @return response of {@code GetChangelogsJsonOkResponse}
   */
  public GetChangelogsJsonOkResponse getChangelogsJson(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetChangelogsJsonRequest(apiVersion);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetChangelogsJsonOkResponse>() {});
  }

  /**
   * Get Changelogs JSON
   *
   * @param apiVersion String
   * @return response of {@code CompletableFuture<GetChangelogsJsonOkResponse>}
   */
  public CompletableFuture<GetChangelogsJsonOkResponse> getChangelogsJsonAsync(@NonNull String apiVersion)
    throws ApiException {
    Request request = this.buildGetChangelogsJsonRequest(apiVersion);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetChangelogsJsonOkResponse>() {})
    );
  }

  private Request buildGetChangelogsJsonRequest(@NonNull String apiVersion) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/changelogs/json"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .build();
  }

  /**
   * Get Speedtest Files
   *
   * @param apiVersion String
   * @param requestParameters {@link GetSpeedtestFilesParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void getSpeedtestFiles(@NonNull String apiVersion, @NonNull GetSpeedtestFilesParameters requestParameters)
    throws ApiException {
    Request request = this.buildGetSpeedtestFilesRequest(apiVersion, requestParameters);
    this.execute(request);
  }

  /**
   * Get Speedtest Files
   *
   * @param apiVersion String
   * @param requestParameters {@link GetSpeedtestFilesParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> getSpeedtestFilesAsync(
    @NonNull String apiVersion,
    @NonNull GetSpeedtestFilesParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetSpeedtestFilesRequest(apiVersion, requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildGetSpeedtestFilesRequest(
    @NonNull String apiVersion,
    @NonNull GetSpeedtestFilesParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/speedtest"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("test_length", requestParameters.getTestLength())
      .setOptionalQueryParameter("region", requestParameters.getRegion())
      .build();
  }
}
