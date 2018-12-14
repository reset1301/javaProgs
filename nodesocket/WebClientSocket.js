var socket = new WebSocket("ws://localhost:8081");

document.forms.publish.onsubmit = function () {
    var outgoingMessage = this.message.value;

    socket.send(outgoingMessage);
    return false;
};

socket.onmessage = function (ev) {
    var incomingMessage = ev.data;
    showMessage(incomingMessage);
};
function showMessage(message) {
    var messageElem = document.createElement('div');
    messageElem.appendChild(document.createTextNode(message));
    document.getElementById('subscribe').appendChild(messageElem);
}