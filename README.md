## Byte Size & Time Duration Support

Wrangler now supports parsing:
- `ByteSize`: e.g. `10KB`, `1.5MB`, `2GB`
- `TimeDuration`: e.g. `5ms`, `1s`, `2h`

###  Example Usage:

```wrangler
aggregate-stats :data_transfer_size :response_time total_size_mb total_time_sec
