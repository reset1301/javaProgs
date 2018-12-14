var WebSocket = require('ws');
var socket = new WebSocket("ws://localhost:3000/ws");

socket.onopen = function (event) {
    alert("Connected!");
};
socket.onclose = function (event) {
    if (event.wasClean) {
        alert("Connect was successfully closed.");
    } else {
        alert("Connect was dropped!")
    }
    alert("Code: " + event.code + " reason: " + event.reason);
};
socket.onmessage = function (event) {
    alert("Get message" + event.data);
};

socket.onerror = function (error) {
    alert("Error message" + error.data);
};