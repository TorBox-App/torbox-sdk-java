# GetSpeedtestFilesParameters

**Properties**

| Name       | Type   | Required | Description                                                                                                                                                                                        |
| :--------- | :----- | :------- | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| testLength | String | ❌       | Determines the size of the file used for the speedtest. May be "long" or "short". Optional.                                                                                                        |
| region     | String | ❌       | Determines what cdns are returned. May be any region that TorBox is located in. To get this value, send a request without this value to determine all of the available regions that are available. |
