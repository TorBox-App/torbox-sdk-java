![Logo](https://raw.githubusercontent.com/TorBox-App/torbox-sdk-java/main/assets/banner.png)

## Table of Contents

- [Setup \& Configuration](#setup--configuration)
  - [Supported Language Versions](#supported-language-versions)
  - [Installation](#installation)
  - [Authentication](#authentication)
    - [Access Token Authentication](#access-token-authentication)
      - [Setting the Access Token](#setting-the-access-token)
  - [Setting a Custom Timeout](#setting-a-custom-timeout)
- [Sample Usage](#sample-usage)
  - [Services](#services)
  - [Models](#models)
  - [License](#license)

# Setup & Configuration

## Supported Language Versions

This SDK is compatible with the following versions: `Java >= 1.8`

## Installation

If you use Maven, place the following within the _dependency_ tag in your `pom.xml` file:

```XML
<dependency>
    <groupId>app.torbox</groupId>
    <artifactId>torbox</artifactId>
    <version>1.0.1</version>
</dependency>
```

If you use Gradle, paste the next line inside the _dependencies_ block of your `build.gradle` file:

```Gradle
implementation group: app.torbox, name: torbox, version: 1.0.1
```

If you use JAR files, package the SDK by running the following command:

```shell
mvn compile assembly:single
```

Then, add the JAR file to your project's classpath.

## Authentication

### Access Token Authentication

The TorboxApi API uses an Access Token for authentication.

This token must be provided to authenticate your requests to the API.

#### Setting the Access Token

When you initialize the SDK, you can set the access token as follows:

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);
  }
}

```

If you need to set or update the access token after initializing the SDK, you can use:

```java
torboxApi.setAccessToken('YOUR_ACCESS_TOKEN');
```

## Setting a Custom Timeout

You can set a custom timeout for the SDK's HTTP requests as follows:

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().timeout(10000).build();
    TorboxApi torboxApi = new TorboxApi(config);
  }
}

```

# Sample Usage

Below is a comprehensive example demonstrating how to authenticate and call a simple endpoint:

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.exceptions.ApiException;
import app.torbox.torbox.models.GetUpStatusOkResponse;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    try {
      GetUpStatusOkResponse response = torboxApi.general.getUpStatus();

      System.out.println(response);
    } catch (ApiException e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}

```

## Services

The SDK provides various services to interact with the API.

<details> 
<summary>Below is a list of all available services with links to their detailed documentation:</summary>

| Name                                                                             |
| :------------------------------------------------------------------------------- |
| [TorrentsService](documentation/services/TorrentsService.md)                     |
| [UsenetService](documentation/services/UsenetService.md)                         |
| [WebDownloadsDebridService](documentation/services/WebDownloadsDebridService.md) |
| [GeneralService](documentation/services/GeneralService.md)                       |
| [NotificationsService](documentation/services/NotificationsService.md)           |
| [UserService](documentation/services/UserService.md)                             |
| [RssFeedsService](documentation/services/RssFeedsService.md)                     |
| [IntegrationsService](documentation/services/IntegrationsService.md)             |
| [QueuedService](documentation/services/QueuedService.md)                         |

</details>

## Models

The SDK includes several models that represent the data structures used in API requests and responses. These models help in organizing and managing the data efficiently.

<details> 
<summary>Below is a list of all available models with links to their detailed documentation:</summary>

| Name                                                                                                             | Description |
| :--------------------------------------------------------------------------------------------------------------- | :---------- |
| [CreateTorrentRequest](documentation/models/CreateTorrentRequest.md)                                             |             |
| [CreateTorrentOkResponse](documentation/models/CreateTorrentOkResponse.md)                                       |             |
| [ControlTorrentOkResponse](documentation/models/ControlTorrentOkResponse.md)                                     |             |
| [RequestDownloadLinkOkResponse](documentation/models/RequestDownloadLinkOkResponse.md)                           |             |
| [GetTorrentListOkResponse](documentation/models/GetTorrentListOkResponse.md)                                     |             |
| [GetTorrentCachedAvailabilityOkResponse](documentation/models/GetTorrentCachedAvailabilityOkResponse.md)         |             |
| [ExportTorrentDataOkResponse](documentation/models/ExportTorrentDataOkResponse.md)                               |             |
| [GetTorrentInfoOkResponse](documentation/models/GetTorrentInfoOkResponse.md)                                     |             |
| [GetTorrentInfo1Request](documentation/models/GetTorrentInfo1Request.md)                                         |             |
| [GetTorrentInfo1OkResponse](documentation/models/GetTorrentInfo1OkResponse.md)                                   |             |
| [CreateUsenetDownloadRequest](documentation/models/CreateUsenetDownloadRequest.md)                               |             |
| [CreateUsenetDownloadOkResponse](documentation/models/CreateUsenetDownloadOkResponse.md)                         |             |
| [GetUsenetListOkResponse](documentation/models/GetUsenetListOkResponse.md)                                       |             |
| [CreateWebDownloadRequest](documentation/models/CreateWebDownloadRequest.md)                                     |             |
| [CreateWebDownloadOkResponse](documentation/models/CreateWebDownloadOkResponse.md)                               |             |
| [GetWebDownloadListOkResponse](documentation/models/GetWebDownloadListOkResponse.md)                             |             |
| [GetHosterListOkResponse](documentation/models/GetHosterListOkResponse.md)                                       |             |
| [GetUpStatusOkResponse](documentation/models/GetUpStatusOkResponse.md)                                           |             |
| [GetStatsOkResponse](documentation/models/GetStatsOkResponse.md)                                                 |             |
| [GetChangelogsJsonOkResponse](documentation/models/GetChangelogsJsonOkResponse.md)                               |             |
| [GetNotificationFeedOkResponse](documentation/models/GetNotificationFeedOkResponse.md)                           |             |
| [GetUserDataOkResponse](documentation/models/GetUserDataOkResponse.md)                                           |             |
| [AddReferralToAccountOkResponse](documentation/models/AddReferralToAccountOkResponse.md)                         |             |
| [GetAllJobsOkResponse](documentation/models/GetAllJobsOkResponse.md)                                             |             |
| [GetAllJobsByHashOkResponse](documentation/models/GetAllJobsByHashOkResponse.md)                                 |             |
| [RequestDownloadLinkParameters](documentation/models/RequestDownloadLinkParameters.md)                           |             |
| [GetTorrentListParameters](documentation/models/GetTorrentListParameters.md)                                     |             |
| [GetTorrentCachedAvailabilityParameters](documentation/models/GetTorrentCachedAvailabilityParameters.md)         |             |
| [ExportTorrentDataParameters](documentation/models/ExportTorrentDataParameters.md)                               |             |
| [GetTorrentInfoParameters](documentation/models/GetTorrentInfoParameters.md)                                     |             |
| [RequestDownloadLink1Parameters](documentation/models/RequestDownloadLink1Parameters.md)                         |             |
| [GetUsenetListParameters](documentation/models/GetUsenetListParameters.md)                                       |             |
| [GetUsenetCachedAvailabilityParameters](documentation/models/GetUsenetCachedAvailabilityParameters.md)           |             |
| [ControlWebDownloadParameters](documentation/models/ControlWebDownloadParameters.md)                             |             |
| [RequestDownloadLink2Parameters](documentation/models/RequestDownloadLink2Parameters.md)                         |             |
| [GetWebDownloadListParameters](documentation/models/GetWebDownloadListParameters.md)                             |             |
| [GetWebDownloadCachedAvailabilityParameters](documentation/models/GetWebDownloadCachedAvailabilityParameters.md) |             |
| [GetSpeedtestFilesParameters](documentation/models/GetSpeedtestFilesParameters.md)                               |             |
| [GetRssNotificationFeedParameters](documentation/models/GetRssNotificationFeedParameters.md)                     |             |
| [GetUserDataParameters](documentation/models/GetUserDataParameters.md)                                           |             |
| [AddReferralToAccountParameters](documentation/models/AddReferralToAccountParameters.md)                         |             |
| [GetUserRssFeedsParameters](documentation/models/GetUserRssFeedsParameters.md)                                   |             |
| [GetRssFeedItemsParameters](documentation/models/GetRssFeedItemsParameters.md)                                   |             |
| [GetQueuedDownloadsParameters](documentation/models/GetQueuedDownloadsParameters.md)                             |             |

</details>

## License

This SDK is licensed under the MIT License.

See the [LICENSE](LICENSE) file for more details.
