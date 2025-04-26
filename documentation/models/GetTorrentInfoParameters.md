# GetTorrentInfoParameters

**Properties**

| Name    | Type   | Required | Description                                                                                                                                                                                          |
| :------ | :----- | :------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| hash    | String | ❌       | Hash of the torrent you want to get info for. This is required.                                                                                                                                      |
| timeout | String | ❌       | The amount of time you want TorBox to search for the torrent on the Bittorrent network. If the number of seeders is low or even zero, this value may be helpful to move up. Default is 10. Optional. |
