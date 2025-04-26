# GetWebDownloadCachedAvailabilityParameters

**Properties**

| Name   | Type   | Required | Description                                                                                                                                              |
| :----- | :----- | :------- | :------------------------------------------------------------------------------------------------------------------------------------------------------- |
| hash   | String | ❌       | The list of web hashes you want to check. Comma seperated. To find the hash, md5 the link.                                                               |
| format | String | ❌       | Format you want the data in. Acceptable is either "object" or "list". List is the most performant option as it doesn't require modification of the list. |
