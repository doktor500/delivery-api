var express = require("express"),
    app     = express(),
    cors    = require('cors'),
    http    = require("http"),
    server  = http.createServer(app);

var BILLING_AGREEMENT_STATUS = 'Active';

app.use(cors());

app.get('/:id', function(req, res) {
  res.write(BILLING_AGREEMENT_STATUS);
  res.end();
});

server.listen(9999, function() {
  console.log("Node server running");
});