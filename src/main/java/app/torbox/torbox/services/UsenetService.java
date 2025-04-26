package app.torbox.torbox.services;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.HttpMethod;
import app.torbox.torbox.http.ModelConverter;
import app.torbox.torbox.http.util.RequestBuilder;
import app.torbox.torbox.models.CreateUsenetDownloadOkResponse;
import app.torbox.torbox.models.CreateUsenetDownloadRequest;
import app.torbox.torbox.models.GetUsenetCachedAvailabilityParameters;
import app.torbox.torbox.models.GetUsenetListOkResponse;
import app.torbox.torbox.models.GetUsenetListParameters;
import app.torbox.torbox.models.RequestDownloadLink1Parameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * UsenetService Service
 */
public class UsenetService extends BaseService {

  public UsenetService(@NonNull OkHttpClient httpClient, TorboxApiConfig config) {
    super(httpClient, config);
  }

  /**
   * Create Usenet Download
   *
   * @param apiVersion String
   * @param createUsenetDownloadRequest {@link CreateUsenetDownloadRequest} Request Body
   * @return response of {@code CreateUsenetDownloadOkResponse}
   */
  public CreateUsenetDownloadOkResponse createUsenetDownload(
    @NonNull String apiVersion,
    @NonNull CreateUsenetDownloadRequest createUsenetDownloadRequest
  ) throws ApiException {
    Request request = this.buildCreateUsenetDownloadRequest(apiVersion, createUsenetDownloadRequest);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<CreateUsenetDownloadOkResponse>() {});
  }

  /**
   * Create Usenet Download
   *
   * @param apiVersion String
   * @param createUsenetDownloadRequest {@link CreateUsenetDownloadRequest} Request Body
   * @return response of {@code CompletableFuture<CreateUsenetDownloadOkResponse>}
   */
  public CompletableFuture<CreateUsenetDownloadOkResponse> createUsenetDownloadAsync(
    @NonNull String apiVersion,
    @NonNull CreateUsenetDownloadRequest createUsenetDownloadRequest
  ) throws ApiException {
    Request request = this.buildCreateUsenetDownloadRequest(apiVersion, createUsenetDownloadRequest);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<CreateUsenetDownloadOkResponse>() {})
    );
  }

  private Request buildCreateUsenetDownloadRequest(
    @NonNull String apiVersion,
    @NonNull CreateUsenetDownloadRequest createUsenetDownloadRequest
  ) {
    MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder()
      .setType(MultipartBody.FORM)
      .addFormDataPart("link", createUsenetDownloadRequest.getLink());
    if (createUsenetDownloadRequest.getFile() != null) {
      multipartBodyBuilder.addFormDataPart(
        "file",
        String.format("file_%s", UUID.randomUUID()),
        RequestBody.create(
          createUsenetDownloadRequest.getFile().toString(),
          MediaType.parse("application/octet-stream")
        )
      );
    }
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/usenet/createusenetdownload"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setBody(multipartBodyBuilder.build())
      .build();
  }

  /**
   * Control Usenet Download
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void controlUsenetDownload(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildControlUsenetDownloadRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Control Usenet Download
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> controlUsenetDownloadAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildControlUsenetDownloadRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildControlUsenetDownloadRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/usenet/controlusenetdownload"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Request Download Link
   *
   * @param apiVersion String
   * @param requestParameters {@link RequestDownloadLink1Parameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void requestDownloadLink1(
    @NonNull String apiVersion,
    @NonNull RequestDownloadLink1Parameters requestParameters
  ) throws ApiException {
    Request request = this.buildRequestDownloadLink1Request(apiVersion, requestParameters);
    this.execute(request);
  }

  /**
   * Request Download Link
   *
   * @param apiVersion String
   * @param requestParameters {@link RequestDownloadLink1Parameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> requestDownloadLink1Async(
    @NonNull String apiVersion,
    @NonNull RequestDownloadLink1Parameters requestParameters
  ) throws ApiException {
    Request request = this.buildRequestDownloadLink1Request(apiVersion, requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildRequestDownloadLink1Request(
    @NonNull String apiVersion,
    @NonNull RequestDownloadLink1Parameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/usenet/requestdl"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("token", requestParameters.getToken())
      .setOptionalQueryParameter("usenet_id", requestParameters.getUsenetId())
      .setOptionalQueryParameter("file_id", requestParameters.getFileId())
      .setOptionalQueryParameter("zip_link", requestParameters.getZipLink())
      .setOptionalQueryParameter("user_ip", requestParameters.getUserIp())
      .setOptionalQueryParameter("redirect", requestParameters.getRedirect())
      .build();
  }

  /**
   * Get Usenet List
   *
   * @param apiVersion String
   * @param requestParameters {@link GetUsenetListParameters} Request Parameters Object
   * @return response of {@code GetUsenetListOkResponse}
   */
  public GetUsenetListOkResponse getUsenetList(
    @NonNull String apiVersion,
    @NonNull GetUsenetListParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetUsenetListRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetUsenetListOkResponse>() {});
  }

  /**
   * Get Usenet List
   *
   * @param apiVersion String
   * @param requestParameters {@link GetUsenetListParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<GetUsenetListOkResponse>}
   */
  public CompletableFuture<GetUsenetListOkResponse> getUsenetListAsync(
    @NonNull String apiVersion,
    @NonNull GetUsenetListParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetUsenetListRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetUsenetListOkResponse>() {})
    );
  }

  private Request buildGetUsenetListRequest(
    @NonNull String apiVersion,
    @NonNull GetUsenetListParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/usenet/mylist"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("bypass_cache", requestParameters.getBypassCache())
      .setOptionalQueryParameter("id", requestParameters.getId())
      .setOptionalQueryParameter("offset", requestParameters.getOffset())
      .setOptionalQueryParameter("limit", requestParameters.getLimit())
      .build();
  }

  /**
   * Get Usenet Cached Availability
   *
   * @param apiVersion String
   * @param requestParameters {@link GetUsenetCachedAvailabilityParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void getUsenetCachedAvailability(
    @NonNull String apiVersion,
    @NonNull GetUsenetCachedAvailabilityParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetUsenetCachedAvailabilityRequest(apiVersion, requestParameters);
    this.execute(request);
  }

  /**
   * Get Usenet Cached Availability
   *
   * @param apiVersion String
   * @param requestParameters {@link GetUsenetCachedAvailabilityParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> getUsenetCachedAvailabilityAsync(
    @NonNull String apiVersion,
    @NonNull GetUsenetCachedAvailabilityParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetUsenetCachedAvailabilityRequest(apiVersion, requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildGetUsenetCachedAvailabilityRequest(
    @NonNull String apiVersion,
    @NonNull GetUsenetCachedAvailabilityParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/usenet/checkcached"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("hash", requestParameters.getHash())
      .setOptionalQueryParameter("format", requestParameters.getFormat())
      .build();
  }
}
