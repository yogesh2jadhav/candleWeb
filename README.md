# candleWeb
Project is to make List of Object containting OCHL values from Tread History Rest Call
<BR>
CandleWeb <BR>
 &nbsp;   | - demo<BR>
 &nbsp;   | &nbsp;  &nbsp;  &nbsp;  &nbsp;      |-- CandleWebApplication.java (@SpringBootApplication)<BR>
 &nbsp;   | &nbsp;   &nbsp;  &nbsp;  &nbsp;     |-- ServletInitializer.java<BR>
 &nbsp;   |<BR>
 &nbsp;   | - Controller<BR>
 &nbsp;   | &nbsp;  &nbsp;  &nbsp;  &nbsp;        |-- CandleStick.java <BR>
 &nbsp;   |<BR>
 &nbsp;   | - DTO<BR>
 &nbsp;   | &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;     |-- CandleDto.java<BR>
 &nbsp;   | &nbsp; &nbsp;  &nbsp;  &nbsp;  &nbsp;      |-- TradeHistoryDto.java<BR>
 &nbsp;   |<BR>
 &nbsp;   | - Service<BR>
 &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;  &nbsp;         |-- CandleValues.java<BR>
 &nbsp;  &nbsp;  &nbsp;  &nbsp; &nbsp;  &nbsp;          |-- CandleService.java<BR>
  <BR>
  <BR>
  # Project Flow<BR>
  URL - http://localhost:8080/candleWeb/candle/<PairName>/<Min><BR>
        e.g. http://localhost:8080/candleWeb/candle/B-BTC_USDT/2<BR>
  <BR>
  
  # Code Flow
  1. URL hits controller where Pair and Min. passed as input params to Service Call.
  2. Candleservice::getData Method do Min*60 to get 60 object assuming one/sec. for requested pair and hit 
    https://public.coindcx.com/market_data/trade_history?pair=<pair>&limit=Min*60
  3. Recived Array is getting Sorted based on time using comparable.
  4. Then this Array sent to CandleValue class.
  5. Where Candle stick values are getting calculated. as per following logic
     a. Assume we got 60 Trade values for a min. in Array
     b. Array got storted time base.
     c. 1st Sec. Value is opening Value and last Values is Closing Value.
     d. Highest from these 60 valus is High price and Lowest from these 60 are low price.
  6. Step 5 will give one Candle stick value for one set of min.
  7. Array is getting created of Candle stick.
  
  Expected Fronend should make this rest call per 1min/ 15 min
  
