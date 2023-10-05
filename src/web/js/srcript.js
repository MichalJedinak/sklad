// var mainContent = document.getElementById('content');

//         fetch('#add') 
//             .then(function(response) {
//                 return response.text();
//             })
//             .then(function(data) {
//                 mainContent.innerHTML = data;
//             })
//             .catch(function(error) {
//                 console.error('Nepodarilo sa načítať obsah', error);
//             });
var section  = document.getElementById("section");
        add  = document.getElementById("add");
       edit  = document.getElementById("edit");
       section.style.visibility=hidden;
    function ShowAdd() {
        section.style.visibility="visible";
        add.style.opacity=1;           
        edit.style.opacity=0;     
    }
    function ShowEdit() {
        section.style.visibility="visible";
        add.style.opacity=0;           
        edit.style.opacity=1; 
        edit.style.position="absolute";
        edit.style.left="25px";
        edit.style.top="50px";
    }