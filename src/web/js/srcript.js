var section  = document.getElementById("section");
var    add  = document.getElementById("add");
var    edit  = document.getElementById("edit");
// section.style.visibility=hidden;
function ShowAdd() {
    section.style.visibility = "visible";
    add.style.opacity = 1;
    edit.style.opacity = 0;
    add.style.visibility = "visible";
    edit.style.visibility = "hidden";
}
function ShowEdit() {
    section.style.visibility = "visible";
    add.style.opacity = 0;
    edit.style.opacity = 1;
    add.style.visibility = "hidden";
    edit.style.visibility = "visible";
}

function submitFormDataToDatabase() {
var name = document.getElementById("editName").value;
var id = document.getElementById("editId").value;    
var available = document.getElementById("editAvailable").value;
var description = document.getElementById("editDescription").value;
console.log(name,available,description);
   //  vytvorenie objektu
    var object = {            
        name: name,
        available: available,
        description:description
    };
    console.log(object);

    // Odoslanie objektu na server
    const url = 'http://localhost:8080/item/'+id;
    console.log(url);
    fetch(url, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(object)
    })
    .then(response => response.json())
    .then(data => {
        // Spracovanie odpovede od servera
        console.log('Odpoveď od servera:', data);
    })
    .catch(error => {
        console.error('Chyba pri odosielaní požiadavky:', error);
    });
}

const url = 'http://localhost:8080/item'; // Nastavte URL svojej databázy
const table = document.getElementById('sklad');
fetch(url)
.then(response => response.json())
.then(data => {
      data.forEach(row => {
            const newRow = table.insertRow();
            const cell1 = newRow.insertCell(0);
            const cell2 = newRow.insertCell(1);
            const cell3 = newRow.insertCell(2);
            const cell4 = newRow.insertCell(3);
            const cell5 = newRow.insertCell(4);
            
            cell1.innerHTML = row.id;
            cell2.innerHTML = row.name;
            cell3.innerHTML = row.available;
            cell4.innerHTML = row.description;
            cell5.innerHTML = row.created_at;
                               
      });
})
.catch(error => {
      console.error('Chyba pri načítaní údajov z databázy:', error);
}); 

//__________________________________________________________________________
const table2 = document.getElementById('table_2');
const url2 = 'http://localhost:8080/item'; // Nastavte URL svojej databázy
fetch(url2)
.then(response => response.json())
.then(data => {
      data.forEach(row => {
            const rowTable2 = table2.insertRow();
            const cell1_2 = rowTable2.insertCell(0);
            const cell2_2 = rowTable2.insertCell(1);
            const cell3_2 = rowTable2.insertCell(2);
            const cell4_2 = rowTable2.insertCell(3);
            const cell5_2 = rowTable2.insertCell(4);

            cell1_2.innerHTML = row.id;
            cell2_2.innerHTML = row.name;
            cell3_2.innerHTML = row.available;
            cell4_2.innerHTML = row.description;
            cell5_2.innerHTML = row.created_at;
      });
})
.catch(error => {
      console.error('Chyba pri načítaní údajov z databázy:', error);
});

table2.addEventListener('click', function(event) {
const target = event.target;
if (target.tagName === 'TD') {
const row = target.parentNode;
const cells = row.querySelectorAll('td');
const id = cells[0].textContent;
const name = cells[1].textContent;
const available = cells[2].textContent;
const description = cells[3].textContent;

document.getElementById('editId').value = id;
document.getElementById('editName').value = name;
document.getElementById('editAvailable').value = available;
document.getElementById('editDescription').value = description;
}
});






