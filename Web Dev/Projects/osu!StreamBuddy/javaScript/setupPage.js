const mouseEnabledToggle = document.querySelector("#mouseToggle");
const mouseEnabledSpan = document.querySelector("#mouseSpan");
const timeModeToggle = document.querySelector("#timeModeToggle");
const tapModeToggle = document.querySelector("#tapModeToggle");
const musicModeToggle = document.querySelector("#musicModeToggle");
const actualBPMSpan = document.querySelector("#actualBPM");
const bpmInput = document.querySelector("#bpmInput");
const songArrow = document.querySelector("#songArrow");
const selectedSongSpan = document.querySelector("#selectedSong");
const songMenu = document.querySelector("#songMenu");
const songSelect = document.querySelector("#songSelect");
const LMB = document.querySelector("#LMB");
const RMB = document.querySelector("#RMB");
const songs = document.querySelectorAll(".song");

// Mouse toggler
mouseEnabledToggle.addEventListener("click", () => {
  if (mouseEnabledToggle.checked) mouseEnabledSpan.innerHTML = "enabled";
  else mouseEnabledSpan.innerHTML = "disabled";
  LMB.classList.toggle("toggleMouseKeys");
  RMB.classList.toggle("toggleMouseKeys");
});

// Mode selectors
$('.mode input[type="checkbox"]').on("change", function() {
  // Only allow one checked checkbox
  $('.mode input[type="checkbox"]')
    .not(this)
    .prop("checked", false);

  // At least one checkbox must be selected
  if ("$input:checked") {
    $(this).prop("checked", true);
  }

  // Music mode seleced
  if ($("#musicModeToggle").prop("checked")) {
    $("#modeInput").fadeOut();
    $("#bpmInfo").fadeOut();
    $("#bpmInput").prop("readonly", true);
    $("#songSelect").fadeIn();
    bpmInput.value = "188";
  } else {
    $("#modeInput").fadeIn();
    $("#bpmInfo").fadeIn();
    $("#bpmInput").prop("readonly", false);
    $("#songSelect").fadeOut();
    bpmInput.value = "160";
  }
});

// Selected song click
$("#selectedSong").on("click", function() {
  toggleSongDropdown();
});

// Click on any song
$(".song").on("click", function() {
  toggleSongDropdown();
  selectedSongSpan.innerHTML = this.value;
});

// Song arrow
$("#songArrow").on("click", function() {
  toggleSongDropdown();
});

// Song menu toggle
function toggleSongDropdown() {
  songArrow.classList.toggle("active");
  selectedSongSpan.classList.toggle("toggle");
  songMenu.classList.toggle("toggle");
}

$("#bpmInput").on("change", function() {
  updateActualBPM();
});

// Beat Per Measure selectors
$('.beatPerMeasure input[type="checkbox"]').on("change", function() { 
  $('.beatPerMeasure input[type="checkbox"]')
    .not(this)
    .prop("checked", false);

  // At least one checkbox must be selected
  if ("$input:checked") {
    $(this).prop("checked", true);
  }
  updateActualBPM();
});

function updateActualBPM() {
  if ($("#bpmMeasure16").prop("checked")) {
    actualBPMSpan.innerHTML = bpmInput.value * 6;
  } else if ($("#bpmMeasure14").prop("checked")) {
    actualBPMSpan.innerHTML = bpmInput.value * 4;
  } else if ($("#bpmMeasure13").prop("checked")) {
    actualBPMSpan.innerHTML = bpmInput.value * 3;
  }
}

// OD table dropdown
$("#bpmArrow").on("click", () => {
  document.querySelector("#bpmArrow").classList.toggle("toggle");
  document.querySelector("#bpmInfo").classList.toggle("active");
});

// OD table dropdown
$("#odArrow").on("click", () => {
  document.querySelector("#odArrow").classList.toggle("toggle");
  document.querySelector("#odInfo").classList.toggle("active");
});
