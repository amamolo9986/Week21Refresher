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
                showErrorAnimation( () => {
                    //animation is completed at this point
                    console.log(`We're now in the callback function: 3`)
                })
            }
        })
})

function showErrorAnimation(callback){
    console.log(`We're in the showErrorAnimation function: 1`)
    //perform error animation code
    console.log(`Done executing animation code: 2`)
    callback()
}




