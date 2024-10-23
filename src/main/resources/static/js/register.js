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
                showErrorAnimation(() => {
                    //animation is completed at this point
                    console.log(`We're now in the callback function: 3`)
                    usernameTextBox.style.backgroundColor = `rgb(255, 255, 255)`
                    // then we change the color back to white afer the interval clears or else it will stay red
                })
            }
        })
})

function showErrorAnimation(callback) {
    console.log(`We're in the showErrorAnimation function: 1`)

    var i = 0       //set our variable
    var animationInterval = setInterval(() => {  //create the interval and set equal to variable
        i++         //create the incrementation
        usernameTextBox.style.backgroundColor = `rgb(${i}, 0, 0)`   //set the background color
        if (i >= 255) {     //then we say when i = 255, we clear the interval
            clearInterval(animationInterval)
            console.log(`Done executing animation code: 2`)
            callback()
        }
    }, 1)
}




