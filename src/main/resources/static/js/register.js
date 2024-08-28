var usernameTextBox = document.querySelector(`#username`)


username.addEventListener(`blur`, () => {
    var user = {
        'username': usernameTextBox.value,
    }
    fetch(`/users/validation`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then((responseEntity) => responseEntity.json())
        .then((data) => {
            if (data === true) { //if username exists
                console.log(`Username already exists`)
                usernameTextBox.focus() //redirects back to box
                usernameTextBox.select() //highlights text
            }
        })
})