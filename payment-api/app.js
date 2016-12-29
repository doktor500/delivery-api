var express = require("express"),
    app     = express(),
    cors    = require('cors'),
    http    = require("http"),
    server  = http.createServer(app);

var BILLING_AGREEMENT_STATUS = 'ACTIVE';

app.use(cors());

app.get('/:id', function(req, res) {
  console.log('Retrieving billing agreement state');
  res.write(BILLING_AGREEMENT_STATUS);
  res.end();
});

server.listen(9999, function() {
  console.log("Node server running");
});
