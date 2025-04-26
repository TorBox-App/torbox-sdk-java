package app.torbox.torbox.services;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.HttpMethod;
import app.torbox.torbox.http.ModelConverter;
import app.torbox.torbox.http.util.RequestBuilder;
import app.torbox.torbox.models.ControlWebDownloadParameters;
import app.torbox.torbox.models.CreateWebDownloadOkResponse;
import app.torbox.torbox.models.CreateWebDownloadRequest;
import app.torbox.torbox.models.GetHosterListOkResponse;
import app.torbox.torbox.models.GetWebDownloadCachedAvailabilityParameters;
import app.torbox.torbox.models.GetWebDownloadListOkResponse;
import app.torbox.torbox.models.GetWebDownloadListParameters;
import app.torbox.torbox.models.RequestDownloadLink2Parameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * WebDownloadsDebridService Service
 */
public class WebDownloadsDebridService extends BaseService {

  public WebDownloadsDebridService(@NonNull OkHttpClient httpClient, TorboxApiConfig config) {
    super(httpClient, config);
  }

  /**
   * Create Web Download
   *
   * @param apiVersion String
   * @param createWebDownloadRequest {@link CreateWebDownloadRequest} Request Body
   * @return response of {@code CreateWebDownloadOkResponse}
   */
  public CreateWebDownloadOkResponse createWebDownload(
    @NonNull String apiVersion,
    @NonNull CreateWebDownloadRequest createWebDownloadRequest
  ) throws ApiException {
    Request request = this.buildCreateWebDownloadRequest(apiVersion, createWebDownloadRequest);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<CreateWebDownloadOkResponse>() {});
  }

  /**
   * Create Web Download
   *
   * @param apiVersion String
   * @param createWebDownloadRequest {@link CreateWebDownloadRequest} Request Body
   * @return response of {@code CompletableFuture<CreateWebDownloadOkResponse>}
   */
  public CompletableFuture<CreateWebDownloadOkResponse> createWebDownloadAsync(
    @NonNull String apiVersion,
    @NonNull CreateWebDownloadRequest createWebDownloadRequest
  ) throws ApiException {
    Request request = this.buildCreateWebDownloadRequest(apiVersion, createWebDownloadRequest);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<CreateWebDownloadOkResponse>() {})
    );
  }

  private Request buildCreateWebDownloadRequest(
    @NonNull String apiVersion,
    @NonNull CreateWebDownloadRequest createWebDownloadRequest
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/webdl/createwebdownload"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setBody(
        new MultipartBody.Builder()
          .setType(MultipartBody.FORM)
          .addFormDataPart("link", createWebDownloadRequest.getLink())
          .build()
      )
      .build();
  }

  /**
   * Control Web Download
   *
   * @param apiVersion String
   * @param requestParameters {@link ControlWebDownloadParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void controlWebDownload(@NonNull String apiVersion, @NonNull ControlWebDownloadParameters requestParameters)
    throws ApiException {
    Request request = this.buildControlWebDownloadRequest(apiVersion, requestParameters);
    this.execute(request);
  }

  /**
   * Control Web Download
   *
   * @param apiVersion String
   * @param requestParameters {@link ControlWebDownloadParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> controlWebDownloadAsync(
    @NonNull String apiVersion,
    @NonNull ControlWebDownloadParameters requestParameters
  ) throws ApiException {
    Request request = this.buildControlWebDownloadRequest(apiVersion, requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildControlWebDownloadRequest(
    @NonNull String apiVersion,
    @NonNull ControlWebDownloadParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/webdl/controlwebdownload"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("bypass_cache", requestParameters.getBypassCache())
      .setOptionalQueryParameter("id", requestParameters.getId())
      .setJsonContent(requestParameters.getRequestBody())
      .build();
  }

  /**
   * Request Download Link
   *
   * @param apiVersion String
   * @param requestParameters {@link RequestDownloadLink2Parameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void requestDownloadLink2(
    @NonNull String apiVersion,
    @NonNull RequestDownloadLink2Parameters requestParameters
  ) throws ApiException {
    Request request = this.buildRequestDownloadLink2Request(apiVersion, requestParameters);
    this.execute(request);
  }

  /**
   * Request Download Link
   *
   * @param apiVersion String
   * @param requestParameters {@link RequestDownloadLink2Parameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> requestDownloadLink2Async(
    @NonNull String apiVersion,
    @NonNull RequestDownloadLink2Parameters requestParameters
  ) throws ApiException {
    Request request = this.buildRequestDownloadLink2Request(apiVersion, requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildRequestDownloadLink2Request(
    @NonNull String apiVersion,
    @NonNull RequestDownloadLink2Parameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/webdl/requestdl"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("token", requestParameters.getToken())
      .setOptionalQueryParameter("web_id", requestParameters.getWebId())
      .setOptionalQueryParameter("file_id", requestParameters.getFileId())
      .setOptionalQueryParameter("zip_link", requestParameters.getZipLink())
      .setOptionalQueryParameter("user_ip", requestParameters.getUserIp())
      .setOptionalQueryParameter("redirect", requestParameters.getRedirect())
      .build();
  }

  /**
   * Get Web Download List
   *
   * @param apiVersion String
   * @param requestParameters {@link GetWebDownloadListParameters} Request Parameters Object
   * @return response of {@code GetWebDownloadListOkResponse}
   */
  public GetWebDownloadListOkResponse getWebDownloadList(
    @NonNull String apiVersion,
    @NonNull GetWebDownloadListParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetWebDownloadListRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetWebDownloadListOkResponse>() {});
  }

  /**
   * Get Web Download List
   *
   * @param apiVersion String
   * @param requestParameters {@link GetWebDownloadListParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<GetWebDownloadListOkResponse>}
   */
  public CompletableFuture<GetWebDownloadListOkResponse> getWebDownloadListAsync(
    @NonNull String apiVersion,
    @NonNull GetWebDownloadListParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetWebDownloadListRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetWebDownloadListOkResponse>() {})
    );
  }

  private Request buildGetWebDownloadListRequest(
    @NonNull String apiVersion,
    @NonNull GetWebDownloadListParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/webdl/mylist"
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
   * Get Web Download Cached Availability
   *
   * @param apiVersion String
   * @param requestParameters {@link GetWebDownloadCachedAvailabilityParameters} Request Parameters Object
   * @return response of {@code void}
   */
  public void getWebDownloadCachedAvailability(
    @NonNull String apiVersion,
    @NonNull GetWebDownloadCachedAvailabilityParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetWebDownloadCachedAvailabilityRequest(apiVersion, requestParameters);
    this.execute(request);
  }

  /**
   * Get Web Download Cached Availability
   *
   * @param apiVersion String
   * @param requestParameters {@link GetWebDownloadCachedAvailabilityParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> getWebDownloadCachedAvailabilityAsync(
    @NonNull String apiVersion,
    @NonNull GetWebDownloadCachedAvailabilityParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetWebDownloadCachedAvailabilityRequest(apiVersion, requestParameters);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildGetWebDownloadCachedAvailabilityRequest(
    @NonNull String apiVersion,
    @NonNull GetWebDownloadCachedAvailabilityParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/webdl/checkcached"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("hash", requestParameters.getHash())
      .setOptionalQueryParameter("format", requestParameters.getFormat())
      .build();
  }

  /**
   * Get Hoster List
   *
   * @param apiVersion String
   * @return response of {@code GetHosterListOkResponse}
   */
  public GetHosterListOkResponse getHosterList(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetHosterListRequest(apiVersion);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetHosterListOkResponse>() {});
  }

  /**
   * Get Hoster List
   *
   * @param apiVersion String
   * @return response of {@code CompletableFuture<GetHosterListOkResponse>}
   */
  public CompletableFuture<GetHosterListOkResponse> getHosterListAsync(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetHosterListRequest(apiVersion);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetHosterListOkResponse>() {})
    );
  }

  private Request buildGetHosterListRequest(@NonNull String apiVersion) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/webdl/hosters"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .build();
  }
}
