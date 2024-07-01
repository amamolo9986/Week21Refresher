package com.coderscampus.javascriptpractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Week21RefresherApplication {

	public static void main(String[] args) {
		SpringApplication.run(Week21RefresherApplication.class, args);
	}

	/* JS Notes
	 * 
	 * Video 1: Setting up the project
	 * 
	 * Video 2: Hello World
	 * JS lives in a web page and a browser is in charge of working with JS.
	 * They essentially have JS engines that can be used to interpret.
	 * 
	 * "Client Side" language. JS can be ran on the server, but thats Node JS. 
	 * 
	 * Is declared in the head or the body of HTML page using <script><script/>
	 * 
	 * Video 3: Declaring Variables in JS
	 * Data types exist but they are handled for us by the JS engine. We dont 
	 * define types explicitly. we say "var variableName = literal".
	 * JS has something called dynamic typing, this means that it tries to figure 
	 * out the data type based on code context. a literal surround by quote or
	 * backtick will be interpreted as string, etc.
	 * 
	 * Side note, == checks value, === checks value and type
	 * 
	 * Video 4: Data Types 
	 * Objects in JS are created by using curly brackets
	 * var person = {
            'firstName': 'Alex',
            'lastName': 'McMahon',
            'age': '28',
            'address': {
                'line 1': '123 Fake Street',
                'line 2': 'apt 3',
                'city': 'San Antonio',
                'state': 'Texas'
            }
        }
	 * 
	 * Video 5: Selecting Objects from the DOM
	 * Selecting an element in order to do something with it. 
	 * We will demonstrate this by adding a button, when we click on the button, we 
	 * want to validate the form to make sure the username and password was entered, 
	 * then the form is sent.
	 * 
	 * How do we do that? We have to select it first. To select, we add an Id, then we 
	 * are able to select the Id by accessing the DOM in which it is stored, or 
	 * Document Object Model.
	 * 
	 * NOTE: Most elements should have an ID assigned upon creation
	 * 
	 * HTML pages have a DOM: Document Object Model
	 * This is what we are selecting from, it holds the data for all elements on the page.
	 * 
	 * So we have given the submit button we created an id of "submitBtn", and we select
	 * it by saying 'document.querySelector("#submitBtn")'. And this will return the 
	 * object that we can then assign to a variable.
	 * 
	 * var submitBtn = document.querySelector("#submitBtn")
	 * 
	 * Vid 6: Event Listeners
	 * 
	 * 
	 */
}
