// This file is the server

// kind of like import with Java and saving it into a variable
const express = require("express");
const Datastore = require("nedb");
const fetch = require("node-fetch");
const app = express();
app.listen(3000, () => console.log("listening at 3000"));
app.use(express.static("public"));
// parse the json
app.use(express.json({ limit: "1mb" }));

// create a database
const database = new Datastore("database.db");
database.loadDatabase();

// Client requests data through the '/api' route
app.get("/api", (request, response) => {
  database.find({}, (error, data) => {
    if (error) {
      response.end();
      return;
    }
    // send back the data
    response.json(data);
  });
});

// Clients send data to /api
// The request holds data sent by client
app.post("/api", (request, response) => {
  const data = request.body;
  const timestamp = Date.now();
  data.timestamp = timestamp;
  // put data into database
  database.insert(data);
  // send a response with some json
  response.json(data);
});

app.get("/weather/:latlon", async (request, response) => {
  const latlon = request.params.latlon.split(",");
  console.log(latlon);
  const lat = latlon[0];
  const lon = latlon[1];
  console.log(lat, lon);
  const weather_url = `https://api.darksky.net/forecast/e7014337e48184596adc3fb415f9d8ed/${lat},${lon}`;
  const weather_response = await fetch(weather_url);
  const weather_data = await weather_response.json();

  const aq_url = `https://api.openaq.org/v1/latest?coordinates=${lat},${lon}`;
  const aq_response = await fetch(aq_url);
  const aq_data = await aq_response.json();

  const data = {
    weather: weather_data,
    air_quality: aq_data
  };

  response.json(data);
  // This server acts as a proxy
  // The client is not communicating with the weather api directly
  // but through our server
});
