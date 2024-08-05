document.getElementById('registerForm').addEventListener('submit', function(e) {
    e.preventDefault();

    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    axios.post('http://localhost:8082/register', {
        name: name,
        email: email,
        password: password
    })
    .then(function (response) {
        console.log('Success:', response.data);
        alert('Registration successful!');
    })
    .catch(function (error) {
        console.error('Error:', error);
        alert('Registration failed. Please try again.');
    });
});