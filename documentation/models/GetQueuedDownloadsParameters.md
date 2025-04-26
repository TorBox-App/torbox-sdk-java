# GetQueuedDownloadsParameters

**Properties**

| Name        | Type   | Required | Description                                                                                                                                                                                   |
| :---------- | :----- | :------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| bypassCache | String | ❌       | Allows you to bypass the cached data, and always get fresh information. Useful if constantly querying for fresh download stats. Otherwise, we request that you save our database a few calls. |
| id          | String | ❌       | Determines the queued download requested, will return an object rather than list. Optional.                                                                                                   |
| offset      | String | ❌       | Determines the offset of items to get from the database. Default is 0. Optional.                                                                                                              |
| limit       | String | ❌       | Determines the number of items to recieve per request. Default is 1000. Optional.                                                                                                             |
| type        | String | ❌       | The type of the queued download you want to retrieve. Can be "torrent", "usenet" or "webdl". Optional. Default is "torrent".                                                                  |
