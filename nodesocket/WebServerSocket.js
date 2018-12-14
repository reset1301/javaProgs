var WebSocketServer = new require('ws');
var clients = {};
var webSocketServer = new WebSocketServer.Server({
    port: 8081
});
webSocketServer.on('connection', function (ws) {
    var id = Math.random();
    clients[id] = ws;
    console.log("New connection " + id);

    ws.on('message', function (message) {
        console.log('Get message ' + message);
        for (var key in clients) {
            clients[key].send(message);
        }
    });
    ws.on('close',function () {
        console.log('Connection is closed ' + id);
        delete clients[id];
    })
});
// var socket = new WebSocket("ws://localhost:3000/ws");
//
// socket.onopen = function (event) {
//     alert("Connected!");
// };
// socket.onclose = function (event) {
//     if (event.wasClean) {
//         alert("Connect was successfully closed.");
//     } else {
//         alert("Connect was dropped!")
//     }
//     alert("Code: " + event.code + " reason: " + event.reason);
// };
// socket.onmessage = function (event) {
//     alert("Get message" + event.data);
// };
//
// socket.onerror = function (error) {
//     alert("Error message" + error.data);
// };