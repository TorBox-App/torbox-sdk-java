package app.torbox.torbox.services;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.HttpMethod;
import app.torbox.torbox.http.ModelConverter;
import app.torbox.torbox.http.util.RequestBuilder;
import app.torbox.torbox.models.AddReferralToAccountOkResponse;
import app.torbox.torbox.models.AddReferralToAccountParameters;
import app.torbox.torbox.models.GetUserDataOkResponse;
import app.torbox.torbox.models.GetUserDataParameters;
import com.fasterxml.jackson.core.type.TypeReference;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import lombok.NonNull;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * UserService Service
 */
public class UserService extends BaseService {

  public UserService(@NonNull OkHttpClient httpClient, TorboxApiConfig config) {
    super(httpClient, config);
  }

  /**
   * Refresh API Token
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code void}
   */
  public void refreshApiToken(@NonNull String apiVersion, @NonNull Object input) throws ApiException {
    Request request = this.buildRefreshApiTokenRequest(apiVersion, input);
    this.execute(request);
  }

  /**
   * Refresh API Token
   *
   * @param apiVersion String
   * @param input Object Request Body
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> refreshApiTokenAsync(@NonNull String apiVersion, @NonNull Object input)
    throws ApiException {
    Request request = this.buildRefreshApiTokenRequest(apiVersion, input);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildRefreshApiTokenRequest(@NonNull String apiVersion, @NonNull Object input) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/user/refreshtoken"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setJsonContent(input)
      .build();
  }

  /**
   * Get User Data
   *
   * @param apiVersion String
   * @param requestParameters {@link GetUserDataParameters} Request Parameters Object
   * @return response of {@code GetUserDataOkResponse}
   */
  public GetUserDataOkResponse getUserData(
    @NonNull String apiVersion,
    @NonNull GetUserDataParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetUserDataRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<GetUserDataOkResponse>() {});
  }

  /**
   * Get User Data
   *
   * @param apiVersion String
   * @param requestParameters {@link GetUserDataParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<GetUserDataOkResponse>}
   */
  public CompletableFuture<GetUserDataOkResponse> getUserDataAsync(
    @NonNull String apiVersion,
    @NonNull GetUserDataParameters requestParameters
  ) throws ApiException {
    Request request = this.buildGetUserDataRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<GetUserDataOkResponse>() {})
    );
  }

  private Request buildGetUserDataRequest(
    @NonNull String apiVersion,
    @NonNull GetUserDataParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/user/me"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("settings", requestParameters.getSettings())
      .build();
  }

  /**
   * Add Referral To Account
   *
   * @param apiVersion String
   * @param requestParameters {@link AddReferralToAccountParameters} Request Parameters Object
   * @return response of {@code AddReferralToAccountOkResponse}
   */
  public AddReferralToAccountOkResponse addReferralToAccount(
    @NonNull String apiVersion,
    @NonNull AddReferralToAccountParameters requestParameters
  ) throws ApiException {
    Request request = this.buildAddReferralToAccountRequest(apiVersion, requestParameters);
    Response response = this.execute(request);
    return ModelConverter.convert(response, new TypeReference<AddReferralToAccountOkResponse>() {});
  }

  /**
   * Add Referral To Account
   *
   * @param apiVersion String
   * @param requestParameters {@link AddReferralToAccountParameters} Request Parameters Object
   * @return response of {@code CompletableFuture<AddReferralToAccountOkResponse>}
   */
  public CompletableFuture<AddReferralToAccountOkResponse> addReferralToAccountAsync(
    @NonNull String apiVersion,
    @NonNull AddReferralToAccountParameters requestParameters
  ) throws ApiException {
    Request request = this.buildAddReferralToAccountRequest(apiVersion, requestParameters);
    CompletableFuture<Response> futureResponse = this.executeAsync(request);
    return futureResponse.thenApplyAsync(response ->
      ModelConverter.convert(response, new TypeReference<AddReferralToAccountOkResponse>() {})
    );
  }

  private Request buildAddReferralToAccountRequest(
    @NonNull String apiVersion,
    @NonNull AddReferralToAccountParameters requestParameters
  ) {
    return new RequestBuilder(
      HttpMethod.POST,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/user/addreferral"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .setOptionalQueryParameter("referral", requestParameters.getReferral())
      .build();
  }

  /**
   * Get Confirmation Code
   *
   * @param apiVersion String
   * @return response of {@code void}
   */
  public void getConfirmationCode(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetConfirmationCodeRequest(apiVersion);
    this.execute(request);
  }

  /**
   * Get Confirmation Code
   *
   * @param apiVersion String
   * @return response of {@code CompletableFuture<Void>}
   */
  public CompletableFuture<Void> getConfirmationCodeAsync(@NonNull String apiVersion) throws ApiException {
    Request request = this.buildGetConfirmationCodeRequest(apiVersion);
    return this.executeAsync(request).thenApplyAsync(response -> null);
  }

  private Request buildGetConfirmationCodeRequest(@NonNull String apiVersion) {
    return new RequestBuilder(
      HttpMethod.GET,
      Optional.ofNullable(this.config.getBaseUrl()).orElse(Environment.DEFAULT.getUrl()),
      "{api_version}/api/user/getconfirmation"
    )
      .setAccessTokenAuth(this.config.getAccessToken(), "Bearer")
      .setPathParameter("api_version", apiVersion)
      .build();
  }
}
