var section  = document.getElementById("section");
        add  = document.getElementById("add");
       edit  = document.getElementById("edit");
       section.style.visibility=hidden;
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

    
 
 
    
   


