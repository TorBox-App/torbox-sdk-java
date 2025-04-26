# GetTorrentCachedAvailabilityParameters

**Properties**

| Name      | Type   | Required | Description                                                                                                                                              |
| :-------- | :----- | :------- | :------------------------------------------------------------------------------------------------------------------------------------------------------- |
| hash      | String | ❌       | The list of torrent hashes you want to check. Comma seperated.                                                                                           |
| format    | String | ❌       | Format you want the data in. Acceptable is either "object" or "list". List is the most performant option as it doesn't require modification of the list. |
| listFiles | String | ❌       | Allows you to list the files found inside the cached data.                                                                                               |
