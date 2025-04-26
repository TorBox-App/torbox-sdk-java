package app.torbox.torbox.services;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.HttpMethod;
import app.torbox.torbox.http.ModelConverter;
import app.torbox.torbox.http.util.RequestBuilder;
import app.torbox.torbox.models.GetAllJobsByHashOkResponse;
import app.torbox.torbox.models.GetAllJobsOkResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * IntegrationsService Service
 */
public class IntegrationsService extends BaseService {

  public IntegrationsService(@NonNull OkHttpClient httpClient, TorboxApiConfig config) {
    super(httpClient, config);
  }

  /**
   * Authenticate OAuth
   *
   * @param apiVersion String
   * @param provider String
   * @return response of {@code void}
   */
  public void authenticateOauth(@NonNull String apiVersion, @NonNull String provider) throws ApiException {
    Request request = this.buildAuthenticateOauthRequest(apiVersion, provider);
    this.execute(request);
  }

  /**
   * Authenticate OAuth
   *
   * @param apiVersion String
   * @param provider String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> authenticateOauthAsync(@NonNull String apiVersion, @NonNull String provider)
    throws ApiException {
    Request request = this.buildAuthenticateOauthRequest(apiVersion, provider);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildAuthenticateOauthRequest(@NonNull String apiVersion, @NonNull String provider) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/oauth/{provider}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setPathParameter("provider", provider)
      .build();
  }

  /**
   * Queue Google Drive
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void queueGoogleDrive(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildQueueGoogleDriveRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Queue Google Drive
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> queueGoogleDriveAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildQueueGoogleDriveRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildQueueGoogleDriveRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/googledrive"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Queue Pixeldrain
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void queuePixeldrain(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildQueuePixeldrainRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Queue Pixeldrain
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> queuePixeldrainAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildQueuePixeldrainRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildQueuePixeldrainRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/pixeldrain"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Queue OneDrive
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void queueOnedrive(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildQueueOnedriveRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Queue OneDrive
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> queueOnedriveAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildQueueOnedriveRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildQueueOnedriveRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/onedrive"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Queue GoFile
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void queueGofile(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildQueueGofileRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Queue GoFile
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> queueGofileAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildQueueGofileRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildQueueGofileRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/gofile"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Queue 1Fichier
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void queue1fichier(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildQueue1fichierRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Queue 1Fichier
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> queue1fichierAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildQueue1fichierRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildQueue1fichierRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/1fichier"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Get All Jobs
   *
   * @param apiVersion String
   * @return response of {@code GetAllJobsOkResponse}
   */
  public GetAllJobsOkResponse getAllJobs(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetAllJobsRequest(apiVersion);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetAllJobsOkResponse>() {});
  }

  /**
   * Get All Jobs
   *
   * @param apiVersion String
   * @return response of {@code CompletableFuture<GetAllJobsOkResponse>}
   */
  public CompletableFuture<GetAllJobsOkResponse> getAllJobsAsync(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetAllJobsRequest(apiVersion);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetAllJobsOkResponse>() {})
    );
  }

  private Request buildGetAllJobsRequest(@NonNull String apiVersion) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/jobs"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .build();
  }

  /**
   * Get Specific Job
   *
   * @param apiVersion String
   * @param jobId String
   * @return response of {@code Object}
   */
  public Object getSpecificJob(@NonNull String apiVersion, @NonNull String jobId) throws ApiException {
    Request request = this.buildGetSpecificJobRequest(apiVersion, jobId);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<Object>() {});
  }

  /**
   * Get Specific Job
   *
   * @param apiVersion String
   * @param jobId String
   * @return response of {@code CompletableFuture<Object>}
   */
  public CompletableFuture<Object> getSpecificJobAsync(@NonNull String apiVersion, @NonNull String jobId)
    throws ApiException {
    Request request = this.buildGetSpecificJobRequest(apiVersion, jobId);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response -> ModelConverter.convert(response, new TypeReference<Object>() {}));
  }

  private Request buildGetSpecificJobRequest(@NonNull String apiVersion, @NonNull String jobId) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/job/{job_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setPathParameter("job_id", jobId)
      .build();
  }

  /**
   * Cancel Specific Job
   *
   * @param apiVersion String
   * @param jobId String
   * @return response of {@code void}
   */
  public void cancelSpecificJob(@NonNull String apiVersion, @NonNull String jobId) throws ApiException {
    Request request = this.buildCancelSpecificJobRequest(apiVersion, jobId);
    this.execute(request);
  }

  /**
   * Cancel Specific Job
   *
   * @param apiVersion String
   * @param jobId String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> cancelSpecificJobAsync(@NonNull String apiVersion, @NonNull String jobId)
    throws ApiException {
    Request request = this.buildCancelSpecificJobRequest(apiVersion, jobId);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildCancelSpecificJobRequest(@NonNull String apiVersion, @NonNull String jobId) {
    return new RequestBuilder(
      HttpMethod.DELETE,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/job/{job_id}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setPathParameter("job_id", jobId)
      .build();
  }

  /**
   * Get All Jobs By Hash
   *
   * @param apiVersion String
   * @param hash String
   * @return response of {@code GetAllJobsByHashOkResponse}
   */
  public GetAllJobsByHashOkResponse getAllJobsByHash(@NonNull String apiVersion, @NonNull String hash)
    throws ApiException {
    Request request = this.buildGetAllJobsByHashRequest(apiVersion, hash);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetAllJobsByHashOkResponse>() {});
  }

  /**
   * Get All Jobs By Hash
   *
   * @param apiVersion String
   * @param hash String
   * @return response of {@code CompletableFuture<GetAllJobsByHashOkResponse>}
   */
  public CompletableFuture<GetAllJobsByHashOkResponse> getAllJobsByHashAsync(
    @NonNull String apiVersion,
    @NonNull String hash
  ) throws ApiException {
    Request request = this.buildGetAllJobsByHashRequest(apiVersion, hash);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetAllJobsByHashOkResponse>() {})
    );
  }

  private Request buildGetAllJobsByHashRequest(@NonNull String apiVersion, @NonNull String hash) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/integration/jobs/{hash}"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setPathParameter("hash", hash)
      .build();
  }
}
