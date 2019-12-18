// User-Set Variables

var key1 = 90; // Z
var key2 = 88; // x
var mouseEnabled = false;
var mode = -1; // Mode 0 = Time | Mode 1 = Taps | Mode 2 = Music
var modeInput = 60; // Seconds or taps
var targetBPM = 160;
var OD = 8;
var selectedSong = null;
// Other Variables

var isGameRunning = false;
var timer;
var startingTime;
var tapsCount = 0;
var tapsPerSec;
var tappingBPM;
var elapsedTime;
var tappingAccuracy;
var comboCount = 0;

// for Unstable rate & Errors

var hitErrorMargin300 = 31.5;
var hitErrorMargin100 = 75.5;
var hitErrorMargin50 = 119.5;

var hitErrorMargin300Count = 0;
var hitErrorMargin100Count = 0;
var hitErrorMargin50Count = 0;
var hitErrorMargin0Count = 0;

var currentInterval;
var tapTimeStamps = [];
var currentHitError;
var tapIntervalsData = [];
var hitErrorsData = [];
var perfectMS;
var unstableRate;

var hitErrorsEarlyCount = 0;
var hitErrorsEarlyTotal = 0;
var hitErrorsEarlyAverage = 0;
var hitErrorsLateCount = 0;
var hitErrorsLateTotal = 0;
var hitErrorsLateAverage = 0;
var hitErrorsTotalAll;

var hitErrorsMax = 0;
var hitErrorsMin = Number.MAX_SAFE_INTEGER;
var hitErrorsAverage;
var hitErrorsVariance;

// HTML Data Display Variables

const timeDisplay = null;
const tapsPerSecDisplay = null;
const tapsDisplay = null;
const tappingBPMDisplay = null;
const osuTimerDisplay = null;
const unstableRateDisplay = null;
const hitErrorsEarlyAverageDisplay = null;
const hitErrorsLateAverageDisplay = null;
const tappingAccuracyDisplay = null;
const comboCountDisplay = null;
const hitErrorMargin300CountDisplay = null;
const hitErrorMargin100CountDisplay = null;
const hitErrorMargin50CountDisplay = null;
const hitErrorMargin0CountDisplay = null;

function readUserValues() {
  // Read keys
  key1 = document.querySelector("#key1").value;
  key2 = document.querySelector("#key2").value;
  key1 = key1.toLowerCase().charCodeAt(0);
  key2 = key2.toLowerCase().charCodeAt(0);
  // Read mouseEnabled
  if (mouseEnabledToggle.checked) mouseEnabled = true;
  // Read user-set mode
  if (timeModeToggle.checked) mode = 0;
  else if (tapModeToggle.checked) mode = 1;
  else if (musicModeToggle.checked) {
    mode = 2;
    selectedSong = document.querySelector("#selectedSong").textContent;
  } else mode = -1;
  // Read targetBPM
  targetBPM = document.querySelector("#bpmInput").value;
  // Read OD
  OD = document.querySelector("#odInput").value;
  // Error Handling
  if (!key1 || !key2) alert("Please set your keys");
  else if (targetBPM < 60 || targetBPM > 400)
    alert("Please choose a BPM between 60 and 400");
  else if (OD < 0 || OD > 10) alert("Please choose an OD between 0 and 10");
  // If everything's in order proceed futher
  else {
    console.log(
      "Settings: \nKey 1: " +
        key1 +
        "\nKey 2: " +
        key2 +
        "\nMouse Buttons Enabled: " +
        mouseEnabled +
        "\nMode selected: " +
        mode +
        "\nSelected Song: " +
        selectedSong +
        "\nBPM: " +
        targetBPM +
        "\nOD: " +
        OD
    );
    perfectMS = 1 / ((targetBPM * 4) / 60 / 1000);
    hitErrorMargin300 = 79.5 - OD * 6;
    hitErrorMargin100 = 139.5 - OD * 8;
    hitErrorMargin50 = 199.5 - OD * 10;
    changeScreen();
  }
}

function changeScreen() {}
