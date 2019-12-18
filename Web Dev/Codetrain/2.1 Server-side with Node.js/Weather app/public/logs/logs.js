getData();
// get data from server
async function getData() {
  // fetch something from the route '/api'
  // uses GET method
  const response = await fetch("/api");
  // parse the json
  const data = await response.json();
  // show the data received in the console
  console.log(data);
  for (item of data) {
    const root = document.createElement("div");
    const geo = document.createElement("div");
    const date = document.createElement("div");
    geo.textContent = `${item.lat}°, ${item.lon}°`;
    const dateString = new Date(item.timestamp).toLocaleString();
    date.textContent = dateString;
    root.append(geo, date);
    document.body.append(root);
  }
  console.log(data);
}
