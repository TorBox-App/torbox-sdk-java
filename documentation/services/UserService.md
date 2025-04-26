# UserService

A list of all methods in the `UserService` service. Click on the method name to view detailed information about that method.

| Methods                                       | Description                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            |
| :-------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| [refreshApiToken](#refreshapitoken)           | ### Overview If you want a new API token, or your old one has been compromised, you may request a new one. If you happen to forget the token, go the [TorBox settings page ](https://torbox.app/settings) and copy the current one. If this still doesn't work, you may contact us at our support email for a new one. ### Authorization Requires an API key using the Authorization Bearer Header as well as passing the `session_token` from the website to be passed in the body. You can find the `session_token` in the localStorage of your browser on any TorBox.app page under the key `torbox_session_token`. This is a temporary token that only lasts for 1 hour, which is why it is used here to verify the identity of a user as well as their API token. |
| [getUserData](#getuserdata)                   | ### Overview Gets a users account data and information. ### Plans `0` is Free plan `1` is Essential plan (_$3 plan_) `2` is Pro plan (_$10 plan_) `3` is Standard plan (_$5 plan_) ### Authorization Requires an API key using the Authorization Bearer Header.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| [addReferralToAccount](#addreferraltoaccount) | ### Overview Automatically adds a referral code to the user's account. This can be used for developers to automatically add their referral to user's accounts who use their service. This will not override any referral a user already has. If they already have one, then it cannot be changed using this endpoint. It can only be done by the user on the [website](https://torbox.app/subscription). ### Authorization Requires an API key using the Authorization Bearer Header. Use the user's API key, not your own.                                                                                                                                                                                                                                            |
| [getConfirmationCode](#getconfirmationcode)   | ### Overview Requests a 6 digit code to be sent to the user's email for verification. Used to verify a user actually wants to perform a potentially dangerous action. ### Authorization Requires an API key using the Authorization Bearer Header.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |

## refreshApiToken

### Overview If you want a new API token, or your old one has been compromised, you may request a new one. If you happen to forget the token, go the [TorBox settings page ](https://torbox.app/settings) and copy the current one. If this still doesn't work, you may contact us at our support email for a new one. ### Authorization Requires an API key using the Authorization Bearer Header as well as passing the `session_token` from the website to be passed in the body. You can find the `session_token` in the localStorage of your browser on any TorBox.app page under the key `torbox_session_token`. This is a temporary token that only lasts for 1 hour, which is why it is used here to verify the identity of a user as well as their API token.

- HTTP Method: `POST`
- Endpoint: `/{api_version}/api/user/refreshtoken`

**Parameters**

| Name       | Type   | Required | Description  |
| :--------- | :----- | :------- | :----------- |
| apiVersion | String | ✅       |              |
| input      | Object | ❌       | Request Body |

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    torboxApi.user.refreshApiToken("api_version", new Object());
  }
}

```

## getUserData

### Overview Gets a users account data and information. ### Plans `0` is Free plan `1` is Essential plan (_$3 plan_) `2` is Pro plan (_$10 plan_) `3` is Standard plan (_$5 plan_) ### Authorization Requires an API key using the Authorization Bearer Header.

- HTTP Method: `GET`
- Endpoint: `/{api_version}/api/user/me`

**Parameters**

| Name              | Type                                                        | Required | Description               |
| :---------------- | :---------------------------------------------------------- | :------- | :------------------------ |
| apiVersion        | String                                                      | ✅       |                           |
| requestParameters | [GetUserDataParameters](../models/GetUserDataParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`GetUserDataOkResponse`

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.models.GetUserDataOkResponse;
import app.torbox.torbox.models.GetUserDataParameters;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    GetUserDataParameters requestParameters = GetUserDataParameters.builder().settings("boolean").build();

    GetUserDataOkResponse response = torboxApi.user.getUserData("api_version", requestParameters);

    System.out.println(response);
  }
}

```

## addReferralToAccount

### Overview Automatically adds a referral code to the user's account. This can be used for developers to automatically add their referral to user's accounts who use their service. This will not override any referral a user already has. If they already have one, then it cannot be changed using this endpoint. It can only be done by the user on the [website](https://torbox.app/subscription). ### Authorization Requires an API key using the Authorization Bearer Header. Use the user's API key, not your own.

- HTTP Method: `POST`
- Endpoint: `/{api_version}/api/user/addreferral`

**Parameters**

| Name              | Type                                                                          | Required | Description               |
| :---------------- | :---------------------------------------------------------------------------- | :------- | :------------------------ |
| apiVersion        | String                                                                        | ✅       |                           |
| requestParameters | [AddReferralToAccountParameters](../models/AddReferralToAccountParameters.md) | ❌       | Request Parameters Object |

**Return Type**

`AddReferralToAccountOkResponse`

**Example Usage Code Snippet**

```java
import app.torbox.torbox.TorboxApi;
import app.torbox.torbox.config.TorboxApiConfig;
import app.torbox.torbox.models.AddReferralToAccountOkResponse;
import app.torbox.torbox.models.AddReferralToAccountParameters;

public class Main {

  public static void main(String[] args) {
    TorboxApiConfig config = TorboxApiConfig.builder().accessToken("YOUR_ACCESS_TOKEN").build();

    TorboxApi torboxApi = new TorboxApi(config);

    AddReferralToAccountParameters requestParameters = AddReferralToAccountParameters.builder()
      .referral("{{referral_code}}")
      .build();

    AddReferralToAccountOkResponse response = torboxApi.user.addReferralToAccount("api_version", requestParameters);

    System.out.println(response);
  }
}

```

## getConfirmationCode

### Overview Requests a 6 digit code to be sent to the user's email for verification. Used to verify a user actually wants to perform a potentially dangerous action. ### Authorization Requires an API key using the Authorization Bearer Header.

- HTTP Method: `GET`
- Endpoint: `/{api_version}/api/user/getconfirmation`

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

    torboxApi.user.getConfirmationCode("api_version");
  }
}

```
