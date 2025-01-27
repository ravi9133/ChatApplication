// Function to validate the Login Form
function validateLoginForm() {
    const email = document.forms["loginForm"]["email"].value.trim();
    const password = document.forms["loginForm"]["password"].value.trim();

    if (email === "") {
        alert("Email is required.");
        return false;
    }
    if (!validateEmail(email)) {
        alert("Please enter a valid email address.");
        return false;
    }
    if (password === "") {
        alert("Password is required.");
        return false;
    }
    return true;
}

// Function to validate the Registration Form
function validateRegistrationForm() {
    const name = document.forms["registerForm"]["name"].value.trim();
    const email = document.forms["registerForm"]["email"].value.trim();
    const password = document.forms["registerForm"]["password"].value.trim();
    const gender = document.forms["registerForm"]["gender"].value;
    const dob = document.forms["registerForm"]["dob"].value;
    const addressLine = document.forms["registerForm"]["addressLine"].value.trim();
    const city = document.forms["registerForm"]["city"].value.trim();
    const state = document.forms["registerForm"]["state"].value.trim();
    const country = document.forms["registerForm"]["country"].value;
    const contact = document.forms["registerForm"]["contact"].value.trim();

    if (name === "") {
        alert("Name is required.");
        return false;
    }
    if (email === "") {
        alert("Email is required.");
        return false;
    }
    if (!validateEmail(email)) {
        alert("Please enter a valid email address.");
        return false;
    }
    if (password === "") {
        alert("Password is required.");
        return false;
    }
    if (gender === "") {
        alert("Please select a gender.");
        return false;
    }
    if (dob === "") {
        alert("Date of birth is required.");
        return false;
    }
    if (addressLine === "") {
        alert("Address is required.");
        return false;
    }
    if (city === "") {
        alert("City is required.");
        return false;
    }
    if (state === "") {
        alert("State is required.");
        return false;
    }
    if (country === "Select-Country:") {
        alert("Please select a country.");
        return false;
    }
    if (!validatePhoneNumber(contact)) {
        alert("Please enter a valid contact number.");
        return false;
    }
    return true;
}

// Function to validate the Compose Mail Form
function validateComposeForm() {
    const to = document.forms["composeForm"]["to"].value.trim();
    const subject = document.forms["composeForm"]["subject"].value.trim();
    const message = document.forms["composeForm"]["message"].value.trim();

    if (to === "") {
        alert("Recipient email is required.");
        return false;
    }
    if (!validateEmail(to)) {
        alert("Please enter a valid email address for the recipient.");
        return false;
    }
    if (subject === "") {
        alert("Subject is required.");
        return false;
    }
    if (message === "") {
        alert("Message cannot be empty.");
        return false;
    }
    return true;
}

// Helper Function to Validate Email
function validateEmail(email) {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}

// Helper Function to Validate Phone Number
function validatePhoneNumber(phone) {
    const phoneRegex = /^[0-9]{10}$/; // Ensures 10 numeric digits
    return phoneRegex.test(phone);
}
