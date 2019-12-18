// This file is the server

// kind of like import with Java and saving it into a variable
const express = require('express');
const Datastore = require('nedb');
const app = express();
app.listen(3000, () => console.log('listening at 3000'));
app.use(express.static('public'));
// parse the json
app.use(express.json({ limit: '1mb'}));

// create a database
const database = new Datastore('database.db');
database.loadDatabase();

// Clients send data to /api
// The request holds data sent by client
app.post('/api', (request, response) => {
    console.log('I got a request!');
    console.log(request.body);
    const data = request.body;
    const timestamp = Date.now();
    data.timestamp = timestamp;
    // put data into database
    database.insert(data);
    // send a response with some json
    response.json({
        // we made this up, can be whatever I guess
        status: "success",
        timestamp: data.timestamp,
        latitude: data.lat,
        longitude: data.lon
    });
});