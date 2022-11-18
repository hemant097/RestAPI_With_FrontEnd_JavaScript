//how to create a local server using nodeJs

// after creating this file run node app.js

const http = require('http');

const hostname = '127.0.0.1';
const port = 8060;

const server = http.createServer((req, res) => {
  res.statusCode = 200;
  res.setHeader('Content-Type', 'text/plain');
  res.end('Hello World');
});

server.listen(port, hostname, () => {
  console.log(`Server running at http://${hostname}:${port}/`);
});