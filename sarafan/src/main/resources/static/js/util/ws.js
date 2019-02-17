import SockJS from 'sockjs-client'
import { Stomp } from '@stomp/stompjs'

var stompClient = null
const handlers=[]

export function connect() {
    const socket = new SockJS('/changeMessage');
    stompClient = Stomp.over(socket)
    stompClient.connect({}, frame => {
        console.log('Connected: ' + frame)
        stompClient.subscribe('/topic/activity', message => {
            // showGreeting(JSON.parse(greeting.body).content)
            handlers.forEach(handler => handler(JSON.parse(message.body)))
        })
    })
}

export function addHandler(handler) {
    handlers.push(handler)
}

export function disconnect() {
    stompClient.disconnect()
    console.log("Disconnected")
}

export function sendMessage(message) {
    // var name = document.getElementById('name').value
    stompClient.send("/app/changeMessage", {}, JSON.stringify(message))
}

function showGreeting(message) {
    var response = document.getElementById('response')
    var p = document.createElement('p')
    p.style.wordWrap = 'break-word'
    p.appendChild(document.createTextNode(message))
    response.appendChild(p)
}