package app.torbox.torbox;

import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.http.Environment;
import app.torbox.torbox.http.interceptors.DefaultHeadersInterceptor;
import app.torbox.torbox.http.interceptors.RetryInterceptor;
import app.torbox.torbox.services.GeneralService;
import app.torbox.torbox.services.IntegrationsService;
import app.torbox.torbox.services.NotificationsService;
import app.torbox.torbox.services.QueuedService;
import app.torbox.torbox.services.RssFeedsService;
import app.torbox.torbox.services.TorrentsService;
import app.torbox.torbox.services.UsenetService;
import app.torbox.torbox.services.UserService;
import app.torbox.torbox.services.WebDownloadsDebridService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;

/** You can view the full documentation at https://api-docs.torbox.app. */
public class TorboxApi {

  public final TorrentsService torrents;
  public final UsenetService usenet;
  public final WebDownloadsDebridService webDownloadsDebrid;
  public final GeneralService general;
  public final NotificationsService notifications;
  public final UserService user;
  public final RssFeedsService rssFeeds;
  public final IntegrationsService integrations;
  public final QueuedService queued;

  private final TorboxApiConfig config;

  public TorboxApi() {
    // Default configs
    this(TorboxApiConfig.builder().build());
  }

  public TorboxApi(TorboxApiConfig config) {
    this.config = config;

    final OkHttpClient httpClient = new OkHttpClient.Builder()
      .addInterceptor(new DefaultHeadersInterceptor(config))
      .addInterceptor(new RetryInterceptor(config.getRetryConfig()))
      .readTimeout(config.getTimeout(), TimeUnit.MILLISECONDS)
      .build();

    this.torrents = new TorrentsService(httpClient, config);
    this.usenet = new UsenetService(httpClient, config);
    this.webDownloadsDebrid = new WebDownloadsDebridService(httpClient, config);
    this.general = new GeneralService(httpClient, config);
    this.notifications = new NotificationsService(httpClient, config);
    this.user = new UserService(httpClient, config);
    this.rssFeeds = new RssFeedsService(httpClient, config);
    this.integrations = new IntegrationsService(httpClient, config);
    this.queued = new QueuedService(httpClient, config);
  }

  public void setEnvironment(Environment environment) {
    setBaseUrl(environment.getUrl());
  }

  public void setBaseUrl(String baseUrl) {
    this.config.setBaseUrl(baseUrl);
  }

  public void setAccessToken(String token) {
    this.config.setAccessToken(token);
  }
}
// c029837e0e474b76bc487506e8799df5e3335891efe4fb02bda7a1441840310c
