let voices=[];

const voiceSelect=document.getElementById("voiceSelect");

function loadVoices(){

voices=speechSynthesis.getVoices();

voiceSelect.innerHTML="";

voices.forEach((voice,index)=>{

let option=document.createElement("option");

option.value=index;
option.text=voice.name;

voiceSelect.appendChild(option);

});

}

speechSynthesis.onvoiceschanged=loadVoices;

function speak(){

let text=document.getElementById("text").value;

let speed=document.getElementById("speed").value;

let speech=new SpeechSynthesisUtterance(text);

speech.rate=speed;

speech.voice=voices[voiceSelect.value];

speechSynthesis.speak(speech);

}

function stop(){

speechSynthesis.cancel();

}

function saveText(){

let text=document.getElementById("text").value;

fetch("http://localhost:8080/api/save",{

method:"POST",

headers:{
"Content-Type":"application/json"
},

body:JSON.stringify({text:text})

});

}

function loadHistory(){

fetch("http://localhost:8080/api/history")

.then(res=>res.json())

.then(data=>{

let list=document.getElementById("history");

list.innerHTML="";

data.forEach(item=>{

let li=document.createElement("li");

li.textContent=item.text;

list.appendChild(li);

});

});

}

loadHistory();