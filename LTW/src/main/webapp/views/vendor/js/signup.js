const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

/*signUpButton.addEventListener('click', () =>
container.classList.add('right-panel-active'));

signInButton.addEventListener('click', () =>
container.classList.remove('right-panel-active'));*/

var password = document.getElementById('password');
var confirmPassword = document.getElementById('confirmPassword');
var toggler1 = document.getElementById('toggler1');
var toggler2 = document.getElementById('toggler2');

showHidePassword1 = () => {
	if (password.type == 'password') {
		password.setAttribute('type', 'text');
		toggler1.classList.add('fa-eye-slash');
	} else {
		toggler1.classList.remove('fa-eye-slash');
		password.setAttribute('type', 'password');
	}
	
};

showHidePassword2 = () => {
	if (confirmPassword.type == 'password') {
		confirmPassword.setAttribute('type', 'text');
		toggler2.classList.add('fa-eye-slash');
	} else {
		toggler2.classList.remove('fa-eye-slash');
		confirmPassword.setAttribute('type', 'password');
	}
	
};

toggler1.addEventListener('click', showHidePassword1);
toggler2.addEventListener('click', showHidePassword2);