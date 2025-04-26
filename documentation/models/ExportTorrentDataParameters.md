# ExportTorrentDataParameters

**Properties**

| Name      | Type   | Required | Description                                                                                                                                                                                                             |
| :-------- | :----- | :------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| torrentId | String | ❌       | The torrent's ID.                                                                                                                                                                                                       |
| type      | String | ❌       | Either "magnet" or "file". Tells how the API what to get, and what to respond as. If magnet, it returns a JSON response with the magnet as a string in the data key. If file, it responds with a torrent file download. |
