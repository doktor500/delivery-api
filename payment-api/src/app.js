const express = require("express"),
      app     = express(),
      cors    = require('cors'),
      http    = require("http"),
      server  = http.createServer(app);

const PORT = 9999;
const BILLING_AGREEMENT_STATUS = 'ACTIVE';

app.use(cors());

app.get('/:id', (request, response) => {
  console.log('Retrieving billing agreement state');
  response.write(BILLING_AGREEMENT_STATUS);
  response.end();
});

server.listen(PORT, () => {
  console.log("Node server running");
});
