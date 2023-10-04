var mainContent = document.getElementById('content');

        fetch('add-index.html') 
            .then(function(response) {
                return response.text();
            })
            .then(function(data) {
                mainContent.innerHTML = data;
            })
            .catch(function(error) {
                console.error('Nepodarilo sa načítať obsah', error);
            });