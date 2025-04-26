# NotificationsService

A list of all methods in the `NotificationsService` service. Click on the method name to view detailed information about that method.

| Methods                                             | Description                                                                                                                                                                                                                                                                                                                                           |
| :-------------------------------------------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [getRssNotificationFeed](#getrssnotificationfeed)   | ### Overview Gets your notifications in an RSS Feed which allows you to use them with RSS Feed readers or notification services that can take RSS Feeds and listen to updates. As soon as a notification goes to your account, it will be added to your feed. ### Authorization Requires an API key using as a query parameter using the `token` key. |
| [getNotificationFeed](#getnotificationfeed)         | ### Overview Gets your notifications in a JSON object that is easily parsable compared to the RSS Feed. Gives all the same data as the RSS Feed. ### Authorization Requires an API key using the Authorization Bearer Header.                                                                                                                         |
| [clearAllNotifications](#clearallnotifications)     | ### Overview Marks all of your notifications as read and deletes them permanently. ### Authorization Requires an API key using the Authorization Bearer Header.                                                                                                                                                                                       |
| [clearSingleNotification](#clearsinglenotification) | ### Overview Marks a single notification as read and permanently deletes it from your notifications. Requires a `notification_id` which can be found by getting your notification feed. ### Authorization Requires an API key using the Authorization Bearer Header.                                                                                  |
| [sendTestNotification](#sendtestnotification)       | ### Overview Sends a test notification to all enabled notification types. This can be useful for validating setups. No need for any body in this request. ### Authorization Requires an API key using the Authorization Bearer Header.                                                                                                                |

## getRssNotificationFeed

### Overview Gets your notifications in an RSS Feed which allows you to use them with RSS Feed readers or notification services that can take RSS Feeds and listen to updates. As soon as a notification goes to your account, it will be added to your feed. ### Authorization Requires an API key using as a query parameter using the `token` key.

- HTTP Method: `GET`
- Endpoint: `/{api_version}/api/notifications/rss`

**Parameters**

| Name              | Type                                                                              | Required | Description               |
| :---------------- | :-------------------------------------------------------------------------------- | :------- | :------------------------ |
| apiVersion        | String                                                                            | ✅       |                           |
| requestParameters | [GetRssNotificationFeedParameters](../models/GetRssNotificationFeedParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`Object`

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.models.GetRssNotificationFeedParameters;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    GetRssNotificationFeedParameters requestParameters = GetRssNotificationFeedParameters.builder()
      .token("{{api_key}}")
      .build();

    Object response = torboxApi.notifications.getRssNotificationFeed("api_version", requestParameters);

    System.out.println(response);
  }
}

```

## getNotificationFeed

### Overview Gets your notifications in a JSON object that is easily parsable compared to the RSS Feed. Gives all the same data as the RSS Feed. ### Authorization Requires an API key using the Authorization Bearer Header.

- HTTP Method: `GET`
- Endpoint: `/{api_version}/api/notifications/mynotifications`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| apiVersion | String | ✅       |             |

**Return Type**

`GetNotificationFeedOkResponse`

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.models.GetNotificationFeedOkResponse;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    GetNotificationFeedOkResponse response = torboxApi.notifications.getNotificationFeed("api_version");

    System.out.println(response);
  }
}

```

## clearAllNotifications

### Overview Marks all of your notifications as read and deletes them permanently. ### Authorization Requires an API key using the Authorization Bearer Header.

- HTTP Method: `POST`
- Endpoint: `/{api_version}/api/notifications/clear`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| apiVersion | String | ✅       |             |

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    torboxApi.notifications.clearAllNotifications("api_version");
  }
}

```

## clearSingleNotification

### Overview Marks a single notification as read and permanently deletes it from your notifications. Requires a `notification_id` which can be found by getting your notification feed. ### Authorization Requires an API key using the Authorization Bearer Header.

- HTTP Method: `POST`
- Endpoint: `/{api_version}/api/notifications/clear/{notification_id}`

**Parameters**

| Name           | Type   | Required | Description |
| :------------- | :----- | :------- | :---------- |
| apiVersion     | String | ✅       |             |
| notificationId | String | ✅       |             |

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    torboxApi.notifications.clearSingleNotification("api_version", "notification_id");
  }
}

```

## sendTestNotification

### Overview Sends a test notification to all enabled notification types. This can be useful for validating setups. No need for any body in this request. ### Authorization Requires an API key using the Authorization Bearer Header.

- HTTP Method: `POST`
- Endpoint: `/{api_version}/api/notifications/test`

**Parameters**

| Name       | Type   | Required | Description |
| :--------- | :----- | :------- | :---------- |
| apiVersion | String | ✅       |             |

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    torboxApi.notifications.sendTestNotification("api_version");
  }
}

```
