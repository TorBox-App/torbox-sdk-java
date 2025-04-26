package app.torbox.torbox.services;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.HttpMethod;
import app.torbox.torbox.http.ModelConverter;
import app.torbox.torbox.http.util.RequestBuilder;
import app.torbox.torbox.models.ControlTorrentOkResponse;
import app.torbox.torbox.models.CreateTorrentOkResponse;
import app.torbox.torbox.models.CreateTorrentRequest;
import app.torbox.torbox.models.ExportTorrentDataOkResponse;
import app.torbox.torbox.models.ExportTorrentDataParameters;
import app.torbox.torbox.models.GetTorrentCachedAvailabilityOkResponse;
import app.torbox.torbox.models.GetTorrentCachedAvailabilityParameters;
import app.torbox.torbox.models.GetTorrentInfo1OkResponse;
import app.torbox.torbox.models.GetTorrentInfo1Request;
import app.torbox.torbox.models.GetTorrentInfoOkResponse;
import app.torbox.torbox.models.GetTorrentInfoParameters;
import app.torbox.torbox.models.GetTorrentListOkResponse;
import app.torbox.torbox.models.GetTorrentListParameters;
import app.torbox.torbox.models.RequestDownloadLinkOkResponse;
import app.torbox.torbox.models.RequestDownloadLinkParameters;
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
 * TorrentsService Service
 */
public class TorrentsService extends BaseService {

  public TorrentsService(@NonNull OkHttpClient httpClient, TorboxApiConfig config) {
    super(httpClient, config);
  }

  /**
   * Create Torrent
   *
   * @param apiVersion String
   * @param createTorrentRequest {@link CreateTorrentRequest} Request Body
   * @return response of {@code CreateTorrentOkResponse}
   */
  public CreateTorrentOkResponse createTorrent(
    @NonNull String apiVersion,
    @NonNull CreateTorrentRequest createTorrentRequest
  ) throws ApiException {
    Request request = this.buildCreateTorrentRequest(apiVersion, createTorrentRequest);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<CreateTorrentOkResponse>() {});
  }

  /**
   * Create Torrent
   *
   * @param apiVersion String
   * @param createTorrentRequest {@link CreateTorrentRequest} Request Body
   * @return response of {@code CompletableFuture<CreateTorrentOkResponse>}
   */
  public CompletableFuture<CreateTorrentOkResponse> createTorrentAsync(
    @NonNull String apiVersion,
    @NonNull CreateTorrentRequest createTorrentRequest
  ) throws ApiException {
    Request request = this.buildCreateTorrentRequest(apiVersion, createTorrentRequest);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<CreateTorrentOkResponse>() {})
    );
  }

  private Request buildCreateTorrentRequest(
    @NonNull String apiVersion,
    @NonNull CreateTorrentRequest createTorrentRequest
  ) {
    MultipartBody.Builder multipartBodyBuilder = new MultipartBody.Builder()
      .setType(MultipartBody.FORM)
      .addFormDataPart("allow_zip", createTorrentRequest.getAllowZip())
      .addFormDataPart("as_queued", createTorrentRequest.getAsQueued())
      .addFormDataPart("magnet", createTorrentRequest.getMagnet())
      .addFormDataPart("name", createTorrentRequest.getName())
      .addFormDataPart("seed", createTorrentRequest.getSeed());
    if (createTorrentRequest.getFile() != null) {
      multipartBodyBuilder.addFormDataPart(
        "file",
        String.format("file_%s", UUID.randomUUID()),
        RequestBody.create(createTorrentRequest.getFile().toString(), MediaType.parse("application/octet-stream"))
      );
    }
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/torrents/createtorrent"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setBody(multipartBodyBuilder.build())
      .build();
  }

  /**
   * Control Torrent
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code ControlTorrentOkResponse}
   */
  public ControlTorrentOkResponse controlTorrent(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildControlTorrentRequest(apiVersion, input);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ControlTorrentOkResponse>() {});
  }

  /**
   * Control Torrent
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<ControlTorrentOkResponse>}
   */
  public CompletableFuture<ControlTorrentOkResponse> controlTorrentAsync(
    @NonNull String apiVersion,
    @NonNull Object input
  ) throws ApiException {
    Request request = this.buildControlTorrentRequest(apiVersion, input);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ControlTorrentOkResponse>() {})
    );
  }

  private Request buildControlTorrentRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/torrents/controltorrent"
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
   * @param requestParameters {@link RequestDownloadLinkParameters} Request Parameters Object
   * @return response of {@code RequestDownloadLinkOkResponse}
   */
  public RequestDownloadLinkOkResponse requestDownloadLink(
    @NonNull String apiVersion,
    @NonNull RequestDownloadLinkParameters requestParameters
  ) throws ApiException {
    Request request = this.buildRequestDownloadLinkRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<RequestDownloadLinkOkResponse>() {});
  }

  /**
   * Request Download Link
   *
   * @param apiVersion String
   * @param requestParameters {@link RequestDownloadLinkParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<RequestDownloadLinkOkResponse>}
   */
  public CompletableFuture<RequestDownloadLinkOkResponse> requestDownloadLinkAsync(
    @NonNull String apiVersion,
    @NonNull RequestDownloadLinkParameters requestParameters
  ) throws ApiException {
    Request request = this.buildRequestDownloadLinkRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<RequestDownloadLinkOkResponse>() {})
    );
  }

  private Request buildRequestDownloadLinkRequest(
    @NonNull String apiVersion,
    @NonNull RequestDownloadLinkParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/torrents/requestdl"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("token", requestParameters.getToken())
      .setOptionalQueryParameter("torrent_id", requestParameters.getTorrentId())
      .setOptionalQueryParameter("file_id", requestParameters.getFileId())
      .setOptionalQueryParameter("zip_link", requestParameters.getZipLink())
      .setOptionalQueryParameter("user_ip", requestParameters.getUserIp())
      .setOptionalQueryParameter("redirect", requestParameters.getRedirect())
      .build();
  }

  /**
   * Get Torrent List
   *
   * @param apiVersion String
   * @param requestParameters {@link GetTorrentListParameters} Request Parameters Object
   * @return response of {@code GetTorrentListOkResponse}
   */
  public GetTorrentListOkResponse getTorrentList(
    @NonNull String apiVersion,
    @NonNull GetTorrentListParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetTorrentListRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetTorrentListOkResponse>() {});
  }

  /**
   * Get Torrent List
   *
   * @param apiVersion String
   * @param requestParameters {@link GetTorrentListParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<GetTorrentListOkResponse>}
   */
  public CompletableFuture<GetTorrentListOkResponse> getTorrentListAsync(
    @NonNull String apiVersion,
    @NonNull GetTorrentListParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetTorrentListRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetTorrentListOkResponse>() {})
    );
  }

  private Request buildGetTorrentListRequest(
    @NonNull String apiVersion,
    @NonNull GetTorrentListParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/torrents/mylist"
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
   * Get Torrent Cached Availability
   *
   * @param apiVersion String
   * @param requestParameters {@link GetTorrentCachedAvailabilityParameters} Request Parameters Object
   * @return response of {@code GetTorrentCachedAvailabilityOkResponse}
   */
  public GetTorrentCachedAvailabilityOkResponse getTorrentCachedAvailability(
    @NonNull String apiVersion,
    @NonNull GetTorrentCachedAvailabilityParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetTorrentCachedAvailabilityRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetTorrentCachedAvailabilityOkResponse>() {});
  }

  /**
   * Get Torrent Cached Availability
   *
   * @param apiVersion String
   * @param requestParameters {@link GetTorrentCachedAvailabilityParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<GetTorrentCachedAvailabilityOkResponse>}
   */
  public CompletableFuture<GetTorrentCachedAvailabilityOkResponse> getTorrentCachedAvailabilityAsync(
    @NonNull String apiVersion,
    @NonNull GetTorrentCachedAvailabilityParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetTorrentCachedAvailabilityRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetTorrentCachedAvailabilityOkResponse>() {})
    );
  }

  private Request buildGetTorrentCachedAvailabilityRequest(
    @NonNull String apiVersion,
    @NonNull GetTorrentCachedAvailabilityParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/torrents/checkcached"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("hash", requestParameters.getHash())
      .setOptionalQueryParameter("format", requestParameters.getFormat())
      .setOptionalQueryParameter("list_files", requestParameters.getListFiles())
      .build();
  }

  /**
   * Export Torrent Data
   *
   * @param apiVersion String
   * @param requestParameters {@link ExportTorrentDataParameters} Request Parameters Object
   * @return response of {@code ExportTorrentDataOkResponse}
   */
  public ExportTorrentDataOkResponse exportTorrentData(
    @NonNull String apiVersion,
    @NonNull ExportTorrentDataParameters requestParameters
  ) throws ApiException {
    Request request = this.buildExportTorrentDataRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<ExportTorrentDataOkResponse>() {});
  }

  /**
   * Export Torrent Data
   *
   * @param apiVersion String
   * @param requestParameters {@link ExportTorrentDataParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<ExportTorrentDataOkResponse>}
   */
  public CompletableFuture<ExportTorrentDataOkResponse> exportTorrentDataAsync(
    @NonNull String apiVersion,
    @NonNull ExportTorrentDataParameters requestParameters
  ) throws ApiException {
    Request request = this.buildExportTorrentDataRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<ExportTorrentDataOkResponse>() {})
    );
  }

  private Request buildExportTorrentDataRequest(
    @NonNull String apiVersion,
    @NonNull ExportTorrentDataParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/torrents/exportdata"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("torrent_id", requestParameters.getTorrentId())
      .setOptionalQueryParameter("type", requestParameters.getType())
      .build();
  }

  /**
   * Get Torrent Info
   *
   * @param apiVersion String
   * @param requestParameters {@link GetTorrentInfoParameters} Request Parameters Object
   * @return response of {@code GetTorrentInfoOkResponse}
   */
  public GetTorrentInfoOkResponse getTorrentInfo(
    @NonNull String apiVersion,
    @NonNull GetTorrentInfoParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetTorrentInfoRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetTorrentInfoOkResponse>() {});
  }

  /**
   * Get Torrent Info
   *
   * @param apiVersion String
   * @param requestParameters {@link GetTorrentInfoParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<GetTorrentInfoOkResponse>}
   */
  public CompletableFuture<GetTorrentInfoOkResponse> getTorrentInfoAsync(
    @NonNull String apiVersion,
    @NonNull GetTorrentInfoParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetTorrentInfoRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetTorrentInfoOkResponse>() {})
    );
  }

  private Request buildGetTorrentInfoRequest(
    @NonNull String apiVersion,
    @NonNull GetTorrentInfoParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/torrents/torrentinfo"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("hash", requestParameters.getHash())
      .setOptionalQueryParameter("timeout", requestParameters.getTimeout())
      .build();
  }

  /**
   * Get Torrent Info
   *
   * @param apiVersion String
   * @param getTorrentInfo1Request {@link GetTorrentInfo1Request} Request Body
   * @return response of {@code GetTorrentInfo1OkResponse}
   */
  public GetTorrentInfo1OkResponse getTorrentInfo1(
    @NonNull String apiVersion,
    @NonNull GetTorrentInfo1Request getTorrentInfo1Request
  ) throws ApiException {
    Request request = this.buildGetTorrentInfo1Request(apiVersion, getTorrentInfo1Request);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetTorrentInfo1OkResponse>() {});
  }

  /**
   * Get Torrent Info
   *
   * @param apiVersion String
   * @param getTorrentInfo1Request {@link GetTorrentInfo1Request} Request Body
   * @return response of {@code CompletableFuture<GetTorrentInfo1OkResponse>}
   */
  public CompletableFuture<GetTorrentInfo1OkResponse> getTorrentInfo1Async(
    @NonNull String apiVersion,
    @NonNull GetTorrentInfo1Request getTorrentInfo1Request
  ) throws ApiException {
    Request request = this.buildGetTorrentInfo1Request(apiVersion, getTorrentInfo1Request);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetTorrentInfo1OkResponse>() {})
    );
  }

  private Request buildGetTorrentInfo1Request(
    @NonNull String apiVersion,
    @NonNull GetTorrentInfo1Request getTorrentInfo1Request
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/torrents/torrentinfo"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setBody(
        new MultipartBody.Builder()
          .setType(MultipartBody.FORM)
          .addFormDataPart("hash", getTorrentInfo1Request.getHash())
          .build()
      )
      .build();
  }
}
