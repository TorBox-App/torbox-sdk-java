# RequestDownloadLink2Parameters

**Properties**

| Name     | Type   | Required | Description                                                                                                                                   |
| :------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------- |
| token    | String | ❌       | Your API Key                                                                                                                                  |
| webId    | String | ❌       | The web download's ID that you want to download                                                                                               |
| fileId   | String | ❌       | The files's ID that you want to download                                                                                                      |
| zipLink  | String | ❌       | If you want a zip link. Required if no file_id. Takes precedence over file_id if both are given.                                              |
| userIp   | String | ❌       | The user's IP to determine the closest CDN. Optional.                                                                                         |
| redirect | String | ❌       | If you want to redirect the user to the CDN link. This is useful for creating permalinks so that you can just make this request URL the link. |
