# IoTDataReader
Time series duplicates removal
Accepts input stream of packets data:
1615560000: 1
1615560005: 1
1615560018: 1
1615560024: 0

Returns stream of data containing pairs:
-Timestamp when input state has changed
-Input value
1615560000: 1
1615560024: 0

