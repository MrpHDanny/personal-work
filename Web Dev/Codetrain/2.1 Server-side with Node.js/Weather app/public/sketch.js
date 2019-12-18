function setup() {
  noCanvas();
  let lat, lon;
  const button = document.getElementById("submit");
  button.addEventListener("click", async event => {
    const data = { lat, lon };
    const options = {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(data)
    };
    const response = await fetch("/api", options);
    const json = await response.json();
    console.log(json);
  });

  if ("geolocation" in navigator) {
    console.log("geolocation available");
    navigator.geolocation.getCurrentPosition(async position => {
      try {
        lat = position.coords.latitude.toFixed(2);
        lon = position.coords.longitude.toFixed(2);
        document.getElementById("latitude").textContent = lat;
        document.getElementById("longitude").textContent = lon;
        // weather API
        const api_url = `weather/${lat},${lon}`;
        const response = await fetch(api_url);
        const json = await response.json();
        const weather = json.weather.currently;
        const air = json.air_quality.results[0].measurements[0];
        document.getElementById("summary").textContent = weather.summary;
        document.getElementById("temperature").textContent =
          weather.temperature;
        document.getElementById("temperature").textContent =
          weather.temperature;
        document.getElementById("aq_parameter").textContent = air.parameter;
        document.getElementById("aq_value").textContent = air.value;
        document.getElementById("aq_units").textContent = air.unit;
        document.getElementById("aq_date").textContent = air.lastUpdated;
        console.log(json);
      } catch (error) {
        console.log("something went wrong :(");
      }
    });
  } else {
    console.log("geolocation not available");
  }
}
