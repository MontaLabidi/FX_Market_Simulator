
  export function TradingViewwidget(){
    new TradingView.widget(
    {
      "width": 980,
      "height": 610,
    "symbol": "FX:EURUSD",
    "interval": "D",
    "timezone": "Etc/UTC",
    "theme": "Light",
    "style": "1",
    "locale": "en",
    "toolbar_bg": "#f1f3f6",
    "enable_publishing": true,
    "withdateranges": true,
    "hide_side_toolbar": false,
    "allow_symbol_change": true,
    "details": true,
    "calendar": true,
    "container_id": "tradingview_96a31"
  }
    );
}
