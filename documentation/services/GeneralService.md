# GeneralService

A list of all methods in the `GeneralService` service. Click on the method name to view detailed information about that method.

| Methods                                       | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| :-------------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [getUpStatus](#getupstatus)                   | ### Overview Simply gets if the TorBox API is available for use or not. Also might include information about downtimes. ### Authorization None needed.                                                                                                                                                                                                                                                                                                                                                                                                 |
| [getStats](#getstats)                         | ### Overview Simply gets general stats about the TorBox service. ### Authorization None needed.                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| [getChangelogsRssFeed](#getchangelogsrssfeed) | ### Overview Gets most recent 100 changelogs from [https://feedback.torbox.app/changelog.](https://feedback.torbox.app/changelog.) This is useful for people who want updates on the TorBox changelog. Includes all the necessary items to make this compatible with RSS feed viewers for notifications, and proper HTML viewing. ### Authorization None needed.                                                                                                                                                                                       |
| [getChangelogsJson](#getchangelogsjson)       | ### Overview Gets most recent 100 changelogs from [https://feedback.torbox.app/changelog.](https://feedback.torbox.app/changelog.) This is useful for developers who want to integrate the changelog into their apps for their users to see. Includes content in HTML and markdown for developers to easily render the text in a fancy yet simple way. ### Authorization None needed.                                                                                                                                                                  |
| [getSpeedtestFiles](#getspeedtestfiles)       | ### Overview Gets CDN speedtest files. This can be used for speedtesting TorBox for users or other usages, such as checking download speeds for verification. Provides all necessary data such as region, server name, and even coordinates. Uses the requesting IP to determine if the server is the closest to the user. You also have the ability to choose between long tests or short tests via the "test_length" parameter. You may also force the region selection by passing the "region" as a specific region. ### Authorization None needed. |

## getUpStatus

### Overview Simply gets if the TorBox API is available for use or not. Also might include information about downtimes. ### Authorization None needed.

- HTTP Method: `GET`
- Endpoint: `/`

**Return Type**

`GetUpStatusOkResponse`

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.models.GetUpStatusOkResponse;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    GetUpStatusOkResponse response = torboxApi.general.getUpStatus();

    System.out.println(response);
  }
}

```

## getStats

### Overview Simply gets general stats about the TorBox service. ### Authorization None needed.

- HTTP Method: `GET`
- Endpoint: `/{api_version}/api/stats`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| apiVersion | String | ✅       |             |

**Return Type**

`GetStatsOkResponse`

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.models.GetStatsOkResponse;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    GetStatsOkResponse response = torboxApi.general.getStats("api_version");

    System.out.println(response);
  }
}

```

## getChangelogsRssFeed

### Overview Gets most recent 100 changelogs from [https://feedback.torbox.app/changelog.](https://feedback.torbox.app/changelog.) This is useful for people who want updates on the TorBox changelog. Includes all the necessary items to make this compatible with RSS feed viewers for notifications, and proper HTML viewing. ### Authorization None needed.

- HTTP Method: `GET`
- Endpoint: `/{api_version}/api/changelogs/rss`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| apiVersion | String | ✅       |             |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    Object response = torboxApi.general.getChangelogsRssFeed("api_version");

    System.out.println(response);
  }
}

```

## getChangelogsJson

### Overview Gets most recent 100 changelogs from [https://feedback.torbox.app/changelog.](https://feedback.torbox.app/changelog.) This is useful for developers who want to integrate the changelog into their apps for their users to see. Includes content in HTML and markdown for developers to easily render the text in a fancy yet simple way. ### Authorization None needed.

- HTTP Method: `GET`
- Endpoint: `/{api_version}/api/changelogs/json`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| apiVersion | String | ✅       |             |

**Return Type**

`GetChangelogsJsonOkResponse`

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.models.GetChangelogsJsonOkResponse;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    GetChangelogsJsonOkResponse response = torboxApi.general.getChangelogsJson("api_version");

    System.out.println(response);
  }
}

```

## getSpeedtestFiles

### Overview Gets CDN speedtest files. This can be used for speedtesting TorBox for users or other usages, such as checking download speeds for verification. Provides all necessary data such as region, server name, and even coordinates. Uses the requesting IP to determine if the server is the closest to the user. You also have the ability to choose between long tests or short tests via the "test_length" parameter. You may also force the region selection by passing the "region" as a specific region. ### Authorization None needed.

- HTTP Method: `GET`
- Endpoint: `/{api_version}/api/speedtest`

**Parameters**

| Name              | Type                                                                    | Required | Description               |
| :---------------- | :---------------------------------------------------------------------- | :------- | :------------------------ |
| apiVersion        | String                                                                  | ✅       |                           |
| requestParameters | [GetSpeedtestFilesParameters](../models/GetSpeedtestFilesParameters.md) | ❌       | Request Parameters Object |

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.models.GetSpeedtestFilesParameters;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    GetSpeedtestFilesParameters requestParameters = GetSpeedtestFilesParameters.builder()
      .testLength("string")
      .region("string")
      .build();

    torboxApi.general.getSpeedtestFiles("api_version", requestParameters);
  }
}

```
